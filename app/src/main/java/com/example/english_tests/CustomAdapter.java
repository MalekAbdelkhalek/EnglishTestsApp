package com.example.english_tests;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<String> name;
    private ArrayList<Integer> level1,level2,level3,level4,level5,overall,rank;
    private ArrayList<byte[]> image;


    public CustomAdapter(Context context, ArrayList<String> name, ArrayList<Integer> level1, ArrayList<Integer> level2, ArrayList<Integer> level3, ArrayList<Integer> level4, ArrayList<Integer> level5, ArrayList<Integer> overall, ArrayList<byte[]> image,ArrayList<Integer> rank) {
        this.context = context;
        this.name = name;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.level4 = level4;
        this.level5 = level5;
        this.overall = overall;
        this.image = image;
        this.rank = rank;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.namet.setText(String.valueOf(name.get(position)));
        holder.rankt.setText(String.valueOf(rank.get(position)));
        holder.l1.setText(String.valueOf(level1.get(position)));
        holder.l2.setText(String.valueOf(level2.get(position)));
        holder.l3.setText(String.valueOf(level3.get(position)));
        holder.l4.setText(String.valueOf(level4.get(position)));
        holder.l5.setText(String.valueOf(level5.get(position)));
        holder.lo.setText(String.valueOf(overall.get(position)));


        Bitmap bitmap= BitmapFactory.decodeByteArray(image.get(position),0,image.get(position).length);
        int desiredWidth = 500;
        int desiredHeight = 500;
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, desiredWidth, desiredHeight, false);
        Resources res = context.getResources();
        Drawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(res, resizedBitmap);
        ((RoundedBitmapDrawable)roundedBitmapDrawable).setCornerRadius(100f);
        holder.iv.setImageDrawable(roundedBitmapDrawable);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView namet,l1,l2,l3,l4,l5,lo,rankt;
        ImageView iv;
        LinearLayout view_acitvity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namet= itemView.findViewById(R.id.namet);
            rankt= itemView.findViewById(R.id.rankt);
            iv= itemView.findViewById(R.id.iv);
            l1=itemView.findViewById(R.id.l1);
            l2=itemView.findViewById(R.id.l2);
            l3=itemView.findViewById(R.id.l3);
            l4=itemView.findViewById(R.id.l4);
            l5=itemView.findViewById(R.id.l5);
            lo=itemView.findViewById(R.id.lo);
            view_acitvity= itemView.findViewById(R.id.view_acitvity);

        }
    }
}
