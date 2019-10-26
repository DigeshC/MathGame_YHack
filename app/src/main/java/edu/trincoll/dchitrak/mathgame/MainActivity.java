package edu.trincoll.dchitrak.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button press = (Button) findViewById(R.id.button);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startint = new Intent(getApplicationContext(), FixedGame.class);
                //startint.putExtra("com.example.twobutton.SOMETHING", "");
                startActivity(startint);
            }
        });


    }
}
