package speedDeliveryTimeClient.views;

import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public class LivreurSessionView extends UserSessionView {

	private static LivreurSessionView _sharedInstance = null; 
	protected LivreurSessionView(){
		
		
	}
	
	public static LivreurSessionView get_sharedInstance() {
		
		if(_sharedInstance == null)
			
			_sharedInstance = (LivreurSessionView) UserSessionView
				.createSharedInstancFor(ConstantsSDT_client.VIEW_SESSION_LIVREUR);
		
		return _sharedInstance;
	}
	
	@Override
	protected void buildCompoenents() {
		
		
	}

}
