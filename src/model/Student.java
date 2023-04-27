package model;

import java.io.Serializable;
import java.util.Comparator;

public class Student implements Serializable, Comparator<Student> {
    private static int idCounter = 10000;
    private String studentID;
    private String studentName;
    private int age;
    private String gender;
    private Address address;
    private double averageScore;

    public Student() {
        ++idCounter;
        this.studentID = "student" + idCounter;
    }

    public Student(String studentName, int age, String gender, Address address, double averageScore) {
        ++idCounter;
        this.studentID = "student" + idCounter;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageScore = averageScore;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address=" + address +
                ", averageScore=" + averageScore +
                '}' + "\n";
    }

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getAverageScore() > s2.getAverageScore()) {
            return 1;
        } else if (s1.getAverageScore() < s2.getAverageScore()) {
            return -1;
        } else return 0;
    }
}
