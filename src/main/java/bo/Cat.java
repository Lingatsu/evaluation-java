package bo;

import java.time.LocalDate;

public class Cat extends Animal {
    private String chipid;

    public Cat() {
    }

    public Cat(LocalDate birth, String couleur, PetStore petStore, String chipid) {
        super(birth, couleur, petStore);
        this.chipid = chipid;
    }

    public String getChipid() {
        return chipid;
    }

    public void setChipid(String chipid) {
        this.chipid = chipid;
    }
}

