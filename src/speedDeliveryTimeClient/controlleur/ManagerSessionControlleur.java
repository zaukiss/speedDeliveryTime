package speedDeliveryTimeClient.controlleur;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import speedDeliveryTimeApi.beans.utils.WrongListenerException;
import speedDeliveryTimeClient.Modeles.ManagerSessionModel;
import speedDeliveryTimeClient.utils.ConstantsSDT_client;
import speedDeliveryTimeClient.utils.NetworkUtils;

public class ManagerSessionControlleur extends UserSessionController {


	private static volatile ManagerSessionControlleur _sharedInstance = null; 
	private DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	
	protected ManagerSessionControlleur(){}
	
	public static ManagerSessionControlleur get_sharedInstance() {

		if(_sharedInstance == null)

			_sharedInstance = (ManagerSessionControlleur) UserSessionController
			.createSharedInstancFor(ConstantsSDT_client.CONTROLLER_SESSION_MANAGER);

		return _sharedInstance;
	}

	public void startController(){

		try {

			_sock = new DatagramSocket(0,NetworkUtils.getLocalHostLANAddress());
			System.out.println("local port : "+_sock.getLocalPort() + " local address : "+ NetworkUtils.getLocalHostLANAddress());
			get_orderManager().addRemoteListener(_sock.getLocalPort(), NetworkUtils.getLocalHostLANAddress());
			get_orderManager().startListenOrder();
			this.waitForOrder();
			System.out.println("Manager lister is ready...");
			ManagerSessionModel.get_sharedInstance().start();
			
		} catch (UnknownHostException | SocketException | WrongListenerException e) {

			e.printStackTrace();
		}

	}

	private void waitForOrder(){

		new Thread(new Runnable() {
			public void run() {
				while(true){
					System.out.println("wait for new order...");
					try {
						_sock.receive(receivePacket);
						System.out.println("recieve : "+new String(receivePacket.getData()));
						ManagerSessionModel.get_sharedInstance().addOrderToList(new String(receivePacket.getData()));
						
					} catch (IOException e) {
						
						e.printStackTrace();
						_sock.close();
					}
				}
			}
		}).start();

	}

}
