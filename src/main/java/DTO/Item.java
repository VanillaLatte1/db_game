package DTO;
import java.util.Scanner;

// db와 연결할 때 테이블 하나 당 클래스 하나
// 데이터를 담아서 전달하는 클래스 / DTO (data transfer object)
// db 테이블에 맞게 작성한다
public class Item {
    Scanner sc = new Scanner(System.in);

    // 변수 (컬럼 값)
    private int id;
    private String name;
    private String att;
    private int dam;
    private String hyo;

    //메소드 (컬럼 값 데이터 get / set)
    public void setId(int id)
    {
        this.id = id;
    }
    public int getID()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setAtt(String att)
    {
        this.att = att;
    }
    public String getAtt()
    {
        return att;
    }

    public void setDam(int dam)
    {
        this.dam = dam;
    }
    public int getDam()
    {
        return dam;
    }

    public void setHyo(String hyo)
    {
        this.hyo = hyo;
    }
    public String getHyo()
    {
        return hyo;
    }
}
