package com.example.a1lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SumNumbers(View view)
    {
        int FirstNum, SecondNum;
        double Sum;
        EditText Num = findViewById(R.id.FirstNumberInput);
        FirstNum = Integer.parseInt(Num.getText().toString());
        Num = findViewById(R.id.SecondNumberInput);
        SecondNum = Integer.parseInt(Num.getText().toString());
        Sum = FirstNum + SecondNum;
        TextView ResultTextView = findViewById(R.id.Result);
        ResultTextView.setText(Double.toString(Sum).substring(0, Double.toString(Sum).length() - 2));
        Snackbar.make(view, Double.toString(Sum).substring(0, Double.toString(Sum).length() - 2), Snackbar.LENGTH_LONG)
                .show();
        Button Bt = findViewById(R.id.SumButton);
        LinearLayout Lt = findViewById(R.id.TextInpLays);
        float BtX = Bt.getX(), BtY = Bt.getY();
        Bt.setX(Lt.getX());
        Bt.setY(Lt.getY());

        Lt.setX(BtX);
        Lt.setY(BtY);

        Sum = 0;
    }


}