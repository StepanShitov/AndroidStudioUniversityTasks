package com.example.a1lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

        int screenParams = getResources().getConfiguration().smallestScreenWidthDp;
        if(screenParams < 350) {
            screenParams = getResources().getConfiguration().orientation;
            if(screenParams == Configuration.ORIENTATION_PORTRAIT)
            {
                Fragment1 f1 = new Fragment1();
                Fragment2 f2 = new Fragment2();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.FirstFargment, f1, f1.getTag()).commit();
                manager.beginTransaction().replace(R.id.SecondFragment, f2, f2.getTag()).commit();
            }
        }
        else if(screenParams >= 350 && screenParams < 400)
        {
            screenParams = getResources().getConfiguration().orientation;
            if(screenParams == Configuration.ORIENTATION_PORTRAIT)
            {
                Fragment1 f1 = null;
                f1 = new Fragment1();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.sw350, f1).commit();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.resultsList: {
                Intent Intent = new Intent(this, ListMenu.class);
                startActivity(Intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void SumNumbers(View view)
    {
        int FirstNum, SecondNum;
        double Sum;
        switch (view.getId()) {
            case R.id.SumButton: {
                EditText Num = findViewById(R.id.FirstNumberInput);
                FirstNum = Integer.parseInt(Num.getText().toString());
                Num = findViewById(R.id.SecondNumberInput);
                SecondNum = Integer.parseInt(Num.getText().toString());
                Sum = FirstNum + SecondNum;
                TextView ResultTextView = findViewById(R.id.Result);
                ResultTextView.setText(Double.toString(Sum).substring(0, Double.toString(Sum).length() - 2));
                Snackbar.make(view, Double.toString(Sum).substring(0, Double.toString(Sum).length() - 2), Snackbar.LENGTH_LONG)
                        .show();
                break;
            }
            case R.id.SumButton2: {
                EditText Num = findViewById(R.id.FirstNumberInput2);
                FirstNum = Integer.parseInt(Num.getText().toString());
                Num = findViewById(R.id.SecondNumberInput2);
                SecondNum = Integer.parseInt(Num.getText().toString());
                Sum = FirstNum + SecondNum;
                TextView ResultTextView = findViewById(R.id.Result2);
                ResultTextView.setText(Double.toString(Sum).substring(0, Double.toString(Sum).length() - 2));
                Snackbar.make(view, Double.toString(Sum).substring(0, Double.toString(Sum).length() - 2), Snackbar.LENGTH_LONG)
                        .show();
                break;
            }
        }

        //Button Bt = findViewById(R.id.SumButton);
        //LinearLayout Lt = findViewById(R.id.TextInpLays);
        //float BtX = Bt.getX(), BtY = Bt.getY();
        //Bt.setX(Lt.getX());
        //Bt.setY(Lt.getY());

        //Lt.setX(BtX);
        //Lt.setY(BtY);

        Sum = 0;
    }


}