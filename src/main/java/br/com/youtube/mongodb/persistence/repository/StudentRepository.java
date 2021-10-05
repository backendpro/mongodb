package br.com.youtube.mongodb.persistence.repository;

import br.com.youtube.mongodb.persistence.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
