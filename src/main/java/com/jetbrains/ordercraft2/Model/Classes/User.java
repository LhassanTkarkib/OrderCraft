package com.jetbrains.ordercraft2.Model.Classes;
import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private  int userId;
    @Column(name="name")
    private String name;
    @Column(name="email",unique = true,nullable = false)
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private boolean role;

    public User() {
    }
    public User(String name, String email, String password, boolean role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Override

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", role=" + role +
                '}';
    }

}
