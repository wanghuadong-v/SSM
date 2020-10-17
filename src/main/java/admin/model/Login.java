package admin.model;

public class Login {
    private String ename;
    private String password;
    private String job;

    public Login(String ename, String password,String job) {
        this.ename = ename;
        this.password = password;
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
