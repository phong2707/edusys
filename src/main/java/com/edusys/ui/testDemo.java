/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.ui;

import com.edusys.dao.NhanVienDAO;
import com.edusys.dao.ThongKeDAO;
import com.edusys.entity.NhanVien;
import java.util.List;

/**
 *
 * @author phongnguyen
 */
public class testDemo {
    public static void main(String[] args) {
        ThongKeDAO tkDAO =new ThongKeDAO();
        List<Object[]> list = tkDAO.getLuongNguoiHoc();
        for (Object[] objects : list) {
            System.out.println("=>"+objects[0]+"-"+objects[1]+"-"+objects[2]);
            
        }
//        NhanVienDAO dao = new NhanVienDAO();
//        dao.insert(new NhanVien("nsda","nguyen thai fduong","1234123",true));
//        List<NhanVien> ls = dao.selectAll();
//        for (NhanVien nv : ls) {
//            System.out.println("=>"+nv.toString());
//        }
    }
    
}
