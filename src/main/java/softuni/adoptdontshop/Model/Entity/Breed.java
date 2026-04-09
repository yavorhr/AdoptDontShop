package softuni.adoptdontshop.Model.Entity;

import softuni.adoptdontshop.Model.Enum.SizeEnum;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "breeds")
public class Breed extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Lob
    private String description;
    private String imageUrl;

    //Characteristics
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SizeEnum size;

    @Column(nullable = false)
    private Integer energyLevel;
    @Column(nullable = false)
    private Integer playfulness;
    @Column(nullable = false)
    private Integer affectionLevel;
    @Column(nullable = false)
    private Integer groomingRequirements;
    @Column(nullable = false)
    private Integer friendlinessToOtherPets;
    @Column(nullable = false)
    private Integer friendlinessToStrangers;
    @Column(nullable = false)
    private Integer watchfulness;
    @Column(nullable = false)
    private Integer easeOfTraining;

    public Breed() {
    }

    @OneToMany(mappedBy = "breed",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Dog> dogs;

    public String getName() {
        return name;
    }

    public Breed setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Breed setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public Breed setDogs(List<Dog> dogs) {
        this.dogs = dogs;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Breed setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getEnergyLevel() {
        return energyLevel;
    }

    public Breed setEnergyLevel(Integer energyLevel) {
        this.energyLevel = energyLevel;
        return this;
    }

    public Integer getPlayfulness() {
        return playfulness;
    }

    public Breed setPlayfulness(Integer playfulness) {
        this.playfulness = playfulness;
        return this;
    }

    public Integer getAffectionLevel() {
        return affectionLevel;
    }

    public Breed setAffectionLevel(Integer affectionLevel) {
        this.affectionLevel = affectionLevel;
        return this;
    }

    public Integer getGroomingRequirements() {
        return groomingRequirements;
    }

    public Breed setGroomingRequirements(Integer groomingRequirements) {
        this.groomingRequirements = groomingRequirements;
        return this;
    }

    public Integer getFriendlinessToOtherPets() {
        return friendlinessToOtherPets;
    }

    public Breed setFriendlinessToOtherPets(Integer friendlinessToOtherPets) {
        this.friendlinessToOtherPets = friendlinessToOtherPets;
        return this;
    }

    public Integer getFriendlinessToStrangers() {
        return friendlinessToStrangers;
    }

    public Breed setFriendlinessToStrangers(Integer friendlinessToStrangers) {
        this.friendlinessToStrangers = friendlinessToStrangers;
        return this;
    }

    public Integer getWatchfulness() {
        return watchfulness;
    }

    public Breed setWatchfulness(Integer watchfulness) {
        this.watchfulness = watchfulness;
        return this;
    }

    public Integer getEaseOfTraining() {
        return easeOfTraining;
    }

    public Breed setEaseOfTraining(Integer easeOfTraining) {
        this.easeOfTraining = easeOfTraining;
        return this;
    }

    public SizeEnum getSize() {
        return size;
    }

    public Breed setSize(SizeEnum size) {
        this.size = size;
        return this;
    }
}
