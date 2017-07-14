package speedDeliveryTimeClient.utils;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import speedDeliveryTimeApi.beans.interfaces.IOrderManager_bean;
import speedDeliveryTimeApi.beans.interfaces.IUserBean;

public abstract class BeanAccess {

	public static IOrderManager_bean createOrderManager() throws NamingException{

		Properties env = new Properties();
		env.setProperty("org.omg.CORBA.ORBInitialHost", ConstantsSDT_client.SERVER_BEAN_IP_ADDRESS);
		env.setProperty("org.omg.CORBA.ORBInitialPort", ConstantsSDT_client.SERVER_BEAN_PORT);
		InitialContext ctx = new InitialContext(env);
		return (IOrderManager_bean) ctx.lookup("ejb/order_bean_resources");

	}

	public static IUserBean createUserBean() throws NamingException{

		Properties env = new Properties();
		env.setProperty("org.omg.CORBA.ORBInitialHost", ConstantsSDT_client.SERVER_BEAN_IP_ADDRESS);
		env.setProperty("org.omg.CORBA.ORBInitialPort", ConstantsSDT_client.SERVER_BEAN_PORT);
		InitialContext ctx = new InitialContext(env);
		return (IUserBean) ctx.lookup("ejb/user_bean_resources");

	}

}
