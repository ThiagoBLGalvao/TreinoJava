package com.mytests.crud_web.resources;

import com.mytests.crud_web.dto.StudentDTO;
import com.mytests.crud_web.dto.StudentInsertDTO;
import com.mytests.crud_web.entities.Student;
import com.mytests.crud_web.repositories.StudentRepository;
import com.mytests.crud_web.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        List<StudentDTO> list  = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> insert(@RequestBody StudentInsertDTO dto){
        StudentDTO newStudent = service.insert(dto);
        return ResponseEntity.ok().body(newStudent);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable long id){
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable("id") long id, @RequestBody StudentDTO dto){
        service.update(id,dto);
    }
}
