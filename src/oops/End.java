package oops;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.LayoutStyle.ComponentPlacement;

public class End extends JFrame {

	private JPanel contentPane;
	private String id;
	private int score;
	private Main main;
	final int frame_Height = 900;
	final int frame_Width = 1300;
	private BackSound Sound;

	public void setSound(BackSound sound) {
		this.Sound = sound;
		sound.mulist();
	}

	public void setSound(boolean start) {
		Sound.play(start);
	}

	public End(User user, Main main_input) {

		this.main = main_input;
		setBounds(100, 100, frame_Width, frame_Height);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Sound = new BackSound("logout");
		Sound.setEnd(true);
		setSound(Sound);
		setSound(true);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "End", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblOopsTheEnd = new JLabel("OOPS! THE END!");
		lblOopsTheEnd.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 99));

		id = user.user(); // user id
		JLabel userScore = new JLabel("User: " + id);
		userScore.setForeground(Color.BLUE);
		userScore.setFont(new Font("Arial Black", Font.BOLD, 40));
		score = user.score(); // user's score
		JLabel userId = new JLabel("Score: " + score);
		userId.setForeground(Color.RED);
		userId.setFont(new Font("Arial Black", Font.PLAIN, 40));
		GroupLayout gl_panel = new GroupLayout(panel);

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
				setSound(false);
				dispose();
				main.setVisible(true);
				main.setSound(true);
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

		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(227).addComponent(lblOopsTheEnd,
										GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(542).addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(userId).addComponent(userScore))))
						.addContainerGap(261, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup().addContainerGap(196, Short.MAX_VALUE)
						.addComponent(lblOopsTheEnd, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addGap(111).addComponent(userScore).addGap(77).addComponent(userId).addGap(113)));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 1272, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(panel,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}
}
