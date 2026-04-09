package softuni.adoptdontshop.Service.Impl;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import softuni.adoptdontshop.Model.Entity.Dog;
import softuni.adoptdontshop.Model.Entity.Picture;
import softuni.adoptdontshop.Model.Entity.PictureUser;
import softuni.adoptdontshop.Model.Entity.UserEntity;
import softuni.adoptdontshop.Repository.DogRepository;
import softuni.adoptdontshop.Repository.PictureRepository;
import softuni.adoptdontshop.Repository.PictureUserRepositorty;
import softuni.adoptdontshop.Repository.UserRepository;
import softuni.adoptdontshop.Service.CloudinaryService;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

    private static final String TEMP_FILE = "temp-file";
    private static final String URL = "url";
    private static final String PUBLIC_ID = "public_id";

    //Used @Autowired to prevent issue "the dependencies of some of the beans in the application context form a cycle"
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private CloudinaryService cloudinaryService;

    private final PictureRepository pictureRepository;
    private final PictureUserRepositorty pictureUserRepositorty;
    private final UserRepository userRepository;
    private final DogRepository dogRepository;

    public CloudinaryServiceImpl(PictureRepository pictureRepository, PictureUserRepositorty pictureUserRepositorty, UserRepository userRepository, DogRepository dogRepository) {
        this.pictureRepository = pictureRepository;
        this.pictureUserRepositorty = pictureUserRepositorty;
        this.userRepository = userRepository;
        this.dogRepository = dogRepository;
    }

    @Override
    public PictureUser upload(MultipartFile multipartFile) throws IOException {
        File tempFile = File.createTempFile(TEMP_FILE, multipartFile.getOriginalFilename());
        multipartFile.transferTo(tempFile);

        try {
            @SuppressWarnings("unchecked")
            Map<String, String> uploadResult = cloudinary.
                    uploader().
                    upload(tempFile, Map.of());

            String url = uploadResult.getOrDefault(URL,
                    "https://i.pinimg.com/originals/c5/21/64/c52164749f7460c1ededf8992cd9a6ec.jpg");
            String publicId = uploadResult.getOrDefault(PUBLIC_ID, "");

            return new PictureUser().
                    setPublicId(publicId).
                    setUrl(url);
        } finally {
            tempFile.delete();
        }
    }

    @Override
    public boolean delete(String publicId) {
        try {
            this.cloudinary.uploader().destroy(publicId, Map.of());
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public void savePicture(MultipartFile picture, String title, String email) throws IOException {
        UserEntity userEntity = userRepository.findByUsername(email).orElseThrow();
        PictureUser pictureUserEntity = createPictureUserEntity(picture, title);
        userEntity.setImageUrl(pictureUserEntity.getUrl());

        pictureUserRepositorty.save(pictureUserEntity);
        userRepository.save(userEntity);
    }

    private PictureUser createPictureUserEntity(MultipartFile file, String title) throws IOException {
        final PictureUser uploaded = this.cloudinaryService.upload(file);
        return new PictureUser().
                setPublicId(uploaded.getPublicId()).
                setTitle(title).
                setUrl(uploaded.getUrl());
    }

    @Override
    public void saveDogPicture(MultipartFile picture, String title, Long id) throws IOException {
        Dog dog = dogRepository.findById(id).orElseThrow();
        Picture pictureEntity = createPictureDogEntity(picture, title);
        pictureEntity.setDog(dog);

        pictureRepository.save(pictureEntity);
        dogRepository.save(dog);
    }

    private Picture createPictureDogEntity(MultipartFile file, String title) throws IOException {
        final PictureUser uploaded = this.cloudinaryService.upload(file);
        return new Picture().
                setPublicId(uploaded.getPublicId()).
                setTitle(title).
                setUrl(uploaded.getUrl());
    }


}
