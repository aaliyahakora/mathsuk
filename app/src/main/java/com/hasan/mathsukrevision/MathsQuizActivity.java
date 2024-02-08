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


// superscript 2: ²
// fraction 3 / 4: ¾
// fraction 1 / 2: ½
// algebra x: 𝑥
// times symbol: ×


    private void addQuestions() {
        questionsList.add(new QuestionsTemplate("What is the circumference of a circle in terms of r?", "2πr", "¾ πr²", "πD","πr²", 1));
        questionsList.add(new QuestionsTemplate("What is x+2x+3x+4x+5x+6x?", "10\uD835\uDC65", "720", "21","21x", 4));
        questionsList.add(new QuestionsTemplate("What is y×y?", "2y", "2y²", "1","y²", 4));
        questionsList.add(new QuestionsTemplate("What is 3y²×3y²?", "6y²", "9y⁴", "6y","9y²", 2));
        questionsList.add(new QuestionsTemplate("What is area of a right angle triangle?", "2π", "ab", "ab/2","ab²", 3));
        questionsList.add(new QuestionsTemplate("What is the cosine rule?", "a² = b² + c² - 2bc CosA", "a² = b² - c² + 2bc CosA", "a/sinA = b/sinB = c/sinC", "a² + b² = c²", 1));
        questionsList.add(new QuestionsTemplate("What is the area of a circle?", "2πr", "¾ πr²", "πD","πr²", 4));
        questionsList.add(new QuestionsTemplate("What is the circumference of a circle?", "2πr", "πr²", "πr", "π * h",1));
        questionsList.add(new QuestionsTemplate("What is the area of a right angle triangle?", "ᵃᵇ⁄₂", "ab/4", "ab", "aa",1));
        questionsList.add(new QuestionsTemplate("What is the area of a trapezium?", "(ab)²", "½ ab", "(a+b)/2 * h", "(a+b)/2", 3));
        questionsList.add(new QuestionsTemplate("What is the area of a rectangle?", "½ * ab", "hb", "h * h","lbw" ,2));
        questionsList.add(new QuestionsTemplate("What is the volume of a cylinder?", "πr²", "πr² * h", "½ * ab * sinC", "E=mc²", 2));
        questionsList.add(new QuestionsTemplate("What does SOH stand for in trigonometry?", "sin x =opposite/hypotenuse", "cos x =adjacent/hypotenuse", "sin x","cos y", 1));
        questionsList.add(new QuestionsTemplate("What is Pythagoras' theorem?", "a²+b²=c²", "a+b=c", "x²-y²=c²", "1+1=3", 1));
        questionsList.add(new QuestionsTemplate("What is the equation of a straight line?", "y=mx", "y=mx+c", "straight line", "0",2));
        questionsList.add(new QuestionsTemplate("what does CAH stand for?", "sin x =opposite/hypotenuse", "cos x =adjacent/hypotenuse", "sin x", "cos x = hypotenuse/adjacent",2));


    }
}