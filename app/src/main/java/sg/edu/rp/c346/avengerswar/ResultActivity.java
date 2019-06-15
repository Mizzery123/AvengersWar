package sg.edu.rp.c346.avengerswar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    ImageButton btn;
    int highScore;
    ImageView medal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        final TextView highScoreLabel = (TextView) findViewById(R.id.hightScoreLabel);
        TextView gamesPlayedLabel = (TextView) findViewById(R.id.gamesPlayedLabel);
        medal = (ImageView) findViewById(R.id.medal);
        btn = (ImageButton) findViewById(R.id.imageButton2);

btn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        SharedPreferences preferencesScore = getSharedPreferences("HIGHSCORE", Context.MODE_PRIVATE);
        highScore = preferencesScore.getInt("HIGHSCORE", 0);
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareBody = "Wowies! Can you believe it? \nMy highscore for Avengers War is " + highScore;
String shareSub = "Holla!";
myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
startActivity(Intent.createChooser(myIntent, "Share using"));
    }
});


        int score = getIntent().getIntExtra("SCORE", 0);
        scoreLabel.setText(""+score);

        if (score < 50){
            medal.setImageResource(R.drawable.bronze);
        } else  if (score >= 150){
            medal.setImageResource(R.drawable.gold);
        } else {
            medal.setImageResource(R.drawable.silver);
        }

        SharedPreferences preferencesScore = getSharedPreferences("HIGHSCORE", Context.MODE_PRIVATE);
        highScore = preferencesScore.getInt("HIGHSCORE", 0);

        if (score > highScore) {
            highScoreLabel.setText("High Score: " + score);

            SharedPreferences.Editor editor = preferencesScore.edit();
            editor.putInt("HIGHSCORE", score);
            editor.commit();
        } else {
            highScoreLabel.setText("High Score: "+ highScore);
        }

        SharedPreferences preferencesGames = getSharedPreferences("GAMES", Context.MODE_PRIVATE);
        int games = preferencesGames.getInt("GAMES", 0);

        gamesPlayedLabel.setText("Games Played: "+ (games+1));

        SharedPreferences.Editor editor = preferencesGames.edit();
        editor.putInt("GAMES", (games+1));
        editor.commit();
    }

    public void tryAgain(View view){
        startActivity(new Intent(getApplicationContext(), StartActivity.class));
        finish();
    }

    //disable return button
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN){
            switch (event.getKeyCode()){
                case  KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return  super.dispatchKeyEvent(event);
    }
}
