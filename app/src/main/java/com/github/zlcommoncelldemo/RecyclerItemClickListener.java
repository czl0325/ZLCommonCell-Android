package com.github.zlcommoncelldemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetector mGestureDetector;
    private RecyclerView mRecyclerView;
    private View mChildView;

    public RecyclerItemClickListener(Context context, final OnItemClickListener listener) {
        mGestureDetector = new GestureDetector(context,
                new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        if (mChildView != null && listener != null) {
                            listener.onItemClick(mChildView, mRecyclerView.getChildAdapterPosition(mChildView));
                        }
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        if (mChildView != null && listener != null) {
                            listener.onItemLongClick(mChildView, mRecyclerView.getChildAdapterPosition(mChildView));
                        }
                    }
                });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        mGestureDetector.onTouchEvent(motionEvent);
        mChildView = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        mRecyclerView = recyclerView;
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
}
