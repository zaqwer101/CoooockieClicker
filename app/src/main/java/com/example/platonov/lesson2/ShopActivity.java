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


public class ShopActivity extends ActionBarActivity {

    public Button btn_farm, btn_factory, btn_mine, btn_lab;
    public TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        btn_farm = (Button) findViewById(R.id.button);
        btn_factory = (Button) findViewById(R.id.button2);
        btn_mine = (Button) findViewById(R.id.button3);
        btn_lab = (Button) findViewById(R.id.button4);
        txtView = (TextView) findViewById(R.id.textView7);

        View.OnClickListener oclBtn = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.button:
                    {
                        if(MainActivity.score >= 100)
                        {
                            MainActivity.score_for_click += 1;
                            MainActivity.score -= 100;
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }
                    case R.id.button2:
                    {
                        if(MainActivity.score >= 500)
                        {
                            MainActivity.score_for_click += 6;
                            MainActivity.score -= 500;
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }
                    case R.id.button3:
                    {
                        if(MainActivity.score >= 2000)
                        {
                            MainActivity.score_for_click += 30;
                            MainActivity.score -= 2000;
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }

                    case R.id.button4:
                    {
                        if(MainActivity.score >= 10000)
                        {
                            MainActivity.score_for_click += 200;
                            MainActivity.score -= 10000;
                            txtView.setText(MainActivity.score+"");
                        }
                        break;
                    }
                }
            }
        };
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
