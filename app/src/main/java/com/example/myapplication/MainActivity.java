package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int userTotalScore, compTotalScore, score;

    int diceValue;
    boolean isUsersTurn;

    ImageView imageDice;
    Button roll, hold, reset;
    TextView scores, turn, turnScore;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll = (Button) findViewById(R.id.roll);
        hold = (Button) findViewById(R.id.hold);
        reset = (Button) findViewById(R.id.reset);
        scores = (TextView) findViewById(R.id.scores);
        turn  = (TextView) findViewById(R.id.turn);
        imageDice = (ImageView) findViewById(R.id.imageDice);
        turnScore = (TextView) findViewById(R.id.turn_score);

        scores.setText("Your Score: 0  Computer Score: 0");
        turn.setText("Your turn");
        turnScore.setText("Turn Score: 0");

        userTotalScore = 0;
        compTotalScore = 0;
        score = 0;
        isUsersTurn = true;

    }
    /** Called when the user taps the roll button
     * Randomly selects a dice value
     * update display to reflect rolled value
     * */
    public void roll (View view) {
//         int value;
         Random random = new Random();
         diceValue = random.nextInt(5) + 1;

         if (diceValue == 1) {
            finalizeScore();
         } else {
             score += diceValue;
         }
         setViews();

    }

    public void hold (View view){
        if (isUsersTurn){
            userTotalScore += score;
            score = 0;
        }
        else {
            compTotalScore += score;
            score = 0;
        }

        setViews();
    }
    public void reset (View view) {
        score = 0;
        userTotalScore = 0;
        compTotalScore = 0;
        setViews();
    }
    private void setViews () {
        if (isUsersTurn) {
            turn.setText("Your turn");
        } else {
            turn.setText("Computer's Turn");
        }
        switch (diceValue)
        {
            case 1:
                imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                break;
            case 2:
                imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                break;
            case 3:
                imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                break;
            case 4:
                imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                break;
            case 5:
                imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                break;
            case 6:
                imageDice.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                break;

        }
        turnScore.setText("Turn score:" +score);
        scores.setText("Your score : " +  userTotalScore + "   Computer Score: " + compTotalScore);


    }

    private void finalizeScore(){
        if (isUsersTurn == true){
            userTotalScore += score;
        } else {
            compTotalScore += score;
        }

        //reset game
        isUsersTurn = !isUsersTurn;
        score = 0;
    }

}
