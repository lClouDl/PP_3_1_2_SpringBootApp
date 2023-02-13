package ru.kireev.spring.SpringBootApp.models;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Нельзя добавить человека без имени")
    @NotEmpty(message = "Нельзя добавить человека без имени")
    @Size(min = 2, max = 20, message = "Имя должно содержать не менее 2 и не более 20 символов")
    @Column(name = "firstName")
    private String firstName;

    @NotNull(message = "Нельзя добавить человека без фамилии")
    @NotEmpty(message = "Нельзя добавить человека без фамилии")
    @Size(min = 1, max = 40, message = "Фамилия должна содержать не менее 1 и не более 40 символов")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "Укажите пол человка")
    @NotEmpty(message = "Укажите пол человка")
    private String gender;

    public User(){}

    public User(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.getId() && firstName.equals(user.getFirstName()) && lastName.equals(user.getLastName()) && gender.equals(user.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender);
    }
}
