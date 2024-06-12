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

        Product litiere = new Product("98643","Litière",ProdType.CLEANING,12.99);
        em.persist(litiere);
        Product brosse = new Product("05847","Brosse",ProdType.ACCESSORY,5.99);
        em.persist(brosse);
        Product croquette = new Product("74680","Croquettes",ProdType.FOOD,35.99);
        em.persist(croquette);

        Address adresseSoleil = new Address("35","Rue des lions","34000","Montpellier");
        em.persist(adresseSoleil);
        Address adresseNuage = new Address("128","Rue des oiseaux","49000","Angers");
        em.persist(adresseNuage);
        Address adresseEau = new Address("4","Rue des dauhpins","30000","Nîmes");
        em.persist(adresseEau);

        PetStore soleil = new PetStore("Soleil","Paul");
        soleil.setAdresse(adresseSoleil);
        soleil.getProducts().add(litiere);
        em.persist(soleil);
        PetStore nuage = new PetStore("Nuage","Pierre");
        nuage.setAdresse(adresseNuage);
        nuage.getProducts().add(brosse);
        em.persist(nuage);
        PetStore eau = new PetStore("Eau","Jacques");
        eau.setAdresse(adresseEau);
        eau.getProducts().add(croquette);
        em.persist(eau);

        Cat tom = new Cat(LocalDate.parse("2008-08-11"),"Gris foncé", soleil, "78975");
        em.persist(tom);
        Animal bugs = new Animal(LocalDate.parse("2020-06-25"),"Gris", nuage);
        em.persist(bugs);
        Fish nemo = new Fish(LocalDate.parse("2010-04-01"),"Orange", eau, FishLivEnv.SEA_WATER);
        em.persist(nemo);

        PetStore extract = em.find(PetStore.class, 1);
        if (null != extract) {
            System.out.println("TEST" + extract.getAnimals());
        }


        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }
}
