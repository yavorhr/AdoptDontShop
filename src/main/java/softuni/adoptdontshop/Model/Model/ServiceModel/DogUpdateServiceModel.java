package softuni.adoptdontshop.Model.Model.ServiceModel;

import softuni.adoptdontshop.Model.Enum.CoatLengthEnum;
import softuni.adoptdontshop.Model.Enum.GenderEnum;
import softuni.adoptdontshop.Model.Enum.MedicalRecordEnum;
import softuni.adoptdontshop.Model.Enum.SizeEnum;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class DogUpdateServiceModel {

    private Long id;
    private String name;
    private Integer age;
    private String breed;
    private String description;
    private String medicalNotes;

    //Dog characteristics
    private GenderEnum gender;

    private SizeEnum size;
    private Integer weight;
    private String colour;
    private CoatLengthEnum coatLength;
    private boolean houseTrained;
    private String getAlongWith;

    //Dog medical record
    @NotNull
    private List<MedicalRecordEnum> medicalRecord;

    public DogUpdateServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public DogUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DogUpdateServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public DogUpdateServiceModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public DogUpdateServiceModel setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DogUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public DogUpdateServiceModel setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public DogUpdateServiceModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public SizeEnum getSize() {
        return size;
    }

    public DogUpdateServiceModel setSize(SizeEnum size) {
        this.size = size;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public DogUpdateServiceModel setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public DogUpdateServiceModel setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public CoatLengthEnum getCoatLength() {
        return coatLength;
    }

    public DogUpdateServiceModel setCoatLength(CoatLengthEnum coatLength) {
        this.coatLength = coatLength;
        return this;
    }

    public boolean isHouseTrained() {
        return houseTrained;
    }

    public DogUpdateServiceModel setHouseTrained(boolean houseTrained) {
        this.houseTrained = houseTrained;
        return this;
    }

    public String getGetAlongWith() {
        return getAlongWith;
    }

    public DogUpdateServiceModel setGetAlongWith(String getAlongWith) {
        this.getAlongWith = getAlongWith;
        return this;
    }

    public List<MedicalRecordEnum> getMedicalRecord() {
        return medicalRecord;
    }

    public DogUpdateServiceModel setMedicalRecord(List<MedicalRecordEnum> medicalRecord) {
        this.medicalRecord = medicalRecord;
        return this;
    }
}
