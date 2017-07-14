package speedDeliveryTimeClient.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import speedDeliveryTimeClient.MainScreen;
import speedDeliveryTimeClient.utils.ConstantsSDT_client;

public class ManagerSessionView extends UserSessionView {

	private volatile static ManagerSessionView _sharedInstance = null; 
	protected ManagerSessionView(){
		
		
	}
	
	public static ManagerSessionView get_sharedInstance() {
		
		if(_sharedInstance == null)
			
			_sharedInstance = (ManagerSessionView) UserSessionView
				.createSharedInstancFor(ConstantsSDT_client.VIEW_SESSION_MANAGER);
		
		return _sharedInstance;
	}
	

	public void buildCompoenents(){
		
		buildListOrderView();
		
	}
	
	public JComponent getComponent(String name){
		
		synchronized (_panels) {
			if(_panels.containsKey(name)){
				
				return _panels.get(name);
				
			}
			return null;
		}
		
	}
	
	private void buildListOrderView(){
		
		JScrollPane mainPanel = new JScrollPane();
		mainPanel.setPreferredSize(new Dimension(ConstantsSDT_client.SCREEN_WIDTH-MainScreen.get_sharedInstance().get_floatLeftPanelWidth(),
				ConstantsSDT_client.SCREEN_HEIGHT-MainScreen.get_sharedInstance().get_floatLeftPanelHeight()));
		mainPanel.setBackground(Color.black);
		synchronized (_panels) {
			
			_panels.put(ConstantsSDT_client.MANAGER_COMPONENT_LIST_ORDER, mainPanel);
		}
		
	}

}
