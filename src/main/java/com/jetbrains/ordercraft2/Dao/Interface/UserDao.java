package com.jetbrains.ordercraft2.Dao.Interface;

import com.jetbrains.ordercraft2.Model.Classes.User;

public interface UserDao {


   public User getUserByEmail(String email);
   User login(String email, String password);
   User addUser(User user);

}
