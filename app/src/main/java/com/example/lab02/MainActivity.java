package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

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
    Button button, insert;
    String[] shows, movies;
    List<String> shows_better, movies_better;
    RadioButton tv, movie, forward, backward;
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
        shows = getResources().getStringArray(R.array.tvShows);
        movies = getResources().getStringArray(R.array.movies);
        shows_better = new ArrayList<String>(Arrays.asList(shows));
        movies_better = new ArrayList<String>(Arrays.asList(movies));

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
                if(tv.isChecked()) {
                    shows_better.add(displayText.getText().toString());
                    count = shows_better.size() - 1;
                    changeName.setText(getString(R.string.starter, "TV Show", shows_better.get(count % shows_better.size())));
                }
                else if(movie.isChecked()) {
                    movies_better.add(displayText.getText().toString());
                    count = movies_better.size() - 1;
                    changeName.setText(getString(R.string.starter, "Movie", movies_better.get(count % movies_better.size())));
                }
            }
        });
    }
}