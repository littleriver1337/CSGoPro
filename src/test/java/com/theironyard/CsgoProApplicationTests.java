package com.theironyard;

import com.theironyard.services.PlayersRepository;
import com.theironyard.services.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CsgoProApplication.class)
@WebAppConfiguration
public class CsgoProApplicationTests {

	@Autowired
	UserRepository users;

	@Autowired
	PlayersRepository players;

	@Autowired
	WebApplicationContext wap;

	MockMvc mockMvc;

	@Before
	public void before(){
		users.deleteAll();
		players.deleteAll();
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}
	@Test
	public void testLogin() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/login")
				.param("username", "testUser")
				.param("password", "password")
		);
		assertTrue(users.count() == 1);
	}
	@Test
	public void testCreatePlayers() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/create-player")
				.param("teamName", "Matt")
				.param("playerName", "Matt")
				.param("totalKills", "1234")
				.param("headShots", "1234")
				.param("deaths", "435")
				.param("killDeath", "4234234")
				.param("mapsPlayed", "2323423")
				.param("roundsPlayed", "23423423")
				.param("avgKillsPerRnd", "1")
				.param("avgAssistsPerRnd", "1")
				.param("avgDeathsPerRnd", "1")
				.param("rating", "1.2")
				.sessionAttr("username", "testUser")
		);
		assertTrue(players.count() == 1);
	}
	@Test
	public void testEditPlayer(){

	}
	@Test
	public void testDeletePlayer(){

	}
}
