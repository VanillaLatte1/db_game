package DAO;

import DTO.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterManage {
    DBClass dc = new DBClass();
    //character 데이터 삽입 메소드
    public void insertCharacter(String name, int hp, String job) {

        //쿼리문 준비
        String sql = "INSERT INTO `tb_character` (`name`, `hp`, `job`) VALUES (?,?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dc.dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, hp);
            pstmt.setString(3, job);

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

    public void insertCharacter(Character cha) {

        //쿼리문 준비
        String sql = "INSERT INTO `tb_character` (`name`, `hp`, `job`) VALUES (?,?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dc.dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cha.getName());
            pstmt.setInt(2, cha.getHp());
            pstmt.setString(3, cha.getJob());

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

    //character 데이터 조회(검색) 메소드
    public void selectCharacter() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = dc.dbConn();

        try {
            String sql = "select * from tb_character";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String hp = rs.getString("hp");
                String job = rs.getString("job");

                System.out.println("캐릭터 이름 : " + name + " / HP : " + hp + " / 직업 : " + job);
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
