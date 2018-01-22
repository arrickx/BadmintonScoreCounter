package com.example.android.badmintonscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA = 20;
    int scoreB = 20;
    int gameA = 0;
    int gameB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void displayScore() {
        TextView scoreForTeamA = findViewById(R.id.team_a_score);
        TextView scoreForTeamB = findViewById(R.id.team_b_score);
        scoreForTeamA.setText(String.valueOf(scoreA));
        scoreForTeamB.setText(String.valueOf(scoreB));
    }

    public void teamAScore(View view) {
        scoreA += 1;
        checkGameWinner();
    }

    public void teamBScore(View view) {
        scoreB += 1;
        checkGameWinner();
    }


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

    public void winnerMessage() {
        if (gameA > 1) {
            return;
        }
        if (gameB > 1) {
            return;
        }
    }

    public void checkGameWinner() {
        if (scoreA > 29) {
            updateTable();
            gameA += 1;
        } else if (scoreA > 20 && scoreA - scoreB > 1) {
            updateTable();
            gameA += 1;
        }
        if (scoreB > 29) {
            updateTable();
            gameB += 1;
        } else if (scoreB > 20 && scoreB - scoreA > 1) {
            updateTable();
            gameB += 1;
        }
        displayScore();
    }
}
