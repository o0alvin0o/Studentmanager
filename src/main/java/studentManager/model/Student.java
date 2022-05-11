package studentManager.model;

import java.util.Date;

public class Student {
    private String name;
    private int age;
    private String address;
    private float grade;
    private int id;

    public Student(String name,int id, int age, String address, float grade) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.grade = grade;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
