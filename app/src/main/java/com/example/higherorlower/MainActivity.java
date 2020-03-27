package com.example.higherorlower;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int i;
    int randomNumber;
    public void generateRandomNumber()
    {
        Random rand= new Random();
        randomNumber = rand.nextInt(20) + 1;

    }
     public void guess(View view)
     {
         EditText editText= (EditText)findViewById(R.id.editText);
         int guessValue=Integer.parseInt(editText.getText().toString());
         String message;

         if (guessValue > randomNumber)
         {
             i++;
             message="Try Lower:(";
         }
         else if(guessValue < randomNumber)
         {
             i++;
             message="Higher Dude!";
         }
         else if(i==1 && guessValue==randomNumber)
         {
             i++;
             message="BINGO! You are the champion;)";
             generateRandomNumber();
             i=1;
         }
         else
         {
             i++;
             message="You got it, in "+i+" tries;) PLAY AGAIN";
             generateRandomNumber();
             i=1;
         }
         Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=1;
        generateRandomNumber();
    }
}

