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
        questionsList.add(new QuestionsTemplate("2+5×7-11", "17", "26", "38","14",  2));
        questionsList.add(new QuestionsTemplate("Can I use the Cosine Rule on a right angle triangle?", "Ofcourse - it is a triangle", "No", "Not sure","Sometimes",  2));
        questionsList.add(new QuestionsTemplate("Can I use the Sine Rule on a right angle triange?", "Ofcourse - it is a triangle", "No", "Not sure","Sometimes",  2));
        questionsList.add(new QuestionsTemplate("What is the probability of getting heads twice when tossing a fair coin 3 times?", "3/8", "1/8", "1","0",  1));
        questionsList.add(new QuestionsTemplate("(𝑥)⁵ = 1", "0", "1", "5⁵","5",  2));
        questionsList.add(new QuestionsTemplate("(𝑥)⁵ = 0", "2", "3", "0","5",  3));
        questionsList.add(new QuestionsTemplate("(𝑥)⁵ = 32", "2", "3", "32⁵","3.2",  1));
        questionsList.add(new QuestionsTemplate("What is the length of a cube with volume 1000?", "500", "100", "20","10",  4));
        questionsList.add(new QuestionsTemplate("What is the probability of getting heads twice in a row (on a fair 2-sided coin)?", "1/4", "1/2", "1","Impossible",  1));
        questionsList.add(new QuestionsTemplate("What is the length of a square with area 625?", "50", "100", "25","312.5",  3));
        questionsList.add(new QuestionsTemplate("What is the length of a square with area 10,000?", "500", "100", "50","10",  2));
        questionsList.add(new QuestionsTemplate("What is the length of a square with area 900?", "30", "3", "20","10",  1));
        questionsList.add(new QuestionsTemplate("What are the chances of rolling a 4 on a fair 6-sided die?", "4/6", "4", "1/6","Random Chance",  3));
        questionsList.add(new QuestionsTemplate("What is the length of a square with area 100?", "50", "100", "20","10",  4));
        questionsList.add(new QuestionsTemplate("What shape is NOT a 'prism'?", "Cylinder", "Sphere", "Cuboid","Triangular Prism",  2));
        questionsList.add(new QuestionsTemplate("What is surface area of a cube with side length 5?", "125", "150", "20","600",  2));
        questionsList.add(new QuestionsTemplate("Simplify expression 3𝑥 × 4y + 4𝑥 × 3y", "24𝑥y", "7𝑥y", "7𝑥 +7y","12𝑥 + 7y",  1));
        questionsList.add(new QuestionsTemplate("What is the probability of getting heads on a fair coin toss?", "1", "0.5", "0","random chance",  2));
        questionsList.add(new QuestionsTemplate("What is the volume of a cube with side length 5?", "216", "25", "125","10",  3));
        questionsList.add(new QuestionsTemplate("What is the volume of a cube with side length 6?", "216", "25", "125","10",  1));
        questionsList.add(new QuestionsTemplate("What is surface area of a cube with side length 10?", "2100", "100", "20","600",  4));
        questionsList.add(new QuestionsTemplate("Simplify expression 12𝑥 -3y + 12𝑥 + 3y", "24𝑥 ", "0", "4𝑥 + y","7𝑥 + 7y",  1));
        questionsList.add(new QuestionsTemplate("Simplify expression 15𝑥 - 4y + 4𝑥 + 7y", "3𝑥 + 8y", "19𝑥 + 3y", "4𝑥 + y","7𝑥 + 7y",  2));
        questionsList.add(new QuestionsTemplate("Find 𝑥: 4𝑥 + 5 = 29", " 𝑥 = 1", " 𝑥 = 9", " 𝑥 = 6"," 𝑥 = 10", 3));
        questionsList.add(new QuestionsTemplate("What is 30𝑥-5=6𝑥+15?(simplify)", "13", "270", "20/24","5/6", 4));
        questionsList.add(new QuestionsTemplate("What is 3𝑥-5=4𝑥-8?(simplify)", "13", "270", "-3/27","3", 4));
        questionsList.add(new QuestionsTemplate("What is 30𝑥-5=31𝑥-8?(simplify)", "-3", "9", "3","-1/9", 3));
        questionsList.add(new QuestionsTemplate("What is 4𝑥-5=3𝑥-8?(simplify)", "3", "270", "-3","-1/9", 3));
        questionsList.add(new QuestionsTemplate("Simplify the ratio 4:8", "4:9", "1:2", "48:1","3:2", 2));
        questionsList.add(new QuestionsTemplate("Simplify the ratio 9:15", "3:5", "15:9", "3:6","1:3",  1));
        questionsList.add(new QuestionsTemplate("What is (3𝑥)² ?", "3𝑥²", "9𝑥²", "9𝑥","30𝑥", 2));
        questionsList.add(new QuestionsTemplate("What is (4𝑥)³ ?", "64𝑥³", "4𝑥³", "8𝑥²","2𝑥³",  1));
        questionsList.add(new QuestionsTemplate("What is 30𝑥-5=10?", "1/2", "5/30", "5/6","2", 1));
        questionsList.add(new QuestionsTemplate("What is 5𝑥-5=10?", "1/2", "3", "1/3","2", 2));
        questionsList.add(new QuestionsTemplate("What is 10𝑥-5=95?", "10", "1/10", "5/6","2", 1));
        questionsList.add(new QuestionsTemplate("What is 17𝑥-5=100?", "105/17", "17/105", "5/6","17", 1));
        questionsList.add(new QuestionsTemplate("What is 30𝑥-40=10?", "50/3", "5/3", "5/6","6/5", 2));
        questionsList.add(new QuestionsTemplate("What is 30𝑥-5=3𝑥-8?(simplify)", "13", "270", "-3/27","-1/9", 3));
        questionsList.add(new QuestionsTemplate("What is 1/𝑥 + 2/𝑥?", "3/𝑥", "3𝑥", "1/𝑥","3", 1));
        questionsList.add(new QuestionsTemplate("What is 5/𝑥 + 6/𝑥?", "30/𝑥", "7/𝑥", "11/𝑥","11", 3));
        questionsList.add(new QuestionsTemplate("What is 8/𝑥 - 2/𝑥?", "3/𝑥", "3𝑥", "6/𝑥","6", 3));
        questionsList.add(new QuestionsTemplate("What is 100/𝑥 + 5/2𝑥?", "105/𝑥", "105/3𝑥", "205/2𝑥","105/2", 3));
        questionsList.add(new QuestionsTemplate("What is 11/𝑥 + 22/𝑥?", "33/𝑥", "33𝑥", "13/𝑥","31", 1));
        questionsList.add(new QuestionsTemplate("What is 55/𝑥 -6/𝑥?", "37/𝑥", "49𝑥", "49/𝑥","61", 2));
        questionsList.add(new QuestionsTemplate("What is 10/𝑥 + 200/𝑥?", "210/𝑥", "210𝑥", "199/𝑥","2000", 1));
        questionsList.add(new QuestionsTemplate("What is 1/2𝑥 + 2/2𝑥?", "3/2𝑥", "3𝑥", "3/𝑥","4x", 1));
        questionsList.add(new QuestionsTemplate("What is 1/𝑥 - 2/𝑥?", "3/𝑥", "3𝑥", "-1/𝑥","0", 3));
        questionsList.add(new QuestionsTemplate("What is 17/10𝑥 + 13/20𝑥?", "47/20𝑥", "47𝑥", "47/2𝑥","3", 1));
        questionsList.add(new QuestionsTemplate("What is 1/𝑥 × 1/𝑥?", "1/𝑥", "1/𝑥²", "1/2𝑥","𝑥²", 2));
        questionsList.add(new QuestionsTemplate("What is 1/𝑥 ÷ 2/𝑥?", "3", "2", "1/𝑥","1/2", 4));
        questionsList.add(new QuestionsTemplate("What is 𝑥²×𝑥³?", "𝑥⁵", "5𝑥", "𝑥⁶","5", 1));
        questionsList.add(new QuestionsTemplate("What is 𝑥²×𝑥⁴?", "𝑥⁶", "6𝑥", "𝑥⁶","5", 1));
        questionsList.add(new QuestionsTemplate("What is 3𝑥²×4𝑥³?", "12𝑥⁵", "5𝑥", "𝑥⁶","5", 1));
        questionsList.add(new QuestionsTemplate("What is 9𝑥²÷3𝑥³?", "3𝑥⁵", "5𝑥", "𝑥⁶","5", 1));
        questionsList.add(new QuestionsTemplate("What is 𝑥²×𝑥⁷?", "𝑥⁹", "5𝑥", "𝑥⁶","5", 1));
        questionsList.add(new QuestionsTemplate("What is 50𝑥²×2𝑥³?", "100𝑥⁵", "500𝑥", "𝑥⁶","5", 1));
        questionsList.add(new QuestionsTemplate("What is 15𝑥²×15𝑥³?", "𝑥⁵", "225𝑥⁵", "𝑥⁶","225", 2));
        questionsList.add(new QuestionsTemplate("What is 60𝑥²×𝑥?", "60𝑥⁵", "60𝑥", "𝑥⁶","60𝑥³", 4));
        questionsList.add(new QuestionsTemplate("What is 25𝑥²×25𝑥³?", "625𝑥⁵", "625𝑥⁵", "𝑥⁶","225", 2));
        questionsList.add(new QuestionsTemplate("What is 18𝑥²×15𝑥³?", "𝑥⁵", "270𝑥⁵", "𝑥⁶","270𝑥⁶", 2));
        questionsList.add(new QuestionsTemplate("What is 30𝑥²÷15𝑥³?", "𝑥⁵", "1/2𝑥", "𝑥⁶","2/𝑥", 4));
        questionsList.add(new QuestionsTemplate("What is r×r×r×r?", "2πr", "4r", "r²","r⁴", 4));
        questionsList.add(new QuestionsTemplate("What is r×r?", "2πr", "4r", "r²","r⁴", 3));
        questionsList.add(new QuestionsTemplate("What is r×r×r×a?", "2πr", "ar³", "ar²","r⁴", 2));
        questionsList.add(new QuestionsTemplate("5𝑥+5𝑥+5𝑥×5𝑥?", "20\uD835\uDC65", "10\uD835\uDC65+25\uD835\uDC65²", "10\uD835\uDC65+25\uD835\uDC65","35\uD835\uDC65", 2));
        questionsList.add(new QuestionsTemplate("What is 𝑥+2𝑥+3𝑥+4𝑥+5𝑥+6𝑥-5𝑥?", "10\uD835\uDC65", "720\uD835\uDC65", "16\uD835\uDC65","21\uD835\uDC65", 3));
        questionsList.add(new QuestionsTemplate("What is 𝑥+12𝑥+3𝑥+14𝑥+5𝑥+16𝑥-5𝑥?", "10𝑥", "45𝑥", "46𝑥","44𝑥", 3));
        questionsList.add(new QuestionsTemplate("What is 5y²×5y²?", "25y⁴", "9y⁴", "6y","25y²", 1));
        questionsList.add(new QuestionsTemplate("What is 8y²×5y²?", "40y⁴", "40y⁴", "13y","25y²", 1));
        questionsList.add(new QuestionsTemplate("What is 5y²/5y²?", "0", "25", "1","25y²", 3));
        questionsList.add(new QuestionsTemplate("What is 20y²×7y²?", "140y⁴", "14y⁴", "27y","140y²", 1));
        questionsList.add(new QuestionsTemplate("What is 5y²+5y²?", "25y⁴", "9y⁴", "10y²","25y²", 3));
        questionsList.add(new QuestionsTemplate("What is 25y²-17y²+15y²+5y²?", "25y²", "9y⁴", "28y²","25y²", 3));
        questionsList.add(new QuestionsTemplate("What is y⁰?", "y", "1", "y²","0", 2));
        questionsList.add(new QuestionsTemplate("What is 𝑥⁰?", "y", "2", "1","0", 3));
        questionsList.add(new QuestionsTemplate("What is r⁰?", "y", "2", "1","0", 3));
        questionsList.add(new QuestionsTemplate("What is m⁰?", "y", "2", "1","0", 3));
        questionsList.add(new QuestionsTemplate("What is a⁰?", "y", "1", "2","0", 2));
        questionsList.add(new QuestionsTemplate("What is b⁰?", "y", "1", "2","0", 2));
        questionsList.add(new QuestionsTemplate("What is c⁰?", "y", "1", "2","0", 2));
        questionsList.add(new QuestionsTemplate("What is r⁰?", "y", "1", "2","0", 2));
        questionsList.add(new QuestionsTemplate("What is d⁰?", "y", "1", "2","0", 2));
        questionsList.add(new QuestionsTemplate("What is e⁰?", "y", "1", "2","0", 2));
        questionsList.add(new QuestionsTemplate("What is the circumference of a circle in terms of r?", "2πr", "¾ πr²", "πD","πr²", 1));
        questionsList.add(new QuestionsTemplate("What is x+2x+3x+4x+5x+6x?", "10\uD835\uDC65", "720", "21","21\uD835\uDC65", 4));
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
        questionsList.add(new QuestionsTemplate("Should you follow mathsuk on IG and TikTok?", "Yes", "Right now, Yes", "Later","No",  2));

    }
}