package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	DistilleryRepository distilleryRepository;

	@Autowired
	WhiskyRepository whiskyRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(6, foundWhisky.size());
		assertEquals("The Glendronach Revival", foundWhisky.get(0).getName());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> foundDistillery= distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals(3,foundDistillery.size());
	}

	@Test
	public void canFindWhiskyInDistilleryByAge(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyInDistilleryByAge(15);
		assertTrue("Greater than 0",foundWhisky.size() >0);
		assertEquals("The Glendronach Revival", foundWhisky.get(0).getName());
	}

}
