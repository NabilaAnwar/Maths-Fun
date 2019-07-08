package com.example.nabilapc.quizapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class StartQuiz extends AppCompatActivity {

    TextView questionLabel, questionCountLabel, scoreLabel;
    EditText answerEdit;
    ProgressBar progressBar;
    Button submit;
    ArrayList<QuestionModel> questionModelArrayList;
    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        questionLabel = (TextView) findViewById(R.id.question1);
        questionCountLabel = (TextView) findViewById(R.id.noqus);
        scoreLabel = (TextView) findViewById(R.id.score);

        answerEdit = (EditText) findViewById(R.id.ans);
        submit = (Button) findViewById(R.id.submit);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        questionModelArrayList = new ArrayList<>();
        setUpQuestions();

        setData();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }
    public void checkAnswer(){
        String answerString = answerEdit.getText().toString().trim();
        if(answerString.equalsIgnoreCase(questionModelArrayList.get(currentPosition).getAnswer())){
            numberOfCorrectAnswer++;
            new SweetAlertDialog(StartQuiz.this,SweetAlertDialog.SUCCESS_TYPE).
                    setTitleText("Good Job")
                    .setContentText("Right Answer")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition++;
                            setData();
                            answerEdit.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();
            /*Log.e("answer","Right");

            currentPosition++;
            setData();
            answerEdit.setText("");*/

        }
        else{
            new SweetAlertDialog(StartQuiz.this,SweetAlertDialog.SUCCESS_TYPE).
                    setTitleText("Wrong Answer")
                    .setContentText("Right Answer is : "+questionModelArrayList.get(currentPosition).getAnswer())
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            currentPosition++;
                            setData();
                            answerEdit.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();
            /*Log.e("answer","Wrong");
            currentPosition++;
            setData();
            answerEdit.setText("");*/
        }
        int x = ((currentPosition+1)+100)/questionModelArrayList.size();

        progressBar.setProgress(x);
    }


    public void setUpQuestions()
    {
        questionModelArrayList.add(new QuestionModel("What is 2+4 ?","6"));
        questionModelArrayList.add(new QuestionModel("What is 3*2 ?","6"));
        questionModelArrayList.add(new QuestionModel("What is 4/2 ?","2"));
        questionModelArrayList.add(new QuestionModel("What is 6+4 ?","10"));
        questionModelArrayList.add(new QuestionModel("What is 3*3 ?","9"));
        questionModelArrayList.add(new QuestionModel("What is 9/3 ?","3"));
        questionModelArrayList.add(new QuestionModel("What is 5+3 ?","8"));
        questionModelArrayList.add(new QuestionModel("What is 5*5 ?","25"));
        questionModelArrayList.add(new QuestionModel("What is 10/2 ?","5"));
        questionModelArrayList.add(new QuestionModel("What is 5%2 ?","1"));
        questionModelArrayList.add(new QuestionModel("What is 15+15 ?","30"));
        questionModelArrayList.add(new QuestionModel("What is 7*2 ?","14"));
        questionModelArrayList.add(new QuestionModel("What is 18/3 ?","6"));
        questionModelArrayList.add(new QuestionModel("What is 10%5 ?","0"));
        questionModelArrayList.add(new QuestionModel("What is 12+14 ?","26"));
        questionModelArrayList.add(new QuestionModel("What is 12*3 ?","36"));
        questionModelArrayList.add(new QuestionModel("What is 30/6 ?","5"));
        questionModelArrayList.add(new QuestionModel("What is 120+15 ?","135"));
        questionModelArrayList.add(new QuestionModel("What is 15*8 ?","120"));
        questionModelArrayList.add(new QuestionModel("What is 100/20 ?","5"));
        questionModelArrayList.add(new QuestionModel("What is 13%4 ?","1"));
        questionModelArrayList.add(new QuestionModel("What is 130+10 ?","140"));
        questionModelArrayList.add(new QuestionModel("What is 12*9 ?","108"));
        questionModelArrayList.add(new QuestionModel("What is 81/9 ?","9"));
        questionModelArrayList.add(new QuestionModel("What is 9%5 ?","4"));
        questionModelArrayList.add(new QuestionModel("What is 145+120","265"));
        questionModelArrayList.add(new QuestionModel("What is 14*5 ?","70"));
        questionModelArrayList.add(new QuestionModel("What is 125/25 ?","5"));
        questionModelArrayList.add(new QuestionModel("What is 500+500 ?","1000"));
        questionModelArrayList.add(new QuestionModel("What is 12*12 ?","144"));

    }
    public void setData(){

        if(questionModelArrayList.size()>currentPosition) {
            questionLabel.setText(questionModelArrayList.get(currentPosition).getQuestionString());
            questionCountLabel.setText("Qusetion No: " + (currentPosition + 1));
            scoreLabel.setText("Score: " + numberOfCorrectAnswer + "/" + questionModelArrayList.size());
        }
        else{
            new SweetAlertDialog(StartQuiz.this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("you have successfully complete the quiz")
                    .setContentText("Your score is: "+numberOfCorrectAnswer)
                    .setConfirmText("Researt")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismiss();
                            currentPosition=0;
                            numberOfCorrectAnswer=0;
                            progressBar.setProgress(0);

                            setData();
                        }
                    })
                    .setCancelText("Close")
                    .show();
        }

    }

}
