package admin.model;

public class Leader {
    private String cid;
    private String cname;
    private String csex;
    private String job;
    private String id;
    private String tel;

    @Override
    public String toString() {
        return "Leader{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", csex='" + csex + '\'' +
                ", job='" + job + '\'' +
                ", id='" + id + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Leader(String cid, String cname, String csex, String job, String id, String tel) {
        this.cid = cid;
        this.cname = cname;
        this.csex = csex;
        this.job = job;
        this.id = id;
        this.tel = tel;
    }
}
