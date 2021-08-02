package com.hasan.mathsukrevision;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private SeekBar timer_bar;
    private TextView text_timer_tool;
    private Button btn_start_timertool;
    private CountDownTimer countDownTimer;
    private Boolean counterIsRunning = false;
    private MediaPlayer mediaPlayer;
    private ColorStateList default_timertool_colour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timer_bar = findViewById(R.id.timer_bar);
        text_timer_tool = findViewById(R.id.text_timertool);
        btn_start_timertool = findViewById(R.id.btn_start_timer);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.timeup);
        default_timertool_colour = text_timer_tool.getTextColors();
        timer_bar.setMax(7200);
        timer_bar.setProgress(5400);
        timer_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateProgress(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void updateProgress(int progress) {
        int minutes = progress / 60;
        int seconds = progress % 60;
        String secondsLeft = "";
        if (seconds <= 9) {
            secondsLeft = "0" + seconds;

        } else {
            secondsLeft = "" + seconds;

        }
        timer_bar.setProgress(progress);
        text_timer_tool.setText("" + minutes + ":" + secondsLeft);
    }

    public void start_timertool(View view) {
        if (!counterIsRunning) {
            counterIsRunning = true;
            timer_bar.setEnabled(false);
            btn_start_timertool.setText("Stop Timer");

            countDownTimer = new CountDownTimer(timer_bar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updateProgress((int) millisUntilFinished / 1000);

                    if (millisUntilFinished <10000) {
                        text_timer_tool.setTextColor(Color.RED);

                    } else {
                        text_timer_tool.setTextColor(default_timertool_colour);
                    }

                }

                @Override
                public void onFinish() {
                    resetTimer();
                    if (mediaPlayer != null) {
                        mediaPlayer.start();
                    }

                }

            }.start();

        } else {
            resetTimer();

        }
    }

    private void resetTimer() {
        text_timer_tool.setText("90:00");
        timer_bar.setProgress(5400);
        countDownTimer.cancel();
        btn_start_timertool.setText("Start Timer");
        timer_bar.setEnabled(true);
        counterIsRunning = false;
        text_timer_tool.setTextColor(default_timertool_colour);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (counterIsRunning) {
            countDownTimer.cancel();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (counterIsRunning) {
            countDownTimer.cancel();

        }
    }

}