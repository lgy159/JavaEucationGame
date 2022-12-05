package oops;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private Join join;
	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<String> userlist_id;
	private ArrayList<String> userlist_pw;
	private String id;
	private String pw;
	final int frame_Height = 900;
	final int frame_Width = 1300;
	private Main main;
	private int index; // check user id index
	private boolean log_in; // check log in
	private ImageIcon image;
	private Font f1;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JButton btnLogin;
	private Start start;
	private OOPSTest test;
	private String filename_id;
	private String filename_pw;
	private File file_id;
	private File file_pw;

	public int getindex_user() {
		return index;
	}

	public void setlog_in(boolean login) {
		this.log_in = login;
	}

	public boolean getlog_in() {
		return log_in;
	}

	public ArrayList<String> getuser_list() {
		return userlist_id;
	}

	public String getId() {
		return id.toString() ;
	}

	public boolean check(String id, String pw, File file_id, File file_pw) throws IOException {// check
																								// log-in
																								// information.
		try {
			BufferedReader rd_id = new BufferedReader(new FileReader(file_id));
			BufferedReader rd_pw = new BufferedReader(new FileReader(file_pw));
			String a;
			while ((a = rd_id.readLine()) != null) {//Arraylist input from file.
				userlist_id.add(a);
			}
			while ((a = rd_pw.readLine()) != null) {
				userlist_pw.add(a);
			}
			if (userlist_id.contains(id)) {//check existing user information(just id)
				if (pw.equals(userlist_pw.get(userlist_id.indexOf(id)))) {//because the id array and the pw array have same index of user.
					index = userlist_id.indexOf(id);
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Password!");
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, id + " doesn't exist.\tPlease input existing id or create new id");
				return false;

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public Login(Main main_input) {
		this.main = main_input;
	}

	public Login(Main main_input, OOPSTest test) {// test : OOPSTest have Start. so it have parameter OOPSTest. 

		this.main = main_input;
		this.test = test;

		setTitle("Login");
		setBounds(100, 100, frame_Width, frame_Height);
		setResizable(false);
		f1 = new Font("Times", Font.BOLD, 40);

		image = new ImageIcon("login.png");

		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblID = new JLabel("ID :");
		lblID.setFont(f1);
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setFont(f1);

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		lblNewLabel = new JLabel("If you don't have id , click the button \"Join\".");

		userlist_id = new ArrayList<String>();
		userlist_pw = new ArrayList<String>();

		filename_id = "id.txt";
		filename_pw = "pw.txt";

		file_id = new File(filename_id);
		file_pw = new File(filename_pw);

		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnJoin)) {

					/* Join */
					join = new Join(main,test);
					join.setVisible(true);
					setVisible(false);

				}
			}

		});

		setlog_in(false);

		btnLogin = new JButton("Log-in");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnLogin)) {
					id = textField.getText();
					pw = textField_1.getText();
					try {
						boolean a = check(id, pw, file_id, file_pw);
						if (a == true) {
							setlog_in(true); // game start.
							JOptionPane.showMessageDialog(null, "Welcome !");
							dispose();
							start = test.getStart();
							start.start(true);
						} else if (a == false) {
							setlog_in(false);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				main.setVisible(true);
				dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(392, Short.MAX_VALUE).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblPassword).addComponent(lblID))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_1, 309, 309, 309).addComponent(textField,
														GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
										.addGap(75).addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(208)
										.addComponent(btnJoin, GroupLayout.PREFERRED_SIZE, 68,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 115, GroupLayout.PREFERRED_SIZE)))
						.addGap(317))
						.addGroup(groupLayout.createSequentialGroup().addGap(290).addComponent(lblNewLabel)
								.addContainerGap(692, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addGap(430).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblID)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGap(61)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPassword))
						.addGap(72).addComponent(btnJoin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel)
						.addContainerGap(128, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addContainerGap(507, Short.MAX_VALUE).addComponent(btnLogin,
												GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addGap(292)));
		getContentPane().setLayout(groupLayout);
	}
}