package speedDeliveryTimeClient.utils;

import java.awt.Toolkit;

public class ConstantsSDT_client {

	public static String SERVER_BEAN_IP_ADDRESS = "192.168.0.15";
	public static String SERVER_BEAN_PORT = "3700";
	
	public static int ENTITY_TYPE_MANAGER = 0;
	public static int ENTITY_TYPE_LIVREUR = 1;
	public static int ENTITY_TYPE_CUISINIER = 2;
	
	public static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int HEADER_BUTTON_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width /4;
	public static int HEADER_BUTTON_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height /8;
	public static int HEADER_MIDDLE_PAN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width /2;
	public static int HEADER_MIDDLE_PAN_HEIGHT= Toolkit.getDefaultToolkit().getScreenSize().height /8;
	
	
	public static final String CONTROLLER_SESSION_MANAGER = "controllerSessionManager";
	public static final String CONTROLLER_SESSION_CUISINIER = "controllerSessionCuisinier";
	public static final String CONTROLLER_SESSION_LIVREUR = "controllerSessionLivreur";
	
	public static final String VIEW_SESSION_MANAGER = "viewSessionManager";
	public static final String VIEW_SESSION_CUISINIER = "viewSessionCuisinier";
	public static final String VIEW_SESSION_LIVREUR = "viewSessionLivreur";
	
	public static final String MODEL_SESSION_MANAGER = "modelSessionManager";
	public static final String MODEL_SESSION_CUISINIER = "modelSessionCuisinier";
	public static final String MODEL_SESSION_LIVREUR = "modelSessionLivreur";
	
	public static final String BUTTON_SETTING = "Settings";
	public static final String BUTTON_LOGIN = "Connexion";
	public static final String BUTTON_INSCRIPTION = "Inscription";
	public static final String BUTTON_PROFILE = "Profile";
	public static final String BUTTON_ALERT = "ALERT";
	public static final String BUTTON_CALL = "CALL";
	public static final String BUTTON_PLANNIFICATION = "Planifier";
	public static final String BUTTON_STATISTIQUE = "Statistique";
	public static final String BUTTON_CREATION = "creer";
	public static final String BUTTON_MODIFICATION = "Modifier";
	public static final String BUTTON_VISUALISER_COMMANDE= "visuliserCommnade";
	public static final String BUTTON_VISUALISER_LIVREUR = "visuliserLivreur";
	
	
	public static final String MANAGER_COMPONENT_LIST_ORDER ="listOrderPanel" ;
	

}
