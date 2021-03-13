package JDBCTest;

import java.sql.*;
import java.util.Scanner;

public class JDBCInsertTest {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pStmt = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb", "root", "12301300");

        String sql = "INSERT INTO regions VALUES(?, ?)";
        int region_id;
        while (true) {
            region_id = scanner.nextInt();
            if(region_id == -1) {
                break;
            }
            String region_name = scanner.nextLine();

            pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, region_id);
            pStmt.setString(2, region_name);
            int res = pStmt.executeUpdate();
            if(res > 0) {
                System.out.println("정상적으로 INSERT 되었습니다.");
            } else {
                System.out.println("오류");
            }
        }
    }
}
