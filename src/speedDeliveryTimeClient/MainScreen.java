package speedDeliveryTimeClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import speedDeliveryTimeClient.utils.ButtonListener;
import speedDeliveryTimeClient.utils.ConstantsSDT_client;
import speedDeliveryTimeClient.views.ManagerSessionView;
import speedDeliveryTimeClient.views.UserSessionView;

public class MainScreen extends JFrame {

	private JPanel _headerPanel;
	private static MainScreen _sharedInstance;
	private static final long serialVersionUID = 1L;
	private volatile UserSessionView _currentView;
	private JButton _setting;
	private JButton _notifIcon;
	private JButton _userIcon;
	private JPanel _middleHeader;
	private JPanel _floatLeftPan;
	private JPanel _iconright;
	private JButton _iconCall;
	private JButton _plannifierComIcon;
	private JButton _statistiqueIcon;
	private JButton _creationIcon;
	private JButton _modificationIcon;
	private JButton _visuaComIcon;
	private JButton _visuaLivIcon;
	JLabel _userLogin;
	JLabel _date;
	private ButtonListener _clickEventManager = new ButtonListener();;

	private MainScreen(){

		this.setTitle("Speed Time Delivery");
		this.setSize(ConstantsSDT_client.SCREEN_WIDTH, ConstantsSDT_client.SCREEN_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout bLay = new BorderLayout(10,10);
		bLay.setVgap(0);
		bLay.setHgap(0);
		this.getContentPane().setLayout(bLay);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(135,206,235));


	}


	public void makeViewAppearFor(String userSessionView){

		if(userSessionView.equals(ConstantsSDT_client.VIEW_SESSION_MANAGER)) {

			_currentView =  ManagerSessionView.get_sharedInstance();
		}
		build();
		this.setVisible(true);
	}

	public UserSessionView get_currentView() {
		return _currentView;
	}

	public void set_currentView(UserSessionView _currentView) {
		this._currentView = _currentView;
	}

