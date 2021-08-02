package com.hasan.mathsukrevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MathsQuizActivity extends AppCompatActivity {

    private TextView text_question_num, text_score, text_timer, text_question;
    private RadioGroup radio_group;
    private RadioButton radio_btn1, radio_btn2, radio_btn3, radio_btn4;
    private Button btn_next;
    int total_questions;
    int question_count = 0;
    int score;
    private QuestionsTemplate current_question;
    private List<QuestionsTemplate> questionsList;
    private boolean ans;
    private ColorStateList default_radio_btn_colour, default_timer_colour;
    private CountDownTimer countdown_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_quiz);

        text_question_num = findViewById(R.id.text_question_num);
        text_score = findViewById(R.id.text_score);
        text_timer = findViewById(R.id.text_timer);
        text_question = findViewById(R.id.text_question);
        radio_group = findViewById(R.id.radio_group);
        radio_btn1 = findViewById(R.id.radio_btn1);
        radio_btn2 = findViewById(R.id.radio_btn2);
        radio_btn3 = findViewById(R.id.radio_btn3);
        radio_btn4 = findViewById(R.id.radio_btn4);
        btn_next = (Button) findViewById(R.id.btn_next);
        default_radio_btn_colour = radio_btn1.getTextColors();
        default_timer_colour = text_timer.getTextColors();

        questionsList = new ArrayList<>();
        addQuestions();

        total_questions = questionsList.size();
        nextQuestion();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ans) {
                    if (radio_btn1.isChecked() || radio_btn2.isChecked() || radio_btn3.isChecked() || radio_btn4.isChecked()) {
                        checkAns();
                        countdown_timer.cancel();

                    } else {
                        Toast.makeText(MathsQuizActivity.this, "You must select an answer", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    nextQuestion();

                }
            }
        });
    }

    private void checkAns() {
        ans = true;
        RadioButton user_answer = findViewById(radio_group.getCheckedRadioButtonId());
        int answerNum = radio_group.indexOfChild(user_answer) + 1;
        if (answerNum == current_question.getCorrectAns()) {
            score++;
            text_score.setText("Current Score: " + score);

        }
        radio_btn1.setTextColor(Color.RED);
        radio_btn2.setTextColor(Color.RED);
        radio_btn3.setTextColor(Color.RED);
        radio_btn4.setTextColor(Color.RED);
        switch (current_question.getCorrectAns()) {
            case 1:
                radio_btn1.setTextColor(Color.GREEN);
                break;
            case 2:
                radio_btn2.setTextColor(Color.GREEN);
                break;
            case 3:
                radio_btn3.setTextColor(Color.GREEN);
                break;
            case 4:
                radio_btn4.setTextColor(Color.GREEN);
                break;

        } if (question_count < total_questions) {
            btn_next.setText("NEXT QUESTION");

        } else {
            btn_next.setText("END QUIZ");
        }

    }

    private void nextQuestion() {
        radio_group.clearCheck();
        radio_btn1.setTextColor(default_radio_btn_colour);
        radio_btn2.setTextColor(default_radio_btn_colour);
        radio_btn3.setTextColor(default_radio_btn_colour);
        radio_btn4.setTextColor(default_radio_btn_colour);

        if (question_count < total_questions) {

            startTimer();

            current_question = questionsList.get(question_count);
            text_question.setText(current_question.getQuestion());
            radio_btn1.setText(current_question.getAnswer1());
            radio_btn2.setText(current_question.getAnswer2());
            radio_btn3.setText(current_question.getAnswer3());
            radio_btn4.setText(current_question.getAnswer4());

            question_count++;

            btn_next.setText("CONFIRM");
            text_question_num.setText("Question: " + question_count + " of " + total_questions);
            ans = false;

        } else {
            finish();
        }

    }

    private void startTimer() {
        countdown_timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisecLeft) {
                int minutes = (int) (millisecLeft / 1000) / 60;
                int seconds = (int) (millisecLeft / 1000) % 60;
                String secondsLeft = "";
                if (seconds <= 9) {
                    secondsLeft = "0" + seconds;

                } else {
                    secondsLeft = "" + seconds;

                }
                text_timer.setText("" + minutes + ":" + secondsLeft);

                if (millisecLeft <10000) {
                    text_timer.setTextColor(Color.RED);

                } else {
                    text_timer.setTextColor(default_timer_colour);
                }

            }

            @Override
            public void onFinish() {
                nextQuestion();

            }
        }.start();

    }

    private void addQuestions() {
        questionsList.add(new QuestionsTemplate("What is the area of a circle?", "2πr", "3/4 πr^2", "πD","πr^2", 4));
        questionsList.add(new QuestionsTemplate("What is the circumference of a circle?", "2πr", "πr^2", "πr", "π * h",1));
        questionsList.add(new QuestionsTemplate("What is the area of a right angle triangle?", "ab/2", "ab/4", "ab", "aa",1));
        questionsList.add(new QuestionsTemplate("What is the area of a trapezium?", "(ab)^2", "1/2 x ab", "(a+b)/2 * h", "(a+b)/2", 3));
        questionsList.add(new QuestionsTemplate("What is the area of a rectangle?", "1/2 * ab", "hb", "h * h","lbw" ,2));
        questionsList.add(new QuestionsTemplate("What is the volume of a cylinder?", "πr^2", "πr^2*h", "1/2 * ab * sinC", "E=mc^2", 2));
        questionsList.add(new QuestionsTemplate("What does SOH stand for in trigonometry?", "sinx=opposite/hypotenuse", "cosx=adjacent/hypotenuse", "sinx","cosy", 1));
        questionsList.add(new QuestionsTemplate("What is Pythagoras' theorem?", "a^2+b^2=c^2", "a+b=c", "x^2+y^2=c^3", "1+1=3", 1));
        questionsList.add(new QuestionsTemplate("What is the equation of a straight line?", "y=mx", "y=mx+c", "straight line", "0",2));
        questionsList.add(new QuestionsTemplate("what does CAH stand for?", "sinx=opposite/hypotenuse", "cosx=adjacent/hypotenuse", "sinx", "cosx=hypotenuse/adjacent",2));

    }
}