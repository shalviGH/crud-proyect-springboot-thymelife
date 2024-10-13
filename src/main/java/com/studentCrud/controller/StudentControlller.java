package com.studentCrud.controller;


import com.studentCrud.entity.Student;
import com.studentCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentControlller {

    @Autowired
    private StudentService service;


    @GetMapping("/")
    public String listStudent(Model model) {
        model.addAttribute ("students", service.findAll());

        return "students";
    }

    @GetMapping("/student/new")
    public String showForm(Model model) {
        Student student= new Student();
        model.addAttribute ("student",student);

        return "create_student";
    }


    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
       service.save(student);

        return "redirect:/";
    }

    @GetMapping("/student/update/{id}")
    public String showFromEdit(@PathVariable long id, Model model){
        model.addAttribute("student", service.find(id));
        return "student_update";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("estudiante") Student student,
                                       Model modelo) {
        Student estudent = service.find(id);
        estudent.setId(id);
        estudent.setNombre(student.getNombre());
        estudent.setApellido(student.getApellido());
        estudent.setEmail(student.getEmail());
        service.update(student);
        return "redirect:/";
    }
    @GetMapping("/student/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
