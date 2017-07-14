package speedDeliveryTimeClient.controlleur;


import java.net.DatagramSocket;

import javax.naming.NamingException;
import speedDeliveryTimeApi.beans.interfaces.IOrderManager_bean;
import speedDeliveryTimeClient.utils.BeanAccess;
import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public abstract class UserSessionController {

	private   static IOrderManager_bean _orderManager;
	protected DatagramSocket _sock;
	protected volatile byte[] receiveData = new byte[1024];
	protected volatile byte[] sendData = new byte[1024];
	protected static UserSessionController createSharedInstancFor(String type){

		System.out.println("Initialize a user is start");
		if(type.equals(ConstantsSDT_client.CONTROLLER_SESSION_MANAGER)) return new ManagerSessionControlleur(); 

		else if (type.equals(ConstantsSDT_client.CONTROLLER_SESSION_CUISINIER)) return new CuisinierSessionController();

		else if (type.equals(ConstantsSDT_client.CONTROLLER_SESSION_LIVREUR)) return new LivreurSessionController();

		return null;
	}


	public static void initializeOrderManagerContext() throws NamingException{

		System.out.println("context is initialzing");
		_orderManager =  BeanAccess.createOrderManager();
		System.out.println("initialzing is ended");

	}


	public static IOrderManager_bean get_orderManager() {
		return _orderManager;
	}




}
