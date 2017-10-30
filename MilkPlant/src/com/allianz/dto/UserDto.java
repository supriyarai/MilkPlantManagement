package com.allianz.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author User
 *Data members of UserDto are given
 */
@XmlRootElement
public class UserDto{
	
	public static final String TABLENAME="user";
	public static final String USERID="UserId";
	public static final String USERNAME="UserName";
	public static final String USERPASSWORD="UserPassword";
	public static final String USERTYPE="UserType";
	public static final String USERADDRESS="UserAddress";
	public static final String USERMOBILE="UserMobile";
	/**
	 * id of the user
	 */
	private int userId;
	/**
	 * name of the user
	 */
	private String userName;
	/**
	 * password of the user
	 */
	private String userPassword;
	/**
	 * type of the user like clerk,admin,customer
	 */
	private String userType;
	/**
	 * Address of the user
	 */
	private String userAddress;
	/**
	 * mobile no of user
	 */
	private int userMobile;

	/**
	 * default constructor
	 */
	public UserDto() {
		super();
	}
	/**
	 * Parameterized constructor
	 * @param userId
	 * @param userName*/
	/**
	 * @param userPassword
	 * @param userType
	 * @param userAddress
	 * @param userMobile
	 */
	public UserDto(int userId, String userName, String userPassword,
			String userType, String userAddress, int userMobile) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
	}
	
	public UserDto(String userName, String userPassword, String userType,
			String userAddress, int userMobile) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
	}
	/**
	 * setters and getters
	 * @return respective attribute values
	 */
	/**
	 * 
	 * @return id of the user
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * setting the id for an user
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * 
	 * @return name of the user
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * setting name of the user
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 * @return password of the user
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * setting the password of an user
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * 
	 * @return type of the user like clerk,customer
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * setting the type of the user like clerk,admin,customer
	 * @param userType
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * 
	 * @return address of the user
	 */
	public String getUserAddress() {
		return userAddress;
	}
	/**
	 * setting the address of the user
	 * @param userAddress
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	/**
	 * 
	 * @return mobile no of user
	 */
	public int getUserMobile() {
		return userMobile;
	}
	/**
	 * setting the mobile no of user
	 * @param userMobile
	 */
	public void setUserMobile(int userMobile) {
		this.userMobile = userMobile;
	}
	/**
	 * toString representation of the attributes
	 */
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userType=" + userType
				+ ", userAddress=" + userAddress + ", userMobile=" + userMobile
				+ "]";
	}


}
