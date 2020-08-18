package com.geekbrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class MainClass {
    public static void main(String[] args) {
        System.out.println("Start:");
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                //.addAnnotatedClass(Book.class)
                //.addAnnotatedClass(Author.class)
                //.addAnnotatedClass(Reader.class)
                //.addAnnotatedClass(Catalog.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        System.out.println("Create factory");
        // CRUD
        Session session = null;

        try {
           session = factory.getCurrentSession();
           Customer[] customer = new Customer[]{new Customer("Bili"),new Customer("Vili"),new Customer("Dili")};
           Product[] product = new Product[]{new Product("Coca cola",35),new Product("Pepsi",23),new Product("Sprite",54)};

           session.beginTransaction();


           for(Customer cust: customer){
               session.save(cust);
           }

            for(Product prod: product){
                session.save(prod);
            }


            session.getTransaction().commit();

            session = null;
            session = factory.getCurrentSession();

            session.beginTransaction();

            Customer cust1 = session.get(Customer.class,1);
            cust1.getProd().add(session.get(Product.class,1));
            cust1.getProd().add(session.get(Product.class,2));

            Customer cust2 = session.get(Customer.class,2);
            cust2.getProd().add(session.get(Product.class,1));
            cust2.getProd().add(session.get(Product.class,3));

            Customer cust3 = session.get(Customer.class,3);
            cust3.getProd().add(session.get(Product.class,2));
            cust3.getProd().add(session.get(Product.class,3));

            session.getTransaction().commit();




   //         session = factory.getCurrentSession();
   //         session.beginTransaction();
   //         Reader reader = session.get(Reader.class, 1);
   //         Book book = session.get(Book.class, 2);
//            reader.getBooks().add(book);
//            reader.getBooks().clear();
  //          session.getTransaction().commit();


//            CREATE
//            session = factory.getCurrentSession();
//            Catalog catalog = new Catalog("Fantasy #15");
//            session.beginTransaction();
//            session.save(catalog);
//            session.getTransaction().commit();

//            READ
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book harryPotterBook = session.get(Book.class, 1);
//            session.getTransaction().commit();
//            System.out.println(harryPotterBook);

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog2 = session.get(Catalog.class, 2L);
//            session.getTransaction().commit();
//            System.out.println(catalog2);

//            UPDATE
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book bookJava1 = session.get(Book.class, 3);
//            bookJava1.setTitle("Java 1 Advanced");
//            session.getTransaction().commit();
//            System.out.println(bookJava1);

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog = session.get(Catalog.class, 1L);
//            catalog.setTitle("Fantasy #8");
//            session.getTransaction().commit();
//            System.out.println(catalog);

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book bookJava1 = session.get(Book.class, 4);
//            session.delete(bookJava1);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//             List<Book> allBooks = session.createQuery("from Book").getResultList();
////             from Book b where b.title = 'Harry Potter' or b.authorName = 'Rowling'
////             from Book b where b.title LIKE 'Harry%'
////             from Book b where b.title = :title
//            List<Book> allBooks = session.createQuery("from Book b where b.title = :title").setParameter("title", "Java 1").getResultList();
//            System.out.println(allBooks);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            session.createQuery("update Book set title = 'A'").executeUpdate();
//            session.createQuery("delete from Book where id = 3").executeUpdate();
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Book book = session.get(Book.class, 1);
//            System.out.println(book);
//            session.getTransaction().commit();
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Author author = session.get(Author.class, 1);
//            System.out.println(author);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            List<Reader> readers = session.createQuery("from Reader").getResultList();
//            System.out.println(readers);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Author author = session.get(Author.class, 2);
//            session.delete(author);
//            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
}
