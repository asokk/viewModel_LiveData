package com.example.killer.testvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ScoreViewModelLiveData extends ViewModel {

    private MutableLiveData<Integer> scoreMutableLiveData;

    public MutableLiveData<Integer> getScore(){
        if(scoreMutableLiveData == null){
            scoreMutableLiveData = new MutableLiveData<>();
            scoreMutableLiveData.setValue(0);
            //scoreMutableLiveData.postValue(0); //this is called from worker thread
        }
        return scoreMutableLiveData;
    }

    public void addScore(){
        if(scoreMutableLiveData.getValue() != null) {
            scoreMutableLiveData.setValue(scoreMutableLiveData.getValue() + 1);
        }
    }

    public void resetScore(){
        scoreMutableLiveData.setValue(0);
    }
}
