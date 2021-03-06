package com.example.ass2androidnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainKhoaHoc2 extends AppCompatActivity {
    Datebase datebase;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_khoa_hoc2);
        datebase = new Datebase(this);
        listView= findViewById(R.id.lvKhoaHoc2);
        List<ModelCourse> modelCourselist= new ArrayList<>();
        datebase = new Datebase(this);
        for (int i=0;i<datebase.getAllCourse().size();i++){
            if (datebase.getAllCourse().get(i).getTrangThai()==1){
                modelCourselist.add(datebase.getAllCourse().get(i));
            }
        }
        AdapterCourse adapterCourse = new AdapterCourse(modelCourselist,MainKhoaHoc2.this);
        listView.setAdapter(adapterCourse);
    }
}