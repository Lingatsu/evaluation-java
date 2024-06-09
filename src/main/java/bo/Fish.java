package bo;

import java.time.LocalDate;

public class Fish extends Animal {

    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(LocalDate birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
