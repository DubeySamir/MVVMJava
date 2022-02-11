package com.sdcode.livedataviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {
    MutableLiveData<Boolean> currentState = new MutableLiveData<>();
}
