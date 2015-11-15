package com.theironyard;
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
    String username;
    String password;

    @OneToMany(mappedBy = "user")
    List <Players> player;
}
