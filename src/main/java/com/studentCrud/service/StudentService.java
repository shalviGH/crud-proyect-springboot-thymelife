package com.studentCrud.service;

import com.studentCrud.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();

    public Student save(Student student);

    public Student find(long id);

    public Student update(Student student);

    public void delete(long id);
}
