package edu.trincoll.dchitrak.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import java.time.chrono.MinguoChronology;
import java.util.Random;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameScreen extends AppCompatActivity {
    Random rand = new Random();
    int number = 1;
    int realAnswer;
    int numQues = 20;

    private int generateNum(int max){
        return rand.nextInt(max);
    }


    private void displayProblem(){

        int num1;
        int num2;
        num1 = generateNum(10);
        num2 = generateNum(10);
        TextView tv1 = (TextView) findViewById(R.id.textView);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textView4);

        tv1.setText(num1+ "");
        tv2.setText(num2+ "");
        tv3.setText(((numQues + 1) - number)+"");
        realAnswer = num1+num2;

        checkEnd();
    }

    private void buttonClick(){
        final EditText ed = (EditText) findViewById(R.id.editText4);
        Button press = (Button) findViewById(R.id.button2);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = ed.getText().toString();
                int finalValue = Integer.parseInt(value);
                if (finalValue == realAnswer) {
                    //Log.d("Success", "Happy")
                    number++;;
                    displayProblem();
                } else {
                    //Log.d("Fail", "Sad");
                }
                ed.setText("");
            }
        });
    }

    private void checkEnd(){
        //Log.d("Exit", "Help");
        if (number>numQues){
            Intent startint = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(startint);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        displayProblem();
        buttonClick();
    }
}
