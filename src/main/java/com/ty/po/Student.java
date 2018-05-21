package com.ty.po;

/**
 * @author pc
 * @create 2018-05-21 下午12:24
 * @desc 学生信息
 **/

public class Student {
    private int studentId;
    private int password;

    public Student(){

    }

    public Student(int studentId,int password){
        this.studentId = studentId;
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", password=" + password +
                '}';
    }
}
