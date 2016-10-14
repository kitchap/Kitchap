package com.example.gcarv.kitchap;

/**
 * Created by gcarv on 14/10/2016.
 */
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterListResume extends BaseAdapter{

    ArrayList<String> imageList;
    ArrayList<String> nameList;
    ArrayList<Integer> tempList;
    Resources resources;

    Context context;
    private static LayoutInflater inflater = null;

    public AdapterListResume(Context context, ArrayList<String> imageList, ArrayList<String> nameList,ArrayList<Integer> tempList) {
        // TODO Auto-generated constructor stub
        this.imageList = imageList;
        this.nameList = nameList;
        this.tempList = tempList;
        this.context = context;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        resources = context.getResources();

    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return nameList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        ImageView image;
        TextView name;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub


        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.item_list_resume, null);
        holder.name=(TextView) rowView.findViewById(R.id.txtViewName);
        holder.name.setText(nameList.get(position));

        final int resourceId = resources.getIdentifier(imageList.get(position), "mipmap", context.getPackageName());

        holder.image = (ImageView) rowView.findViewById(R.id.imgElement);
        holder.image.setImageResource(resourceId);

        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "Clicked " + nameList.get(position), Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

}