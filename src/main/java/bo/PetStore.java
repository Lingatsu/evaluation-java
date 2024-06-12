package bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ANIMALERIE")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOM")
    private String name;
    @Column(name = "NOM_MANAGER")
    private String managerName;
    // Relation ManyToMany bidirectionnelle avec la classe Product
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // Création d'une table de jointure
    @JoinTable(name = "PROD_PET",
            joinColumns = @JoinColumn(name = "ID_PET", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PROD", referencedColumnName = "ID")
    )
    private Set<Product> products = new HashSet<>();

    // Relation OneToMany bidirectionnelle avec la classe PetStore
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Animal> animals = new HashSet<>();

    // Relation OneToOne bidirectionnelle avec la classe Address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ADRESSE")
    private Address adresse;

    public PetStore() {
    }

    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Address getAdresse() {
        return adresse;
    }

    public void setAdresse(Address adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", products=" + products +
                ", animals=" + animals +
                ", adresse=" + adresse +
                '}';
    }
}
