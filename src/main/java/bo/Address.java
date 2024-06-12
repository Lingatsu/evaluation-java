// Importation des différentes classes constituant le package bo
package bo;
//Importation de tout le contenue de la librairie jakarta.persistence
import jakarta.persistence.*;

// Definition de la classe comme entité JPA
@Entity
// Définition du nom de la table
@Table(name = "ADRESSE")
public class Address {
    @Id
    // Génération automatique de l'ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Crée plusieurs colonnes dans table adresse de la base de donnée dont une nommée ID
    @Column(name = "ID")
    // Le contenue de cette colonne sera une variable privé nommé id de type long int
    private Long id;
    @Column(name = "NUMERO")
    private String number;
    @Column(name = "RUE")
    private String street;
    @Column(name = "CODE_POSTAL")
    private String zipcode;
    @Column(name = "VILLE")
    private String city;
    @OneToOne(mappedBy = "adresse")
    private PetStore petStore;

    // Constructeur vide pour instancier les objets
    public Address() {
    }
    // Constructeur plein pour initialiser les objets
    public Address(String number, String street, String zipcode, String city) {
        this.number = number;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

    // Getters and setters : permettent de récupérer et de définir des valeurs
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    // To string: permet de convertir les objets de type differents en string (chaine de caractère)
    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}
