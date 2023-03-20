package app.repository.implemetation;

import app.configuration.HibernateConfiguration;
import app.model.User;
import app.repository.UserRepository;

import app.service.UserService;
import app.single_point_access.ServiceSinglePointAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User save(User entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnPersonSaved = (Integer) session.save(entity);

        transaction.commit();
        session.close();

        return findById(idOnPersonSaved);
    }

    @Override
    public User register(String name, String password, String nickname)
    {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setNickname(nickname);

        UserService userService = ServiceSinglePointAccess.getUserService();
        User savedUser = userService.save(user);

        transaction.commit();
        session.close();

        return savedUser;
    }

    @Override
    public User update(User entity) {
        // TO DO
        // Same logic - extract it somehow
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
    public List<User> findAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Native SQL - not preferred
        // Query query = session.createSQLQuery("select * from person");

        TypedQuery<User> query = session.getNamedQuery("findAllUsers");
        List<User> persons = query.getResultList();

        transaction.commit();
        session.close();

        return persons;
    }

    @Override
    public User findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL - Hibernate Query Language, but use named query instead to reuse them
        // Query query = session.createQuery("from Person where id=:id");
        // query.setParameter("id", id);

        TypedQuery<User> query = session.getNamedQuery("findUserById");
        query.setParameter("id", id);

        User person;
        try {
            person = (User) query.getSingleResult();
        } catch (NoResultException e) {
            person = null;
        }

        transaction.commit();
        session.close();

        return person;
    }

    @Override
    public boolean delete(User entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getId();
        session.delete(entity);

        transaction.commit();
        session.close();

        return findById(id) == null;
    }

    @Override
    public User findByNickame(String nickname) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Used a Named Query - best solution
        TypedQuery<User> query = session.getNamedQuery("findUserByNickname");
        query.setParameter("nickname", nickname);
        User person;
        try {
            person = query.getSingleResult();
        } catch (NoResultException e) {
            person = null;
        }

        transaction.commit();
        session.close();

        return person;
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // TO DO
        // Same logic - extract it somehow
        TypedQuery<User> query = session.getNamedQuery("findUserByNameAndPassword");
        query.setParameter("name", name);
        query.setParameter("password", password);

        User person;
        try {
            person = query.getSingleResult();
        } catch (NoResultException e) {
            person = null;
        }

        transaction.commit();
        session.close();

        return person;
    }

    @Override
    public User findFavoriteGame() {
        return null;
    }
}

