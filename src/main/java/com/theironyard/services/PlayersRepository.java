package com.theironyard.services;

import com.theironyard.entities.Players;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MattBrown on 11/12/15.
 */
public interface PlayersRepository extends CrudRepository<Players, Integer> {
}
