package admin.model;

public class Student {
    private String sid;
    private String sname;
    private String tel;
    private String id;
    private String state;
    private  String clId;

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", tel='" + tel + '\'' +
                ", id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", clId='" + clId + '\'' +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClId() {
        return clId;
    }

    public void setClId(String clId) {
        this.clId = clId;
    }

    public Student(String sid, String sname, String tel, String id, String state, String clId) {
        this.sid = sid;
        this.sname = sname;
        this.tel = tel;
        this.id = id;
        this.state = state;
        this.clId = clId;
    }
}
