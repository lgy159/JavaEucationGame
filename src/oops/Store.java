package oops;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;
import oops.step.Step;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Icon;
import java.awt.Color;

public class Store extends JFrame {

	private JPanel contentPane;
	private String caution;

	private int coin;// user가 가지고 있는 coin개수
	private int co;
	private int lifenum; // user가 가지고 있는 life의 개수
	private int timenum; // user가 가지고 있는 time의 개수
	private int hintnum; // user가 가지고 있는 hint의 개수
	private int lifenum_buy; // user가 구입하고자하는 life의 개수 life=3coin
	private int timenum_buy; // user가 구입하고자하는 time의 개수 time=2coin
	private int hintnum_buy; // user가 구입하고자하는 hint의 개수 hint=1coin
	private Font f1;//
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea_2;
	private Step step;
	private Clock clock;

	public void clock_m(Clock clock) {
		this.clock = clock;
	}

	/**
	 * Create the frame.
	 */
	public Store(User user, Clock clock, Step sstep) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Store");
		caution = "Do you really want to exit store?";
		setResizable(false);

		this.step = sstep;
		setBounds(100, 100, 957, 747);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		f1 = new Font("Times", Font.BOLD, 40);

		JPanel panel_life = new JPanel();
		panel_life.setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 138, 53, 0 };
		gbl_panel.rowHeights = new int[] { 56, 178, 104, 57, 85, 27, 29, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel label = new JLabel("Time");
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHEAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("time_store.png"));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.gridwidth = 2;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);

		JTextArea txtrYouCanGet_1 = new JTextArea();
		txtrYouCanGet_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtrYouCanGet_1.setText("you can get 10 seconds.\r\nThe time gives you more\r\ntime to solve question.\r\nAlthough you have enough\r\nlife, you game over when \r\nyour time is over.");
		txtrYouCanGet_1.setEditable(false);
		GridBagConstraints gbc_txtrYouCanGet_1 = new GridBagConstraints();
		gbc_txtrYouCanGet_1.anchor = GridBagConstraints.NORTH;
		gbc_txtrYouCanGet_1.gridwidth = 2;
		gbc_txtrYouCanGet_1.insets = new Insets(0, 0, 5, 0);
		gbc_txtrYouCanGet_1.gridx = 0;
		gbc_txtrYouCanGet_1.gridy = 2;
		panel.add(txtrYouCanGet_1, gbc_txtrYouCanGet_1);
		coin = user.getCoin(0);
		hintnum = user.getHintnum();
		lifenum = user.lifenum(lifenum);
		timenum = clock.getTime();
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("coin_store.png"));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.BOTH;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 4;
		panel.add(label_2, gbc_label_2);

		JLabel lblX = new JLabel("x2");
		lblX.setFont(new Font("Dialog", Font.BOLD, 40));
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblX.insets = new Insets(0, 0, 5, 0);
		gbc_lblX.gridx = 1;
		gbc_lblX.gridy = 4;
		panel.add(lblX, gbc_lblX);
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Dialog", Font.PLAIN, 19));
		textArea_2.setText("Now you have\r\n" + lifenum + " life\r\n" + timenum + " time\r\n" + hintnum + " hint\r\n"
				+ user.getCoin(0) + " coin.");

		textArea_2.setEditable(false);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 5;
		panel.add(textField_1, gbc_textField_1);

		JButton button = new JButton("BUY");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timenum_buy = 0;
				try {
					String s2 = textField_1.getText();
					timenum_buy = Integer.parseInt(s2);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "ERROR: Please input only positive integers.");
				}
				if (coin < timenum_buy * 2)
					JOptionPane.showMessageDialog(null, "You don't have enough coin to buy it!!");
				else {
					JOptionPane.showMessageDialog(null, "You get " + timenum_buy * 10 + " seconds.");
					timenum += timenum_buy * 10;
					coin -=(timenum_buy * 2);
					user.setCoin(coin);
					textArea_2.setText("Now you have\r\n" + lifenum + " life\r\n" + timenum + " time\r\n" + hintnum
							+ " hint\r\n" + coin + " coin.");
					textField_1.setText("");
					clock.setTime(timenum);
						
				}

			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTHEAST;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 6;
		panel.add(button, gbc_button);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 138, 53, 0 };
		gbl_panel_1.rowHeights = new int[] { 56, 179, 104, 75, 84, 27, 29, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblHint = new JLabel("Hint");
		lblHint.setFont(new Font("Dialog", Font.BOLD, 40));
		GridBagConstraints gbc_lblHint = new GridBagConstraints();
		gbc_lblHint.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblHint.insets = new Insets(0, 0, 5, 5);
		gbc_lblHint.gridx = 0;
		gbc_lblHint.gridy = 0;
		panel_1.add(lblHint, gbc_lblHint);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("hint.png"));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.BOTH;
		gbc_label_5.gridwidth = 2;
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 1;
		panel_1.add(label_5, gbc_label_5);

		JTextArea txtrYouCanGet_2 = new JTextArea();
		txtrYouCanGet_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtrYouCanGet_2.setText("you can get 1 hint.\r\nThe hint helps you to\r\nsolve question easier.\r\nyou use hint item only\r\nonce in same question.");
		txtrYouCanGet_2.setEditable(false);
		GridBagConstraints gbc_txtrYouCanGet_2 = new GridBagConstraints();
		gbc_txtrYouCanGet_2.anchor = GridBagConstraints.NORTH;
		gbc_txtrYouCanGet_2.gridwidth = 2;
		gbc_txtrYouCanGet_2.insets = new Insets(0, 0, 5, 0);
		gbc_txtrYouCanGet_2.gridx = 0;
		gbc_txtrYouCanGet_2.gridy = 2;
		panel_1.add(txtrYouCanGet_2, gbc_txtrYouCanGet_2);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("coin_store.png"));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.BOTH;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 4;
		panel_1.add(label_6, gbc_label_6);

		JLabel lblX_1 = new JLabel("x1");
		lblX_1.setFont(new Font("Dialog", Font.BOLD, 40));
		GridBagConstraints gbc_lblX_1 = new GridBagConstraints();
		gbc_lblX_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblX_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblX_1.gridx = 1;
		gbc_lblX_1.gridy = 4;
		panel_1.add(lblX_1, gbc_lblX_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 5;
		panel_1.add(textField_2, gbc_textField_2);

		JButton button_1 = new JButton("BUY");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintnum_buy = 0;
				try {
					String s3 = textField_2.getText();
					hintnum_buy = Integer.parseInt(s3);
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(null, "ERROR: Please input only positive integers.");
				}
				if (coin < hintnum_buy * 1)
					JOptionPane.showMessageDialog(null, "You don't have enough coin to buy it!!");
				else {
					JOptionPane.showMessageDialog(null, "You get " + hintnum_buy + " hint.");
					hintnum += hintnum_buy;
					coin -=(hintnum_buy * 1);
					user.setCoin(coin);
					textArea_2.setText("Now you have\r\n" + lifenum + " life\r\n" + timenum + " time\r\n" + hintnum
							+ " hint\r\n" + coin + " coin.");
					textField_2.setText("");
					user.setHintnum(hintnum);
					

				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 6;
		panel_1.add(button_1, gbc_button_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_life, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(panel_life, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("store_rabbit.png"));

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("store_turtle.png"));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING,
						gl_panel_2.createSequentialGroup().addGap(33)
								.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(41)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)));
		panel_2.setLayout(gl_panel_2);

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
				int window = JOptionPane.showConfirmDialog(null, caution, "Caution", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (window == JOptionPane.CANCEL_OPTION) {

				} else if (window == JOptionPane.OK_OPTION) {
					step.getClock().restart();
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
				GridBagLayout gbl_panel_life = new GridBagLayout();
				gbl_panel_life.columnWidths = new int[]{128, 53, 0};
				gbl_panel_life.rowHeights = new int[]{70, 178, 154, 18, 82, 27, 29, 0};
				gbl_panel_life.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_life.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel_life.setLayout(gbl_panel_life);
								
										JLabel lblLife = new JLabel("Life");
										lblLife.setFont(f1);
										GridBagConstraints gbc_lblLife = new GridBagConstraints();
										gbc_lblLife.anchor = GridBagConstraints.SOUTHEAST;
										gbc_lblLife.insets = new Insets(0, 0, 5, 5);
										gbc_lblLife.gridx = 0;
										gbc_lblLife.gridy = 0;
										panel_life.add(lblLife, gbc_lblLife);
								
										JLabel life_image = new JLabel("");
										life_image.setIcon(new ImageIcon("life_store.png"));
										GridBagConstraints gbc_life_image = new GridBagConstraints();
										gbc_life_image.fill = GridBagConstraints.BOTH;
										gbc_life_image.insets = new Insets(0, 0, 5, 0);
										gbc_life_image.gridwidth = 2;
										gbc_life_image.gridx = 0;
										gbc_life_image.gridy = 1;
										panel_life.add(life_image, gbc_life_image);
						
								JTextArea txtrYouCanGet = new JTextArea();
								txtrYouCanGet.setFont(new Font("Times New Roman", Font.PLAIN, 16));
								txtrYouCanGet
										.setText("you can get 1 life. The \r\nlife gives you a one more \r\nchance to solve question. \r\nBut you can't have more \r\nthan 5 life.And life must \r\napply next question.\r\n");
								txtrYouCanGet.setEditable(false);
								GridBagConstraints gbc_txtrYouCanGet = new GridBagConstraints();
								gbc_txtrYouCanGet.anchor = GridBagConstraints.NORTH;
								gbc_txtrYouCanGet.insets = new Insets(0, 0, 5, 0);
								gbc_txtrYouCanGet.gridwidth = 2;
								gbc_txtrYouCanGet.gridx = 0;
								gbc_txtrYouCanGet.gridy = 2;
								panel_life.add(txtrYouCanGet, gbc_txtrYouCanGet);
						
								JLabel label1_coin = new JLabel("");
								label1_coin.setIcon(new ImageIcon("coin_store.png"));
								GridBagConstraints gbc_label1_coin = new GridBagConstraints();
								gbc_label1_coin.fill = GridBagConstraints.BOTH;
								gbc_label1_coin.insets = new Insets(0, 0, 5, 5);
								gbc_label1_coin.gridx = 0;
								gbc_label1_coin.gridy = 4;
								panel_life.add(label1_coin, gbc_label1_coin);
						
								JLabel lblNewLabel = new JLabel("x3");
								lblNewLabel.setFont(f1);
								GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
								gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
								gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
								gbc_lblNewLabel.gridx = 1;
								gbc_lblNewLabel.gridy = 4;
								panel_life.add(lblNewLabel, gbc_lblNewLabel);
				
						textField = new JTextField();
						textField.setColumns(10);
						GridBagConstraints gbc_textField = new GridBagConstraints();
						gbc_textField.anchor = GridBagConstraints.NORTH;
						gbc_textField.insets = new Insets(0, 0, 5, 0);
						gbc_textField.gridwidth = 2;
						gbc_textField.gridx = 0;
						gbc_textField.gridy = 5;
						panel_life.add(textField, gbc_textField);
				
						JButton btnBuy = new JButton("BUY");
						btnBuy.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								lifenum_buy = 0;
								try {
									String s = textField.getText();
									lifenum_buy = Integer.parseInt(s);
								} catch (NumberFormatException n) {
									JOptionPane.showMessageDialog(null, "ERROR: Please input only positive integers.");
								}
								if (coin < lifenum_buy * 3)
									JOptionPane.showMessageDialog(null, "You don't have enough coin to buy it!!");
								else if (lifenum + lifenum_buy > 5)
									JOptionPane.showMessageDialog(null, "You can't have more than 5 life!!");
								else {
									JOptionPane.showMessageDialog(null, "You get " + lifenum_buy + " life.");
									lifenum += lifenum_buy;
									coin -= lifenum_buy * 3;
									user.setCoin(coin);
									textArea_2.setText("Now you have\r\n" + lifenum + " life\r\n" + timenum + " time\r\n" + hintnum
											+ " hint\r\n" + coin + " coin.");
									textField.setText("");
									user.setlifenum(lifenum);
								

								}
							}
						});
						GridBagConstraints gbc_btnBuy = new GridBagConstraints();
						gbc_btnBuy.anchor = GridBagConstraints.NORTHEAST;
						gbc_btnBuy.insets = new Insets(0, 0, 0, 5);
						gbc_btnBuy.gridx = 0;
						gbc_btnBuy.gridy = 6;
						panel_life.add(btnBuy, gbc_btnBuy);
		contentPane.setLayout(gl_contentPane);

	}
}
