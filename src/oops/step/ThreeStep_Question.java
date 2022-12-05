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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ThreeStep_Question extends JPanel {

   /**
    * Create the panel.
    */
   private int check = 1;
   private File q1;
   private String a;
   private String answer;
   private String comboNum;
   private int num;
   private File q;
   private File q2;
   private File q3;
   private File q4;
   
   private ArrayList<String> answer_select;
   private ArrayList<String> answer_num;
   private Font f1;
   private JTextField textField_1;
   private JComboBox comboBox;
   private JButton btnA;


   public JTextField getTextField_1() {
      return textField_1;
   }
   

   public JComboBox getComboBox() {
      return comboBox;
   }


   public String getComboNum() {
      return comboNum;
   }

   public void setComboNum(String comboNum) {
      if(comboNum==null)
         System.out.println("error");
      this.comboNum = comboNum;
   }

   public void setTextField_1(JTextField textField_1) {
      this.textField_1 = textField_1;
   }

   public ArrayList<String> getAnswer_num() {
      return answer_num;
   }

   public void setAnswer_num(ArrayList<String> answer_num) {
      if(answer_select==null)
         System.out.println("error");
      this.answer_num = answer_num;
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

   public ThreeStep_Question(int num) {

      f1 = new Font("Times", Font.BOLD, 14);

      JScrollPane scrollPane = new JScrollPane();

      JLabel lblAnswer = new JLabel("Answer :");
      lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 23));
      textField_1 = new JTextField();
      textField_1.setColumns(10);

      answer = textField_1.getText().trim();
      answer = answer.toLowerCase();
      setAnswer(answer);
      
      comboBox = new JComboBox();
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));   
      
      comboNum = comboBox.getSelectedItem().toString().trim();
      setComboNum(comboNum);
      
      

      this.check = 1;
      String reader = "";

      try {
         q1 = new File("step3-1.txt");
         q2 = new File("step3-2.txt");
         q3 = new File("step3-3.txt");
         q4 = new File("step3-4.txt");

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

      //´äÃ¼Å©
      btnA = new JButton("A");
      setBtnA(btnA);
      answer_select = new ArrayList<String>();
      answer_select.add("+");
      answer_select.add("\\");
      answer_select.add("return");
      answer_select.add("fos");
      setAnswer_select(answer_select);
      
      answer_num = new ArrayList<String>();
      answer_num.add("3");
      answer_num.add("3");
      answer_num.add("1");
      answer_num.add("2");
      setAnswer_num(answer_num);
      
   
      
      JLabel lblNewLabel = new JLabel("* Select the number that error has been occured and write something that is required for correction.");
      lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
      
      JLabel lblanyModificationOr = new JLabel("(Any Modification or deletion is not allowed. Only addtion to the proper place is allowed.)");
      lblanyModificationOr.setFont(new Font("Times New Roman", Font.PLAIN, 20));

   
      GroupLayout groupLayout = new GroupLayout(this);
      groupLayout.setHorizontalGroup(
         groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
               .addGap(39)
               .addComponent(lblanyModificationOr)
               .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(groupLayout.createSequentialGroup()
               .addGap(27)
               .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                  .addGroup(groupLayout.createSequentialGroup()
                     .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 832, GroupLayout.PREFERRED_SIZE)
                     .addContainerGap())
                  .addGroup(groupLayout.createSequentialGroup()
                     .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                           .addComponent(lblAnswer)
                           .addGap(18)
                           .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                           .addGap(18)
                           .addComponent(textField_1))
                        .addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE))
                     .addGap(27)
                     .addComponent(btnA, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                     .addContainerGap())))
      );
      groupLayout.setVerticalGroup(
         groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
               .addContainerGap()
               .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(lblanyModificationOr)
               .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
                  .addComponent(btnA, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
               .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                  .addComponent(lblAnswer)
                  .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
               .addGap(87))
      );

      JTextArea textArea_1 = new JTextArea();
      scrollPane.setViewportView(textArea_1);
      setLayout(groupLayout);
      textArea_1.setText(a);
      textArea_1.setFont(f1);
      textArea_1.setEditable(false);

   }
}