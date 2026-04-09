package softuni.adoptdontshop.Model.Model.BindingModel;

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

public class DogUpdateBindingModel {

    private Long id;
    @Size(min = 2, max = 15)
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

    //Dog characteristics
    @NotNull
    private GenderEnum gender;
    @NotNull
    private SizeEnum size;
    @NotNull
    @Positive
    private Integer weight;
    @NotEmpty
    private String colour;
    @NotNull
    private CoatLengthEnum coatLength;
    @NotNull
    private boolean houseTrained;
    @NotEmpty
    private String getAlongWith;

    //Dog medical record
    @NotNull
    private List<MedicalRecordEnum> medicalRecord;

    public DogUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public DogUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DogUpdateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public DogUpdateBindingModel setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public DogUpdateBindingModel setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DogUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public DogUpdateBindingModel setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
        return this;
    }


    public GenderEnum getGender() {
        return gender;
    }

    public DogUpdateBindingModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public SizeEnum getSize() {
        return size;
    }

    public DogUpdateBindingModel setSize(SizeEnum size) {
        this.size = size;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public DogUpdateBindingModel setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public DogUpdateBindingModel setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public CoatLengthEnum getCoatLength() {
        return coatLength;
    }

    public DogUpdateBindingModel setCoatLength(CoatLengthEnum coatLength) {
        this.coatLength = coatLength;
        return this;
    }

    public boolean isHouseTrained() {
        return houseTrained;
    }

    public DogUpdateBindingModel setHouseTrained(boolean houseTrained) {
        this.houseTrained = houseTrained;
        return this;
    }

    public String getGetAlongWith() {
        return getAlongWith;
    }

    public DogUpdateBindingModel setGetAlongWith(String getAlongWith) {
        this.getAlongWith = getAlongWith;
        return this;
    }

    public List<MedicalRecordEnum> getMedicalRecord() {
        return medicalRecord;
    }

    public DogUpdateBindingModel setMedicalRecord(List<MedicalRecordEnum> medicalRecord) {
        this.medicalRecord = medicalRecord;
        return this;
    }
}
