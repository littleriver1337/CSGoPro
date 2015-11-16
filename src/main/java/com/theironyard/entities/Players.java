package com.theironyard.entities;
import com.theironyard.entities.User;

import javax.persistence.*;
/**
 * Created by MattBrown on 11/12/15.
 */
@Entity
public class Players {
    @Id
    @GeneratedValue
    Integer id;
    public String teamName;
    public String playerName;
    public Integer totalKills;
    public Double headShots;
    public Integer deaths;
    public Double killDeath;
    public Integer mapsPlayed;
    public Integer roundsPlayed;
    public Double avgKillsPerRnd;
    public Double avgAssistsPerRnd;
    public Double avgDeathsPerRnd;
    public Double rating;
    @ManyToOne
    public User user;

}
