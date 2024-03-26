package com.example.usersmanagement.Service;

import com.example.usersmanagement.ApiResponse.ApiExcption;
import com.example.usersmanagement.Model.User;
import com.example.usersmanagement.Repositry.UserRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepositry userRepositry;

    public void add(User user){
        userRepositry.save(user);
    }

    public List get(){
        return userRepositry.findAll();
    }

    public void update(int id , User user){
         User user1=userRepositry.findUserById(id);
         if(user1==null){
         throw new ApiExcption("id not found");
         }

         user1.setName(user.getName());
         user1.setAge(user.getAge());
         user1.setEmail(user.getEmail());
         user1.setRole(user.getRole());
         user1.setPassword(user.getPassword());
         user1.setUsername(user.getUsername());

         userRepositry.save(user1);
    }


    public void delete(int id){
        User user= userRepositry.findUserById(id);
        if(user==null){
            throw new ApiExcption("id not found");
        }
        userRepositry.delete(user);
    }

    public User check(String username, String password){
     User user= userRepositry.check(username,password);
        if(user==null){
            throw new ApiExcption(("not correct"));
        }
     return user;
    }

    public User byEmail(String email){
        User user= userRepositry.findUserByEmail(email);
        if(user==null){
            throw new ApiExcption(("not found"));
        }
        return user;
    }

    public List<User> byRole(String role){
        List<User>users=userRepositry.findUserByRole(role);
        if(users.isEmpty()){
            throw new ApiExcption("not found");
        }
        return users;
    }

    public List<User>byAge(int age){
        List<User>userList=userRepositry.searchByage(age);
        if(userList.isEmpty()){
            throw new ApiExcption("not found");
        }
        return userList;
    }



}
