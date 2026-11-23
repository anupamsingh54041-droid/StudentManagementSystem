package com.bca.sms;

public class Student {

    private int id;
    private String rollNo;
    private String fullName;
    private String email;
    private String phone;
    private String course;
    private int semester;

    public Student(int id, String rollNo, String fullName,
                   String email, String phone,
                   String course, int semester) {

        this.id = id;
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }
}
