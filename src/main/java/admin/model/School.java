package admin.model;

public class School {
    private String id;
    private String uname;
    private String uaddr;
    private String eid;

    public School() {
    }

    public School(String id, String uname, String uaddr, String eid) {
        this.id = id;
        this.uname = uname;
        this.uaddr = uaddr;
        this.eid = eid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUaddr() {
        return uaddr;
    }

    public void setUaddr(String uaddr) {
        this.uaddr = uaddr;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", uname='" + uname + '\'' +
                ", uaddr='" + uaddr + '\'' +
                ", eid='" + eid + '\'' +
                '}';
    }
}
