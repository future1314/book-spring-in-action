package com.getset.bsia.mvc.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Spitter {
    private long id;

    @NotEmpty
    @Size(min = 3, max = 12)
    private String firstName;
    @NotEmpty
    @Size(min = 3, max = 12)
    private String lastName;
    @NotEmpty
    @Size(min = 3, max = 12)
    private String username;
    @NotEmpty
    @Size(min = 8, max = 12)
    @Pattern(regexp = "[a-z0-9]{8,12}")
    private String password;

    public Spitter() {
    }

    public Spitter(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Spitter(long id, String firstName, String lastName, String username, String password) {
        this(firstName, lastName, username, password);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, "id", "username", "password");
    }

    @Override
    public String toString() {
        return this.username + "(" + this.lastName + " " + this.firstName + ")";
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "username", "password");
    }
}
