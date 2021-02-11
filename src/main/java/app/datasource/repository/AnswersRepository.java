package app.datasource.repository;

import app.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends JpaRepository<Answer, Integer> {

    @Query("SELECT COUNT(*) FROM Answer a WHERE sex = 'MALE'")
    int countMale();

    @Query("SELECT COUNT(*) FROM Answer a WHERE operators = CONCAT('%', ?1, '%')")
    int countOperator(String operator);
}
