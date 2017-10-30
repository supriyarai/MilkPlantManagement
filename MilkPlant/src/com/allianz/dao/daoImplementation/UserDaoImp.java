package com.allianz.dao.daoImplementation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.allianz.connection.DbConnection;
import com.allianz.dao.daoInterface.UserDaoInterface;
import com.allianz.dto.ProductDto;
import com.allianz.dto.UserDto;
import com.allianz.servlet.StockServlet;


public class UserDaoImp implements UserDaoInterface{
	private static final Logger logger=Logger.getLogger(UserDaoImp.class);

	Connection	connection=DbConnection.getConnection();
	public static String addUserQuery=
			"insert into " + UserDto.TABLENAME +"("+UserDto.USERNAME+","+UserDto.USERPASSWORD+
			","+UserDto.USERTYPE+","+UserDto.USERADDRESS+","+UserDto.USERMOBILE+")" +" values(?,?,?,?,?)";
	public static String getUserQuery="select * from "+UserDto.TABLENAME +" where " + UserDto.USERID+"=? ";
	public static String getAllUserQuery="select *from "+UserDto.TABLENAME;

	public UserDto userDetailById(int userid) {
		// TODO Auto-generated method stub
		java.sql.Connection connection=DbConnection.getConnection();
		 

		try
		{
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(getUserQuery);
			prepareStatement.setInt(1, userid);
			ResultSet resultSet=prepareStatement.executeQuery();
			if(resultSet.next())
			{
				int userId=resultSet.getInt(1);
				String userName=resultSet.getString(2);
			String	userPassword=resultSet.getString(3);
				String userType=resultSet.getString(4);
				String userAddress=resultSet.getString(5);
			int	userMobile=resultSet.getInt(6);
				UserDto	 user= new UserDto(userId, userName, userPassword, userType, userAddress, userMobile);
				return user;
			}//if ends
		}//try ends
		catch(Exception e)
		{
		}//catch ends
		return null;
	}
	
	
	
	
	
	




			
	
	
	
	public  List<UserDto> getAllUsers()//fetching the details(name,price type) of all the products produced
	{
		java.sql.Connection connection=DbConnection.getConnection();
		List<UserDto> usersList= new ArrayList<UserDto>();//for storing the details of all products
		try
		{
			java.sql.PreparedStatement prepareStatement= connection.prepareStatement(getAllUserQuery);
			ResultSet resultSet= prepareStatement.executeQuery();
			while(resultSet.next())
			{
				int id= resultSet.getInt(1);
				String name= resultSet.getString(2);
				String password= resultSet.getString(3);
				String type= resultSet.getString(4);
				String address= resultSet.getString(5);
				int phone=resultSet.getInt(6);
				UserDto user= new UserDto(id, name, password, type, address, phone);

				usersList.add(user);

			}//while ends
		}//try ends
		catch (Exception r)
		{
			//logger.error(r);
		}//catch ends
		return usersList;

	}

@Override
	public UserDto addUser(UserDto user) {
		java.sql.Connection	connection=DbConnection.getConnection();
		if(connection!=null)
			try {
				java.sql.PreparedStatement prepareStatement= connection.prepareStatement(addUserQuery);
				prepareStatement.setString(1, user.getUserName());
				prepareStatement.setString(2, user.getUserPassword());
				prepareStatement.setString(3, user.getUserType());
				prepareStatement.setString(4, user.getUserAddress());
				prepareStatement.setInt(5, user.getUserMobile());

				int result=prepareStatement.executeUpdate();
				if(result==0)
				{
					return null;
				}//if ends

			}//try ends
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//logger.error(e);
		}//catch ends
		return user;
	}

}