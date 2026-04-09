package softuni.adoptdontshop.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "donations")
public class Donation extends BaseEntity {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private BigDecimal sum;
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @Lob
    private String text;

    @Column(nullable = false)
    private LocalDate contributedOn;

    public Donation() {
    }

    public LocalDate getContributedOn() {
        return contributedOn;
    }

    public Donation setContributedOn(LocalDate contributedOn) {
        this.contributedOn = contributedOn;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Donation setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Donation setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public Donation setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Donation setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Donation setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getText() {
        return text;
    }

    public Donation setText(String text) {
        this.text = text;
        return this;
    }
}
