package studentmanager;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentManager {
    private Student[] listStudent;
    private int size = 0;

    public StudentManager() {
        listStudent = new  Student[20];
    }

    public int getSize() {
        return size;
    }

    public Student[] getListStudent() {
        return this.listStudent;

    }
    public void add(Student student){
        listStudent[size] = student;
        size++;
    }

    public int findStudentByID(int id){
        for (int i = 0; i < size; i++) {
            if (id == listStudent[i].getId()){
                return i;
            }
        }
        return -1;
    }

    public void remove ( int id){
        int index = findStudentByID(id);
        for (int i = 0; i < size; i++) {
            listStudent[index] = listStudent[i+1];
        }
        size--;
    }
    public int findStudentToGetId (int id){
        for (int i = 0; i < size; i++) {
            if (listStudent[i].getId() ==id){
                System.out.println("result : "+ listStudent[i]);
                return listStudent[i].getId();
            }
        }
        return -1;
    }
    public void findStudentToGetStudentInfo(int id){
        for (int i = id-1; i < size; i++) {
            if (listStudent[i].getId() == id){
                System.out.println(listStudent[i]);
                return;
            }
            else {
                System.out.println("This student could not be found");
            }
            }
        }


    public void update(int id, Student newStudent){
        for (int i = 0; i < size; i++) {
            if (listStudent[i].getId() == id){
                listStudent[i] = newStudent;
                return;
            }
        }
    }

    public void getAvgMax(){
        Student studentMaxScore = new Student();
        double max = listStudent[0].getAVG();
        for (int i = 0; i < size; i++) {
            if (listStudent[i].getAVG() > max ){
                max = listStudent[i].getAVG();
                studentMaxScore = listStudent[i];
            }
        }
        System.out.println("The student with the highest average score is : " );
        System.out.println(studentMaxScore + " With AVG Score is : "+(double)Math.round(max*100)/100);

    }

    public void getStudentByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if(listStudent[i].getName().toLowerCase().contains(name.toLowerCase())) {
                students.add(listStudent[i]);
            }
        }
        if (students.isEmpty()){
            System.out.println("This student could not be found");
        }
        else {
            for (Student student:students) {
                System.out.println(student);
            }
        }

    }
}


