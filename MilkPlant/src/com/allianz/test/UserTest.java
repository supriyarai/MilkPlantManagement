/**
 * 
 */
package com.allianz.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.allianz.dto.UserDto;
import com.allianz.serviceImplementation.UserServiceImp;
import com.allianz.serviceInterface.UserServiceInterface;

/**
 * @author User
 *
 */
public class UserTest {

	UserServiceInterface userServe= new UserServiceImp();
	@Test
	public void addUserTest() {
	
	UserDto userDto=new UserDto("sunita", "sunita", "customer", "bangalore", 8764984);
	UserDto actualRes=userServe.addUser(userDto);
	String expectedOp ="sunita";
	assertEquals(expectedOp, actualRes.getUserName());
	}

	@Test
	public void getUserByIdTest()
	{
		UserDto res=userServe.getUserById(200);
		String actualResultName=res.getUserName();
		String expectedName="krishna";
		assertEquals(expectedName, actualResultName);
	}
}
