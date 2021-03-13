package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class JDBCCRUDTest {
    public static class Region {
        int region_id;
        String region_name;

        public int getRegion_id() {
            return region_id;
        }

        public void setRegion_id(int region_id) {
            this.region_id = region_id;
        }

        public String getRegion_name() {
            return region_name;
        }

        public void setRegion_name(String region_name) {
            this.region_name = region_name;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        DBConnection();

        while (true) {
        }
    }

    public static Connection conn;
    public static void DBConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb", "root", "12301300");
    }

    public static ArrayList Select() throws Exception{
        Statement stmt = null;
        String sql = "SELECT * FROM regions";
        stmt = conn.createStatement();
        ResultSet rs = null;
        rs = stmt.executeQuery(sql);

        ArrayList<Region> list = new ArrayList<>();
        while(rs.next()) {
            Region r = new Region();
            r.setRegion_id(rs.getInt(1));
            r.setRegion_name(rs.getString(2));
            list.add(r);
        }

        return list;
    }

    public static void Update() {

    }

    public static void Delete() {

    }

    public static void Insert() {

    }
}
