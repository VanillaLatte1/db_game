package DAO;

import DTO.Item;
import DTO.Character;
import DTO.Monster;

import java.sql.*;

public class DBClass {
    // 여기서 만들어 사용가능한 것
    // 생성자
    // 변수
    // 메소드

    //db 연결 메소드
    public Connection dbConn() {
        final String driver = "org.mariadb.jdbc.Driver";
        final String DB_IP = "localhost";
        final String DB_PORT = "3306";
        final String DB_NAME = "mydb";
        final String DB_USER = "root";
        final String DB_PASS = "1234";
        final String DB_URL =
                "jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

        //java 와 db 연결
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            if (conn != null) {
                System.out.println("DB 접속 성공");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
        return conn;
    }

    public boolean checkDB() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = dbConn();   // db 연결 메소드
        String playerCheck = "select id from tb_character;";
        String monsterCheck = "select id from monster;";
        String itemCheck = "select id from item;";
        boolean cc = false;
        boolean ic = false;
        boolean mc = false;
        boolean result;
        try {
            pstmt = conn.prepareStatement(playerCheck);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int index = rs.getInt("id");
                System.out.println(index);
                cc = true;      //해당 테이블에 데이터가 있으면 true
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
        try {
            pstmt = conn.prepareStatement(monsterCheck);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                int index = rs.getInt("id");
                System.out.println(index);
                ic = true;      //해당 테이블에 데이터가 있으면 true
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
        try {
            pstmt = conn.prepareStatement(itemCheck);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                int index = rs.getInt("id");
                System.out.println(index);
                mc = true;      //해당 테이블에 데이터가 있으면 true
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
        }

        if (cc && ic && mc) {       //3개의 테이블에 데이터가 모두 있으면 true / 없으면 false
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
