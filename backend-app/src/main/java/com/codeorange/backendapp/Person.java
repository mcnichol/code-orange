package com.codeorange.backendapp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = Person.Builder.class)
public class Person {
    private String name;
    private String role;

    private Person() {
        throw new Error("You are not allowed to do that");
    }

    private Person(Builder builder) {
        this.name = builder.name;
        this.role = builder.role;
    }

    @JsonPOJOBuilder(withPrefix = "")
    static class Builder {

        private String name;
        private String role;

        Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder role(String role) {
            this.role = role;
            return this;
        }


        Person build() {
            return new Person(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(role, person.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
