package com.example.yoga_tab_statics.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yoga_tab_statics.R;
import com.example.yoga_tab_statics.home.MainActivity;
import com.example.yoga_tab_statics.model.Workout;

import java.util.List;

import static com.example.yoga_tab_statics.view.SlimApp.context;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Workout> workouts;
    public DataAdapter(MainActivity mainActivity, List<Workout> workouts) {
        this.workouts = workouts;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
       View view = (View)inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        Workout workout = workouts.get(position);
        holder.workoutNameTextView.setText(workout.getName());
        holder.workoutNameTextView2.setText(workout.getDescription());
        holder.imageWorkout.setImageResource(workout.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView workoutNameTextView;
        private TextView workoutNameTextView2;
        private ImageView imageWorkout;

        public ViewHolder(@NonNull View view) {
            super(view);
            workoutNameTextView = view.findViewById(R.id.listTextTitle);
            workoutNameTextView2 = view.findViewById(R.id.listTextDescription);
            imageWorkout = view.findViewById(R.id.imageListWorkout);

        }
    }
}
