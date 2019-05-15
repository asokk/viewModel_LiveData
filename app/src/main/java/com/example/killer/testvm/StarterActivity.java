package com.example.killer.testvm;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StarterActivity extends AppCompatActivity {

    Button addScoreButton, resetScoreButton;
    TextView scoreTextView;

    private StarterScoreViewModel mStarterScoreViewModel;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStarterScoreViewModel = ViewModelProviders.of(this).get(StarterScoreViewModel.class);

        scoreTextView = findViewById(R.id.scoreTextView);
        addScoreButton = findViewById(R.id.addScoreButton);
        resetScoreButton = findViewById(R.id.resetScoreButton);

        addScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addScore();
            }
        });

        resetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScore();
            }
        });

        scoreTextView.setText(String.valueOf(mStarterScoreViewModel.getScore())); //later Added
    }

    private void addScore(){
       // score += 1;
        //scoreTextView.setText(String.valueOf(score));
        mStarterScoreViewModel.addScore();
        scoreTextView.setText(String.valueOf(mStarterScoreViewModel.getScore()));
    }

    private void resetScore() {
        //score = 0;
        mStarterScoreViewModel.resetScore();
        //scoreTextView.setText(String.valueOf(score));
        scoreTextView.setText(String.valueOf(mStarterScoreViewModel.getScore()));
    }
}
