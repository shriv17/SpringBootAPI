package springBoot.dao;

import springBoot.models.MemberModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 5/5/2017.
 */
public class ConnectionManager {
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
            String query = "select * from test_api where email ='" + email + "'";
            Statement st = null;
            memberList = new ArrayList<>();
            MemberModel model = null;
            try {
                st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
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
        public static void main(String []args){
            ConnectionManager man = new ConnectionManager();
            MemberModel model = man.getMemberDetails("email");
            System.out.print(model.toString());
        }
        public String insertMember(String name, String email, String phone, String id){
            String query = "INSERT INTO TEST_API VALUES(?,?,?,?)";
            try {
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, name);
                st.setString(2, email);
                st.setString(3, phone);
                st.setString(4, id);
                st.execute();
                return "success";
            } catch (SQLException e) {
                e.printStackTrace();
                return "error";
            }
        }
    }

