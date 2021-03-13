package JDBCTest;

import java.sql.*;

public class JDBCTest1 {
    public static void main(String[] args) throws Exception{
        // Database : 여러 사람에게 공유되어 사용될 목적으로 만들어진 데이터의 집합
        // JDBC : Java 언어를 사용하여 DB에 sql을 전달하고 결과를 얻어올 수 있는 수단.

        // 1. JDBC Driver Load
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. DB Connection 획득. (DBMS와 연결 채널을 수립)
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb", "root", "12301300");

        String sql = "SELECT * FROM regions";

        // 3. Statement 구문 준비 (SQL 명령어)
        stmt = conn.createStatement();

        // 4. 구문 Execute
        rs = stmt.executeQuery(sql);

        PreparedStatement pStmt = null;
        sql = "UPDATE regions SET region_name = ? WHERE region_id = ?";

        String input_name = "East Asia";
        int input_id = 3;
        pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, input_name);
        pStmt.setInt(2, input_id);

        int res = pStmt.executeUpdate();
        System.out.println(res + "개의 행이 업데이트 되었습니다.");

        // 5. 결과물 수집
        while(rs.next()) {
            System.out.print(rs.getInt(1));
            System.out.print(" ");
            System.out.print(rs.getString(2));
            System.out.println();
        }
    }
}
