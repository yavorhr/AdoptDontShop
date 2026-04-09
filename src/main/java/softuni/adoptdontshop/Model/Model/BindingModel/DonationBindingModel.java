package softuni.adoptdontshop.Model.Model.BindingModel;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class DonationBindingModel {

    @NotEmpty
    @Size(min = 1, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String lastName;

    @NotNull
    @Positive
    private BigDecimal sum;

    @Pattern(regexp = "\\+[0-9]{12}")
    private String phoneNumber;

    @NotEmpty
    @Email
    private String email;

    @Lob
    private String text;

    @Pattern(regexp = "[0-9]{12}")
    private String creditCardNumber;

    @Size(min = 5, max = 30)
    private String cardHolderName;

   @Pattern(regexp = "[0-9]{2}\\/[0-9]{2}")
    private String expiration;

    @Pattern(regexp = "[0-9]{3}")
    private String cvv;

    public DonationBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public DonationBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DonationBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCvv() {
        return cvv;
    }

    public DonationBindingModel setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public DonationBindingModel setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public DonationBindingModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DonationBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getText() {
        return text;
    }

    public DonationBindingModel setText(String text) {
        this.text = text;
        return this;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public DonationBindingModel setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        return this;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public DonationBindingModel setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }

    public String getExpiration() {
        return expiration;
    }

    public DonationBindingModel setExpiration(String expiration) {
        this.expiration = expiration;
        return this;
    }
}
