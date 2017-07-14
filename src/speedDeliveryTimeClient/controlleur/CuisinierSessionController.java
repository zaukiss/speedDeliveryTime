package speedDeliveryTimeClient.controlleur;

import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public class CuisinierSessionController extends UserSessionController {
	
	private  CuisinierSessionController _sharedInstance = null; 
	protected CuisinierSessionController(){
		
		
	}
	
	public CuisinierSessionController get_sharedInstance() {
		
		if(_sharedInstance == null)
			_sharedInstance = (CuisinierSessionController) UserSessionController
				.createSharedInstancFor(ConstantsSDT_client.CONTROLLER_SESSION_CUISINIER);
		
		return _sharedInstance;
	}

}
