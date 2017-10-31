package com.allianz.serviceImplementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.allianz.dao.daoImplementation.ProductDao;
import com.allianz.dao.daoImplementation.UserDaoImp;
import com.allianz.dao.daoInterface.UserDaoInterface;
import com.allianz.dto.ProductDto;
import com.allianz.dto.UserDto;
import com.allianz.serviceInterface.UserServiceInterface;
import com.allianz.servlet.StockServlet;

/**
 * 
 * @author User
 *
 */
public class UserServiceImp implements UserServiceInterface{
	private static final Logger logger=Logger.getLogger(UserServiceImp.class);


	/**
	 * @param userId of int type
	 * @return UserDto
	 */
	public UserDto getUserById(int userId) {
		// TODO Auto-generated method stub
		UserDaoInterface userDao=new UserDaoImp();
		UserDto userDetails=userDao.userDetailById(userId);
		return userDetails;
	}//getUserById() ends

	/**
	 * @return Set<String>
	 */

	@Override
	public Set<String> getUserType() 
	{
		UserDaoImp userDao=new UserDaoImp();
		List<UserDto> users=	userDao.getAllUsers();

		String[] userString= new String[users.size()];
		int j=0;
		String userType=null;
		String availabletype= " ";
		Set set= new HashSet();
		for(int i=0;i<users.size();i++)	
		{

			userString[j]=users.get(i).getUserType();
			userType= userString[j];
			j++;
			if(availabletype.indexOf(userType)==-1)
			{
				availabletype+=userString[i] + " ";
				set.add(userType);

			}
		}
		return set;
	}//getUserType() ends


	/**
	 * @param user of UserDto type
	 * @return UserDto 
	 */
	@Override
	public UserDto addUser(UserDto user)
	{
		UserDaoImp userDao=new UserDaoImp();
		return userDao.addUser(user);
	}//addUser() ends

}//class ends
