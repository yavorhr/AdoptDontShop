package softuni.adoptdontshop.Model.Entity;

import softuni.adoptdontshop.Model.Enum.CoatLengthEnum;
import softuni.adoptdontshop.Model.Enum.GenderEnum;
import softuni.adoptdontshop.Model.Enum.MedicalRecordEnum;
import softuni.adoptdontshop.Model.Enum.SizeEnum;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "dogs")
public class Dog extends BaseEntity {

    //Dog

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    private boolean isAdopted;
    private LocalDate lastModified;
    private LocalDate addedOn;
    private LocalDate adoptedOn;
    @Column(nullable = false)
    @Lob
    private String description;
    @Lob
    private String medicalNotes;

    //Dog characteristics


    public LocalDate getAdoptedOn() {
        return adoptedOn;
    }

    public Dog setAdoptedOn(LocalDate adoptedOn) {
        this.adoptedOn = adoptedOn;
        return this;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Column(nullable = false)
    private String colour;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CoatLengthEnum coatLength;
    @Column(nullable = false)
    private boolean houseTrained;
    private String getAlongWith;
    @Column(nullable = false)
    private Integer weight;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SizeEnum size;

    //Dog medical record

    @ManyToMany(fetch = FetchType.LAZY)
    private List<MedicalRecord> medicalRecord = new ArrayList<>();

    @OneToMany(mappedBy = "dog",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "dog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Picture> pictures = new ArrayList<>();

    @ManyToOne
    private Shelter shelter;

    @ManyToOne
    private Breed breed;

    public Dog() {
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Dog setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Dog setAge(Integer age) {
        this.age = age;
        return this;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public Dog setAdopted(boolean adopted) {
        isAdopted = adopted;
        return this;
    }


    public LocalDate getLastModified() {
        return lastModified;
    }

    public Dog setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public LocalDate getAddedOn() {
        return addedOn;
    }

    public Dog setAddedOn(LocalDate addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Dog setDescription(String description) {
        this.description = description;
        return this;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public Dog setShelter(Shelter shelter) {
        this.shelter = shelter;
        return this;
    }

    public Breed getBreed() {
        return breed;
    }

    public Dog setBreed(Breed breed) {
        this.breed = breed;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public Dog setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public String getColour() {
        return colour;
    }

    public Dog setColour(String colour) {
        this.colour = colour;
        return this;
    }

    public CoatLengthEnum getCoatLength() {
        return coatLength;
    }

    public Dog setCoatLength(CoatLengthEnum coatLength) {
        this.coatLength = coatLength;
        return this;
    }

    public boolean isHouseTrained() {
        return houseTrained;
    }

    public Dog setHouseTrained(boolean houseTrained) {
        this.houseTrained = houseTrained;
        return this;
    }

    public String getGetAlongWith() {
        return getAlongWith;
    }

    public Dog setGetAlongWith(String getAlongWith) {
        this.getAlongWith = getAlongWith;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Dog setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public SizeEnum getSize() {
        return size;
    }

    public Dog setSize(SizeEnum size) {
        this.size = size;
        return this;
    }

    public List<MedicalRecord> getMedicalRecord() {
        return medicalRecord;
    }

    public Dog setMedicalRecord(List<MedicalRecord> medicalRecord) {
        this.medicalRecord = medicalRecord;
        return this;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public Dog setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
        return this;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public Dog setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }


}
