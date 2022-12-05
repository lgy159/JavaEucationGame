package oops.step;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TwoStep_Question extends JPanel {

	/**
	 * Create the panel.
	 */
	private int check = 1;
	private File q1;
	private String a;
	private String answer;
	private File q;
	private File q2;
	private File q3;
	private File q4;
	
	private ArrayList<String> answer_select;
	private Font f1;
	private JTextField textField_1;
	private JButton btnA;


	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		if(answer==null)
			System.out.println("error!");
		this.answer = answer;
	}

	public ArrayList<String> getAnswer_select() {
		return answer_select;
	}

	public void setAnswer_select(ArrayList<String> answer_select) {
		if(answer_select==null)
			System.out.println("error");
		this.answer_select = answer_select;
	}

	public JButton getBtnA() {
		return btnA;
	}

	public void setBtnA(JButton btnA) {
		this.btnA = btnA;
		btnA.setFont(new Font("±¼¸²", Font.BOLD, 49));
		btnA.setForeground(Color.MAGENTA);
		btnA.setBackground(Color.CYAN);
		
		
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {// capsulation ÇØ¾ß´ï
		this.check = check;
	}

	public TwoStep_Question(int num) {

		f1 = new Font("Times", Font.BOLD, 14);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblAnswer = new JLabel("Answer :");
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 23));
		textField_1 = new JTextField();
		textField_1.setColumns(10);

		answer = textField_1.getText().trim();
		answer = answer.toLowerCase();
		setAnswer(answer);

		this.check = 1;
		String reader = "";

		try {
			q1 = new File("step2-1.txt");
			q2 = new File("step2-2.txt");
			q3 = new File("step2-3.txt");
			q4 = new File("step2-4.txt");

			switch (num) {
			case 1:
				q = q1;
				break;
			case 2:
				q = q2;
				break;
			case 3:
				q = q3;
				break;
			case 4:
				q = q4;
				break;
			}
			BufferedReader br = new BufferedReader(new FileReader(q));
			a = "";
			while ((reader = br.readLine()) != null) {
				a += reader;
				a += "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btnA = new JButton("A");
		setBtnA(btnA);
		answer_select = new ArrayList<String>();
		answer_select.add("static");
		answer_select.add("inheritance");
		answer_select.add("polymorphism");
		answer_select.add("superclass");
		setAnswer_select(answer_select);

	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(27)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(49).addComponent(lblAnswer)
								.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE).addComponent(
										textField_1, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
				.addComponent(btnA, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE).addGap(32)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(28).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(56).addComponent(btnA,
										GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAnswer))
						.addGap(37)));

		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		setLayout(groupLayout);
		textArea_1.setText(a);
		textArea_1.setFont(f1);
		textArea_1.setEditable(false);

	}

}
