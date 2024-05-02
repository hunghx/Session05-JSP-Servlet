package ra.demo.jspservlet.model;

public class Student {
    private Integer id;
    private String name;
    private String phone;
    private Boolean sex;
    private String address;

    public Student() {
    }

    public Student(Integer id, String name, String phone, Boolean sex, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
