package com.example.android.badmintonscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app is a score counter for badminton.
 * It follows the rules of badminton.
 * It also automatically switch game and show a winner.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Creates values for both team's original score and game number.
     * It also creates the value for the reset counter.
     */
    int scoreA = 0;
    int scoreB = 0;
    int gameA = 0;
    int gameB = 0;
    int resetCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This function displays score of current game.
     */
    public void displayScore() {
        TextView scoreForTeamA = findViewById(R.id.team_a_score);
        TextView scoreForTeamB = findViewById(R.id.team_b_score);
        scoreForTeamA.setText(String.valueOf(scoreA));
        scoreForTeamB.setText(String.valueOf(scoreB));
    }

    /**
     * This function add point for Team A and check if there is a winner.
     */
    public void teamAScore(View view) {
        scoreA += 1;
        checkGameWinner();
    }

    /**
     * This function add point for Team B and check if there is a winner.
     */
    public void teamBScore(View view) {
        scoreB += 1;
        checkGameWinner();
    }

    /**
     * This function updates the game table if any of the team win the current game.
     */
    public void updateTable() {
        TextView gameOneTeamA = findViewById(R.id.game1_a);
        TextView gameOneTeamB = findViewById(R.id.game1_b);
        TextView gameTwoTeamA = findViewById(R.id.game2_a);
        TextView gameTwoTeamB = findViewById(R.id.game2_b);
        TextView gameThreeTeamA = findViewById(R.id.game3_a);
        TextView gameThreeTeamB = findViewById(R.id.game3_b);
        if (gameA > 0 && gameB > 0) {
            gameThreeTeamA.setText(String.valueOf(scoreA));
            gameThreeTeamB.setText(String.valueOf(scoreB));
        } else if (gameA > 0 || gameB > 0) {
            gameTwoTeamA.setText(String.valueOf(scoreA));
            gameTwoTeamB.setText(String.valueOf(scoreB));
        } else {
            gameOneTeamA.setText(String.valueOf(scoreA));
            gameOneTeamB.setText(String.valueOf(scoreB));
        }
        scoreA = 0;
        scoreB = 0;
    }

    /**
     * This function will shows the winner message if any of the team won the match.
     */
    public void winnerMessage() {
        TextView winnerTeam = findViewById(R.id.winner_team);
        if (gameA > 1) {
            winnerTeam.setText(R.string.team_a);
            findViewById(R.id.winner_message).setVisibility(View.VISIBLE);
        }
        if (gameB > 1) {
            winnerTeam.setText(R.string.team_b);
            findViewById(R.id.winner_message).setVisibility(View.VISIBLE);
        }
    }

    /**
     * This function checks if any of the team win the game.
     */
    public void checkGameWinner() {
        if (scoreA > 29) {
            updateTable();
            gameA += 1;
            winnerMessage();
        } else if (scoreA > 20 && scoreA - scoreB > 1) {
            updateTable();
            gameA += 1;
            winnerMessage();
        }
        if (scoreB > 29) {
            updateTable();
            gameB += 1;
            winnerMessage();
        } else if (scoreB > 20 && scoreB - scoreA > 1) {
            updateTable();
            gameB += 1;
            winnerMessage();
        }
        displayScore();
    }

    /**
     * This function resets everything to original state.
     */
    public void resetScore(View view) {
        resetCounter += 1;
        if (resetCounter > 1) {
            TextView gameOneTeamA = findViewById(R.id.game1_a);
            TextView gameOneTeamB = findViewById(R.id.game1_b);
            TextView gameTwoTeamA = findViewById(R.id.game2_a);
            TextView gameTwoTeamB = findViewById(R.id.game2_b);
            TextView gameThreeTeamA = findViewById(R.id.game3_a);
            TextView gameThreeTeamB = findViewById(R.id.game3_b);
            scoreA = 0;
            scoreB = 0;
            gameA = 0;
            gameB = 0;
            displayScore();
            gameThreeTeamA.setText(String.valueOf(scoreA));
            gameThreeTeamB.setText(String.valueOf(scoreB));
            gameTwoTeamA.setText(String.valueOf(scoreA));
            gameTwoTeamB.setText(String.valueOf(scoreB));
            gameOneTeamA.setText(String.valueOf(scoreA));
            gameOneTeamB.setText(String.valueOf(scoreB));
            findViewById(R.id.winner_message).setVisibility(View.INVISIBLE);
            resetCounter = 0;
        } else {
            //Let the user to confirm for the reset
            Toast.makeText(this, R.string.reset_confirmation, Toast.LENGTH_SHORT).show();
        }

    }
}
