import DAO.CharacterManage;

import java.util.Scanner;

// 게임 플레이 메소드
public class PlayClass {
    Scanner sc = new Scanner(System.in);
    CharacterManage cm = new CharacterManage();
    public void play1(){
        System.out.println("1. 모험을 떠난다 | 2. 집으로 간다");
        int num = sc.nextInt();
        sc.nextLine();
        if (num == 1){
            System.out.println("모험");
        }
        else if(num == 2){
            System.out.println("집");
        }
    }
}
