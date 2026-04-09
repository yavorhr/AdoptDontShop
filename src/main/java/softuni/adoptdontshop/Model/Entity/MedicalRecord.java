package softuni.adoptdontshop.Model.Entity;
import softuni.adoptdontshop.Model.Enum.MedicalRecordEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "medical_records")
public class MedicalRecord extends BaseEntity{

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private MedicalRecordEnum name;

    public MedicalRecord() {
    }

    public MedicalRecordEnum getName() {
        return name;
    }

    public MedicalRecord setName(MedicalRecordEnum name) {
        this.name = name;
        return this;
    }

}
