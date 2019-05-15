package com.example.killer.testvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LiveDataActivity extends AppCompatActivity {

    ScoreViewModelLiveData mScoreViewModelLiveData;
    Button addScoreButton, resetScoreButton;
    TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        mScoreViewModelLiveData = ViewModelProviders.of(this).get(ScoreViewModelLiveData.class);
        mScoreViewModelLiveData.getScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                scoreTextView.setText(String.valueOf(integer));
            }
        });
    }

    //ADD the live data observer in this class


    private void addScore(){
        mScoreViewModelLiveData.addScore();
    }

    private void resetScore() {
          mScoreViewModelLiveData.resetScore();
    }
}
