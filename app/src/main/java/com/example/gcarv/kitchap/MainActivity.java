package com.example.gcarv.kitchap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearLayBtnFruits,linearLayBtnVegetables,linearLayBtnMeat,
            linearLayBtnCereals,linearLayBtnMilk,linearLayBtnFish;
    private String selectedCategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayBtnFruits = (LinearLayout)findViewById(R.id.linearLayBtnFruits);
        linearLayBtnVegetables = (LinearLayout)findViewById(R.id.linearLayBtnVegetables);
        linearLayBtnMeat = (LinearLayout)findViewById(R.id.linearLayBtnMeat);
        linearLayBtnCereals = (LinearLayout)findViewById(R.id.linearLayBtnCereals);
        linearLayBtnMilk = (LinearLayout)findViewById(R.id.linearLayBtnMilk);
        linearLayBtnFish = (LinearLayout)findViewById(R.id.linearLayBtnFish);

        linearLayBtnFruits.setOnClickListener(this);
        linearLayBtnVegetables.setOnClickListener(this);
        linearLayBtnMeat.setOnClickListener(this);
        linearLayBtnCereals.setOnClickListener(this);
        linearLayBtnMilk.setOnClickListener(this);
        linearLayBtnFish.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.linearLayBtnFruits:
                selectedCategorie = "fruits";
                goToResumeActivity(selectedCategorie);
                break;

            case R.id.linearLayBtnVegetables:
                selectedCategorie = "vegetables";
                goToResumeActivity(selectedCategorie);
                break;

            case R.id.linearLayBtnMeat:
                selectedCategorie = "meat";
                goToResumeActivity(selectedCategorie);
                break;

            case R.id.linearLayBtnCereals:
                selectedCategorie = "cereals";
                goToResumeActivity(selectedCategorie);
                break;

            case R.id.linearLayBtnMilk:
                selectedCategorie = "milk";
                goToResumeActivity(selectedCategorie);
                break;

            case R.id.linearLayBtnFish:
                selectedCategorie = "fish";
                goToResumeActivity(selectedCategorie);
                break;
        }

    }

    public void goToResumeActivity(String categorie){
        Intent intent = new Intent(MainActivity.this,ResumeActivity.class);
        intent.putExtra("CATEGORIE",categorie);
        startActivity(intent);
    }
}
