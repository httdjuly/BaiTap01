package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText Input;
    private TextView Output;
    private Button btn;
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Input = findViewById(R.id.editText);
        Output = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = Input.getText().toString();
                if (!input.isEmpty()) {
                    String reversedText = reverseWords(input);
                    Output.setText(reversedText);
                    Toast.makeText(MainActivity.this, reversedText, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Integer> arrayNumber = new ArrayList<>();
                ArrayList<Integer> arrayOddNumber = new ArrayList<>();
                ArrayList<Integer> arrayEvenNumber = new ArrayList<>();
                Random random = new Random();

                for (int i = 0; i < 20; i++) {
                    int randomNumber = random.nextInt(100);
                    arrayNumber.add(randomNumber);
                }
                Log.d("RandomNumbers", "arrayNumber: " + arrayNumber.toString());
                for (int number : arrayNumber) {
                    if (number % 2 == 0) {
                        arrayEvenNumber.add(number); // Số chẵn
                    } else {
                        arrayOddNumber.add(number); // Số lẻ
                    }
                }
                Log.d("EvenNumbers", "arrayEvenNumber: " + arrayEvenNumber.toString());
                Log.d("OddNumbers", "arrayOddNumber: " + arrayOddNumber.toString());
            }
        });

    }


    private String reverseWords(String input) {
        String[] words = input.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]).append(" ");
        }
        return reversedString.toString().trim();
    }
}