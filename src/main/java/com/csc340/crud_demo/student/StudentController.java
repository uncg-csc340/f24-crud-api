package com.csc340.crud_demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * StudentController.java.
 * Includes all REST API endpoint mappings for the Student object.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    /**
     * Get a list of all Students in the database.
     *
     * @return a list of Students  objects.
     */
    @GetMapping("/all")
    public Collection<Student> getAllStudents() {
        return service.getAllStudents();
    }

    /**
     * Get a specific Student by Id.
     *
     * @param studentId the unique Id for a Student.
     * @return One Student object.
     */
    @GetMapping("/{studentId}")
    public Student getOneStudent(@PathVariable int studentId) {
        return service.getStudentById(studentId);
    }

    /**
     * Get a list of Students based on their major.
     *
     * @param major the search key.
     * @return A list of Student objects matching the search key.
     */
    @GetMapping("")
    public Collection<Student> getStudentsByMajor(@RequestParam(name = "major", defaultValue = "csc") String major) {
        return service.getStudentsByMajor(major);
    }

    /**
     * Create a new Student entry.
     *
     * @param student the new Student object.
     * @return the updated list of Students.
     */
    @PostMapping("/new")
    public Collection<Student> addNewStudent(@RequestBody Student student) {
        service.addNewStudent(student);
        return service.getAllStudents();
    }

    /**
     * Update an existing Student object.
     *
     * @param studentId the unique Student Id.
     * @param student   the new update Student details.
     * @return the updated Student object.
     */
    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        service.updateStudent(studentId, student);
        return service.getStudentById(studentId);
    }

    /**
     * Delete a Student object.
     *
     * @param studentId the unique Student Id.
     * @return the updated list of Students.
     */
    @DeleteMapping("/delete/{studentId}")
    public Collection<Student> deleteStudentById(@PathVariable int studentId) {
        service.deleteStudentById(studentId);
        return service.getAllStudents();
    }
}
