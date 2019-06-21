package com.example.asad.zuoye.bfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asad.zuoye.R;
import com.example.asad.zuoye.afragment.AAdapter;
import com.example.asad.zuoye.bean.Shujukulei;
import com.example.asad.zuoye.db.DataHelp;
import com.example.asad.zuoye.m.MShixianlei;
import com.example.asad.zuoye.p.PShiXianlei;
import com.example.asad.zuoye.v.ViewInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment implements ViewInterface, View.OnClickListener {


    private AAdapter adapter;
    private View view;
    private RecyclerView mRv;
    private ArrayList<Shujukulei> arrayList;
    private PShiXianlei pShiXianlei;

    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_b, container, false);
        initView(inflate);
        arrayList = new ArrayList<>();
        adapter = new AAdapter(arrayList, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRv.setLayoutManager(manager);
        mRv.setAdapter(adapter);


        pShiXianlei = new PShiXianlei(new MShixianlei(), this);


        adapter.setOnclick(new AAdapter.Onclick() {
            @Override
            public void duanan(int postion) {
                boolean b = DataHelp.getDataHelp().ShanChu(arrayList.get(postion));
                if (b) {
                    Toast.makeText(getContext(), "删除成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "删除失败", Toast.LENGTH_SHORT).show();

                }
                arrayList.remove(postion);
                adapter.notifyDataSetChanged();
            }
        });
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            pShiXianlei.getChaXunData();
        }else if(arrayList!=null){
            arrayList.clear();
        }
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mRv.setOnClickListener(this);
    }

    @Override
    public void onCharuChenggong(String s) {

    }

    @Override
    public void onCharuShibai(String s) {

    }

    @Override
    public void onChaXunChenggong(List<Shujukulei> mlist) {
        arrayList.addAll(mlist);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onChaXunShibai(String s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rv:
                break;
        }
    }
}
