package studentManager.model;

import java.util.Date;

public class Student {
    private String name;
    private Date birthDay;
    private String address;
    private float grade;

    public Student(String name, Date birthDay, String address, float grade) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
