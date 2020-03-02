package com.example.billit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.billit.models.BillItem;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ItemHolder> {

    ArrayList<BillItem> mBillList;

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        BillItem item = mBillList.get(position);

        holder.setAttributes(item.mTitle, item.mSubTitle);
    }

    @Override
    public int getItemCount() {
        return mBillList.size();
    }

    public Adapter(ArrayList<BillItem> list){
        this.mBillList = list;
    }

    class ItemHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mHeadText;
        TextView mSubText;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView3);
            mHeadText = itemView.findViewById(R.id.textView3);
            mSubText = itemView.findViewById(R.id.textView4);
        }

        public void setAttributes(String title, String subTitle){
            mHeadText.setText(title);
            mSubText.setText(subTitle);
        }
    }
}

