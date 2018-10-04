package com.example.android.testappproject3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method creates the submitTestResult
     * This method makes a toast with the test result
     * Max total is 100
     * 30 is mininum to pass
     * This method resets the test resetTextResult
     */

    public void submitTestResult(View view) {

        // This creates the Test presenter's name
        EditText nameField = (EditText) findViewById(R.id.name_hint);
        String name = nameField.getText().toString();

        // Checks questionOneScore

        if (checkAnswerQuestion1()) {
            totalScore++;
        } else {
            totalScore = totalScore + 0;
        }

        // Checks questionTwoScore
        if (checkAnswerQuestion2()) {
            totalScore++;
        } else {
            totalScore = totalScore + 0;
        }

        // Checks questionThreeScore
        if (checkAnswerQuestion3()) {
            totalScore++;
        } else {
            totalScore = totalScore + 0;
        }

        // Checks questionFourScore
        if (checkAnswerQuestion4()) {
            totalScore++;
        } else {
            totalScore = totalScore + 0;
        }

        // Checks questionFiveScore
        if (checkAnswerQuestion5()) {
            totalScore++;
        } else {
            totalScore = totalScore + 0;
        }

        // Calculates the total  Score
        // Sends a Toast Message with the Result
        if (totalScore >= 4) {
            Toast.makeText(this, getString(R.string.thank_you) + name + getString(R.string.score) + totalScore, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.sorry) + name + getString(R.string.score) + totalScore, Toast.LENGTH_LONG).show();
        }

        totalScore = 0;

    }

    /**
     * This method creates the scoreQ1
     * OnClick answerQuestion1
     * id question_1_rg
     * correct question_1_rb_b
     */

    private boolean checkAnswerQuestion1() {

        RadioButton rbQuestionOne = findViewById(R.id.question_1_rb_b);

        if (!rbQuestionOne.isChecked()) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * This method creates the scoreQ2
     * OnClick answerQuestion2
     * id question_2_rg
     * correct question_2_rg_a
     */

    private boolean checkAnswerQuestion2() {

        RadioButton rbQuestionTwo = findViewById(R.id.question_1_rb_a);

        if (!rbQuestionTwo.isChecked()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method creates the scoreQ3
     * OnClick answerQuestion3
     * id question_3_cb
     * correct:
     * question_3_cb_a false
     * question_3_cb_b false
     * question_3_cb_c true
     * question_3_cb_d true
     * question_3_cb_e false
     */

    private boolean checkAnswerQuestion3() {

        // Id each CheckBox
        CheckBox q3optionAIsClicked = ((CheckBox) findViewById(R.id.question_3_cb_a));
        CheckBox q3optionBIsClicked = ((CheckBox) findViewById(R.id.question_3_cb_b));
        CheckBox q3optionCIsClicked = ((CheckBox) findViewById(R.id.question_3_cb_c));
        CheckBox q3optionDIsClicked = ((CheckBox) findViewById(R.id.question_3_cb_d));
        CheckBox q3optionEIsClicked = ((CheckBox) findViewById(R.id.question_3_cb_e));

        // View is Checked?
        // Which is checked
        if (!q3optionAIsClicked.isChecked() & !q3optionBIsClicked.isChecked() & q3optionCIsClicked.isChecked() & q3optionDIsClicked.isChecked() & !q3optionEIsClicked.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method creates the scoreQ4
     * OnClick answerQuestion4
     * id q4_cb
     * correct:
     * q4_cb_a true
     * q4_cb_b true
     * q4_cb_c false
     * q4_cb_d true
     * q4_cb_e true
     */

    private boolean checkAnswerQuestion4() {

        // Id each CheckBox
        CheckBox q4optionAIsClicked = ((CheckBox) findViewById(R.id.question_4_cb_a));
        CheckBox q4optionBIsClicked = ((CheckBox) findViewById(R.id.question_4_cb_b));
        CheckBox q4optionCIsClicked = ((CheckBox) findViewById(R.id.question_4_cb_c));
        CheckBox q4optionDIsClicked = ((CheckBox) findViewById(R.id.question_4_cb_d));
        CheckBox q4optionEIsClicked = ((CheckBox) findViewById(R.id.question_4_cb_e));

        // View is Checked?
        //Which is checked
        if (q4optionAIsClicked.isChecked() & q4optionBIsClicked.isChecked() & !q4optionCIsClicked.isChecked() & q4optionDIsClicked.isChecked() & q4optionEIsClicked.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method creates the questionFiveScore
     * OnClick answerQuestion5
     * correct: "Facebook"
     */

    private boolean checkAnswerQuestion5() {

        // What is written in the answer?
        String questionFiveIsCorrect = getResources().getString(R.string.answer_5);

        EditText question5AnsweredByTestTaker = (EditText) findViewById(R.id.question_5_answer);
        String answerGiven = question5AnsweredByTestTaker.getText().toString();

        //Is it correct?
        if (answerGiven.equalsIgnoreCase(questionFiveIsCorrect)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method resets the test resetTextResult
     */

    public void resetTestResult(View view) {

        // Resets test score
        totalScore = 0;

        EditText nameField = (EditText) findViewById(R.id.name_hint);
        nameField.setText(" ");

        // Cleans question 1 selection
        RadioGroup rgQuestionOne = (RadioGroup) findViewById(R.id.question_1_rg);
        rgQuestionOne.clearCheck();

        // Cleans question 2 selection
        RadioGroup rgQuestionTwo = (RadioGroup) findViewById(R.id.question_2_rg);
        rgQuestionTwo.clearCheck();

        // Cleans question 3 selection
        CheckBox q3optionAIsClicked = (CheckBox) findViewById(R.id.question_3_cb_a);
        q3optionAIsClicked.setChecked(false);

        CheckBox q3optionBIsClicked = (CheckBox) findViewById(R.id.question_3_cb_b);
        q3optionBIsClicked.setChecked(false);

        CheckBox q3optionCIsClicked = (CheckBox) findViewById(R.id.question_3_cb_c);
        q3optionCIsClicked.setChecked(false);

        CheckBox q3optionDIsClicked = (CheckBox) findViewById(R.id.question_3_cb_d);
        q3optionDIsClicked.setChecked(false);

        CheckBox q3optionEIsClicked = (CheckBox) findViewById(R.id.question_3_cb_e);
        q3optionEIsClicked.setChecked(false);

        // Cleans question 4 selection
        CheckBox q4optionAIsClicked = (CheckBox) findViewById(R.id.question_4_cb_a);
        q4optionAIsClicked.setChecked(false);

        CheckBox q4optionBIsClicked = (CheckBox) findViewById(R.id.question_4_cb_b);
        q4optionBIsClicked.setChecked(false);

        CheckBox q4optionCIsClicked = (CheckBox) findViewById(R.id.question_4_cb_c);
        q4optionCIsClicked.setChecked(false);

        CheckBox q4optionDIsClicked = (CheckBox) findViewById(R.id.question_4_cb_d);
        q4optionDIsClicked.setChecked(false);

        CheckBox q4optionEIsClicked = (CheckBox) findViewById(R.id.question_4_cb_e);
        q4optionEIsClicked.setChecked(false);

        // Cleans question 5 selection
        EditText question5AnsweredByTestTaker = (EditText) findViewById(R.id.question_5_answer);
        question5AnsweredByTestTaker.setText(" ");

    }
}
