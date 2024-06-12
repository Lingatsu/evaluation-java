package bo;

import jakarta.persistence.*;
//Importation de la librairie permettant d'utiliser l'objet LocalDate
import java.time.LocalDate;

@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATE_DE_NAISSANCE")
    private LocalDate birth;
    @Column(name = "COULEUR")
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "ID_PETSTORE")
    private PetStore petStore;

    public Animal() {
    }

    public Animal(LocalDate birth, String couleur, PetStore petStore) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStore = petStore;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}
