package com.nejdetkadirr.banucampus.ui.wantorcomplaint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nejdetkadirr.banucampus.R;

import java.util.ArrayList;

public class WantOrComplaintFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_want_or_complaint, container, false);
        ArrayList<String> dropdown  = new ArrayList<>();
        dropdown.add("Mesaj tipini seçiniz");
        dropdown.add("İstek");
        dropdown.add("Şikayet");
        dropdown.add("Öneri");
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,dropdown);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = rootView.findViewById(R.id.want_or_complaint_dropdown);
        spinner.setAdapter(myAdapter);
        return rootView;
    }
}