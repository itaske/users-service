package com.iapl.userservice.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import java.util.Objects;
import java.util.UUID;

@Document("Users")
public class User {

    private String id;

    private String name;

    private String username;

    private String phone;

    //@Pattern can be used with specified regex too
    @Email
    private String email;


    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(name, user.name) && Objects.equals(username, user.username) && Objects.equals(phone, user.phone) && Objects.equals(email, user.email) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, phone, email, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
