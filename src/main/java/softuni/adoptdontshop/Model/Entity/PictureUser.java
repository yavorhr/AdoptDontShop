package softuni.adoptdontshop.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "pictures_users")
public class PictureUser extends BaseEntity {

    private String title;
    @Lob
    private String url;
    private String publicId;

    public PictureUser() {
    }

    public String getTitle() {
        return title;
    }

    public PictureUser setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureUser setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureUser setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
