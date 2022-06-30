import java.util.Scanner;

public class NameSet {
    public NameSet(){
        sc = new Scanner(System.in);
    }
    private Scanner     sc;
    private String name;

    public void set_Name(){
        System.out.print("이름을 입력하세요 : ");
        name = sc.next();
    }

    public String get_Name(){
        System.out.println("어서 오세요! " + name + "님");
        return name;
    }
}
