package com.example.asad.zuoye.afragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asad.zuoye.R;
import com.example.asad.zuoye.bean.Shujukulei;
import com.example.asad.zuoye.m.MShixianlei;
import com.example.asad.zuoye.p.PShiXianlei;
import com.example.asad.zuoye.v.ViewInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements ViewInterface{


    private AAdapter adapter;
    private View view;
    private RecyclerView mRv;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        final ArrayList<Shujukulei> arrayList = new ArrayList<>();
        adapter = new AAdapter(arrayList, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRv.setLayoutManager(manager);
        mRv.setAdapter(adapter);
        for (int i = 0; i < 20; i++) {
            arrayList.add(new Shujukulei(Long.valueOf(i), 123, "张三" + i));
        }
        adapter.notifyDataSetChanged();

        final PShiXianlei pShiXianlei = new PShiXianlei(new MShixianlei(), this);
        adapter.setOnclick(new AAdapter.Onclick() {
            @Override
            public void duanan(int postion) {
                pShiXianlei.getChaRuData(arrayList.get(postion));
            }
        });
        return inflate;
    }


    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
    }

    @Override
    public void onCharuChenggong(String s) {
        Toast.makeText(getContext(), "插入成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCharuShibai(String s) {
        Toast.makeText(getContext(), "插入失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onChaXunChenggong(List<Shujukulei> mlist) {

    }

    @Override
    public void onChaXunShibai(String s) {

    }
}
