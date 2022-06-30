package DAO;

import DTO.Monster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonsterManage {
    DBClass dc = new DBClass();
    //monster 데이터 삽입 메소드
    public void insertMonster(String name, String hp) {
        //쿼리문 준비
        String sql = "INSERT INTO `monster` (`name`, `hp`) VALUES (?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dc.dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, hp);

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("데이터 삽입 성공!");
            }

        } catch (Exception e) {
            System.out.println("데이터 삽입 실패!");
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void insertMonster(Monster mon) {

        //쿼리문 준비
        String sql = "INSERT INTO `monster` (`name`, `hp`) VALUES (?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dc.dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mon.getName());
            pstmt.setInt(2, mon.getHp());

            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("데이터 삽입 성공!");
            }

        } catch (Exception e) {
            System.out.println("데이터 삽입 실패!");
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    //monster 데이터 조회(검색) 메소드
    public void selectMonster() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = dc.dbConn();

        try {
            String sql = "select * from monster";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String hp = rs.getString("hp");

                System.out.println("몬스터 이름 : " + name + " / HP : " + hp);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
