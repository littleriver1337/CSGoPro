package com.theironyard.entities;

import javax.persistence.*;
import java.util.List;


/**
 * Created by MattBrown on 11/12/15.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    Integer id;
    public String username;
    public String password;

    @OneToMany(mappedBy = "user")
    public List <Players> player;
}
