import DAO.CharacterManage;
import DAO.DBClass;
import DAO.ItemManage;
import DAO.MonsterManage;
import DTO.Character;

import java.util.Scanner;

public class MainClass {
    // 게임 시작
    // 1. 게임 설정 / 2. 게임 플레이 / 3. 저장된 정보 보기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // db 생성
        DBClass dc = new DBClass();
        ItemManage im = new ItemManage();
        CharacterManage cm = new CharacterManage();
        MonsterManage mm = new MonsterManage();
        PlayClass pc = new PlayClass();

        System.out.println("----- DB_GAME -----\n");
        dc.dbConn();
        System.out.println();
        NameSet ns = new NameSet();
        ns.set_Name();
        ns.get_Name();

        System.out.println("=========================================");
        System.out.println("GAME");
        System.out.println("=========================================");
        while (true) {
            System.out.println("1. 게임 설정 | 2. 게임 플레이 | 3. 저장된 정보 보기");
            int num = sc.nextInt();
            // if num == 1
            // 캐릭터 정보 설정 및 db 저장
            // 몬스터 정보 설정 및 db 저장
            // 아이템 정보 설정 및 db 저장
            if (num == 1) {
                System.out.println("-- 게임 설정 --");
                System.out.println("1. 캐릭터 정보 | 2. 아이템 정보 | 3. 몬스터 정보");
                int num_1 = sc.nextInt();
                sc.nextLine();

                if (num_1 == 1) {
                    System.out.println("-- 1. 캐릭터 정보 설정 | 2. 캐릭터 정보 삭제 --");
                    int x = sc.nextInt();
                    sc.nextLine();
                    if (x == 1){
                        cm.charInfo();
                        continue;
                    }
                    else if (x == 2){
                        cm.delete();
                    }
                    else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else if (num_1 == 2) {
                    im.itemInfo();
                    continue;
                } else if (num_1 == 3) {
                    mm.monInfo();
                    continue;
                } else {
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
            }

            // if num == 2
            // db에 저장된 정보가 있으면 게임 시작
            // 없으면 게임 설정부터 하라고 메세지
            else if (num == 2) {
                System.out.println("-- 게임 플레이 --");
                if (dc.checkDB()) {
                    System.out.println("진행");

                    cm.selectChar();
                    System.out.print("사용할 캐릭터를 고르시오(이름) : ");
                    String Playername = sc.next();
                    Character cha = cm.selectChar(Playername);
                    System.out.println("당신의 이름은 " + cha.getName() + "입니다.");

                    pc.play1();

                } else {
                    System.out.println("데이터가 없습니다. 데이터 설정을 먼저 해주세요.");
                    continue;
                }

            }
                // if num == 3
                // 1. 캐릭터 정보 / 2. 아이템 정보 / 3. 몬스터 정보
                // db에 저장된 정보 출력
            else if (num == 3) {
                    System.out.println("-- 3. 저장된 정보 보기 --");
                    System.out.println("1. 캐릭터 정보 | 2. 아이템 정보 | 3. 몬스터 정보");
                    int num_3 = sc.nextInt();

                    if (num_3 == 1) {
                        // db의 캐릭터 정보 보기 (select)
                        cm.selectChar();
                        continue;
                    } else if (num_3 == 2) {
                        // db의 아이템 정보 보기 (select)
                        im.selectItem();
                        continue;
                    } else if (num_3 == 3) {
                        // db의 몬스터 정보 보기 (select)
                        mm.selectMon();
                        continue;
                    }
                }
            }
        }
    }
