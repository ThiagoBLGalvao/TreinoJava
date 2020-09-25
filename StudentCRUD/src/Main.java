import dao.StudentDAO;
import entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }

    public Scanner getScanner(){
        return new Scanner(System.in);
    }

    public void menu(){
        System.out.println("\nChose one of the following options:\n" +
                "1 - Add one new Student;\n" +
                "2 - Update one Student;\n" +
                "3 - Delete one Student;\n" +
                "4 - Show all Students;\n" +
                "5 - Exit Program\n");

        int op = getScanner().nextInt();

        switch(op){
            case 1:
                addStudent();
                break;
            case 2:
                updateStudet();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                getAllStudent();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid option");
                menu();
        }
    }

    private void getAllStudent() {
        StudentDAO studentDao = new StudentDAO();

        listStudents();

        menu();
    }

    private void deleteStudent() {
        StudentDAO studentDao = new StudentDAO();

        listStudents();

        System.out.println("Chose the Student\'s Id to delete:");
        int id = getScanner().nextInt();

        studentDao.removeById(id);

        menu();
    }

    private void updateStudet() {
        StudentDAO studentDao = new StudentDAO();

        listStudents();

        System.out.println("Write the Student\'s name to update:");
        String name = getScanner().nextLine();
        System.out.println("Write the Student\'s age to update");
        int age = getScanner().nextInt();
        System.out.println("Chose the Student\'s Id to update:");
        int id = getScanner().nextInt();

        Student s = new Student(id,name,age);

        studentDao.update(s);

        menu();
    }

    private void addStudent(){
        System.out.println("Write the Student\'s name:");
        String name = getScanner().nextLine();
        System.out.println("Write the Student\'s age");
        int age = getScanner().nextInt();

        Student s = new Student(name, age);

        StudentDAO studentDao = new StudentDAO();
        studentDao.save(s);

        menu();
    }

    private void listStudents(){
        StudentDAO studentDao = new StudentDAO();
        List<Student> students = new ArrayList<>();
        students = studentDao.getStudents();
        for (Student s:students) {
            System.out.println("Id: " + s.getId() + " " + "Name: " + s.getName());
        }
    }

}
