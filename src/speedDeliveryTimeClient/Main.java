package speedDeliveryTimeClient;

import javax.swing.SwingUtilities;

import speedDeliveryTimeClient.views.LoginView;

public class Main {

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				LoginView.getSharedInstance().BuildLoginViewAnDisplay();
				
			}
		});
			
	}

}
