import DAO.CharacterManage;
import DAO.DBClass;
import DAO.ItemManage;
import DAO.MonsterManage;
import DTO.Item;
import DTO.Character;
import DTO.Monster;

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

        System.out.println("----- DB_GAME -----\n");
        dc.dbConn();
        System.out.println();
        NameSet ns = new NameSet();
        ns.set_Name();
        ns.get_Name();

        while (true) {
            System.out.println("1. 게임 설정 / 2. 게임 플레이 / 3. 저장된 정보 보기");
            int num = sc.nextInt();
            // if num == 1
            // 캐릭터 정보 설정 및 db 저장
            // 몬스터 정보 설정 및 db 저장
            // 아이템 정보 설정 및 db 저장
            if (num == 1) {
                System.out.println("-- 1. 게임 설정 --");
                System.out.println("1. 캐릭터 정보 / 2. 아이템 정보 / 3. 몬스터 정보");
                int num_1 = sc.nextInt();
                sc.nextLine();
                if (num_1 == 1) {
                    // 캐릭터 정보 추가
                    //db에 character 정보 삽입 / 출력
                    System.out.println("캐릭터 등록");
                    System.out.print("이름 입력 : ");
                    String c_name = sc.nextLine();
                    System.out.print("hp 설정 : ");
                    int c_hp = sc.nextInt();
                    sc.nextLine();
                    System.out.print("직업 설정 : ");
                    String job = sc.nextLine();

                    Character character = new Character();
                    character.setName(c_name);
                    character.setHp(c_hp);
                    character.setJob(job);

                    cm.insertCharacter(c_name, c_hp, job);
                    continue;
                } else if (num_1 == 2) {
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

                    im.insertItem(item);
                    continue;
                } else if (num_1 == 3) {
                    // 몬스터 정보 추가
                    //db에 monster 정보 삽입 / 출력
                    System.out.println("몬스터 등록");
                    System.out.print("이름 입력 : ");
                    String m_name = sc.nextLine();
                    System.out.print("hp 설정 : ");
                    int m_hp = sc.nextInt();
                    sc.nextLine();

                    Monster monster = new Monster();

                    monster.setName(m_name);
                    monster.setHp(m_hp);

                    mm.insertMonster(monster);
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
                if (dc.checkDB()) {
                    System.out.println("진행");
                } else {
                    System.out.println("데이터부터 생성 ㄱ");
                    continue;
                }
            }

            // if num == 3
            // 1. 캐릭터 정보 / 2. 아이템 정보 / 3. 몬스터 정보
            // db에 저장된 정보 출력
            else if (num == 3) {
                System.out.println("-- 3. 저장된 정보 보기 --");
                System.out.println("1. 캐릭터 정보 / 2. 아이템 정보 / 3. 몬스터 정보");
                int num_3 = sc.nextInt();
                if (num_3 == 1) {
                    // db의 캐릭터 정보 보기 (select)
                    cm.selectCharacter();
                    continue;
                } else if (num_3 == 2) {
                    // db의 아이템 정보 보기 (select)
                    im.selectItem();
                    continue;
                } else if (num_3 == 3) {
                    // db의 몬스터 정보 보기 (select)
                    mm.selectMonster();
                    continue;
                }
            }
        }
    }
}
