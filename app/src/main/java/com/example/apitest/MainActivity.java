package com.example.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<BlogDataResponse> blogDataResponseList = new ArrayList<>();
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView= findViewById(R.id.gridView);

        getAllBlogData();
    }

    public void getAllBlogData(){
        Call<List<BlogDataResponse>> imageResponse = ApiClient.getInterface().getAllBlogData();

        imageResponse.enqueue(new Callback<List<BlogDataResponse>>() {
            @Override
            public void onResponse(Call<List<BlogDataResponse>> call, Response<List<BlogDataResponse>> response) {
                if (response.isSuccessful()){

                    String message = "Request Successful";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                    blogDataResponseList = response.body();
                    CustomAdapter customAdapter= new CustomAdapter(blogDataResponseList,MainActivity.this);
                    gridView.setAdapter(customAdapter);

                }
                else {
                    String message = "An error occurred try again later...";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<BlogDataResponse>> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this, message,Toast.LENGTH_LONG).show();

            }
        });
    }

    public  class CustomAdapter extends BaseAdapter{

        private  List<BlogDataResponse> blogDataResponseList;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(List<BlogDataResponse> blogDataResponseList, Context context) {
            this.blogDataResponseList = blogDataResponseList;
            this.context = context;
            this.layoutInflater=(LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return blogDataResponseList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view==null){
                view= layoutInflater.inflate(R.layout.row_grid_items,viewGroup,false);
            }
            ImageView imageView=view.findViewById(R.id.imageView);
            TextView textView= view.findViewById(R.id.textView);

            textView.setText(blogDataResponseList.get(i).getTitle());

            Glide.with(context)
                    .load(blogDataResponseList.get(i)
                            .getThumbnail()).into(imageView);

            return view;
        }
    }
}