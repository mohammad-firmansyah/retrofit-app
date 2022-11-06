package com.example.myretrofitapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private RecyclerView rcView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tvResult = findViewById(R.id.tv_result);
        rcView = findViewById(R.id.rc_view);
        rcView.setHasFixedSize(true);
        rcView.setLayoutManager(new LinearLayoutManager(this));
//        rcView.setLayoutManager(llm);
        Photo[] photos = new Photo[]{
                new Photo(1,2,"saya title 1","url satu",R.drawable.dua,"sdajsdnsajdn"),
                new Photo(4,3,"saya title 2","url sata",R.drawable.tiga,"sadsadas")

        };

        MyPostAdapter adapter = new MyPostAdapter(photos,MainActivity.this);
        rcView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JsonPlaceholderAPI.class);
        Call<List<Photo>> call = jsonPlaceholderAPI.getPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Code : " + response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Photo> photos2 = response.body();
                Photo[] photos = new Photo[photos2.size()];
                photos2.toArray(photos);
                Toast.makeText(getApplicationContext(),"Success : " + photos,Toast.LENGTH_SHORT).show();

                MyPostAdapter adapter = new MyPostAdapter(photos,MainActivity.this);
                rcView.setAdapter(adapter);
            }



            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}