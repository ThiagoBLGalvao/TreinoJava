import dao.StudentDAO;
import entities.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentDAO stDAO = new StudentDAO();

        Student student = new Student();
        student.setName("João");
        student.setAge(18);
        stDAO.save(student);

        List<Student> students= new ArrayList<>();
        students =  stDAO.getStudents();
        for ( Student x : students ) {
            System.out.println(x.getName());
        }



    }
}
