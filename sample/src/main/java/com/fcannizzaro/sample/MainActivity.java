package com.fcannizzaro.sample;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button tabs, progress, text, dots, tabsNL, tabClassic;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data != null && data.getExtras() != null)
            for (String key : data.getExtras().keySet())
                Toast.makeText(this, key + " : " + data.getExtras().get(key).toString(), Toast.LENGTH_SHORT).show();

        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = findViewById(R.id.tabsL);
        tabsNL = findViewById(R.id.tabs);
        tabClassic = findViewById(R.id.tabClassic);
        text = findViewById(R.id.text);
        progress = findViewById(R.id.progress);
        dots = findViewById(R.id.dots);
        Toolbar toolbar = findViewById(R.id.toolbar);

        tabs.setOnClickListener(this);
        tabsNL.setOnClickListener(this);
        tabClassic.setOnClickListener(this);
        text.setOnClickListener(this);
        progress.setOnClickListener(this);
        dots.setOnClickListener(this);

        setSupportActionBar(toolbar);

    }

    @Override
    public void onClick(View view) {

        Intent intent = null;

        if (view == tabsNL)
            intent = new Intent(this, TabSample.class);
        else if (view == progress)
            intent = new Intent(this, ProgressSample.class);
        else if (view == text)
            intent = new Intent(this, TextSample.class);
        else if (view == dots)
            intent = new Intent(this, DotsSample.class);
        else if (view == tabClassic)
            intent = new Intent(this, TabClassicSample.class);
        else if (view == tabs) {
            intent = new Intent(this, TabSample.class);
            intent.putExtra("linear", true);
        }

        startActivityForResult(intent, 1);

    }


}
