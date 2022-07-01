import DAO.CharacterManage;
import DTO.Character;

import java.util.Random;
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
            battleplay();
        }
        else if(num == 2){
            System.out.println("집");
            System.out.println("----무엇을 하시겠습니까?----");
            System.out.println("1. 쉬기 | 2. 캐릭터 변경");
            int num_1 = sc.nextInt();
            sc.nextLine();
            if(num_1 == 1){
                System.out.println("쉼");
            }
            else if(num_1 == 2)
            {
                System.out.print("변경할 캐릭터의 이름을 입력하시오 : ");
                String name = sc.nextLine();
                Character cha = cm.selectChar(name);
                System.out.println("당신의 이름은 " + cha.getName() + "입니다.");
            }
            else
            {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
    public void battleplay(){

    }
}
