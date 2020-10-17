package admin.model;

public class Class {
    private String clid;
    private String cliname;
    private String opentime;

    @Override
    public String toString() {
        return "Class{" +
                "clid='" + clid + '\'' +
                ", cliname='" + cliname + '\'' +
                ", opentime='" + opentime + '\'' +
                '}';
    }

    public String getClid() {
        return clid;
    }

    public void setClid(String clid) {
        this.clid = clid;
    }

    public String getCliname() {
        return cliname;
    }

    public void setCliname(String cliname) {
        this.cliname = cliname;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public Class(String clid, String cliname, String opentime) {
        this.clid = clid;
        this.cliname = cliname;
        this.opentime = opentime;
    }
}
