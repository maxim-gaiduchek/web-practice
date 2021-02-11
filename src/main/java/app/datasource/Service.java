package app.datasource;

import app.model.Answer;

public interface Service {

    void saveAnswer(Answer answer);

    int countAnswers();

    int countMaleAnswers();

    int countOperators(String operator);
}
