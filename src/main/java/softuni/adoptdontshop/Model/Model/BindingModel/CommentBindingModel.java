package softuni.adoptdontshop.Model.Model.BindingModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentBindingModel {

    @NotBlank
    @Size(min=10)
    private String message;

    public CommentBindingModel() {
    }

    public String getMessage() {
        return message;
    }

    public CommentBindingModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
