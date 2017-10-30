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


public class UserServiceImp implements UserServiceInterface{
	private static final Logger logger=Logger.getLogger(UserServiceImp.class);

	

	public UserDto getUserById(int userId) {
		// TODO Auto-generated method stub
		UserDaoInterface userDao=new UserDaoImp();
		UserDto userDetails=userDao.userDetailById(userId);
		return userDetails;
	}

	

	@Override
	public Set<String> getUserType() 
	{
		UserDaoImp userDao=new UserDaoImp();
		List<UserDto> users=	userDao.getAllUsers();

		String[] str= new String[users.size()];
		int j=0;
		String s1=null;
		String s2= " ";
		Set set= new HashSet();
		for(int i=0;i<users.size();i++)	
		{

			str[j]=users.get(i).getUserType();
			s1= str[j];
			j++;




			if(s2.indexOf(s1)==-1)
			{
				s2+=str[i] + " ";
set.add(s1);

			}
		}
		return set;
		
		
	}



	@Override
	public UserDto addUser(UserDto user)
	{
UserDaoImp userDao=new UserDaoImp();
		return userDao.addUser(user);
	}

}
