package org.example.dao;

import org.example.entity.Product;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class ProductDaoImpl implements ProductDao{

    private final SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();

        }
        catch (RuntimeException re){
            System.out.println(re.getLocalizedMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
try(Session session = sessionFactory.openSession()) {
    Transaction transaction = session.beginTransaction();
    Product product = session.get(Product.class, id);
    session.delete(product);
    transaction.commit();


}
catch (RuntimeException e){
    System.out.println(e.getLocalizedMessage());
}
catch (Exception e){
    System.out.println(e.getMessage());
}
    }

    @Override
    public List<Product> findAll() {

        try (Session session = sessionFactory.openSession()){
            return session.createQuery("From Product", Product.class).list();

        }
    }

    @Override
    public Product findById(Long id) {
    Session session =sessionFactory.openSession();
    Product product = session.get(Product.class, id);

    return product;
    }

    @Override
    public List<Product> findAllById(List<Long> ids) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Product where id in (:ids)", Product.class);
            query.setParameter("ids", ids);
            return query.getResultList();
        }
    }
}
