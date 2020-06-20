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

public class FacultyNoticesFragment extends Fragment {
    ArrayList<String> faculties = new ArrayList<>();
    ArrayList<String> facultyURLs = new ArrayList<>();
    public static FacultyNoticesFragment newInstance() {
        return new FacultyNoticesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_faculty_notices, container, false);
        addData();
        ListView listView = rootView.findViewById(R.id.notices_facultyNoticesListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (facultyURLs.get(position).matches("empty")) {
                    Toast.makeText(getActivity().getApplicationContext(), "Verilere Ulaşılamadı!",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("URL", facultyURLs.get(position));
                    getActivity().startActivity(intent);
                }
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,faculties);
        listView.setAdapter(arrayAdapter);
        return rootView;
    }

    public void addData() {
        faculties.add("Denizcilik Fakültesi");
        facultyURLs.add("https://denizcilik.bandirma.edu.tr/tr/denizcilik/Duyuru/Liste?k=-1");
        faculties.add("İktisadi ve İdari Bilimler Fakültesi");
        facultyURLs.add("https://iibf.bandirma.edu.tr/tr/iibf/Duyuru/Liste?k=-1");
        faculties.add("İnsan ve Toplum Bilimleri Fakültesi");
        facultyURLs.add("https://itbf.bandirma.edu.tr/tr/itbf/Duyuru/Liste?k=-1");
        faculties.add("Mühendislik ve Doğa Bilimleri Fakültesi");
        facultyURLs.add("https://mdbf.bandirma.edu.tr/tr/mdbf/Duyuru/Liste?k=-1");
        faculties.add("Ömer Seyfettin Uygulamalı Bilimler Fakültesi");
        facultyURLs.add("https://ubf.bandirma.edu.tr/tr/ubf/Duyuru/Liste?k=-1");
        faculties.add("Sağlık Bilimleri Fakültesi");
        facultyURLs.add("https://sbf.bandirma.edu.tr/tr/sbf/Duyuru/Liste?k=-1");
        faculties.add("Mimarlık ve Tasarım Fakültesi");
        facultyURLs.add("empty");
        faculties.add("Spor Bilimleri Fakültesi");
        facultyURLs.add("empty");
        faculties.add("Ziraat Fakültesi");
        facultyURLs.add("empty");
        faculties.add("Yabancı Diller Yüksekokulu");
        facultyURLs.add("https://ydyo.bandirma.edu.tr/tr/ydyo/Duyuru/Liste?k=-1");
        faculties.add("Adalet Meslek Yüksekokulu");
        facultyURLs.add("https://adaletmyo.bandirma.edu.tr/tr/adaletmyo/Duyuru/Liste?k=-1");
        faculties.add("Bandırma Meslek Yüksekokulu");
        facultyURLs.add("https://bandirmamyo.bandirma.edu.tr/tr/bandirmamyo/Duyuru/Liste?k=-1");
        faculties.add("Denizcilik Meslek Yüksekokulu");
        facultyURLs.add("https://denizcilikmyo.bandirma.edu.tr/tr/denizcilikmyo/Duyuru/Liste?k=-1");
        faculties.add("Erdek Meslek Yüksekokulu");
        facultyURLs.add("https://erdek.bandirma.edu.tr/tr/erdek/Duyuru/Liste?k=-1");
        faculties.add("Gönen Meslek Yüksekokulu");
        facultyURLs.add("https://gonen.bandirma.edu.tr/tr/gonen/Duyuru/Liste?k=-1");
        faculties.add("Manyas Meslek Yüksekokulu");
        facultyURLs.add("https://manyas.bandirma.edu.tr/tr/manyas/Duyuru/Liste?k=-1");
        faculties.add("Sağlık Hizmetleri Meslek Yüksekokulu");
        facultyURLs.add("https://shmyo.bandirma.edu.tr/tr/shmyo/Duyuru/Liste?k=-1");
        faculties.add("Bandırma OSB Teknik Bilimler Meslek Yüksekokulu");
        facultyURLs.add("empty");
    }
}
