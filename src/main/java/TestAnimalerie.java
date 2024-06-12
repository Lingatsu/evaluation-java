import bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;


public class TestAnimalerie {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("animalerie");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        // Définition et écriture des produits dans la base de donnée
        Product litiere = new Product("98643","Litière",ProdType.FOOD,12.99);
        em.persist(litiere);
        Product brosse = new Product("05847","Brosse",ProdType.ACCESSORY,5.99);
        em.persist(brosse);
        Product croquette = new Product("74680","Croquettes",ProdType.CLEANING,35.99);
        em.persist(croquette);

        // Définition et écriture des adresse dans la base de donnée
        Address adresseSoleil = new Address("35","Rue des lions","34000","Montpellier");
        em.persist(adresseSoleil);
        Address adresseNuage = new Address("128","Rue des oiseaux","49000","Angers");
        em.persist(adresseNuage);
        Address adresseEau = new Address("4","Rue des dauhpins","30000","Nîmes");
        em.persist(adresseEau);

        // Définition et écriture des animaleries dans la base de donnée
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

        // Définition et écriture des animaux (chat, lapin, poisson) dans la base de donnée
        Cat tom = new Cat(LocalDate.parse("2006-08-05"),"Gris foncé", soleil, "78975");
        em.persist(tom);
        Cat tam = new Cat(LocalDate.parse("2009-05-20"),"Blanc", soleil, "95624");
        em.persist(tam);
        Cat tim = new Cat(LocalDate.parse("2004-02-12"),"Roux", soleil, "45671");
        em.persist(tim);

        Animal bugsBunny = new Animal(LocalDate.parse("2020-06-25"),"Gris", nuage);
        em.persist(bugsBunny);

        Fish nemo = new Fish(LocalDate.parse("2010-04-01"),"Orange", eau, FishLivEnv.SEA_WATER);
        em.persist(nemo);
        Fish nema = new Fish(LocalDate.parse("2015-06-08"),"Rouge", eau, FishLivEnv.FRESH_WATER);
        em.persist(nema);
        Fish nemi = new Fish(LocalDate.parse("2012-08-26"),"Jaune", eau, FishLivEnv.SEA_WATER);
        em.persist(nemi);

        // Extraction et affichage de tous les animaux d'une animalerie donnée
        // Selon l'animalerie sélectionné il y a les animaux qui sont affiché en fonction de la condition dans le if
        TypedQuery<Animal> queryAnimals = em.createQuery("SELECT anm FROM Animal anm where anm.petStore.name = 'Soleil'", Animal.class);
        List<Animal> animalList = queryAnimals.getResultList();
        for (Animal animal : animalList) {
            if (animal.getPetStore().getName().equals("Soleil")) {
                System.out.println("Dans l'animalerie " + soleil.getName() + " Il y a l'animal numéro " + animal.getId() + " de couleur " + animal.getCouleur() + " née le " + animal.getBirth());
            }
            else if (animal.getPetStore().getName().equals("Nuage")) {
                System.out.println("Dans l'animalerie " + nuage.getName() + " Il y a l'animal numéro " + animal.getId() + " de couleur " + animal.getCouleur() + " née le " + animal.getBirth());
            }
            else if (animal.getPetStore().getName().equals("Eau")) {
                System.out.println("Dans l'animalerie " + eau.getName() + " Il y a l'animal numéro " + animal.getId() + " de couleur " + animal.getCouleur() + " née le " + animal.getBirth());
            }
        }


        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }
}