	private void build(){


		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbc2 = new GridBagConstraints();
		GridBagConstraints gbc3 = new GridBagConstraints();

		initButtonSet();
		initPanelSet();
		initLabelSet();

		//Constraints settings

		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		_headerPanel.add(_setting,gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 0;
		_headerPanel.add(_middleHeader,gbc);

		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 3;
		gbc.gridy = 0;
		_headerPanel.add(_iconright, gbc);	

		gbc2.gridx = 0;
		gbc2.gridy = 0;
		_middleHeader.add(_userLogin, gbc2);

		gbc2.gridx = 0;
		gbc2.gridy = 1;
		_middleHeader.add(_date, gbc2);

		gbc3.fill = GridBagConstraints.NONE;
		gbc3.weighty = 2;
		gbc3.gridx = 0;
		gbc3.gridy = 0;
		_floatLeftPan.add(_plannifierComIcon, gbc3);

		gbc3.gridx = 0;
		gbc3.gridy = 1;
		_floatLeftPan.add(_statistiqueIcon, gbc3);

		gbc3.gridx = 0;
		gbc3.gridy = 2;
		_floatLeftPan.add(_creationIcon, gbc3);

		gbc3.gridx = 0;
		gbc3.gridy = 3;
		_floatLeftPan.add(_modificationIcon, gbc3);

		gbc3.gridx = 0;
		gbc3.gridy = 4;
		_floatLeftPan.add(_visuaComIcon, gbc3);

		gbc3.gridx = 0;
		gbc3.gridy = 5;
		_floatLeftPan.add(_visuaLivIcon, gbc3);

		this.getContentPane().add(_headerPanel, BorderLayout.NORTH);

		if(_currentView instanceof ManagerSessionView)
			this.getContentPane().add(_floatLeftPan, BorderLayout.WEST);

	}

	public static MainScreen get_sharedInstance() {

		if(_sharedInstance == null) _sharedInstance = new MainScreen();
		return _sharedInstance;
	}

	public int get_headerPanelWidth() {
		return _headerPanel.getWidth();
	}

	public int get_headerPanelHeight() {
		return _headerPanel.getHeight();
	}

	public int get_floatLeftPanelWidth(){

		return _floatLeftPan.getWidth();
	}

	public int get_floatLeftPanelHeight(){

		return _floatLeftPan.getHeight();
	}

	public void refreshFrame(){

		this.invalidate();
		this.validate();
		this.repaint();

	}

	public void putUserView(JComponent comp){

		this.getContentPane().add(comp, BorderLayout.CENTER);
		refreshFrame();

	}


	//private methods

	private void initButtonSet(){

		_plannifierComIcon = new JButton();
		_statistiqueIcon = new JButton();
		_creationIcon = new JButton();
		_modificationIcon = new JButton();
		_visuaComIcon = new JButton();
		_visuaLivIcon = new JButton();
		_notifIcon = new JButton();
		_userIcon = new JButton();
		_iconCall = new JButton();
		_setting = new JButton();

		_plannifierComIcon.setActionCommand(ConstantsSDT_client.BUTTON_PLANNIFICATION);
		_statistiqueIcon.setActionCommand(ConstantsSDT_client.BUTTON_STATISTIQUE);
		_creationIcon.setActionCommand(ConstantsSDT_client.BUTTON_CREATION);
		_modificationIcon.setActionCommand(ConstantsSDT_client.BUTTON_MODIFICATION);
		_visuaComIcon.setActionCommand(ConstantsSDT_client.BUTTON_VISUALISER_COMMANDE);
		_visuaLivIcon.setActionCommand(ConstantsSDT_client.BUTTON_VISUALISER_LIVREUR);
		_notifIcon.setActionCommand(ConstantsSDT_client.BUTTON_ALERT);
		_userIcon.setActionCommand(ConstantsSDT_client.BUTTON_PROFILE);
		_iconCall.setActionCommand(ConstantsSDT_client.BUTTON_CALL);
		_setting.setActionCommand(ConstantsSDT_client.BUTTON_SETTING);

		_setting.setPreferredSize(new Dimension(64, 53));
		_notifIcon.setPreferredSize(new Dimension(64, 50));
		_userIcon.setPreferredSize(new Dimension(64, 61));
		_iconCall.setPreferredSize(new Dimension(64,60));
		_plannifierComIcon.setPreferredSize(new Dimension(64, 64));
		_statistiqueIcon.setPreferredSize(new Dimension(64, 64));
		_creationIcon.setPreferredSize(new Dimension(64, 64));
		_modificationIcon.setPreferredSize(new Dimension(64, 64));
		_visuaComIcon.setPreferredSize(new Dimension(64, 64));
		_visuaLivIcon.setPreferredSize(new Dimension(64, 64));

		setIconSet();

		_setting.addActionListener(_clickEventManager);
		_plannifierComIcon.addActionListener(_clickEventManager);
		_statistiqueIcon.addActionListener(_clickEventManager);
		_creationIcon.addActionListener(_clickEventManager);
		_modificationIcon.addActionListener(_clickEventManager);
		_visuaComIcon.addActionListener(_clickEventManager);
		_visuaLivIcon.addActionListener(_clickEventManager);
		_notifIcon.addActionListener(_clickEventManager);
		_userIcon.addActionListener(_clickEventManager);
		_iconCall.addActionListener(_clickEventManager);

		_plannifierComIcon.setOpaque(false);
		_statistiqueIcon.setOpaque(false);
		_creationIcon.setOpaque(false);
		_modificationIcon.setOpaque(false);
		_visuaComIcon.setOpaque(false);
		_visuaLivIcon.setOpaque(false);
		_notifIcon.setOpaque(false);
		_userIcon.setOpaque(false);
		_iconCall.setOpaque(false);
		_setting.setOpaque(false);

		_plannifierComIcon.setBorder(null);
		_statistiqueIcon.setBorder(null);
		_creationIcon.setBorder(null);
		_modificationIcon.setBorder(null);
		_visuaComIcon.setBorder(null);
		_visuaLivIcon.setBorder(null);
		_notifIcon.setBorder(null);
		_userIcon.setBorder(null);
		_iconCall.setBorder(null);
		_setting.setBorder(null);

	}

	private void setIconSet(){

		try {

			_setting.setIcon(new ImageIcon("resources/images/setting.png"));
			_notifIcon.setIcon(new ImageIcon("resources/images/notification.png"));
			_userIcon.setIcon(new ImageIcon("resources/images/userIcon.png"));
			_iconCall.setIcon(new ImageIcon("resources/images/callIcon.png"));
			_plannifierComIcon.setIcon(new ImageIcon("resources/images/iconPlanning.png"));
			_statistiqueIcon.setIcon(new ImageIcon("resources/images/iconStatistique.png"));
			_creationIcon.setIcon(new ImageIcon("resources/images/iconCreerCommand.png"));
			_modificationIcon.setIcon(new ImageIcon("resources/images/iconModifierCommande.png"));
			_visuaComIcon.setIcon(new ImageIcon("resources/images/visualiseationCommande.png"));
			_visuaLivIcon.setIcon(new ImageIcon("resources/images/visualisationsationLivreur.png"));

			repaint();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private void initPanelSet(){

		_headerPanel =  new JPanel();
		_middleHeader = new JPanel();
		_floatLeftPan = new JPanel();
		_iconright = new JPanel();

		_middleHeader.setPreferredSize(new Dimension(ConstantsSDT_client.HEADER_MIDDLE_PAN_WIDTH, 61));
		_headerPanel.setPreferredSize(new Dimension(ConstantsSDT_client.SCREEN_WIDTH,85));
		_floatLeftPan.setPreferredSize(new Dimension(256, ConstantsSDT_client.SCREEN_HEIGHT -  _headerPanel.getHeight() ) );

		GridBagLayout layout = new GridBagLayout();
		_headerPanel.setLayout(layout);
		_middleHeader.setLayout(layout);
		_floatLeftPan.setLayout(layout);

		GridLayout gLay = new GridLayout(1, 3);
		_iconright.setLayout(gLay);;
		_iconright.setPreferredSize(new Dimension(192,61));
		_iconright.setOpaque(false);
		_iconright.add(_userIcon);
		_iconright.add(_notifIcon);
		_iconright.add(_iconCall);

	}

	private void initLabelSet(){

		_userLogin = new JLabel("User : Test");
		_date = new JLabel("Date :  17/1/2019");

		_userLogin.setPreferredSize(new Dimension(100, 75));
		_date.setPreferredSize(new Dimension(100, 75));
		_userLogin.setFont(new Font("Arial", Font.BOLD , 24));
		_date.setFont(new Font("Arial", Font.BOLD , 24));
		_userLogin.setForeground(new Color(192,92,192));
		_date.setForeground(new Color(192,92,192));

	}





}
