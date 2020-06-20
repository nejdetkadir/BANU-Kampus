package com.nejdetkadirr.banucampus.ui.communities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nejdetkadirr.banucampus.R;

import java.util.ArrayList;

public class CommunitiesFragment extends Fragment {
    ArrayList<Community> communities = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_communities, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.communities_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        communities.add(new Community("https://www.bandirma.edu.tr/Content/Web/images/logo_tr.png","Sosyal Etkinlik ve Eğlence Topluluğu","Yönetici : Yunus Emre Gümüş","Danışman : Ufuk Çelik"));
        CommunitiesRecyclerViewAdapter recyclerViewAdapter = new CommunitiesRecyclerViewAdapter(communities);
        recyclerView.setAdapter(recyclerViewAdapter);
        return rootView;
    }
}