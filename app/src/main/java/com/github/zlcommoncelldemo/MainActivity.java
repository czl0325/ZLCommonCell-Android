package com.github.zlcommoncelldemo;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                }));
    }

    private class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(MainActivity.this)
                            .inflate(R.layout.item_wraptext,viewGroup,false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder viewHolder1 = (MyViewHolder)viewHolder;
            viewHolder1.leftImageView.setImageDrawable(getResources().getDrawable(R.mipmap.timg));
            viewHolder1.leftText.setText("标题");
            if (i%2==0) {
                viewHolder1.rightText.setText(getResources().getString(R.string.content));
                viewHolder1.leftImageView.setVisibility(View.GONE);
            } else {
                viewHolder1.rightText.setText("短文字");
                viewHolder1.leftImageView.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView leftImageView;
            public TextView leftText;
            public ImageView rightImageView;
            public TextView rightText;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                leftImageView = itemView.findViewById(R.id.leftImage);
                leftText = itemView.findViewById(R.id.leftText);
                rightImageView = itemView.findViewById(R.id.rightImage);
                rightText = itemView.findViewById(R.id.rightText);
            }
        }
    }
}
