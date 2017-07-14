package speedDeliveryTimeClient.views;

import java.util.Hashtable;

import javax.swing.JComponent;

import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public abstract class UserSessionView {
	
	protected Hashtable<String, JComponent> _panels =  new Hashtable<>();
	
	protected static UserSessionView createSharedInstancFor(String type){
		
		if(type.equals(ConstantsSDT_client.VIEW_SESSION_MANAGER)) return new ManagerSessionView(); 
			
		else if (type.equals(ConstantsSDT_client.VIEW_SESSION_CUISINIER)) return new CuisinierSessionView();
			
		else if (type.equals(ConstantsSDT_client.VIEW_SESSION_LIVREUR)) return new LivreurSessionView();

		return null;
	}
	abstract protected void buildCompoenents();
}
