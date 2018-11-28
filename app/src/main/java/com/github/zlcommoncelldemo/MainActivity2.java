package com.github.zlcommoncelldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(new MyAdapter());
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
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
            View view = LayoutInflater.from(MainActivity2.this)
                    .inflate(R.layout.item_tabicon, viewGroup, false);
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            view.setLayoutParams(params);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder viewHolder1 = (MyViewHolder)viewHolder;
            viewHolder1.topImageView.setImageDrawable(getResources().getDrawable(R.mipmap.timg));
            viewHolder1.bottomTextView.setText("首页");
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView topImageView;
            public TextView bottomTextView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                topImageView = itemView.findViewById(R.id.topImage);
                bottomTextView = itemView.findViewById(R.id.bottomText);
            }
        }
    }
}
