package com.github.zlcommoncelldemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MyViewHolder(LayoutInflater.from(MainActivity4.this).inflate(R.layout.item_cell3, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder viewHolder1 = (MyViewHolder)viewHolder;
            viewHolder1.leftImageView.setImageDrawable(getResources().getDrawable(R.mipmap.liuyifei));
            viewHolder1.topTextView.setText("刘亦菲");
            viewHolder1.bottomTextView.setText("刘亦菲，1987年8月25日出生于湖北省武汉市，华语影视女演员、歌手，毕业于北京电影学院2002级表演系本科班。");
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView leftImageView;
            public TextView topTextView;
            public TextView bottomTextView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                leftImageView = itemView.findViewById(R.id.leftImage);
                topTextView = itemView.findViewById(R.id.topText);
                bottomTextView = itemView.findViewById(R.id.bottomText);
            }
        }
    }
}
