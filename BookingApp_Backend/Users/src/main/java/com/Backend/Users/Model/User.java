package com.Backend.Users.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @Column(name="Name", length=50)
    
    private String Name;

    @Column(name="Surname", length=50)
    
    private String Surname;

    @Column(name="Age")
    
    private int Age;

    @Column(name="Nationality", length=30)
    
    private String Nationality;

    @Column(name="DNI", length=10)
    
    private String DNI;
    
    
}
