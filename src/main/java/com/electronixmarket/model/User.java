package com.electronixmarket.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
public class User extends PanacheMongoEntity {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private Role role;
    private Long createdAt;
    private Long updatedAt;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return isActive == user.isActive && Objects.equals(username, user.username) && Objects.equals(email, user.email)
                && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName) && role == user.role && Objects.equals(createdAt, user.createdAt)
                && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password, firstName, lastName, isActive, role, createdAt, updatedAt);
    }

    public static User findByUsername(String username) {
        return find("username", username).firstResult();
    }

    public static boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }


}