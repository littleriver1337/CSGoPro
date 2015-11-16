package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileReader;

/**
 * Created by MattBrown on 11/12/15.
 */
@Controller
public class CsgoProController {

    @Autowired
    UserRepository users;

    @Autowired
    PlayersRepository players;

    @PostConstruct
    public void loadData(){
        String fileContent = readFile("players.csv");
        String[] lines = fileContent.split("\r");
        if (players.count() == 0){
            for (String line : lines){
                if (line == lines[0])
                    continue;
                String columns[] = line.split(",");
                Players player = new Players();
                player.teamName = columns[0];
                player.playerName = columns[1];
                player.totalKills = Integer.valueOf(columns[2]);
                player.headShots = Double.valueOf(columns[3]);
                player.deaths = Integer.valueOf(columns[4]);
                player.killDeath = Double.valueOf(columns[5]);
                player.mapsPlayed = Integer.valueOf(columns[6]);
                player.roundsPlayed = Integer.valueOf(columns[7]);
                player.avgKillsPerRnd = Double.valueOf(columns[8]);
                player.avgAssistsPerRnd = Double.valueOf(columns[9]);
                player.avgDeathsPerRnd = Double.valueOf(columns[10]);
                player.rating = Double.valueOf(columns[11]);
                players.save(player);
            }
        }
    }
    static String readFile(String fileName) {
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/")
    public String home(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null){
            return "login";
        }
        model.addAttribute("players", players.findAll());
        return "playerpage";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) throws Exception {
        session.setAttribute("username", username);
        User user = users.findOneByUsername(username);
        if (user == null) {
            user = new User();
            user.username = username;
            user.password = PasswordHash.createHash(password);
            users.save(user);
        }
        else if(!PasswordHash.validatePassword(password, user.password)){
            throw new Exception ("Wrong Password");
        }
        return "redirect:/";
    }


    @RequestMapping("/create-player")
    public String createPlayer(HttpSession session,
                                String teamName,
                                String playerName,
                                int totalKills,
                                double headShots,
                                int deaths,
                                double killDeath,
                                int mapsPlayed,
                                int roundsPlayed,
                                double avgKillsPerRnd,
                                double avgAssistsPerRnd,
                                double avgDeathsPerRnd,
                                double rating
                                )throws Exception {
        String username = (String) session.getAttribute("username");
        if (username == null){
            throw new Exception ("Not Logged In");
        }
        User user = users.findOneByUsername(username);
        Players player = new Players();
        player.teamName = teamName;
        player.playerName = playerName;
        player.totalKills = totalKills;
        player.headShots = headShots;
        player.deaths = deaths;
        player.killDeath = killDeath;
        player.mapsPlayed = mapsPlayed;
        player.roundsPlayed = roundsPlayed;
        player.avgKillsPerRnd = avgKillsPerRnd;
        player.avgAssistsPerRnd = avgAssistsPerRnd;
        player.avgDeathsPerRnd = avgDeathsPerRnd;
        player.rating = rating;
        player.user = user;
        players.save(player);
        return "redirect:/";

    }

    @RequestMapping("/edit-player-page")
    public String editPlayerPage(Model model,
                                 HttpSession session,
                                 int id) throws Exception {
        if (session.getAttribute("username") == null){
            throw new Exception ("Not Logged In");
        }
        Players player = players.findOne(id);
        model.addAttribute("player", player);
        return "edit";
    }

    @RequestMapping("/edit-player")
    public String editPlayer(HttpSession session,
                             int id,
                             String teamName,
                             String playerName,
                             int totalKills,
                             double headShots,
                             int deaths,
                             double killDeath,
                             int mapsPlayed,
                             int roundsPlayed,
                             double avgKillsPerRnd,
                             double avgAssistsPerRnd,
                             double avgDeathsPerRnd,
                             double rating
                             )throws Exception {
        if (session.getAttribute("username") == null){
            throw new Exception ("Not Logged In");
        }
        Players player = players.findOne(id);
        player.teamName = teamName;
        player.playerName = playerName;
        player.totalKills = totalKills;
        player.headShots = headShots;
        player.deaths = deaths;
        player.killDeath = killDeath;
        player.mapsPlayed = mapsPlayed;
        player.roundsPlayed = roundsPlayed;
        player.avgKillsPerRnd = avgKillsPerRnd;
        player.avgAssistsPerRnd = avgAssistsPerRnd;
        player.avgDeathsPerRnd = avgDeathsPerRnd;
        player.rating = rating;
        players.save(player);
        return "redirect:/";
    }
    @RequestMapping("/delete-player")
    public String deletePlayer(HttpSession session,
                               int id,
                               String teamName,
                               String playerName,
                               int totalKills,
                               double headShots,
                               int deaths,
                               double killDeath,
                               int mapsPlayed,
                               int roundsPlayed,
                               double avgKillsPerRnd,
                               double avgAssistsPerRnd,
                               double avgDeathsPerRnd,
                               double rating
                               )throws Exception {
        if (session.getAttribute("username") == null){
            throw new Exception ("Not Logged In");
        }
        Players player = players.findOne(id);
        player.teamName = teamName;
        player.playerName = playerName;
        player.totalKills = totalKills;
        player.headShots = headShots;
        player.deaths = deaths;
        player.killDeath = killDeath;
        player.mapsPlayed = mapsPlayed;
        player.roundsPlayed = roundsPlayed;
        player.avgKillsPerRnd = avgKillsPerRnd;
        player.avgAssistsPerRnd = avgAssistsPerRnd;
        player.avgDeathsPerRnd = avgDeathsPerRnd;
        player.rating = rating;
        players.delete(id);
        return "redirect:/";
    }
}
