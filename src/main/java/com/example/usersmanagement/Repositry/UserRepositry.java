package com.example.usersmanagement.Repositry;

import com.example.usersmanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositry extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByEmail(String email);
    List<User>findUserByRole(String role);

    @Query("select user from User user where user.age>=?1")
    List<User> searchByage(Integer age);
    @Query("select user from User user where user.username=?1 and user.password=?2")
    User check(String username , String password);


}
