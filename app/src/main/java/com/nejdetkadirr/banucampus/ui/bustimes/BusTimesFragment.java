package com.nejdetkadirr.banucampus.ui.bustimes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.nejdetkadirr.banucampus.PdfViewActivity;
import com.nejdetkadirr.banucampus.R;

import java.util.ArrayList;

public class BusTimesFragment extends Fragment {
    ArrayList<String> routes = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bus_times, container, false);
        addData();
        ListView listView = rootView.findViewById(R.id.bus_times_listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PdfViewActivity.class);
                intent.putExtra("fileName","hat"+routes.get(position).split(" ")[0]+".pdf");
                getActivity().startActivity(intent);
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,routes);
        listView.setAdapter(arrayAdapter);
        return rootView;
    }

    public void addData() {
        routes.add("1 NUMARA OTOGAR-ÇARŞI HATTI");
        routes.add("2 NUMARA KONAKTUR HATTI");
        routes.add("3 NUMARA KAYACIK TOKİ HATTI");
        routes.add("4 NUMARA AYYILDIZ HATTI");
        routes.add("5 NUMARA LEVENT HATTI");
        routes.add("6 NUMARA YENİ MAHALLE - BEYAZ EVLER HATTI");
        routes.add("7 NUMARA PAŞABAYIR HATTI");
        routes.add("8 NUMARA 600 EVLER-SANAYİ HATTI");
        routes.add("9 NUMARA LİVATYA HATTI");
        routes.add("10 NUMARA FAKÜLTE-HASTANE HATTI");
        routes.add("11 NUMARA PAŞABAYIR-HASTANE HATTI");
        routes.add("12 NUMARA OKULLAR HATTI");
        routes.add("14 LEVENT-HASTANE HATTI");
        routes.add("15 NUMARA TOKİ-HASTANE HATTI");
        routes.add("16 NUMARA VERGİ DAİRESİ HATTI");
        routes.add("17 NUMARA 100. YIL KÜME EVLERİ HATTI");
        routes.add("19 NUMARA BANVİT-TİCARET BORSASI HATTI");
        routes.add("20 NUMARA AYYILDIZ-YENİ MAHALLE-HASTANE HATTI");
        routes.add("21 NUMARA EDİNCİK-BANDIRMA HATTI");
    }
}