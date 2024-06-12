package bo;

import jakarta.persistence.*;
//Importation des librairies pour utiliser les méthodes Set et Hashset
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUIT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Column(name = "ETIQUETTE")
    private String label;
//    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private ProdType type;
    @Column(name = "PRIX")
    private double price;

    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStore = new HashSet<>();

    public Product() {
    }

    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStore() {
        return petStore;
    }

    public void setPetStore(Set<PetStore> petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Product{" +
                "petStore=" + petStore +
                ", price=" + price +
                ", type=" + type +
                ", label='" + label + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
