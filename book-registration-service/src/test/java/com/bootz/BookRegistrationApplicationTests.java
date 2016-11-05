package com.bootz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.registration.BookRegistrationApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookRegistrationApplication.class)
@WebAppConfiguration
public class BookRegistrationApplicationTests {

	@Test
	public void contextLoads() {
	}

}
