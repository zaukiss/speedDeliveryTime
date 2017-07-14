package speedDeliveryTimeClient.Modeles;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JScrollPane;

import speedDeliveryTimeClient.MainScreen;
import speedDeliveryTimeClient.utils.ConstantsSDT_client;
import speedDeliveryTimeClient.views.ManagerSessionView;

public class ManagerSessionModel extends UserSessionModel {

	private static ManagerSessionModel _sharedInstance = null; 
	AtomicBoolean _isStart = new AtomicBoolean(false);
	AtomicInteger _nbCommande = new AtomicInteger(0);
	
	protected ManagerSessionModel(){}
	
	public static ManagerSessionModel get_sharedInstance() {
		
		if(_sharedInstance == null)
			
			_sharedInstance = (ManagerSessionModel) UserSessionModel
				.createSharedInstancFor(ConstantsSDT_client.MODEL_SESSION_MANAGER);
		
		return _sharedInstance;
	}
	
	public void start(){
		
		if(!_isStart.get()){
			
			_isStart.set(true);
			//just for demonstration of first delivery
			buildInitialView();
			
		}
	}
	
	private void buildInitialView(){
		
		ManagerSessionView.get_sharedInstance().buildCompoenents();
		JScrollPane listView = (JScrollPane) ManagerSessionView.get_sharedInstance().getComponent(ConstantsSDT_client.MANAGER_COMPONENT_LIST_ORDER);
		if(listView != null)
		MainScreen.get_sharedInstance().putUserView(listView);
		
	}
	
}
