package com.example.unquote;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int currentQuestionIndex;
    int totalCorrect;
    int totalQuestions;
    ArrayList<Question> questions;

    // TODO 3-A: Declare View member variables
    Button submitButton;
    Button answer0;
    Button answer1;
    Button answer2;
    Button answer3;
    TextView questionMain;
    TextView questionCount;
    ImageView questionImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO 2-G: Show app icon in ActionBar
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.ic_unquote_icon);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setElevation(0);

        setContentView(R.layout.activity_main);

        // TODO 3-B: assign View member variables
        submitButton = findViewById(R.id.btn_main_submit_answer);
        answer0 = findViewById(R.id.btn_main_answer_0);
        answer1 = findViewById(R.id.btn_main_answer_1);
        answer2 = findViewById(R.id.btn_main_answer_2);
        answer3 = findViewById(R.id.btn_main_answer_3);
        questionMain = findViewById(R.id.tv_main_question_title);
        questionCount = findViewById(R.id.tv_main_questions_remaining_count);
        questionImage = findViewById(R.id.iv_main_question_image);
        // TODO 4-E: set onClickListener for each answer Button
        answer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(0);
            }
        });
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(1);
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(2);
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(3);
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onAnswerSubmission();
            }
        });


        // TODO 5-A: set onClickListener for the submit answer Button

        startNewGame();
    }

    // TODO 3-F: displayQuestion(Question question) {...}
    public void displayQuestion(Question question) {
        questionImage.setImageResource(question.imageId);
        questionMain.setText(question.questionText);
        answer0.setText(question.answer0);
        answer1.setText(question.answer1);
        answer2.setText(question.answer2);
        answer3.setText(question.answer3);
    }

    // TODO 3-C: displayQuestionsRemaining(int questionRemaining) {...}
    public void displayQuestionsRemaining(int questionsRemaining){
      questionCount.setText(String.valueOf(questionsRemaining));
    }
    // TODO 4-A: onAnswerSelected(int answerSelected) {...}
    public void onAnswerSelected(int answerSelected) {
        Question currentQuestion = getCurrentQuestion();
        currentQuestion.playerAnswer = answerSelected;
        answer0.setText(currentQuestion.answer0);
        answer1.setText(currentQuestion.answer1);
        answer2.setText(currentQuestion.answer2);
        answer3.setText(currentQuestion.answer3);


        switch(answerSelected) {
            case 0:
                answer0.setText("✔ " + currentQuestion.answer0);
                break;
            case 1:
                answer1.setText("✔ " + currentQuestion.answer1);
                break;
            case 2:
                answer2.setText("✔ " + currentQuestion.answer2);
                break;
            case 3:
                answer3.setText("✔ " + currentQuestion.answer3);
                break;
        }

    }


    void onAnswerSubmission() {
        Question currentQuestion = getCurrentQuestion();
        if(currentQuestion.playerAnswer > -1){
        if (currentQuestion.isCorrect()) {
            totalCorrect = totalCorrect + 1;
        }
        questions.remove(currentQuestion);}
        else return;

        // TODO 3-D.i: Uncomment the line below after implementing displayQuestionsRemaining(int)
        displayQuestionsRemaining(questions.size());

        if (questions.size() == 0) {
            String gameOverMessage = getGameOverMessage(totalCorrect, totalQuestions);

            // TODO 5-D: Show a popup instead
            AlertDialog.Builder gameOverDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            gameOverDialogBuilder.setCancelable(false);
            gameOverDialogBuilder.setTitle("Game Over!");
            gameOverDialogBuilder.setMessage(gameOverMessage);
            gameOverDialogBuilder.setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startNewGame();
                }
            });
            gameOverDialogBuilder.create().show();

        } else {
            chooseNewQuestion();

            // TODO 3-H.i: uncomment after implementing displayQuestion(Question)
            displayQuestion(getCurrentQuestion());
        }
    }

    void startNewGame() {
        questions = new ArrayList<>();

        // TODO 2-H: Provide actual drawables for each of these questions!
        Question question0 = new Question(R.drawable.img_quote_0, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question1 = new Question(R.drawable.img_quote_1, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question2 = new Question(R.drawable.img_quote_2, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question3 = new Question(R.drawable.img_quote_3, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question4 = new Question(R.drawable.img_quote_4, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question5 = new Question(R.drawable.img_quote_5, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question6 = new Question(R.drawable.img_quote_6, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question7 = new Question(R.drawable.img_quote_7, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question8 = new Question(R.drawable.img_quote_8, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question9 = new Question(R.drawable.img_quote_9, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question10 = new Question(R.drawable.img_quote_10, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question11 = new Question(R.drawable.img_quote_11, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);
        Question question12 = new Question(R.drawable.img_quote_12, "This is a test question!", "Test Answer 0", "Test Answer 1", "Test Answer 2", "Test Answer 3", 2);

        questions.add(question0);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question10);
        questions.add(question11);
        questions.add(question12);


        while(questions.size()>6){ //a game is only 6 questions
            int randomNum = generateRandomNumber(questions.size());
            questions.remove(randomNum);
        }

        totalCorrect = 0;
        totalQuestions = questions.size();

        Question firstQuestion = chooseNewQuestion();

        // TODO 3-D.ii: Uncomment the line below after implementing displayQuestionsRemaining(int)
        displayQuestionsRemaining(questions.size());

        // TODO 3-H.ii: Uncomment after implementing displayQuestion(Question)
         displayQuestion(firstQuestion);
    }

    Question chooseNewQuestion() {
        int newQuestionIndex = generateRandomNumber(questions.size());
        currentQuestionIndex = newQuestionIndex;
        return questions.get(currentQuestionIndex);
    }

    int generateRandomNumber(int max) {
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    Question getCurrentQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        return currentQuestion;
    }

    String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if (totalCorrect == totalQuestions) {
            return "You got all " + totalQuestions + " right! You won!";
        } else {
            return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
        }
    }
}