package oops.step;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oops.BackSound;
import oops.Clock;
import oops.End;
import oops.Main;
import oops.Store;
import oops.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class OneStep extends Step {

	private JPanel contentPane;
	private String caution;
	private BackSound Sound;
	private ImageIcon image;
	final int frame_Height = 900;
	final int frame_Width = 1300;
	private int window;
	private Main main;
	private Store usestore;
	private int coin;
	private int score;
	private OneStep_Question panel_1;// question1
	private OneStep_Question panel_2;// question2
	private OneStep_Question panel_3;// question3
	private String answer;
	private ImageIcon life;// life image
	private TwoStep twostep;
	private ArrayList<JLabel> imageArray;
	private int num;
	private Hint hintclass;
	private int hintnum;
	private int i;// index of hints ArrayList
	private Clock clock;
	private JButton btnNewButton;
	private OneStep mine;

	@Override
	public void setSound(BackSound sound) {// set sound track of backsound
		this.Sound = sound;
		sound.mulist();
	}

	public void setSound(boolean start) {// start or stop sound
		Sound.play(start);
	}

	@Override
	public void showlife(int num, ArrayList<JLabel> imageArray, User user) {
		if (num <= 0) {// life==0 , end
			dispose();
			setSound(false);
			End end = new End(user,main);
			end.setVisible(true);

		} else {

			for (int i = 0; i < 5; i++) {
				imageArray.get(i).setVisible(false);
			}
			for (int i = 0; i < num; i++) {
				imageArray.get(i).setVisible(true);
			}
		}
	}

	@Override
	public int getScore() {
		return score;
	}

	/**
	 * Create the frame.
	 */
	public OneStep(Main main_input, User user) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.mine = this;
		this.main = main_input;

		clock = new Clock(user,main);
		clock.setVisible(true);
		clock.setTime(30);
		clock.setStep(this);
		

		Sound = new BackSound("game1");

		setResizable(false);
		setTitle("One Step");
		setBounds(100, 100, frame_Width, frame_Height);
		setSound(Sound);
		setSound(true);
		caution = "Do you really want to close the window? If you close the window, you need to solve the problem again from the beginning.";
		image = new ImageIcon("step1.png");

		life = new ImageIcon("life.png");
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);

			}
		};

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// showlife(user.lifenum(num) , imageArray, user);
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
				window = JOptionPane.showConfirmDialog(null, caution, "Caution", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				mine.getClock().stop();
				if (window == JOptionPane.CANCEL_OPTION) {
					mine.getClock().restart();
				} else if (window == JOptionPane.OK_OPTION) {
					setSound(false);
					main.setSound(true);
					main.setVisible(true);
					dispose();
				}

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

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		/* Question panel (argument = Question number) */
		panel_1 = new OneStep_Question(1);
		panel_1.setBackground(Color.WHITE);
		panel_2 = new OneStep_Question(2);
		panel_2.setBackground(Color.WHITE);
		panel_3 = new OneStep_Question(3);
		panel_3.setBackground(Color.WHITE);

		panel_1.setVisible(true);
		panel_2.setVisible(false);
		panel_3.setVisible(false);

		/* life image label */
		JLabel lblNewLabel = new JLabel(life);
		JLabel lblNewLabel_1 = new JLabel(life);
		JLabel lblNewLabel_2 = new JLabel(life);
		JLabel lblNewLabel_3 = new JLabel(life);
		JLabel lblNewLabel_4 = new JLabel(life);

		imageArray = new ArrayList<JLabel>();
		imageArray.add(lblNewLabel);
		imageArray.add(lblNewLabel_1);
		imageArray.add(lblNewLabel_2);
		imageArray.add(lblNewLabel_3);
		imageArray.add(lblNewLabel_4);

		user.setlifenum(3); // set life °ª
		hintnum = user.getHintnum(); // hint number 
		num = 0;// ¼Ò¸êµÇ´Â life°ª
		i = 0;
		showlife(user.lifenum(num), imageArray, user);
		user.setCoin(0);
		panel_1.getBtnA().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = panel_1.getTextField_1().getText().trim();
				answer = answer.toLowerCase();
				if (answer.equals(panel_1.getAnswer_select().get(0))) {
					score = score + 3;
					coin = user.getCoin(1);// coin num increment
					num = 0;
				} else
					num = -1;

				mine.getClock().stop();
				JOptionPane.showMessageDialog(null, "Your score is " + score);
				mine.getClock().restart();
				showlife(user.lifenum(num), imageArray, user);
				user.setCoin(coin);
				clock.setTime(30);
				if (clock.getTime() == 0) {
					dispose();
					setSound(false);
					End end = new End(user,main);
					end.setVisible(true);
				}
				// timefinish(user, mine.getClock().getTime());
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				i++;

			}

		});
		panel_2.getBtnA().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = panel_2.getTextField_1().getText();
				answer = answer.toLowerCase();

				if (answer.equals(panel_2.getAnswer_select().get(1))) {
					score = score + 3;
					coin = user.getCoin(1);
					num = 0;
				} else {
					num = -1;
				}

				mine.getClock().stop();
				JOptionPane.showMessageDialog(null, "Your score is " + score);
				mine.getClock().restart();
				showlife(user.lifenum(num), imageArray, user);
				user.setCoin(coin);
				clock.setTime(30);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				i++;

			}

		});
		panel_3.getBtnA().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = panel_3.getTextField_1().getText();
				if (answer.equals(panel_3.getAnswer_select().get(2))) {
					score = score + 3;
					coin = user.getCoin(1);
					num = 0;
				} else
					num = -1;

				mine.getClock().stop();
				JOptionPane.showMessageDialog(null, "Your score is " + score);
				showlife(user.lifenum(num), imageArray, user);
				user.setCoin(coin);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				i++;

				if (user.lifenum(0) != 0) {
					/* Exit the step1 & Open the Step2 */
					dispose();
					setSound(false);
					clock.stop();
					clock.setStep(null);
					twostep = new TwoStep(main, user);
					twostep.setVisible(true);
					user.step(twostep);
				}
			}

		});

		btnNewButton = new JButton("STORE");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Store sto = new Store(user, clock, mine);
				sto.setVisible(true);
				mine.getClock().stop();
			}
		});

		hintclass = new Hint();
		JButton btnhint = new JButton("*HINT*");
		btnhint.setForeground(Color.RED);
		btnhint.setFont(new Font("±¼¸²", Font.BOLD, 23));
		btnhint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mine.getClock().stop();
				hintnum = user.getHintnum();
				if (hintnum > 0) {
					String hint = hintclass.getHints().get(i);
					JOptionPane.showMessageDialog(null, hint + "\n*If you close the hint, you have to pay quiz again*",
							"HINT", JOptionPane.INFORMATION_MESSAGE);
					hintnum -= 1;
					user.setHintnum(hintnum);
					mine.getClock().restart();

				} else {
					JOptionPane.showMessageDialog(null, "You don't have a hint item.\nBuy it at store!!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
					mine.getClock().restart();
				}
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane
										.createSequentialGroup().addGap(
												31)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 900,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 900,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 900,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addGap(29).addGroup(gl_contentPane
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addComponent(btnNewButton,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(btnhint,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)))
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(clock, GroupLayout.PREFERRED_SIZE,
																				348, GroupLayout.PREFERRED_SIZE))))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(29)
														.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 104,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 110,
																GroupLayout.PREFERRED_SIZE)
														.addGap(55)
														.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 121,
																GroupLayout.PREFERRED_SIZE)
														.addGap(65)
														.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 153,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(lblNewLabel_4,
																GroupLayout.PREFERRED_SIZE, 167,
																GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(29)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(55).addComponent(btnNewButton)
								.addGap(37).addComponent(btnhint).addPreferredGap(ComponentPlacement.RELATED,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(clock, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 95,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}

	public int getCoin() {
		// TODO Auto-generated method stub
		return coin;
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

}
