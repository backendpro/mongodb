package br.com.youtube.mongodb.service;

import br.com.youtube.mongodb.model.StudentRequest;
import br.com.youtube.mongodb.model.StudentResponse;
import br.com.youtube.mongodb.persistence.entity.Student;
import br.com.youtube.mongodb.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public StudentResponse create(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setDocument(request.getDocument());
        student.setBirthDate(request.getBirthDate());
        student.setSecondKey(UUID.randomUUID().toString());

        repository.save(student);
        return createResponse(student);
    }

    @Override
    public List<StudentResponse> getAll() {
        List<StudentResponse> responses = new ArrayList<>();

        List<Student> students = repository.findAll();
        if (!students.isEmpty()) {
            students.forEach(student -> responses.add(createResponse(student)));
        }

        return responses;
    }

    private StudentResponse createResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setSecondKey(student.getSecondKey());
        response.setName(student.getName());
        response.setDocument(student.getDocument());
        response.setBirthDate(student.getBirthDate());

        return response;
    }
}
