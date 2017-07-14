package speedDeliveryTimeClient.Modeles;

import java.awt.GridBagConstraints;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import speedDeliveryTimeClient.utils.ConstantsSDT_client;
import speedDeliveryTimeClient.views.ManagerSessionView;

public class ManagerSessionModel extends UserSessionModel {

	private static ManagerSessionModel _sharedInstance = null; 

	AtomicBoolean _isStart = new AtomicBoolean(false);
	AtomicInteger _nbCommande = new AtomicInteger(-1);
	
	volatile GridBagConstraints gbc = new GridBagConstraints();

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
			ManagerSessionView.get_sharedInstance().buildInitialView();

		}
	}


	public void addOrderToList(String content){
		
		_nbCommande.set(_nbCommande.incrementAndGet());
		ManagerSessionView.get_sharedInstance().updateListOrder(content, _nbCommande.get());
		
	}

}
