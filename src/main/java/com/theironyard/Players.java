package com.theironyard;
import javax.persistence.*;
/**
 * Created by MattBrown on 11/12/15.
 */
@Entity
public class Players {
    @Id
    @GeneratedValue
    Integer id;
    String teamName;
    String playerName;
    String totalKills;
    String headShots;
    String deaths;
    String killDeath;
    String mapsPlayed;
    String roundsPlayed;
    String avgKillsPerRnd;
    String avgAssistsPerRnd;
    String avgDeathsPerRnd;
    String rating;
    @ManyToOne
    User user;

}
