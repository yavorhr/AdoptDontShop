package softuni.adoptdontshop.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    private String title;
    @Lob
    private String url;
    private String publicId;

//    @ManyToOne
//    private UserEntity userEntity;

    @ManyToOne
    private Dog dog;

    public Picture() {
    }

    public String getTitle() {
        return title;
    }

    public Picture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }
//
//    public UserEntity getUser() {
//        return userEntity;
//    }
//
//    public Picture setUser(UserEntity userEntity) {
//        this.userEntity = userEntity;
//        return this;
//    }

    public Dog getDog() {
        return dog;
    }

    public Picture setDog(Dog dog) {
        this.dog = dog;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public Picture setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }


}
