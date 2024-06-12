package bo;
//Importation de
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
// Liaison de l'héritage
public class Cat extends Animal {
    private String chipId;

    public Cat() {
    }

    public Cat(LocalDate birth, String couleur, PetStore petStore, String chipId) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipid) {
        this.chipId = chipid;
    }
}

