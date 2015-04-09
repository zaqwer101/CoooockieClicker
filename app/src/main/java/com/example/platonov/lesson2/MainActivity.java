package com.example.platonov.lesson2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;


public class MainActivity extends ActionBarActivity {
    // Переменные
    ImageButton imgBut;
    Button button_shop;
    TextView txtView, txtScoreClick;
    public static LinearLayout f1;
    public static long score = 0;
    public static long score_for_click = 1;
    Random rand = new Random();
    String str, string_score;
    String[] str_;

    //Методы
    void writeFile() {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput("cookie_score.txt", MODE_PRIVATE)));
            bw.write(score + "-" + score_for_click);
            bw.close();
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)

        {
            e.printStackTrace();
        }
    }

    public void readFile()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("cookie_score.txt")));
            String x = br.readLine();
            str_ = x.split("-");
            this.score = Long.getLong(str_[0]);
            this.score_for_click = Long.getLong(str_[1]);
            Toast.makeText(this, score_for_click+"" , Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e)

        {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        readFile();
        button_shop = (Button) findViewById(R.id.button_shop);
        txtScoreClick = (TextView) findViewById(R.id.textView6);
        imgBut = (ImageButton) findViewById(R.id.imageButton);
        txtView = (TextView) findViewById(R.id.textView);
        f1 = (LinearLayout) findViewById(R.id.linearlayot);
        txtView.setText(score+"");
        txtScoreClick.setText(score_for_click+"");

        // создаем единый обработчик нажатия
        View.OnClickListener oclBtn = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.imageButton:
                    {
                        int x;
                        f1.setBackgroundColor(x = -rand.nextInt(0xFFFFFF));
                        imgBut.setBackgroundColor(x);
                        txtScoreClick.setText(score_for_click + "");
                        score += score_for_click;
                        string_score = Long.toString(score);
                        txtView.setText(string_score);
                        break;
                    }
                    case R.id.button_shop:
                    {
                        Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };

        // присвоим обработчик
        button_shop.setOnClickListener(oclBtn);
        imgBut.setOnClickListener(oclBtn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add("Сохранить");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        writeFile();
        Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
