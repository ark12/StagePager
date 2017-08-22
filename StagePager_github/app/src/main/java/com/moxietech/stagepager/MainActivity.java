package com.moxietech.stagepager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moxietech.stagepager.customviews.StageView;

public class MainActivity extends AppCompatActivity {

    private StageView stageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stageView = (StageView) findViewById(R.id.stage_view);
    }
}
