package speedDeliveryTimeClient.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import speedDeliveryTimeClient.MainScreen;
import speedDeliveryTimeClient.utils.ConstantsSDT_client;
import speedDeliveryTimeClient.utils.ScrollPaneLine;

public class ManagerSessionView extends UserSessionView {

	private volatile static ManagerSessionView _sharedInstance = null; 
	private JPanel panneOrder = new JPanel();
	protected ManagerSessionView(){
		
		
	}
	
	public static ManagerSessionView get_sharedInstance() {
		
		if(_sharedInstance == null)
			
			_sharedInstance = (ManagerSessionView) UserSessionView
				.createSharedInstancFor(ConstantsSDT_client.VIEW_SESSION_MANAGER);
		
		return _sharedInstance;
	}
	

	protected void buildCompoenents(){
		
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
	
	public void refreshComponent(String name){
		
		JComponent c = getComponent(name);
		c.invalidate();
		c.validate();
		c.repaint();
		
	}
	
	public void updateListOrder(String content, int nbCommande){
		
		ScrollPaneLine line =  new ScrollPaneLine(content, nbCommande);
		panneOrder.add(line);
		((JScrollPane) ManagerSessionView.get_sharedInstance().getComponent(ConstantsSDT_client.MANAGER_COMPONENT_LIST_ORDER)).setViewportView(panneOrder);
		
	}
	
	public void buildInitialView(){

		buildCompoenents();
		JScrollPane listView = (JScrollPane) getComponent(ConstantsSDT_client.MANAGER_COMPONENT_LIST_ORDER);
		if(listView != null)
			MainScreen.get_sharedInstance().putUserView(listView);

	}
	
	private void buildListOrderView(){
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(ConstantsSDT_client.SCREEN_WIDTH,ConstantsSDT_client.SCREEN_HEIGHT));
		panel.setBackground(Color.GREEN);
		
		JScrollPane mainPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.setPreferredSize(new Dimension(ConstantsSDT_client.SCREEN_WIDTH-MainScreen.get_sharedInstance().get_floatLeftPanelWidth(),
				ConstantsSDT_client.SCREEN_HEIGHT-MainScreen.get_sharedInstance().get_floatLeftPanelHeight()));
		mainPanel.setBackground(Color.black);
		
		GridLayout layout = new GridLayout(100,1);
		layout.setVgap(30);
		panneOrder.setLayout(layout);
		panneOrder.setSize(ConstantsSDT_client.SCREEN_WIDTH, ConstantsSDT_client.SCREEN_HEIGHT);
		
		
		synchronized (_panels) {
			
			_panels.put(ConstantsSDT_client.MANAGER_COMPONENT_LIST_ORDER, mainPanel);
			_panels.put(ConstantsSDT_client.MANAGER_COMPONENT_PANEL_LIST, panel);	
		}
		
	}
	
	

}
