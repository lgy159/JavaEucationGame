package oops;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Join extends JFrame {

	private JPanel contentPane_1;
	private Login log;
	final int frame_Height = 900;
	final int frame_Width = 1300;
	private Font f1;
	private ImageIcon image;
	private JTextField textField_1;//pw textField
	private JTextField textField; //id textField
	private String id;
	private String pw;
	private String filename_id;
	private String filename_pw;
	private File file_id;
	private File file_pw;
	private Main main;
	
	public boolean check(String id,File file_id) throws IOException{//Check existing id 
		try {
			BufferedReader rd_id = new BufferedReader(new FileReader(file_id));
			String s;
			while((s=rd_id.readLine()) != null){
				if(s.equals(id))
				return true;
			}
			return false;
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public Join(Main main_input,OOPSTest test) {
		
		this.main = main_input;
		log = new Login(main,test);
		
		setTitle("Sign");
		setBounds(100, 100, frame_Width, frame_Height);
		setResizable(false);
		f1 = new Font("Times", Font.BOLD, 40);

		image = new ImageIcon("join.png");

		filename_id = "id.txt";
		filename_pw = "pw.txt";
		
		file_id = new File(filename_id);
		file_pw = new File(filename_pw);
		
		
		
		contentPane_1 = new JPanel() {//background image
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);



		JLabel lblId = new JLabel("ID :");
		lblId.setFont(f1);
		JLabel lblPassword = new JLabel("PassWord : ");
		lblPassword.setFont(f1);
		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = textField.getText();
				pw = textField_1.getText();
				try{
					if (check(id,file_id)) {//check that already exist user.
						JOptionPane.showMessageDialog(null, "It already exist.");
					} else {//make the user (input user id & pw in file.)
						
						BufferedWriter fw_id = new BufferedWriter(new FileWriter(file_id,true));
						BufferedWriter fw_pw = new BufferedWriter(new FileWriter(file_pw,true));
						fw_id.write(id+"\n");
						fw_pw.write(pw+"\n");
						
						fw_id.flush();//buffer가 차지않아도 write.
						fw_pw.flush();
						
						fw_id.close();
						fw_pw.close();
						
						JOptionPane.showMessageDialog(null, "Success join ! \n *Welcome* ");
						setVisible(false);
						log.setVisible(true);
						//dispose();
					}	
				}
				catch(Exception e2){
					e2.printStackTrace();
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
				log.setVisible(true);
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
		
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup().addGap(123)
						.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING).addComponent(lblPassword)
								.addComponent(lblId))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 337,
										Short.MAX_VALUE)
								.addComponent(textField, Alignment.TRAILING))
						.addGap(46).addComponent(btnJoin, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(556, Short.MAX_VALUE)));
		gl_contentPane_1.setVerticalGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING).addGroup(
				gl_contentPane_1.createSequentialGroup().addContainerGap(522, Short.MAX_VALUE).addGroup(gl_contentPane_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								gl_contentPane_1.createSequentialGroup()
										.addComponent(btnJoin, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addGap(247))
						.addGroup(Alignment.TRAILING, gl_contentPane_1.createSequentialGroup().addGroup(gl_contentPane_1
								.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane_1.createSequentialGroup()
										.addGroup(gl_contentPane_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblId).addComponent(textField, GroupLayout.PREFERRED_SIZE,
														42, GroupLayout.PREFERRED_SIZE))
										.addGap(74).addComponent(lblPassword)))
								.addGap(211)))));
		contentPane_1.setLayout(gl_contentPane_1);
	}

}
