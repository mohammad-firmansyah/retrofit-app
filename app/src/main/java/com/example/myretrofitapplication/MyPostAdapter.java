package com.example.myretrofitapplication;

import static android.os.FileUtils.copy;

import android.content.Context;
//import android.support.v7.widget.RecyclerView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder> {


    Photo[] myPostData;
    Context context;
    public MyPostAdapter(Photo[] data, MainActivity mainActivity){
        this.myPostData =data;
        this.context = mainActivity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.post_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Photo myPostData2 = myPostData[position];
        holder.tvName.setText(myPostData2.getTitle());
        holder.tvDate.setText(myPostData2.getThumbnailUrl());

        Picasso.get().load(myPostData2.getThumbnailUrl()).into(holder.movieImg);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView tvResult = v.findViewById(R.id.tvName);
                tvResult.setText("baru muncul");
            }
        });
    }

    @Override
    public int getItemCount() {
        if (myPostData != null)
            return myPostData.length;
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImg;
        TextView tvName;
        TextView tvDate;
        public ViewHolder (@NonNull View v) {
            super(v);
            movieImg = v.findViewById(R.id.imgview);
            tvName = v.findViewById(R.id.tvName);
            tvDate = v.findViewById(R.id.tvDesc);
        }
    }


}


//    @android.support.annotation.NonNull
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@android.support.annotation.NonNull @NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
//        View view = layoutInflater.inflate(R.layout.post_item_list,viewGroup,false);
//        ViewHolder viewHolder = new ViewHolder(view);
//
//        return viewHolder;
//
//    }
//
//    @Override
//    public void onBindViewHolder(@android.support.annotation.NonNull @NonNull ViewHolder viewHolder, int i) {
////        Photo[] Photo;
//        final Photo myPostData2 = myPostData.get(i);
//        viewHolder.tvName.setText(myPostData2.getTitle());
//        viewHolder.tvDate.setText(myPostData2.getThumbnailUrl());
//        viewHolder.movieImg.setImageResource(myPostData2.getDrwImg());
//
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,myPostData2.getTitle(),Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }