package com.jetbrains.ordercraft2.Dao.Interface;

import com.jetbrains.ordercraft2.Model.Classes.User;

import java.util.List;

public interface UserDao {


   public User getUserByEmail(String email);
   User login(String email, String password);
   User addUser(User user);
   List<User> getAllUsers();
   void deleteUserByEmail(String email);
   void updateUserById(int Id, String newName, String newEmail, String newPassword);
}
