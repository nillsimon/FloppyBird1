package com.example.animation2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements Animation.AnimationListener {
    private ImageView mImage;
    private Animation animation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, R.anim.alpha, Menu.NONE, "Alpha")
                .setAlphabeticShortcut('a');
        menu.add(Menu.NONE, R.anim.scale, Menu.NONE, "Scale")
                .setAlphabeticShortcut('s');
        menu.add(Menu.NONE, R.anim.translate, Menu.NONE, "Translate")
                .setAlphabeticShortcut('t');
        menu.add(Menu.NONE, R.anim.rotate, Menu.NONE, "Rotate")
                .setAlphabeticShortcut('r');
        menu.add(Menu.NONE, R.anim.combination, Menu.NONE, "Комбинация")
                .setAlphabeticShortcut('o');

        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        animation = AnimationUtils.loadAnimation(
                this, item.getItemId());
        animation.setAnimationListener(this);

        mImage.startAnimation(animation);
        return true;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        mImage.setVisibility(View.VISIBLE);

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mImage.setVisibility(View.VISIBLE);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        mImage.setVisibility(View.VISIBLE);

    }
}
