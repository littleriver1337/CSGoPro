package com.theironyard.services;

import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MattBrown on 11/12/15.
 */
public interface UserRepository extends CrudRepository <User, Integer> {
    User findOneByUsername(String username);
}
