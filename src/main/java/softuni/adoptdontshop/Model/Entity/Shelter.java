package softuni.adoptdontshop.Model.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "shelter")
public class Shelter extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "shelter", fetch = FetchType.LAZY)
    private List<Dog> dogs;

    public List<Dog> getDogs() {
        return dogs;
    }

    public Shelter setDogs(List<Dog> dogs) {
        this.dogs = dogs;
        return this;
    }

    public Shelter() {
    }

    public String getName() {
        return name;
    }

    public Shelter setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Shelter setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }
}
