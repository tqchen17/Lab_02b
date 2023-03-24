package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView changeName;
    EditText displayText;
    Lifecycle current;
    Button button, insert;
    String[] shows, movies;
    List<String> shows_better, movies_better;
    RadioButton tv, movie, forward, backward;
    ConstraintLayout background;
    int startCount=0;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeName = findViewById(R.id.changeName);
        button = findViewById(R.id.button);
        insert = findViewById(R.id.insert);
        displayText = findViewById(R.id.display_text);
        tv = findViewById(R.id.radioShow);
        movie = findViewById(R.id.radioMovie);
        forward = findViewById(R.id.radioForward);
        backward = findViewById(R.id.radioBackward);
        background = findViewById(R.id.background);
        current = new Lifecycle();
        shows = getResources().getStringArray(R.array.tvShows);
        movies = getResources().getStringArray(R.array.movies);
        shows_better = new ArrayList<String>(Arrays.asList(shows));
        movies_better = new ArrayList<String>(Arrays.asList(movies));
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(forward.isChecked()) {
                    count++;
                }
                if(backward.isChecked()) {
                    count--;
                }
                if(tv.isChecked()) {
                    if(count < 0) {
                        count = shows_better.size() -1;
                    }
                    changeName.setText(getString(R.string.starter, "TV Show", shows_better.get(count % shows_better.size())));
                }
                if(movie.isChecked()) {
                    if(count < 0) {
                        count = movies_better.size()-1;
                    }
                    changeName.setText(getString(R.string.starter, "Movie", movies_better.get(count % movies_better.size())));
                }
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayText.getText().toString().length() != 0) {
                    if (tv.isChecked()) {
                        shows_better.add(displayText.getText().toString());
                        count = shows_better.size() - 1;
                        changeName.setText(getString(R.string.starter, "TV Show", shows_better.get(count % shows_better.size())));
                    } else if (movie.isChecked()) {
                        movies_better.add(displayText.getText().toString());
                        count = movies_better.size() - 1;
                        changeName.setText(getString(R.string.starter, "Movie", movies_better.get(count % movies_better.size())));
                    }
                }
            }
        });
    }

    public void updateBackground() {
        if(startCount > 2) {
            background.setBackgroundColor(Color.argb(255, 255, 255, 0));
        } else if(startCount > 1) {
            background.setBackgroundColor(Color.argb(255, 255, 0, 255));
        } else {
            background.setBackgroundColor(Color.argb(255, 0, 255, 255));
        }
    }

    public void updateCount(String currentEnclosingMethod) {
        //pass name to LifecycleData to update count
        current.updateEvent(currentEnclosingMethod);
        startCount = current.getOnStart();
        updateBackground();
    }

    @Override
    protected void onStart() {
        super.onStart();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onResume() {
        super.onResume();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onPause() {
        super.onPause();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onStop() {
        super.onStop();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
}