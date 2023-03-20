package app.repository.implemetation;

import app.configuration.HibernateConfiguration;
import app.model.Game;
import app.repository.GameRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class GameRepositoryImpl implements GameRepository {

    @Override
    public Game save(Game entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnGameSaved = (Integer) session.save(entity);

        transaction.commit();
        session.close();

        return findById(idOnGameSaved);
    }

    @Override
    public Game update(Game entity) {
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
    public Game findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TypedQuery<Game> query = session.getNamedQuery("findGameById");
        query.setParameter("id", id);

        Game game;
        try {
            game = query.getSingleResult();
        } catch (NoResultException e) {
            game = null;
        }

        transaction.commit();
        session.close();

        return game;
    }

    @Override
    public Game findByName(String name) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TypedQuery<Game> query = session.getNamedQuery("findGameByName");
        query.setParameter("name", name);

        Game game;
        try {
            game = query.getSingleResult();
        } catch (NoResultException e) {
            game = null;
        }

        transaction.commit();
        session.close();

        return game;
    }

    @Override
    public List<Game> findAll() {
        return null;
    }

    @Override
    public boolean delete(Game entity) {
        return false;
    }
}
