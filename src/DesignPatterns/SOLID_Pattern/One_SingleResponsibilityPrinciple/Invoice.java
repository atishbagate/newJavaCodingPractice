package DesignPatterns.SOLID_Pattern.One_SingleResponsibilityPrinciple;

public class Invoice {
    private Integer Id;
    private String desc;

    public Invoice(Integer id, String desc) {
        Id = id;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "desc='" + desc + '\'' +
                ", Id=" + Id +
                '}';
    }
}
