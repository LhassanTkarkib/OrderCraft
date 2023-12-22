package com.jetbrains.ordercraft2.Dao.Implimentation;

import com.jetbrains.ordercraft2.Dao.Interface.UserDao;
import com.jetbrains.ordercraft2.Model.Classes.User;
import com.jetbrains.ordercraft2.Config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl implements UserDao {

    @Override
    public User addUser(User user){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }
}
