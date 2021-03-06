package com.example.ass2androidnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterCourse extends BaseAdapter {
    private List<ModelCourse> modelCourses;
    private Context context;

    public AdapterCourse(List<ModelCourse> modelCourses, Context context) {
        this.modelCourses = modelCourses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modelCourses.size();
    }

    @Override
    public Object getItem(int position) {
        return modelCourses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        TextView monHoc, lopHoc, lichHoc, ngaythi, trangThai;
        ImageView imageView;
        monHoc = convertView.findViewById(R.id.tvMonhoc);
        lopHoc = convertView.findViewById(R.id.tvlophoc);
        lichHoc = convertView.findViewById(R.id.tvlichHoc);
        ngaythi = convertView.findViewById(R.id.tvNgayThi);

        trangThai = convertView.findViewById(R.id.tvTrangThi);
        imageView = convertView.findViewById(R.id.imgMonhoc);

        final ModelCourse modelCourse = modelCourses.get(position);

        monHoc.setText(modelCourse.getMonHoc());
        lopHoc.setText(modelCourse.getLop());
        lichHoc.setText(modelCourse.getLichHoc());
        ngaythi.setText(modelCourse.getNgayThi());
        trangThai.setText((modelCourse.getTrangThai() == 1) ? "Dang Ky" : "Chua Dang Ky");
//        trangThai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return convertView;
    }
}
