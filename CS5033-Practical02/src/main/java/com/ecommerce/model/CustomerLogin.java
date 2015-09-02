package com.ecommerce.model;

/**
 * Created by jid on 21/04/15.
 */
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class CustomerLogin {

    @NotEmpty
    @Size(min=4, max=45)
    private String email;

    @NotEmpty
    @Size(min=4, max=15)
    private String password;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}