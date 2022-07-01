package DTO;

public class Character {
    private int id;
    private String name;
    private int hp;
    private String job;
// currnet character가 필요할 것 같아서 만듦 / 필요 x
//    private String C_name;
//    private int C_hp;
//    private String C_job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
//    public String getC_name() {
//        return C_name;
//    }
//
//    public void setC_name(String c_name) {
//        C_name = c_name;
//    }
//
//    public int getC_hp() {
//        return C_hp;
//    }
//
//    public void setC_hp(int c_hp) {
//        C_hp = c_hp;
//    }
//
//    public String getC_job() {
//        return C_job;
//    }
//
//    public void setC_job(String c_job) {
//        C_job = c_job;
//    }
}
