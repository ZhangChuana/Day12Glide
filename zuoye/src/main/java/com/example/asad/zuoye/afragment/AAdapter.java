package com.example.asad.zuoye.afragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asad.zuoye.R;
import com.example.asad.zuoye.bean.Shujukulei;

import java.util.List;

/**
 * Created by 13768 on 2019/5/15.
 */

public class AAdapter extends RecyclerView.Adapter{
    private List<Shujukulei> mlist;
    private Context context;

    public AAdapter(List<Shujukulei> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Shujukulei shujukulei = mlist.get(position);
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.textView.setText(shujukulei.getTitle());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclick!=null) {
                    onclick.duanan(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv);
            imageView=itemView.findViewById(R.id.iv);
        }
    }

    private Onclick onclick;

    public void setOnclick(Onclick onclick) {
        this.onclick = onclick;
    }

    public interface Onclick{
        void duanan(int postion);
    }
}
