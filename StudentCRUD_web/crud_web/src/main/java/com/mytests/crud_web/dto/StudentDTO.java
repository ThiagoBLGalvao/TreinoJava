package com.mytests.crud_web.dto;

import com.mytests.crud_web.entities.Student;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private int age;

    public StudentDTO() {
    }

    public StudentDTO(Student entity){
        id = entity.getId();
        name = entity.getName();
        age = entity.getAge();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
