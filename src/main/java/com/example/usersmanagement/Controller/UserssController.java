package com.example.usersmanagement.Controller;

import com.example.usersmanagement.Model.User;
import com.example.usersmanagement.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userss")
@AllArgsConstructor
public class UserssController {

    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid User user , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        userService.add(user);

        return ResponseEntity.status(200).body("added");
    }


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(userService.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody @Valid User user,Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }

        userService.update(id,user);
        return ResponseEntity.status(20).body("updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        userService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }


    @GetMapping("/by_email/{email}")
    public User byEmail(@PathVariable String email){
        User user=userService.byEmail(email);
        return user;
    }


    @GetMapping("/by_role/{role}")
    public List<User> byRole(@PathVariable String role){
        List<User> users=userService.byRole(role);

        return users;
    }
    @GetMapping("/by_age/{age}")
    public List<User> byAge(@PathVariable Integer age){
        List<User> users=userService.byAge(age);
        return users;
    }

    @GetMapping("/check/{username}/{password}")
    public User byEmail(@PathVariable String username,@PathVariable String password){
        User user=userService.check(username,password);
        return user;
    }



}
