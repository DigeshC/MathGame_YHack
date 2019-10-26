package edu.trincoll.dchitrak.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ResultsPage extends AppCompatActivity {

    private void buttonClick(){
        ImageButton exitButton = (ImageButton) findViewById(R.id.imageButton2);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startint = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startint);
            }
        });
    }

    private void dispFinal(){
        String Score = getIntent().getExtras().getString("Score");
        String Time = getIntent().getExtras().getString("Time");

        TextView tvs = (TextView) findViewById(R.id.dispScore);
        TextView tvt = (TextView) findViewById(R.id.dispTime);

        tvs.setText(Score);
        tvt.setText(Time);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);
        dispFinal();
        buttonClick();
    }
}
