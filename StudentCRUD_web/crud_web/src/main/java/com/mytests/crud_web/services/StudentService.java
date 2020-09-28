package com.mytests.crud_web.services;

import com.mytests.crud_web.dto.StudentDTO;
import com.mytests.crud_web.dto.StudentInsertDTO;
import com.mytests.crud_web.entities.Student;
import com.mytests.crud_web.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    @Transactional(readOnly = true)
    public List<StudentDTO> findAll(){
        List<Student> list = repository.findAll();
        return list.stream().map( x -> new StudentDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public StudentDTO insert(StudentInsertDTO dto){
        Student entity = new Student();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity =  repository.save(entity);
        return new StudentDTO(entity);
    }
    @Transactional
    public void delete(long id){
        repository.deleteById(id);
    }

    @Transactional
    public void update(long id, StudentDTO dto){
          repository.findById(id).map(student -> {
              student.setName(dto.getName());
              student.setAge(dto.getAge());
              Student entity = repository.save(student);
              return ResponseEntity.ok().body(entity);
          }).orElse(ResponseEntity.notFound().build());
    }
}
