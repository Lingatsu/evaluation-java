import bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class TestAnimalerie {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("animalerie");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Product croquette = new Product("12345","Croquetty",ProdType.FOOD,35.99);
        em.persist(croquette);

        Address adresseSoleil = new Address("35","Rue des lions","34000","Montpellier");
        em.persist(adresseSoleil);
        Address adresseNuage = new Address("128","Rue des oiseaux","49000","Angers");
        em.persist(adresseNuage);
        Address adresseEau = new Address("4","Rue des dauhpins","30000","Nîmes");
        em.persist(adresseEau);

        PetStore soleil = new PetStore("Soleil","Paul");
        soleil.setAdresse(adresseSoleil);
        soleil.getProducts().add(croquette);
        em.persist(soleil);
        PetStore nuage = new PetStore("Nuage","Pierre");
        nuage.setAdresse(adresseNuage);
        nuage.getProducts().add(croquette);
        em.persist(nuage);
        PetStore eau = new PetStore("Eau","Jacques");
        eau.setAdresse(adresseEau);
        eau.getProducts().add(croquette);
        em.persist(eau);

        Animal jerry = new Animal(LocalDate.now(),"Marron", soleil);
        em.persist(jerry);
        Animal bugs = new Animal(LocalDate.now(),"Gris", nuage);
        em.persist(bugs);
        Animal nemo = new Animal(LocalDate.now(),"Orange", eau);
        em.persist(nemo);

        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }
}
