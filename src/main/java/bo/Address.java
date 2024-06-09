package bo;

import jakarta.persistence.*;

@Entity
@Table(name="ADRESSE")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
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

    public Address() {
    }

    public Address(String number, String street, String zipcode, String city) {
        this.number = number;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

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
