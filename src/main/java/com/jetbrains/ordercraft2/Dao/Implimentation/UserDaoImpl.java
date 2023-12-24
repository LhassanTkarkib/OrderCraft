package com.jetbrains.ordercraft2.Dao.Implimentation;

import com.jetbrains.ordercraft2.Dao.Interface.UserDao;
import com.jetbrains.ordercraft2.Model.Classes.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public User getUserByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User U WHERE U.email = :email";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User login(String email, String password) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE email = :email AND password = :password", User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            return query.uniqueResult();
        }
    }

    public User addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return user;
        }
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User";
            Query<User> query = session.createQuery(hql, User.class);
            users = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void deleteUserByEmail(String email) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = getUserByEmail(email);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateUserById(int Id, String newName, String newEmail, String newPassword) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, Id);

            if (user != null) {
                user.setName(newName);
                user.setEmail(newEmail);
                user.setPassword(newPassword);
                session.update(user);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
