package dao;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

/**
 * Created by Administrator on 5/4/2017.
 */
public class ConnectionManager{
    private Connection con = null;
    private static String url = "jdbc:mysql://localhost/test?useSSL=false";
    private static String username = "test";
    private static String password = "test";
    private JSONObject jsonObject = null;
    private JSONArray jsonArray = null;
    public void initDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

            String query = "select * from test_api";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            jsonArray = new JSONArray();
            while(rs.next()){
                jsonObject = new JSONObject();
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("email", rs.getString("email"));
                jsonObject.put("phone", rs.getString("phone"));
                jsonObject.put("id", rs.getString("id"));
                jsonArray.put(jsonObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ConnectionManager(){
        initDB();
    }
    public JSONArray getResult(){
        return jsonArray;
    }
}
