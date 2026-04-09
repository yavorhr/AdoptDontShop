package softuni.adoptdontshop.Model.Model.BindingModel;


import softuni.adoptdontshop.Model.Validator.UniqueEmail;
import softuni.adoptdontshop.Model.Validator.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegistrationBindingModel {

    @NotBlank
    @Size
    @UniqueUsername
    private String username;
    @NotBlank(message = "Email is required.")
    @Email
    @UniqueEmail
    private String email;
    @NotNull
    @Size(min = 4, max = 20)
    private String firstName;
    @NotNull
    @Size(min = 4, max = 20)
    private String lastName;
    private Integer age;
    @NotNull
    @Size(min = 4, max = 20)
    private String password;
    @NotNull
    @Size(min = 4, max = 20)
    private String confirmPassword;
    private String description;

    public String getUsername() {
        return username;
    }

    public UserRegistrationBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserRegistrationBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegistrationBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }
}


