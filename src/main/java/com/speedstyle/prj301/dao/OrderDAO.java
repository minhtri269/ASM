/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.speedstyle.prj301.dao;

import com.speedstyle.prj301.dto.Order;
import com.speedstyle.prj301.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avillX
 */
public class OrderDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private final static String ALLORDERS = "Select * from dbo.Orders";    

    public List<Order> getAllOrder(String search){
        List<Order> list = new ArrayList<>();        
        try{
            String query = ALLORDERS;
            if(!search.equals("")){
                query+= " Where transaction_id LIKE = "+search;
            }
            conn = new DBUtils().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Order(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    rs.getInt(4),
                                    rs.getString(5),
                                    rs.getDouble(6),
                                    rs.getString(7),
                                    rs.getDate(8)));
            }
        }catch(Exception e){}
        return list;
    }











































    public static void main(String[] args) {
        OrderDAO dao = new OrderDAO();
        List<Order> list = dao.getAllOrder("");
//        System.out.println(n);
//        ProductSize list = dao.getProductAllSize("1");
        for(Order o :list){
            System.out.println(o);
        }
        
    }
    }











