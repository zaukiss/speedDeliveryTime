package speedDeliveryTimeClient.Modeles;

import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public class LivreurSessionModel extends UserSessionModel {
	
	private static LivreurSessionModel _sharedInstance = null; 
	protected LivreurSessionModel(){
		
		
	}
	
	public static LivreurSessionModel get_sharedInstance() {
		
		if(_sharedInstance == null)
			
			_sharedInstance = (LivreurSessionModel) UserSessionModel
				.createSharedInstancFor(ConstantsSDT_client.MODEL_SESSION_LIVREUR);
		
		return _sharedInstance;
	}

}
