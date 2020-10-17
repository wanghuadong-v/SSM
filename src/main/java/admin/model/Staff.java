package admin.model;

public class Staff {
    private Integer eid;//员工编号
    private String ename;//员工姓名
    private String tel;
    private String job;
    private String password;

    public Staff(Integer eid, String ename, String tel, String job, String password) {
        this.eid = eid;
        this.ename = ename;
        this.tel = tel;
        this.job = job;
        this.password = password;
    }

    public Staff(String ename, String tel, String job, String password) {
        this.ename = ename;
        this.tel = tel;
        this.job = job;
        this.password = password;
    }

    @Override
    public String toString() {
        return "staff{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", tel='" + tel + '\'' +
                ", job='" + job + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private Staff(){

    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


