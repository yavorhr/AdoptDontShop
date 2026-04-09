package softuni.adoptdontshop.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    private boolean approved;
    private Instant created;
    private String textContent;

    @ManyToOne
    private UserEntity userEntity;

    @ManyToOne
    private Dog dog;

    public Comment() {
    }

    public boolean isApproved() {
        return approved;
    }

    public Comment setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Comment setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Comment setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public Comment setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public Dog getDog() {
        return dog;
    }

    public Comment setDog(Dog dog) {
        this.dog = dog;
        return this;
    }
}
