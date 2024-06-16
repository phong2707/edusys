/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.HocVien;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phongnguyen
 */
public class HocVienDAO extends EdusysDAO<HocVien, Integer>{
    final String INSERT_SQL = "INSERT INTO NhanVien(MaHV,MaKH,MaNH,Diem) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NhanVien SET MaHV = ?,MaKH = ?,MaNH= ?, Diem = ? WHERE MaHV = ?";
    final String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM HocVien";
    final String SELECT_BY_ID_SQL = "SELECT * FROM HocVien WHERE MaHV = ?";
 
    @Override
    public void insert(HocVien entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaHV(),entity.getMaKH(),entity.getMaNH(),entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaHV(),entity.getMaKH(),entity.getMaNH(),entity.getDiem());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HocVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HocVien selectById(Integer id) {
        List<HocVien> list= selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list= new  ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("MaNV"));
                entity.setMaKH(rs.getInt("MatKhau"));
                entity.setMaNH(rs.getString("Hoten"));
                entity.setDiem(rs.getDouble("VaiTro"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
