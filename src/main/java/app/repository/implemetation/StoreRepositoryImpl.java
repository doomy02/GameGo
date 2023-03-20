package app.repository.implemetation;

import app.configuration.HibernateConfiguration;
import app.model.Store;
import app.model.User;
import app.repository.StoreRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class StoreRepositoryImpl implements StoreRepository {

    @Override
    public Store save(Store entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnStoreSaved = (Integer) session.save(entity);

        transaction.commit();
        session.close();

        return findById(idOnStoreSaved);
    }

    @Override
    public Store update(Store entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getId();
        session.saveOrUpdate(entity);

        transaction.commit();
        session.close();

        return findById(id);
    }

    @Override
    public Store findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TypedQuery<Store> query = session.getNamedQuery("findStoreById");
        query.setParameter("id", id);

        Store store;
        try {
            store = (Store)query.getSingleResult();
        } catch (NoResultException e) {
            store = null;
        }

        transaction.commit();
        session.close();

        return store;
    }

    @Override
    public List<Store> findAll() {
        return null;
    }

    @Override
    public boolean delete(Store entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getId();
        session.delete(entity);

        transaction.commit();
        session.close();

        return findById(id) == null;
    }
}
