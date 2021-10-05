package br.com.youtube.mongodb.service;

import br.com.youtube.mongodb.model.StudentRequest;
import br.com.youtube.mongodb.model.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse create(StudentRequest request);

    List<StudentResponse> getAll();
}
