package com.example.killer.testvm;

import android.arch.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel{

    Integer score;

    public Integer getScore() {
        if (score == null) {
            return 0;
        }
        return score;
    }
}
