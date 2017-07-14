package speedDeliveryTimeClient.controlleur;

import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public class LivreurSessionController extends UserSessionController{
	
	private LivreurSessionController _sharedInstance = null; 
	
	protected LivreurSessionController() {
		
	}

	public LivreurSessionController get_sharedInstance() {
		
		if(_sharedInstance == null)
			
			_sharedInstance = (LivreurSessionController) UserSessionController
				.createSharedInstancFor(ConstantsSDT_client.CONTROLLER_SESSION_LIVREUR);
		
		return _sharedInstance;
	}
}
