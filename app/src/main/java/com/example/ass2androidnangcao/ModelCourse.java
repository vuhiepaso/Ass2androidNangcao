package com.example.ass2androidnangcao;

public class ModelCourse {
    String monHoc;
    int trangThai;//dang hoac huy
    String lop;
    String lichHoc;
    String ngayThi;

    public ModelCourse() {
    }

    public ModelCourse(String monHoc, int trangThai, String lop, String lichHoc, String ngayThi) {
        this.monHoc = monHoc;
        this.trangThai = trangThai;
        this.lop = lop;
        this.lichHoc = lichHoc;
        this.ngayThi = ngayThi;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getLichHoc() {
        return lichHoc;
    }

    public void setLichHoc(String lichHoc) {
        this.lichHoc = lichHoc;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }
}
