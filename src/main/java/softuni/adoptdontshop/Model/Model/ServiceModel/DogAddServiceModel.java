package softuni.adoptdontshop.Model.Model.ServiceModel;

import softuni.adoptdontshop.Model.Enum.CoatLengthEnum;
import softuni.adoptdontshop.Model.Enum.GenderEnum;
import softuni.adoptdontshop.Model.Enum.MedicalRecordEnum;
import softuni.adoptdontshop.Model.Enum.SizeEnum;

import jakarta.validation.constraints.*;
import java.util.Set;

public class DogAddServiceModel {

    private Long id;
    @NotEmpty
    @Size(min = 2, max = 15)
    private String name;
    @NotNull
    @Positive
    private Integer age;
    @NotEmpty
    private String description;
    @NotEmpty
    private String medicalNotes;
    private String imageUrl;

    //Dog characteristics

    private GenderEnum gender;
    private String colour;
    private CoatLengthEnum coatLength;
    private boolean houseTrained;
    private String getAlongWith;
    private Integer weight;
    private SizeEnum size;
    private String breed;

    //Dog medical record
    private Set<MedicalRecordEnum> medicalRecord;

    public DogAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public DogAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DogAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public DogAddServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DogAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public DogAddServiceModel setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public DogAddServiceModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public DogAddServiceModel setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public CoatLengthEnum getCoatLength() {
        return coatLength;
    }

    public DogAddServiceModel setCoatLength(CoatLengthEnum coatLength) {
        this.coatLength = coatLength;
        return this;
    }

    public boolean isHouseTrained() {
        return houseTrained;
    }

    public DogAddServiceModel setHouseTrained(boolean houseTrained) {
        this.houseTrained = houseTrained;
        return this;
    }

    public String getGetAlongWith() {
        return getAlongWith;
    }

    public DogAddServiceModel setGetAlongWith(String getAlongWith) {
        this.getAlongWith = getAlongWith;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public DogAddServiceModel setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public SizeEnum getSize() {
        return size;
    }

    public DogAddServiceModel setSize(SizeEnum size) {
        this.size = size;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public DogAddServiceModel setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public Set<MedicalRecordEnum> getMedicalRecord() {
        return medicalRecord;
    }

    public DogAddServiceModel setMedicalRecord(Set<MedicalRecordEnum> medicalRecord) {
        this.medicalRecord = medicalRecord;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public DogAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
