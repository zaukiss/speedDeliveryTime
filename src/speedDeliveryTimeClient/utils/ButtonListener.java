package speedDeliveryTimeClient.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import speedDeliveryTimeApi.exeption.ConnectionException;
import speedDeliveryTimeClient.MainScreen;
import speedDeliveryTimeClient.controlleur.ManagerSessionControlleur;
import speedDeliveryTimeClient.views.LoginView;

public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("but : "+e.getActionCommand());

		switch (e.getActionCommand()) {
		
		case ConstantsSDT_client.BUTTON_INSCRIPTION:
			System.out.println("je m'enregistre...");
			break;

		case ConstantsSDT_client.BUTTON_LOGIN:
			new Thread( new Runnable() {
				
				@Override
				public void run() {
					while(!LoginView.getSharedInstance().isServerOk()){
						
						try {
							Thread.sleep(1000);
							System.out.println("wait for server...");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
			
					try {
						if(UserEntities.get_userBean().connect(LoginView.getSharedInstance().getLoginText(), LoginView.getSharedInstance().getPasswordText())){
							
							//just for demonstration of first delivery
							LoginView.getSharedInstance().disapear();
							MainScreen.get_sharedInstance().makeViewAppearFor(ConstantsSDT_client.VIEW_SESSION_MANAGER);
							ManagerSessionControlleur.get_sharedInstance().startController();
							
						}
					} catch (ConnectionException e) {
						e.printStackTrace();
					}
					
				}
			}).start();;
			
			break;
			
		case ConstantsSDT_client.BUTTON_ALERT:
			
			break;
			
		case ConstantsSDT_client.BUTTON_CALL:
			
			break;
			
		case ConstantsSDT_client.BUTTON_CREATION:
			
			break;
			
		case ConstantsSDT_client.BUTTON_MODIFICATION:
			
			break;
			
		case ConstantsSDT_client.BUTTON_PLANNIFICATION:
			
			break;
			
		case ConstantsSDT_client.BUTTON_PROFILE:
			
			break;
			
		case ConstantsSDT_client.BUTTON_SETTING:
			
			break;
		case ConstantsSDT_client.BUTTON_STATISTIQUE:
			
			break;
			
		case ConstantsSDT_client.BUTTON_VISUALISER_COMMANDE:
			
			break;
			
		case ConstantsSDT_client.BUTTON_VISUALISER_LIVREUR:
			
			break;

		}

	}
}
