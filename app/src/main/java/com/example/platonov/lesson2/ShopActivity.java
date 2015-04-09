package com.example.platonov.lesson2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/*
    Для добавления новой постройки нужно добавить переменную кнопки, указать переменную стоимости и добавить в обработчик
*/

public class ShopActivity extends ActionBarActivity {
    //Переменные кнопок
    public Button btn_farm, btn_factory, btn_mine, btn_lab, btn_spsh;

    public TextView txtView;

    public static TextView txt1,txt2,txt3,txt4,txt5;

    //Переменные стоимости построек
    public static long farm_cost = 100,mine_cost = 500,factory_cost = 2000,lab_cost = 10000, spsh_cost = 100000;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        //Присваивание кнопок
        btn_farm = (Button) findViewById(R.id.button);
        btn_factory = (Button) findViewById(R.id.button2);
        btn_mine = (Button) findViewById(R.id.button3);
        btn_lab = (Button) findViewById(R.id.button4);
        btn_spsh = (Button) findViewById(R.id.button5);
        txtView = (TextView) findViewById(R.id.textView7);

        txt1 = (TextView) findViewById(R.id.textView2);
        txt2 = (TextView) findViewById(R.id.textView3);
        txt3 = (TextView) findViewById(R.id.textView4);
        txt4 = (TextView) findViewById(R.id.textView5);
        txt5 = (TextView) findViewById(R.id.textView8);

        txt1.setText(farm_cost+"");
        txt2.setText(mine_cost+"");
        txt3.setText(factory_cost+"");
        txt4.setText(lab_cost+"");
        txt5.setText(spsh_cost+"");

        // Обработчик
        View.OnClickListener oclBtn = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.button:
                    {
                        if(MainActivity.score >= farm_cost)
                        {
                            MainActivity.score_for_click += 1;
                            MainActivity.score -= farm_cost;
                            farm_cost*=1.3;
                            txt1.setText(farm_cost+"");
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }
                    case R.id.button2:
                    {
                        if(MainActivity.score >= factory_cost)
                        {
                            MainActivity.score_for_click += 8;
                            MainActivity.score -= factory_cost;
                            factory_cost*=1.3;
                            txt2.setText(factory_cost+"");
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }
                    case R.id.button3:
                    {
                        if(MainActivity.score >= mine_cost)
                        {
                            MainActivity.score_for_click += 40;
                            MainActivity.score -= mine_cost;
                            mine_cost*=1.3;
                            txt3.setText(mine_cost+"");
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }

                    case R.id.button4:
                    {
                        if(MainActivity.score >= lab_cost)
                        {
                            MainActivity.score_for_click += 220;
                            MainActivity.score -= lab_cost;
                            lab_cost*=1.3;
                            txt4.setText(lab_cost+"");
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }

                    case R.id.button5:
                    {
                        if(MainActivity.score >= spsh_cost)
                        {
                            MainActivity.score_for_click += 600;
                            MainActivity.score -= spsh_cost;
                            spsh_cost*=1.3;
                            txt5.setText(spsh_cost+"");
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }
                }
            }
        };

        //Присвоение кнопкам обработчик
        btn_farm.setOnClickListener(oclBtn);
        btn_factory.setOnClickListener(oclBtn);
        btn_mine.setOnClickListener(oclBtn);
        btn_lab.setOnClickListener(oclBtn);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shop, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
