package com.demo.tasktracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


// @SpringBootTest annotation tells Spring Boot to look for 
// a main configuration class (one with @SpringBootApplication, for instance) 
// and use that to start a Spring application context
@SpringBootTest
class TaskTrackerApiH2ApplicationTests {

	//simple sanity check test that will fail if the application context cannot start.
	@Test
	void contextLoads() {
	}

}
