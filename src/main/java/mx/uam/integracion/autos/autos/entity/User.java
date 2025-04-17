package mx.uam.integracion.autos.autos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "users")

public class User {
    @Id
    private String id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String user;

    public User(String id, String name, String lastName, String user) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
