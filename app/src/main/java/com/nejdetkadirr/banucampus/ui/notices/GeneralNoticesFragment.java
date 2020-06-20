package com.nejdetkadirr.banucampus.ui.notices;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nejdetkadirr.banucampus.R;
import com.nejdetkadirr.banucampus.WebViewActivity;

import java.util.ArrayList;

public class GeneralNoticesFragment extends Fragment {
    ArrayList<String> notices = new ArrayList<>();
    ArrayList<String> noticeURLs = new ArrayList<>();
    public static GeneralNoticesFragment newInstance() {
        return new GeneralNoticesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_general_notices, container, false);
        ListView listView = rootView.findViewById(R.id.notices_generalNoticesListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (noticeURLs.get(position).matches("empty")) {
                    Toast.makeText(getActivity().getApplicationContext(), "Verilere Ulaşılamadı!",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("URL", noticeURLs.get(position));
                    getActivity().startActivity(intent);
                }
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,notices);
        listView.setAdapter(arrayAdapter);
        return rootView;
    }

    public void getData() {

    }
}
