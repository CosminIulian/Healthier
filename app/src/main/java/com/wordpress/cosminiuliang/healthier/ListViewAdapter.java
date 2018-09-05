package com.wordpress.cosminiuliang.healthier;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    //variables
    private Context mContext;
    private LayoutInflater inflater;
    private List<Model> modelList;
    private ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modelList) {
        mContext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }

    public class ViewHolder{
        TextView mNameTv, mCaloriesTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row_aliments_list_view, null);

            //locate the views in row.xml
            holder.mNameTv = view.findViewById(R.id.nameAliments);
            holder.mCaloriesTv = view.findViewById(R.id.calories);
            holder.mIconIv = view.findViewById(R.id.icon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mNameTv.setText(modelList.get(postition).getName());
        holder.mCaloriesTv.setText(modelList.get(postition).getCalories());
        //set the result in imageview
        holder.mIconIv.setImageResource(modelList.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // action click list item

                // Ou
                if (modelList.get(postition).getName().equals("Ou")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Ou");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Carne de vita
                if (modelList.get(postition).getName().equals("Carne de vita")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Carne de vita");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Branza
                if (modelList.get(postition).getName().equals("Branza")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Branza");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Peste
                if (modelList.get(postition).getName().equals("Peste")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Peste");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Mar
                if (modelList.get(postition).getName().equals("Mar")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Mar");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Cartof
                if (modelList.get(postition).getName().equals("Cartof")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Cartof");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Lapte
                if (modelList.get(postition).getName().equals("Lapte")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Lapte");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Carne de curcan
                if (modelList.get(postition).getName().equals("Carne de curcan")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Carne de curcan");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Carne de miel si de oaie
                if (modelList.get(postition).getName().equals("Carne de miel si de oaie")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Carne de miel si de oaie");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Iaurt
                if (modelList.get(postition).getName().equals("Iaurt")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Iaurt");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }
                // Banana
                if (modelList.get(postition).getName().equals("Banana")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, ShowDetails.class);
                    intent.putExtra("actionBarTitle", "Banana");
                    intent.putExtra("contentTv", modelList.get(postition).getDesc());
                    mContext.startActivity(intent);
                }

            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if (charText.length()==0){
            modelList.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}