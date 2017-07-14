package speedDeliveryTimeClient.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import speedDeliveryTimeClient.controlleur.UserSessionController;
import speedDeliveryTimeClient.utils.ButtonListener;
import speedDeliveryTimeClient.utils.ConstantsSDT_client;
import speedDeliveryTimeClient.utils.UserEntities;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JTextField _loginField;
	private JPasswordField _passWordField;
	private JLabel _loginLabel,_passwordLabel;
	private JLabel _title;
	private JButton _connex;
	private JButton _regis;
	private ButtonListener _but_eventListener =  new ButtonListener();
	private static LoginView _sharedInstance = null;
	private  AtomicBoolean _isServerOk =  new AtomicBoolean();
	
	private LoginView(){
		
		_isServerOk.set(false); 
		new Thread(new Runnable() {

			public void run() {
					
				try {
					
					//just for demonstration of first delivery
					UserSessionController.initializeOrderManagerContext();
					UserEntities.initializeUserBeanContext();
					_isServerOk.set(true); 
					
				} catch (NamingException e) {
					
					e.printStackTrace();
				};
				
			}
		}).start();
			
		
	}
	
	
	public boolean isServerOk() {
		return _isServerOk.get();
	}


	public static LoginView  getSharedInstance() {
		
		if(_sharedInstance == null)_sharedInstance = new LoginView();
		return _sharedInstance;	
	}
	
	public String getLoginText(){
		return _loginField.getText();
		
	}
	
	public char[] getPasswordText(){
		return _passWordField.getPassword();
		
	}
	
	public void BuildLoginViewAnDisplay(){
		
		this.setTitle("Loggin");
		this.getContentPane().setBackground(new Color(112,128,144));
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		_title = new JLabel("Speed Delivery Time",JLabel.CENTER );
		_title.setFont(new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 32));
		_title.setForeground(new Color(192,192,192));
		_title.setPreferredSize(new Dimension(500, 50));
		
		_loginLabel = new JLabel("Login       : ");
		_passwordLabel = new JLabel("Password : ");
		
		_loginLabel.setFont(new Font("Comic Sans MS", Font.BOLD , 12));
		_passwordLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		_loginLabel.setForeground(new Color(192,192,192));
		_passwordLabel.setForeground(new Color(192,192,192));
		
		_loginLabel.setPreferredSize(new Dimension(75, 15));
		_passwordLabel.setPreferredSize(new Dimension(75, 15));
		
		_loginField = new JTextField();
		_passWordField = new JPasswordField();
		
		_loginField.setPreferredSize(new Dimension(425, 25));
		_passWordField.setPreferredSize(new Dimension(425, 25));
		
		_connex = new JButton("Connexion");
		_regis = new JButton("s'enregistrer");
		_connex.setActionCommand(ConstantsSDT_client.BUTTON_LOGIN);
		_regis.setActionCommand(ConstantsSDT_client.BUTTON_INSCRIPTION);
		
		_connex.setForeground(new Color(25,25,112));
		_regis.setForeground(new Color(25,25,112));
		
		
		_connex.addActionListener(_but_eventListener);
		_regis.addActionListener(_but_eventListener);
		
		_connex.setPreferredSize(new Dimension(160, 45));
		_regis.setPreferredSize(new Dimension(160, 45));
		
	    GridBagLayout gridLayout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    this.getContentPane().setLayout(gridLayout);
	    
	    gbc.insets = new Insets (0,0,0,0);
	    gbc.fill = GridBagConstraints.NONE;
	    
	    gbc.weighty = 1;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = _title.getWidth();
	    this.getContentPane().add(_title,gbc);
	    
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = _loginLabel.getWidth();
	    this.getContentPane().add(_loginLabel, gbc);
	    
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gbc.gridwidth = _loginField.getWidth();
	    this.getContentPane().add(_loginField, gbc);

	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = _passwordLabel.getWidth();
	    this.getContentPane().add(_passwordLabel, gbc);
	    
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.gridwidth = _passWordField.getWidth();
	    this.getContentPane().add(_passWordField, gbc);
	    
	    gbc.ipadx = 0;
	    gbc.ipady = 0;
	    gbc.anchor = GridBagConstraints.EAST;
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.gridwidth = _connex.getWidth();
	    gbc.gridheight = _connex.getHeight();
	    this.getContentPane().add(_connex, gbc);
	    
	    gbc.anchor = GridBagConstraints.ABOVE_BASELINE;
	    gbc.gridx = 1;
	    gbc.gridy = 3;

	    gbc.gridwidth = _regis.getWidth();
	    gbc.gridheight = _regis.getHeight();
	    
	    this.getContentPane().add(_regis, gbc);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	public void disapear(){
		
		this.setVisible(false);
	}

	

}
