package com.example.Spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.example.Spring.domain.User;
import com.example.Spring.domain.UserRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
		String formattedDate = dateFormat.format(date);
		
		/*userRepository.save(new User("aa@126.com", "aa1", "aa", "aa123456",formattedDate));
		userRepository.save(new User("bb@126.com", "bb2", "bb", "bb123456",formattedDate));
		userRepository.save(new User("cc@126.com", "cc3", "cc", "cc123456",formattedDate));*/

		Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("aa123456", "cc@126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa123456"));
	}

}
