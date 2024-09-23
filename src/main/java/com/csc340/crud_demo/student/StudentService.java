package com.csc340.crud_demo.student;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * StudentService.java
 * Centralizes data access to the Student Database.
 */
@Service
public class StudentService {

    private Map<Integer, Student> studentRepository = initializeRepo();


    /**
     * Fetch all Students.
     *
     * @return the list of all Students.
     */
    public Collection<Student> getAllStudents() {
        return studentRepository.values();
    }

    /**
     * Fetch a unique student.
     *
     * @param studentId the unique Student id.
     * @return a unique Student object.
     */
    public Student getStudentById(int studentId) {
        return studentRepository.get(studentId);
    }

    /**
     * Fetch all students whose major matches the search term.
     *
     * @param major the search key.
     * @return the list of matching Students.
     */
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.values()
                .stream()
                .filter(student -> student.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    /**
     * Add a new Student to the database.
     *
     * @param student the new Student to add.
     */
    public void addNewStudent(Student student) {
        studentRepository.put(student.getStudentId(), student);
    }

    /**
     * Update an existing Student.
     *
     * @param studentId the unique Student Id.
     * @param student   the new Student details.
     */
    public void updateStudent(int studentId, Student student) {
        Student existing = studentRepository.get(studentId);
        existing.setName(student.getName());
        existing.setMajor(student.getMajor());
        existing.setGpa(student.getGpa());
        studentRepository.put(studentId, existing);

    }

    /**
     * Delete a unique Student.
     *
     * @param studentId the unique Student Id.
     */
    public void deleteStudentById(int studentId) {
        studentRepository.remove(studentId);
    }


    /**
     * Utility for making our database never empty for illustration purposes.
     *
     * @return the initialized repository.
     */
    private Map<Integer, Student> initializeRepo() {
        studentRepository = new HashMap<>();
        studentRepository.put(1, new Student(1, "sample1", "csc", 3.89));
        studentRepository.put(2, new Student(2, "sample2", "mat", 4.00));
        studentRepository.put(3, new Student(3, "sample3", "eng", 3.25));
        return studentRepository;
    }
}
