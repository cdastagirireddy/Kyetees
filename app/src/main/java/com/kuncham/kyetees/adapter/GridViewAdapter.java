package com.kuncham.kyetees.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuncham.kyetees.modelclasses.Beanclass;
import com.kuncham.kyetees.ProductDetails;
import com.kuncham.kyetees.R;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    Context context;

    ArrayList<Beanclass> bean;
    public GridViewAdapter(Context context, ArrayList<Beanclass> bean) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.gridview, null);

            viewHolder = new ViewHolder();

            viewHolder.image1 = (ImageView) convertView.findViewById(R.id.image1);
            viewHolder.title1 = (TextView) convertView.findViewById(R.id.title1);
            viewHolder.discription1 = (TextView) convertView.findViewById(R.id.description1);
            viewHolder.date1 = (TextView) convertView.findViewById(R.id.date1);
            convertView.setTag(viewHolder);


        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }


        Beanclass bean = (Beanclass) getItem(position);

        viewHolder.image1.setImageResource(bean.getImage1());
        viewHolder.title1.setText(bean.getTitle1());
        viewHolder.discription1.setText(bean.getDiscription1());
        viewHolder.date1.setText(bean.getDate1());

        viewHolder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(context, ProductDetails.class);
                context.startActivity(ii);

            }
        });

        return convertView;
    }

    private class ViewHolder {
        ImageView image1;
        TextView title1;
        TextView discription1;
        TextView date1;

    }
}
