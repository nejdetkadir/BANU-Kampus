package com.nejdetkadirr.banucampus.ui.notices;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.nejdetkadirr.banucampus.R;

public class NoticesFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notices, container, false);
        ViewPager viewPager = rootView.findViewById(R.id.notices_WiewPager);
        TabLayout tabLayout = rootView.findViewById(R.id.notices_Tablayout);
        NoticesPagerAdapter adapter = new NoticesPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return rootView;
    }
}