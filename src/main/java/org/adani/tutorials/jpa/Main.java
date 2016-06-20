package org.adani.tutorials.jpa;

import org.adani.tutorials.jpa.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Basic tutorial of on JPA
 */
public class Main {

    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("The Hitchhikers Guide to the Galaxy");
        book.setPrice(12.5f);
        book.setDescription("Science Fiction Comedy");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPages(354);
        book.setIllustrations(false);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter02PU");
        EntityManager em = emf.createEntityManager();


        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();

        em.close();
        emf.close();
    }
}
