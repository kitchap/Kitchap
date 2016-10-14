package com.example.gcarv.kitchap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ResumeActivity extends AppCompatActivity {

    private ImageView imgViewPreviousResume;
    private LinearLayout linearLayItemResume;
    private ListView listViewResume;
    private AdapterListResume adapterListResume;

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

        listViewResume = (ListView)findViewById(R.id.listViewResume);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String categorie = extras.getString("CATEGORIE");

            switch (categorie){

                case "fruits":
                    Log.v("catt " , "fruits");
                    showCategorieList("fruits");
                    break;

                case "vegetables":
                    Log.v("catt " , "vegetables");

                    break;

                case "meat":
                    Log.v("catt " , "meat");

                    break;

                case "cereals":
                    Log.v("catt " , "cereals");

                    break;

                case "milk":
                    Log.v("catt " , "milk");

                    break;

                case "fish":
                    Log.v("catt " , "fish");

                    break;

            }

        }


    }

    public void showCategorieList(String categorie){

        InputStream inputStream = getResources().openRawResource(R.raw.database);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("Text Data", byteArrayOutputStream.toString());
        try {
            JSONObject jObject = new JSONObject(
                    byteArrayOutputStream.toString());
            JSONObject jObjectResult = jObject.getJSONObject("Categories");
            JSONArray jArray = jObjectResult.getJSONArray(categorie);
            String id = "";

            String image = "";
            String name = "";
            int temp;

            ArrayList<String> imgList = new ArrayList<String>();
            ArrayList<String> nameList = new ArrayList<String>();
            ArrayList<Integer> tempList = new ArrayList<Integer>();

            for (int i = 0; i < jArray.length(); i++) {
                id = jArray.getJSONObject(i).getString("id");
                image = jArray.getJSONObject(i).getString("image");
                name = jArray.getJSONObject(i).getString("name");
                temp = jArray.getJSONObject(i).getInt("temp");

                //Log.v("ID", id);
                //Log.v("Name", name);
                imgList.add(image);
                nameList.add(name);
                tempList.add(temp);
            }

            System.out.println("imgg " + imgList);


            adapterListResume = new AdapterListResume(this,imgList,nameList,tempList);
            listViewResume.setAdapter(adapterListResume);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
