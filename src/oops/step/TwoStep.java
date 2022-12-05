package oops.step;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TwoStep extends Step {

	private JPanel contentPane;
	private String caution;
	private BackSound Sound;
	private ImageIcon image;
	final int frame_Height = 900;
	final int frame_Width = 1300;
	private int window;
	private Main main;
	private int score;
	private int coin;
	private TwoStep_Question panel_1;// question 1
	private TwoStep_Question panel_2;// question 2
	private TwoStep_Question panel_3;// question 3
	private TwoStep_Question panel_4;// question 4
	private String answer;
	private ImageIcon life;// life image
	private ArrayList<JLabel> imageArray;
	private ThreeStep threestep;
	private int num;
	private Hint hintclass;
	private int hintnum;
	private int i;
    private Clock clock;
    public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	private TwoStep mine;
	

	
	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setSound(BackSound sound) {
		this.Sound = sound;

		sound.mulist();
	}
	public void setSound(boolean start){
		Sound.play(start);
	}

	@Override
	public void showlife(int num, ArrayList<JLabel> imgaeArray, User user) {

		if (num <= 0) {
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

	/**
	 * Create the frame.
	 */
	public TwoStep(Main main_input, User user) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.mine = this;
		this.main = main_input;
		setTitle("Two Step");
		setBounds(100, 100, frame_Width, frame_Height);
		setResizable(false);
		Sound = new BackSound("game2");
		setSound(Sound);
		setSound(true);
		caution = "Do you really want to close the window? If you close the window, you need to solve the problem again from the beginning.";
		image = new ImageIcon("step2.png");

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
				showlife(user.lifenum(num), imageArray, user);
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
				if (window == JOptionPane.CANCEL_OPTION) {
					
				} else if (window == JOptionPane.OK_OPTION) {
					dispose();
					setSound(false);
					main.setSound(true);
					main.setVisible(true);
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

		clock = new Clock(user,main);
		clock.setVisible(true);
		clock.setTime(30);
		clock.setStep(this);	

		
		
		JPanel panel = new JPanel();
		panel_1 = new TwoStep_Question(1);
		panel_1.getBtnA().setForeground(new Color(165, 42, 42));
		panel_1.getBtnA().setBackground(new Color(240, 248, 255));
		panel_1.setBackground(Color.WHITE);
		panel_2 = new TwoStep_Question(2);
		panel_2.setBackground(Color.WHITE);
		panel_3 = new TwoStep_Question(3);
		panel_3.setBackground(Color.WHITE);
		panel_4 = new TwoStep_Question(4);
		panel_4.setBackground(Color.WHITE);

		panel_1.setVisible(true);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_4.setVisible(false);

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

		num = 0;
		i = 3;
		showlife(user.lifenum(num), imageArray, user);
		coin=user.getCoin(0);
		
		panel_1.getBtnA().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = panel_1.getTextField_1().getText().trim();
				answer = answer.toLowerCase();
				panel_1.setAnswer(answer);
				if (panel_1.getAnswer().equals(panel_1.getAnswer_select().get(0))) {
					score = score + 5;
					num = 0;
					coin=user.getCoin(1);
				} else
					num = -1;
				mine.getClock().stop();
				JOptionPane.showMessageDialog(null, "Your score is " + user.score());
				clock.setTime(30);
				mine.getClock().restart();
				showlife(user.lifenum(num), imageArray, user);
				user.setCoin(coin);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				i++;

			}

		});
		panel_2.getBtnA().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = panel_2.getTextField_1().getText().trim();
				answer = answer.toLowerCase();
				panel_2.setAnswer(answer);

				if (panel_2.getAnswer().equals(panel_2.getAnswer_select().get(1))) {
					score = score + 5;
					num = 0;
					coin=user.getCoin(1);
					
					
				} else
					num = -1;
				mine.getClock().stop();
				JOptionPane.showMessageDialog(null, "Your score is " + user.score());
				clock.setTime(30);
				mine.getClock().restart();
				showlife(user.lifenum(num), imageArray, user);
				user.setCoin(coin);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				panel_4.setVisible(false);
				i++;

			}

		});
		panel_3.getBtnA().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = panel_3.getTextField_1().getText().trim();
				answer = answer.toLowerCase();
				panel_3.setAnswer(answer);
				if (panel_3.getAnswer().equals(panel_3.getAnswer_select().get(2))) {
					score = score + 5;
					num = 0;
					coin=user.getCoin(1);
					
				} else
					num = -1;
				mine.getClock().stop();
				JOptionPane.showMessageDialog(null, "Your score is " + user.score());
				showlife(user.lifenum(num), imageArray, user);
				user.setCoin(coin);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				i++;

			}

		});
		panel_4.getBtnA().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer = panel_4.getTextField_1().getText().trim();
				answer = answer.toLowerCase();
				panel_4.setAnswer(answer);
				if (panel_4.getAnswer().equals(panel_4.getAnswer_select().get(3))) {
					score = score + 5;
					num = 0;
					coin=user.getCoin(1);
					
				} else
					num = -1;
				mine.getClock().stop();
				JOptionPane.showMessageDialog(null, "Your score is " + user.score());
				clock.setTime(30);
				mine.getClock().restart();
				showlife(user.lifenum(num), imageArray, user);
				user.setCoin(coin);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				i++;

				if (user.lifenum(0) != 0) {
					// exit the Step2 & show the Step3
					dispose();
					setSound(false);
					clock.setStep(null);
					threestep = new ThreeStep(main, user);
					user.step(threestep);
					threestep.setVisible(true);
					clock.stop();
				}
			}

		});


		JButton btnStore = new JButton("STORE");
		btnStore.setFont(new Font("±¼¸²", Font.BOLD, 22));
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Store sto = new Store(user,clock,mine);
				sto.setVisible(true);
				mine.getClock().stop();
			}
		});

		hintclass=new Hint();
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
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(31)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnStore, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnhint, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(clock, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(btnStore, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnhint, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(clock, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
					.addGap(146)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
								.addGap(3)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public int getCoin() {
		// TODO Auto-generated method stub
		return coin;
	}
}
