package com.theironyard.entities;
import com.theironyard.entities.User;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
/**
 * Created by MattBrown on 11/12/15.
 */
@Entity
public class Players {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    int id;
    @Column(nullable = false)
    public String teamName;
    @Column(nullable = false)
    public String playerName;
    @Column(nullable = false)
    public Integer totalKills;
    @Column(nullable = false)
    public Double headShots;
    @Column(nullable = false)
    public Integer deaths;
    @Column(nullable = false)
    public Double killDeath;
    @Column(nullable = false)
    public Integer mapsPlayed;
    @Column(nullable = false)
    public Integer roundsPlayed;
    @Column(nullable = false)
    public Double avgKillsPerRnd;
    @Column(nullable = false)
    public Double avgAssistsPerRnd;
    @Column(nullable = false)
    public Double avgDeathsPerRnd;
    @Column(nullable = false)
    public Double rating;
    @ManyToOne
    public User user;

}
