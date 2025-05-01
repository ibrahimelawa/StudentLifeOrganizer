package com.example.studentlifeorganizer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class OnboardingActivity extends AppCompatActivity {
    private int currentScreen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_one);

        findViewById(R.id.next_button).setOnClickListener(v -> navigateToNextScreen());
    }

    private void navigateToNextScreen() {
        currentScreen++;
        switch (currentScreen) {
            case 1:
                setContentView(R.layout.screen_two);
                findViewById(R.id.next_button).setOnClickListener(v -> navigateToNextScreen());
                break;
            case 2:
                setContentView(R.layout.screen_three);
                findViewById(R.id.next_button).setOnClickListener(v -> navigateToNextScreen());
                break;
            default:
                Intent intent = new Intent(OnboardingActivity.this, Sing_in.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
