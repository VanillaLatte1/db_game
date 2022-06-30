package DAO;

import DTO.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ItemManage {
    DBClass dc = new DBClass();
    Scanner sc = new Scanner(System.in);
    //item 데이터 삽입 메소드
    public void insertItem(String name, String att, String dam, String hyo) {

        //쿼리문 준비
        String sql = "INSERT INTO `item` (`name`, `att`, `dam`, `hyo`) VALUES (?,?,?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dc.dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, att);
            pstmt.setString(3, dam);
            pstmt.setString(4, hyo);

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

    public void insertItem(Item item) {

        //쿼리문 준비
        String sql = "INSERT INTO `item` (`name`, `att`, `dam`, `hyo`) VALUES (?,?,?,?)";
        PreparedStatement pstmt = null;
        Connection conn = dc.dbConn();
        //db 연결 메소드에서 return값을 이용해 데이터 삽입 메소드에서 conn을 사용할 수 있도록 만든다

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, item.getName());
            pstmt.setString(2, item.getAtt());
            pstmt.setInt(3, item.getDam());
            pstmt.setString(4, item.getHyo());

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



    //item 데이터 조회(검색) 메소드
    public void selectItem() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = dc.dbConn();

        try {
            String sql = "select * from item";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String att = rs.getString("att");
                String dam = rs.getString("dam");
                String hyo = rs.getString("hyo");

                System.out.println("아이템 이름 : " + name + " / 속성 : " + att +
                        " / 데미지 : " + dam + " / 효과: " + hyo);
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
    public void itemInfo(){
        // 아이템 정보 추가
        // db에 아이템 정보 삽입 / 출력
        System.out.println("아이템 등록");
        System.out.print("이름 입력 : ");
        String i_name = sc.nextLine();
        System.out.print("속성 입력 : ");
        String att = sc.nextLine();
        System.out.print("공격력 입력 : ");
        int dam = sc.nextInt();
        sc.nextLine();
        System.out.print("효과 입력 : ");
        String hyo = sc.nextLine();

        Item item = new Item();
        item.setName(i_name);
        item.setAtt(att);
        item.setDam(dam);
        item.setHyo(hyo);

        insertItem(item);
    }
}
