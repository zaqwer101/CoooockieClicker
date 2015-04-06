package com.example.platonov.lesson2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends ActionBarActivity {
    // Переменные
    ImageButton imgBut;
    Button button_shop;
    TextView txtView, txtScoreClick;

    public static long score;
    public static long score_for_click;
    String str, string_score;
    String[] str_;

    //Методы
    void writeFile(String filename, String str_) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput(filename, MODE_PRIVATE)));
            bw.write(str_);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String FILENAME)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
            return br.readLine();
        } catch (FileNotFoundException e)
        {
            return "0 1";
        } catch (IOException e)
        {
            return "0 1";
        }
        catch (NullPointerException e)
        {
            return "0 1";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            str_ = readFile("cookie_score").trim().split("\\s+");
            score = Long.getLong(str_[0]);
            score_for_click = Long.getLong(str_[1]);
        }
        catch(NullPointerException e)
        {
            score = 0;
            score_for_click = 1;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button_shop = (Button) findViewById(R.id.button_shop);
        txtScoreClick = (TextView) findViewById(R.id.textView6);
        imgBut = (ImageButton) findViewById(R.id.imageButton);
        txtView = (TextView) findViewById(R.id.textView);

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
                        txtScoreClick.setText(score_for_click+"");
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
    public void onBackPressed() {
        str = score+" "+score_for_click;
        writeFile("cookie_score",str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
