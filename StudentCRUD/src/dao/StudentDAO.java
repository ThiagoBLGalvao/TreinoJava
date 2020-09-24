package dao;

import connection.SchoolConnection;
import entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    //Metodo usado para efetuar o CREATE(ou melhor INSET)
    public  void save(Student student){
        String sql = "INSERT INTO students(name, age)" + "VALUES(?,?)";

        Connection con = null;
        PreparedStatement prst = null;

        try{
            //Abrindo Conecxão com o banco de dados
            con = SchoolConnection.getConnection();

            //Preparando o codigo SQL
            prst = con.prepareStatement(sql);

            //Colocando como primeiro valor o nome do Estudante
            prst.setString(1, student.getName());

            //Colocando como segundo valor a idade do Estudante
            prst.setInt(2, student.getAge());

            prst.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(prst != null){
                    prst.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //Metodo para efetuar o DELETE
    public void removeById(int id){
        String sql = "DELETE FROM students WHERE id = ?";

        Connection con = null;
        PreparedStatement prst = null;

        try{
            con = SchoolConnection.getConnection();
             prst = con.prepareStatement(sql);

             prst.setInt(1, id);

             prst.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(prst != null){
                    prst.close();
                }
                if(con != null){
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //Metodo utilizado para efetuar o UPDATE
    public void update(Student student){
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = SchoolConnection.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setInt(3, student.getId());

            ps.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //Metodo utilizado para efetuar o SELECT
    public List<Student> getStudents(){
        String sql = "SELECT * FROM students";

        List<Student> students = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        try{
            conn = SchoolConnection.getConnection();
            ps = conn.prepareStatement(sql);
            rset = ps.executeQuery();

            while(rset.next()){
                Student student = new Student();

                student.setId(rset.getInt("id"));

                student.setName(rset.getString("name"));

                student.setAge(rset.getInt("age"));

                students.add(student);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rset != null){
                    rset.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return students;
    }
}
