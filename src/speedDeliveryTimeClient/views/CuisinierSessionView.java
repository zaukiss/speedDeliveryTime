package speedDeliveryTimeClient.views;


import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public class CuisinierSessionView extends UserSessionView {
	
	private static CuisinierSessionView _sharedInstance = null; 
	protected CuisinierSessionView(){
		
		
	}
	
	public static CuisinierSessionView get_sharedInstance() {
		
		if(_sharedInstance == null)
			
			_sharedInstance = (CuisinierSessionView) UserSessionView
				.createSharedInstancFor(ConstantsSDT_client.VIEW_SESSION_CUISINIER);
		
		return _sharedInstance;
	}
	
	
	@Override
	void buildCompoenents() {
		// TODO Auto-generated method stub
		
	}

}
