package com.simon.mychat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = "SingInActivity";
    private FirebaseAuth auth;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText repeatPasswordEditText;
    private EditText nameEditText;
    private TextView toggleLoginSingUpTextView;
    private Button loginSignUpButton;

    private boolean loginModeActive;

    FirebaseDatabase database;
    DatabaseReference usersDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        usersDatabaseReference = database.getReference().child("users");

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        repeatPasswordEditText = findViewById(R.id.repeatPasswordEditText);
        nameEditText = findViewById(R.id.nameEditText);
        toggleLoginSingUpTextView = findViewById(R.id.toggleLoginSingUpTextView);
        loginSignUpButton = findViewById(R.id.loginSignUpButton);

        loginSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginSingUpUser(emailEditText.getText().toString().trim()
                        ,passwordEditText.getText().toString().trim());
            }
        });
        if (auth.getCurrentUser() != null){
            startActivity(new Intent(SignInActivity.this, ChatActivity.class));
        }
    }

    private void loginSingUpUser(String email, String password) {

        if(loginModeActive){
            if(passwordEditText.getText().toString().trim().length() < 7){
                Toast.makeText(this,"Пароль должен состоять из 7 символов", Toast.LENGTH_LONG).show();
            }else if (emailEditText.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Введите ваш адрес", Toast.LENGTH_LONG).show();
            }else {
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = auth.getCurrentUser();
                                    createUser(user);
                                    Intent intent = new Intent(SignInActivity.this,
                                            ChatActivity.class);
                                    intent.putExtra("userName", nameEditText.getText().toString().trim());
                                    startActivity(intent);
                                    Toast.makeText(SignInActivity.this,
                                            "Успешный вход пользователя",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SignInActivity.this,
                                         "Нет такого пользователя",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        }else {
            if(!passwordEditText.getText().toString().trim().equals(
                    repeatPasswordEditText.getText().toString().trim()
            )) {
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show();
            }else if(passwordEditText.getText().toString().trim().length() < 7){
                Toast.makeText(this,"Пароль должен состоять из 7 символов", Toast.LENGTH_LONG).show();
            }else if(passwordEditText.getText().toString().trim().equals("")){
                Toast.makeText(this,"Введите ваш адрес", Toast.LENGTH_LONG).show();
            }else {
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Успешное создание пользователя");
                                    FirebaseUser user = auth.getCurrentUser();
                                    createUser(user);
                                    Intent intent = new Intent(SignInActivity.this,
                                            ChatActivity.class);
                                    intent.putExtra("userName", nameEditText.getText().toString().trim());
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(SignInActivity.this,
                                            "Ошибка аутентификации",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        }
    }

    private void createUser(FirebaseUser firebaseUser) {

        User user = new User();
        user.setId(firebaseUser.getUid());
        user.setEmail(firebaseUser.getEmail());
        user.setName(nameEditText.getText().toString().trim());

        usersDatabaseReference.push().setValue(user);
    }

    public void toggleLoginMode(View view) {
        if(loginModeActive) {
            loginModeActive = false;
            loginSignUpButton.setText("Вход");
            toggleLoginSingUpTextView.setText("Регистрация");
            repeatPasswordEditText.setVisibility(View.VISIBLE);
        }else {
            loginModeActive = true;
            loginSignUpButton.setText("Вход");
            toggleLoginSingUpTextView.setText("Регистрация");
            repeatPasswordEditText.setVisibility(View.GONE);

        }
    }
}
