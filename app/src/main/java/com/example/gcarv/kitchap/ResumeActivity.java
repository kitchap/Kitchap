package com.example.gcarv.kitchap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ResumeActivity extends AppCompatActivity {

    private ImageView imgViewPreviousResume;
    private LinearLayout linearLayItemResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        imgViewPreviousResume = (ImageView)findViewById(R.id.imgViewPreviousResume);
        imgViewPreviousResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        linearLayItemResume = (LinearLayout)findViewById(R.id.news_item);
        linearLayItemResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResumeActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
