package app.model;

import java.util.List;

public class UserRecord {

    private String name;
    private String surname;
    private String sex;
    private List<String> operators;

    public UserRecord() {
    }

    // getters

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    public List<String> getOperators() {
        return operators;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setOperators(List<String> operators) {
        this.operators = operators;
    }

    // core

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRecord that)) return false;

        if (!name.equals(that.name)) return false;
        if (!surname.equals(that.surname)) return false;
        return sex.equals(that.sex);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + sex.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserRecord{" +
               "name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", sex='" + sex + '\'' +
               ", operators=" + operators +
               '}';
    }
}
