package org.adani.tutorials.jpa.model;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;


    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("chapter02PU");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void cloeEntityManager() throws Exception {
        em.close();
        emf.close();
    }

    @Before
    public void initTransaction() {
        tx = em.getTransaction();
    }


    @Test
    public void shouldCreateABook() throws Exception {

        Book book = new Book();
        book.setTitle("The Hitchhikers Guide to the Galaxy");
        book.setPrice(12.5f);
        book.setDescription("Science Fiction Comedy");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPages(354);
        book.setIllustrations(false);

        tx.begin();
        em.persist(book);
        tx.commit();

        assertNotNull("ID Should not be NULL ", book.getId());


        List<Book> books = em.createNamedQuery("findAllBooks").getResultList();

        assertEquals(1, books.size());
    }


}