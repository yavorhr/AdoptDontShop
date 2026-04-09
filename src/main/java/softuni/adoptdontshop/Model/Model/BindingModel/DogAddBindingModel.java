package softuni.adoptdontshop.Model.Model.BindingModel;

import softuni.adoptdontshop.Model.Enum.CoatLengthEnum;
import softuni.adoptdontshop.Model.Enum.GenderEnum;
import softuni.adoptdontshop.Model.Enum.MedicalRecordEnum;
import softuni.adoptdontshop.Model.Enum.SizeEnum;

import jakarta.validation.constraints.*;
import java.util.Set;

public class DogAddBindingModel {

    //Basic data
    @Pattern(regexp = "[A-Za-z]{2,15}")
    private String name;
    @NotNull
    @Positive
    private Integer age;
    @NotEmpty
    private String breed;
    @Size(min = 5)
    private String description;
    @Size(min = 5)
    private String medicalNotes;
    @NotEmpty
    private String imageUrl;

    //Dog characteristics
    @NotNull
    private GenderEnum gender;
    @NotNull
    private SizeEnum size;
    @NotNull
    @Positive
    private Integer weight;
    @NotEmpty
    @Pattern(regexp = "[A-Za-z]+")
    private String colour;
    @NotNull
    private CoatLengthEnum coatLength;
    @NotNull
    private boolean houseTrained;
    @NotEmpty
    private String getAlongWith;

    //Dog medical record
    @NotNull
    private Set<MedicalRecordEnum> medicalRecord;

    public DogAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public DogAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public DogAddBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DogAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public DogAddBindingModel setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public DogAddBindingModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public DogAddBindingModel setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public CoatLengthEnum getCoatLength() {
        return coatLength;
    }

    public DogAddBindingModel setCoatLength(CoatLengthEnum coatLength) {
        this.coatLength = coatLength;
        return this;
    }

    public boolean isHouseTrained() {
        return houseTrained;
    }

    public DogAddBindingModel setHouseTrained(boolean houseTrained) {
        this.houseTrained = houseTrained;
        return this;
    }

    public String getGetAlongWith() {
        return getAlongWith;
    }

    public DogAddBindingModel setGetAlongWith(String getAlongWith) {
        this.getAlongWith = getAlongWith;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public DogAddBindingModel setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public SizeEnum getSize() {
        return size;
    }

    public DogAddBindingModel setSize(SizeEnum size) {
        this.size = size;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public DogAddBindingModel setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public DogAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Set<MedicalRecordEnum> getMedicalRecord() {
        return medicalRecord;
    }

    public DogAddBindingModel setMedicalRecord(Set<MedicalRecordEnum> medicalRecord) {
        this.medicalRecord = medicalRecord;
        return this;
    }
}
