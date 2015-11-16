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
    Integer totalKills;
    Double headShots;
    Integer deaths;
    Double killDeath;
    Integer mapsPlayed;
    Integer roundsPlayed;
    Double avgKillsPerRnd;
    Double avgAssistsPerRnd;
    Double avgDeathsPerRnd;
    Double rating;
    @ManyToOne
    User user;

}
