package com.spring_boot.dao;

import com.spring_boot.models.MemberModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 5/4/2017.
 */
public class ConnectionManager{
    private Connection con = null;
    private static String url = "jdbc:mysql://localhost/test?useSSL=false";
    private static String username = "test";
    private static String password = "test";
    private List<MemberModel> memberList = null;
    public void initDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ConnectionManager(){
        initDB();
    }

    public MemberModel getMemberDetails(String email){
        String query = "select * from test_api where email";
        Statement st = null;
        memberList = new ArrayList<>();
        MemberModel model = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.getFetchSize() == 1){
                model = new MemberModel(rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("id"));
            }
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if(con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
