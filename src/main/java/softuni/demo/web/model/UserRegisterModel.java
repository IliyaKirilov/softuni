package softuni.demo.web.model;

import org.hibernate.validator.constraints.Length;
import softuni.demo.domain.model.enums.Brand;

public class UserRegisterModel {
    private String username;
    private String password;
    private String confirmPassword;
    private Brand brand;


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public UserRegisterModel() {
    }

    @Length(min = 4,max = 23, message = "Name length must be more than 3 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 5,max = 23, message = "Password length must be more than 4 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
