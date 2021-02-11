package app.model;

import app.datasource.converters.StringListConverter;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @Column(name = "ip")
    private String ip;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "operators")
    @Convert(converter = StringListConverter.class)
    private List<String> operators;

    private Answer() {
    }

    public Answer(HttpServletRequest servletRequest, UserRecord record) {
        ip = servletRequest.getRemoteAddr();
        name = record.getName();
        surname = record.getSurname();
        sex = record.getSex().equals("male") ? Sex.MALE : Sex.FEMALE;
        operators = record.getOperators();
    }

    // core

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer answer)) return false;

        return ip.equals(answer.ip);
    }

    @Override
    public int hashCode() {
        return ip.hashCode();
    }

    @Override
    public String toString() {
        return "Answer{" +
               "ip='" + ip + '\'' +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", sex=" + sex +
               ", operators=" + operators +
               '}';
    }

    private enum Sex {
        MALE, FEMALE
    }
}
