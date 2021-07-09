package com.example.Meetstranger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreAdapter extends BaseAdapter{

    private String name[];
    private int icons[];
    private Context context;

    public MoreAdapter(String[] name, int[] icons, Context context) {
        this.name = name;
        this.icons = icons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = layoutInflater.inflate(R.layout.grid_category,null);
        View view = LayoutInflater.from(context).inflate(R.layout.more_category,parent,false);

        ImageView imageView = view.findViewById(R.id.image_view);
        TextView textView = view.findViewById(R.id.text_view);

        imageView.setImageResource(icons[position]);
        textView.setText(name[position]);

        return view;
    }

}