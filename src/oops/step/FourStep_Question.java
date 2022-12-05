package oops.step;

import javax.swing.JPanel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JLabel;

import javax.swing.JTextArea;
import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;

public class FourStep_Question extends JPanel {

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
	private JTextArea textarea;
	private ArrayList<String> answer_select;
	private Font f1;
	private JButton btnA;

	public JTextArea getTextField_1() {
		return textarea;
	}

	public void setTextField_1(JTextArea textField_1) {
		this.textarea = textField_1;
	}

	public ArrayList<String> getAnswer_select() {
		return answer_select;
	}

	public void setAnswer_select(ArrayList<String> answer_select) {
		if (answer_select == null)
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

	public FourStep_Question(int num) {

		f1 = new Font("Times", Font.BOLD, 14);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblAnswer = new JLabel("Answer :");
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 23));

		textarea = new JTextArea();

		this.check = 1;
		String reader = "";

		try {
			q1 = new File("step4-1.txt");
			q2 = new File("step4-2.txt");
			q3 = new File("step4-3.txt");
			q4 = new File("step4-4.txt");

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

		answer_select.add("4");
		answer_select.add("0\n0\n4\n");
		answer_select.add("-1 4 5");
		answer_select.add("6\ntrue\n13\n5\nfalse\n2\n5\n66\nB\nB\nC\n");

		setAnswer_select(answer_select);

		JScrollPane scrollPane_1 = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(27)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addGap(84).addComponent(lblAnswer)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 415,
												GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(btnA, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE).addGap(32)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(28).addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))
								.addGroup(
										groupLayout.createSequentialGroup().addGap(56).addComponent(btnA,
												GroupLayout.PREFERRED_SIZE, 247,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(74).addComponent(lblAnswer)
										.addGap(47))
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
												.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 120,
														GroupLayout.PREFERRED_SIZE)
												.addGap(21)))));

		scrollPane_1.setViewportView(textarea);
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		setLayout(groupLayout);
		textArea_1.setText(a);
		textArea_1.setFont(f1);
		textArea_1.setEditable(false);

	}
}
