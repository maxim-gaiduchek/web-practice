package app.datasource;

import app.datasource.repository.AnswersRepository;
import app.model.Answer;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@org.springframework.stereotype.Service
public class JpaService implements Service {

    private final AnswersRepository answersRepository;

    public JpaService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Override
    public void saveAnswer(Answer answer) {
        answersRepository.save(answer);
    }

    @Override
    public int countAnswers() {
        return (int) answersRepository.count();
    }

    @Override
    public int countMaleAnswers() {
        return answersRepository.countMale();
    }

    @Override
    public int countOperators(String operator) {
        return answersRepository.countOperator(operator);
    }
}
