package speedDeliveryTimeClient.Modeles;

import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public class CuisinierSessionModel extends UserSessionModel{
	
	private static CuisinierSessionModel _sharedInstance = null; 
	protected CuisinierSessionModel(){
		
		
	}
	
	public static CuisinierSessionModel get_sharedInstance() {
		
		if(_sharedInstance == null)
			
			_sharedInstance = (CuisinierSessionModel) UserSessionModel
				.createSharedInstancFor(ConstantsSDT_client.MODEL_SESSION_CUISINIER);
		
		return _sharedInstance;
	}
	
}


