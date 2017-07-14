package speedDeliveryTimeClient.Modeles;

import speedDeliveryTimeClient.utils.ConstantsSDT_client;


public abstract class UserSessionModel {
	
	
protected static UserSessionModel createSharedInstancFor(String type){
		
		if(type.equals(ConstantsSDT_client.MODEL_SESSION_MANAGER)) return new ManagerSessionModel(); 
			
		else if (type.equals(ConstantsSDT_client.MODEL_SESSION_CUISINIER)) return new CuisinierSessionModel();
			
		else if (type.equals(ConstantsSDT_client.MODEL_SESSION_LIVREUR)) return new LivreurSessionModel();

		return null;
	}

}
