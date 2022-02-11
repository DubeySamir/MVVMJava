package com.sdcode.livedataviewmodel;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btn_change;
    ConstraintLayout main_layout;
    TestViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("On Off App");

        btn_change = findViewById(R.id.btn_change);
        main_layout = findViewById(R.id.main_layout);

        viewModel = new ViewModelProvider(this).get(TestViewModel.class);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (viewModel.currentState.getValue() == null) {
                    viewModel.currentState.setValue(true);
                }
                viewModel.currentState.setValue(!viewModel.currentState.getValue());
            }
        });

        viewModel.currentState.observe(this, new Observer<Boolean>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    btn_change.setText(R.string.TurnOn);
                    main_layout.setBackgroundColor(getColor(R.color.red));
                } else {
                    btn_change.setText(R.string.TurnOff);
                    main_layout.setBackgroundColor(getColor(R.color.green));
                }
            }
        });
    }
}