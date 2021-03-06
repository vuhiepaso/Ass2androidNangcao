package com.example.ass2androidnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainKhoaHoc extends AppCompatActivity {
    Datebase datebase;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_khoa_hoc);
        datebase = new Datebase(this);
        listView= findViewById(R.id.lvKhoaHoc);
        Toast.makeText(this, ""+datebase.getAllCourse().size(), Toast.LENGTH_SHORT).show();

        datebase = new Datebase(this);

        AdapterCourse adapterCourse = new AdapterCourse(datebase.getAllCourse(),MainKhoaHoc.this);
        listView.setAdapter(adapterCourse);
        Toast.makeText(this, ""+datebase.getAllCourse().size(), Toast.LENGTH_SHORT).show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelCourse modelCourse = datebase.getAllCourse().get(position);
                if (modelCourse.getTrangThai() == 0) {
                    ModelCourse modelCourse1 = new ModelCourse();
                    modelCourse1.setMonHoc(datebase.getAllCourse().get(position).getMonHoc());
                    modelCourse1.setTrangThai(1);
                    datebase.update(modelCourse1);
                    AdapterCourse adapterCourse = new AdapterCourse(datebase.getAllCourse(),MainKhoaHoc.this);
                    listView.setAdapter(adapterCourse);
                    Toast.makeText(MainKhoaHoc.this, "1", Toast.LENGTH_SHORT).show();
                }
                if (modelCourse.getTrangThai() == 1) {
                    ModelCourse modelCourse1 = new ModelCourse();
                    modelCourse1.setMonHoc(datebase.getAllCourse().get(position).getMonHoc());
                    modelCourse1.setTrangThai(0);
                    datebase.update(modelCourse1);
                    AdapterCourse adapterCourse = new AdapterCourse(datebase.getAllCourse(),MainKhoaHoc.this);
                    listView.setAdapter(adapterCourse);
                    Toast.makeText(MainKhoaHoc.this, "0", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void dangky(View view) {
        Intent intent = new Intent(this,MainKhoaHoc2.class);
        startActivity(intent);

//        ModelCourse modelCourse1 = new ModelCourse("Tin Hoc",0,"5a","30","20/04/2021");
//        datebase.inset(modelCourse1);
//        ModelCourse modelCourse2 = new ModelCourse("Hoa Hoc",0,"7a","20","10/03/2021");
//        datebase.inset(modelCourse2);
//        ModelCourse modelCourse3 = new ModelCourse("Sinh Hoc",0,"12a","15","10/03/2021");
//        datebase.inset(modelCourse3);
    }
}
