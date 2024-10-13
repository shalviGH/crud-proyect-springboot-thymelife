package com.studentCrud.logic;

import com.studentCrud.entity.Student;
import com.studentCrud.reposistory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements com.studentCrud.service.StudentService {

    @Autowired
    private StudentRepository repository;


    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student find(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
