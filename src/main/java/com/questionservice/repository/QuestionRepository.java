package com.questionservice.repository;

import com.questionservice.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Integer> {

    @Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :no_of_que", nativeQuery = true)
    List<Questions> findRandomQuestion(@Param("no_of_que") int no_of_que, @Param("category") String category);
}
