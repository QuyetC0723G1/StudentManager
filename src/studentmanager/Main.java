package studentmanager;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Student inputInfo(){
        Scanner input = new Scanner(System.in);
        Student newstudent = new Student();
        System.out.println("Enter the name of Student : ");
        newstudent.setName(input.nextLine());
        System.out.println("Enter the gender of Student : ");
        newstudent.setGender(input.nextLine());
        System.out.println("Enter the Score of Student : ");
        for (int i = 0; i < newstudent.getScore().length; i++) {
            switch (i) {
                case 0: System.out.println("Math Score : " );
                    break;
                case 1 : System.out.println("Literature Score : " );
                    break;
                case 2 : System.out.println("English Score : " );
                    break;
            }
            double score = input.nextDouble();
            newstudent.getScore()[i] = score;

        }
        return newstudent;
    }
    public static void showListStudent(){
    }
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        double[] score1 = {9, 8, 9};
        double[] score2 = {6, 8, 7};
        double[] score3 = {9, 8, 5};

        Student student1 = new Student("Hang", "Female", score2);
        Student student2 = new Student("Long", "Male", score3);
        Student student3 = new Student("Hai", "Male", score1);


        StudentManager studentManager = new StudentManager();
        studentManager.add(student1);
        studentManager.add(student2);
        studentManager.add(student3);

        System.out.println("The current student list is : ");
        for (int i = 0; i < studentManager.getSize(); i++) {
            System.out.println(studentManager.getListStudent()[i]);
        }

        System.out.println("\nENTER 1 TO GO TO THE MENU : ");
        int check = input.nextInt();
        if (check == 1) {

            int choice;
            do {
                System.out.println("Menu");
                System.out.println("1 : Add new Student");
                System.out.println("2 : Remove Student");
                System.out.println("3 : Update Student");
                System.out.println("4 : Find Student");
                System.out.println("5 : List Student Find By Name and Show out");
                System.out.println("6 : The best score avg of Student ");
                System.out.println("7 : List Student");
                System.out.println("8 : Exit");
                System.out.println("Enter your choice : ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("How many students do you want to add? ");
                        int numberchoice = input.nextInt();
                        for (int i = 0; i < numberchoice; i++) {
                            System.out.println("Studen" + (i + 1) + " : ");
                            Student student = inputInfo();
                            studentManager.add(student);
                        }
                        System.out.println("List Student after Update : ");
                        for (int i = 0; i < studentManager.getSize(); i++) {
                            System.out.println(studentManager.getListStudent()[i]);
                        }
                        break;
                    case 2:
                        System.out.println("Enter the id of student you want to Remove:");
                        int id = input.nextInt();
                        studentManager.findStudentByID(id);
                        studentManager.remove(id);
                        System.out.println("List Student last remove : ");
                        for (int i = 0; i < studentManager.getSize(); i++) {
                            System.out.println(studentManager.getListStudent()[i]);
                        }
                        break;
                    case 3:
                        System.out.println("Enter the id of student you want find : ");
                        int id2 = input.nextInt();
                        studentManager.findStudentToGetId(id2);
                        System.out.println("Are you sure to go to Edit this Student ? " +
                                "\nEnter 1 to start editing or any number to exit");
                        int yourchoice = input.nextInt();
                        if (yourchoice==1){
                            System.out.println("\nPlease enter new student information ");
                            Student newStudent = inputInfo();
                            studentManager.update(id2, newStudent);
                            System.out.println("Student list after update : ");
                            for (int i = 0; i < studentManager.getSize(); i++) {
                                System.out.println(studentManager.getListStudent()[i]);
                            }
                            System.out.println("\nENTER 1 TO RETURN THE MENU OR ANY NUMBER TO EXIT :");
                            int yourchoice2 = input.nextInt();
                            if (yourchoice2==1){
                                break;
                            }else {
                                System.exit(0);
                                break;
                            }

                        }else {
                            System.exit(0);
                            break;
                        }

                    case 4 :
                        System.out.println("Enter the id of student you want find : ");
                        int id3 = input.nextInt();
                        studentManager.findStudentToGetStudentInfo(id3);
                        System.out.println("\nENTER 1 TO RETURN THE MENU OR ANY NUMBER TO EXIT :");
                        int yourchoice2 = input.nextInt();
                        if (yourchoice2==1){
                            break;
                        }else {
                            System.exit(0);
                            break;
                        }

                    case 5:
                        input.nextLine();
                        System.out.println("Enter Student Name you want to Search : ");
                        String search = input.nextLine();
                        System.out.println("Result is : ");
                        studentManager.getStudentByName(search);
                        System.out.println("\nENTER 1 TO RETURN THE MENU OR ANY NUMBER TO EXIT :");
                        int yourchoice5 = input.nextInt();
                        if (yourchoice5==1){
                            break;
                        }else {
                            System.exit(0);
                            break;
                        }

                    case 6:studentManager.getAvgMax();
                        System.out.println("\nENTER 1 TO RETURN THE MENU OR ANY NUMBER TO EXIT :");
                        int yourchoice3 = input.nextInt();
                        if (yourchoice3==1){
                            break;
                        }else {
                            System.exit(0);
                            break;
                        }
                    case 7:
                        System.out.println("List Student is : ");
                        for (int i = 0; i < studentManager.getSize(); i++) {
                            System.out.println(studentManager.getListStudent()[i]);
                        }
                        System.out.println("\nENTER 1 TO RETURN THE MENU OR ANY NUMBER TO EXIT :");
                        int yourchoice7 = input.nextInt();
                        if (yourchoice7==1){
                            break;
                        }else {
                            System.exit(0);
                            break;
                        }
                    case 8:
                        System.exit(0);
                        break;
                }
            } while (true);


        }
    }
}
