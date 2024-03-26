package com.example.usersmanagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "must be not empty")
//    @Min(value = 4)
    @Column(columnDefinition = "varchar(10) check(length(name)>4)")
    private String name;
    @NotEmpty(message = "username must be not empty")
    @Size(min = 4,message = "user name must be mor then 5")
    @Column(columnDefinition ="varchar(15) UNIQUE ")
    private String  username;
    @NotEmpty
    @Column(columnDefinition ="varchar(20) check(length(password)>6) not null")
    private String password;
    @Email(message ="must be valid email ")
    @Column(columnDefinition =" varchar(50) UNIQUE not null")
    private String email;
    @NotEmpty(message = "role must be not null")
    @Pattern(regexp ="^(admin|customer)$",message = "role must be admin or customer")
    @Column(columnDefinition = "varchar(10) check(role ='Admin' or role='Customer' )")
    private String role;
      @NotNull(message = "age must be not empty")
    @Column(columnDefinition = "int not null")
    private Integer age;
}
