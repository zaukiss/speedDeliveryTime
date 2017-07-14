package speedDeliveryTimeClient.utils;

import javax.naming.NamingException;

import speedDeliveryTimeApi.beans.interfaces.IUserBean;
import speedDeliveryTimeClient.views.UserSessionView;

public abstract class UserEntities{

	private static IUserBean _userBean;
	
	protected int idUser;
	protected String login;
	protected String password;
	protected int type;
	
	protected String compagnieName;
	protected String compagnieAddress;
	protected String compagnieMail;
	protected String compagniePhone;
	protected UserSessionView _view;
	
	//clientBean clientAccess;
	
	//Getters and Setters 
	
    public static void initializeUserBeanContext() throws NamingException{
		
		System.out.println("context is initialzing bean user...");
		_userBean =  BeanAccess.createUserBean();
		System.out.println("initialzing bean user is ended");
		
	}
	
	public static IUserBean get_userBean() {
		return _userBean;
	}


	public int getIdUser() {
		return idUser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getCompagnieName() {
		return compagnieName;
	}
	public void setCompagnieName(String compagnieName) {
		this.compagnieName = compagnieName;
	}
	public String getCompagnieAddress() {
		
		return compagnieAddress;
	}
	public void setCompagnieAddress(String compagnieAddress) {
		this.compagnieAddress = compagnieAddress;
	}
	public String getCompagnieMail() {
		return compagnieMail;
	}
	public void setCompagnieMail(String compagnieMail) {
		this.compagnieMail = compagnieMail;
	}
	public String getCompagniePhone() {
		return compagniePhone;
	}
	public void setCompagniePhone(String compagniePhone) {
		this.compagniePhone = compagniePhone;
	}
	public UserSessionView get_view() {
		return _view;
	}

}
