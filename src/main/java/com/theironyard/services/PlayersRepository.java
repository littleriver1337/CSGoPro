package com.theironyard.services;
import org.springframework.data.domain.Page;
import com.theironyard.entities.Players;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by MattBrown on 11/12/15.
 */
public interface PlayersRepository extends PagingAndSortingRepository<Players, Integer> {
    Page findByTeamName(PageRequest pageable, String teamName);
}
