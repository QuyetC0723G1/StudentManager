package studentmanager;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private String gender;
    private double[] score = new double[3];
    public static int number = 1;

    public Student( String name, String gender, double[] score) {
        this.id = number;
        this.name = name;
        this.gender = gender;
        this.score = score;
        number++;
    }

    public Student() {
        this.id = number;
        number++;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double[] getScore() {
        return score;
    }

    public void setScore(double[] score) {
        this.score = score;
    }
    public double getAVG(){
        double sum = 0;
        for (double point: score) {
            sum += point;
        }
        return sum/3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + Arrays.toString(score) +
                '}';
    }
}
