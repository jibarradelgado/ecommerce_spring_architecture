package com.ecommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by jid on 21/04/15.
 */
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue
    private int customer_id;

    @NotEmpty
    @Size(min=4, max=45)
    private String username;

    @NotEmpty
    private String first_name;

    @NotEmpty
    private String last_name;

    @NotEmpty
    @Size(min=4, max=15)
    private String password;

    @NotEmpty
    @Email
    private String email;

    @Past
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date create_date = new Date();

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lastName) {
        this.last_name = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailAddress) {
        this.username = emailAddress;
        this.email = emailAddress;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date() {
        this.create_date = new Date();
    }
}
