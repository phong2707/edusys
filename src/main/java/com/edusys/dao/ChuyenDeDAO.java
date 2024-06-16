/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phongnguyen
 */
public class ChuyenDeDAO extends EdusysDAO<ChuyenDe, String>{
    final String INSERT_SQL = "INSERT INTO ChuyenDE(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE ChuyenDE SET MaCD = ?,TenCD = ?,HocPhi= ?, ThoiLuong = ?,Hinh = ?,MoTa = ? WHERE MaNV = ?";
    final String DELETE_SQL = "DELETE FROM ChuyenDE WHERE MaCD = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM ChuyenDE";
    final String SELECT_BY_ID_SQL = "SELECT * FROM ChuyenDE WHERE MaCD = ?";
    
    @Override
    public void insert(ChuyenDe entity) {
       JdbcHelper.update(INSERT_SQL, entity.getMaCD(),entity.getTenCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa());
    }
    

    @Override
    public void update(ChuyenDe entity) {
       JdbcHelper.update(UPDATE_SQL, entity.getMaCD(),entity.getTenCD(),entity.getHocPhi(),entity.getThoiLuong(),entity.getHinh(),entity.getMoTa());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChuyenDe selectById(String id) {
        List<ChuyenDe> list= selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    @Override
    public List<ChuyenDe> selectBySql(String sql, Object... args) {
        List<ChuyenDe> list= new  ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                ChuyenDe entity = new ChuyenDe();
                entity.setMaCD(rs.getString("MaCD"));
                entity.setTenCD(rs.getString("TenCD"));
                entity.setHocPhi(rs.getDouble("HocPhi"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setMoTa(rs.getString("MoTa"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
