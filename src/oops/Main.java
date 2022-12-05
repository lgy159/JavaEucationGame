package oops;


import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main extends JFrame {

   private Main mine;
   private JPanel contentPane;
   private ImageIcon image;
   private Font f1;
   final int frame_Height = 900;
   final int frame_Width = 1300;
   private OOPSTest oopstest;
   private BackSound Sound;

   /**
    * Create the frame.
    */
   
   public static void main(String[] args) {
      Main main = new Main();      
      main.setVisible(true);
   }
   public void setSound(BackSound sound){
      this.Sound = sound;
      sound.mulist();
   }
   public void setSound(boolean start){
	      Sound.play(start);
   }
   public Main() {
      this.mine = this;
      setTitle("OOPS");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, frame_Width, frame_Height);
      setResizable(false);
     
      Sound = new BackSound("main");
      setSound(Sound);
      setSound(true);

      image = new ImageIcon("image.png");

      contentPane = new JPanel() {
         public void paintComponent(Graphics g) {
            g.drawImage(image.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
         }
      };
      
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      f1 = new Font("µ¸¿ò", Font.BOLD, 15);

      setContentPane(contentPane);

      
      JButton btnStart = new JButton("Start");
      btnStart.setFont(f1);
      btnStart.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0)
         {            
            oopstest = new OOPSTest(mine);
            oopstest.test(btnStart.getText());
            setSound(false);
         }
      });

      JButton btnIntroduce = new JButton("Introduce");
      btnIntroduce.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0)
         {            
            oopstest = new OOPSTest(mine);
            oopstest.test(btnIntroduce.getText());
            setSound(false);
         }
      });
      
      
      btnIntroduce.setFont(f1);

      JButton btnExit = new JButton("Exit");
      btnExit.setFont(f1);
      btnExit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent arg0){
            mine.setVisible(false);
            setSound(false);
         }
      });
      
      

      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
      	gl_contentPane.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addGap(529)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      				.addComponent(btnStart, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
      				.addComponent(btnIntroduce, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
      				.addComponent(btnExit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
      			.addGap(507))
      );
      gl_contentPane.setVerticalGroup(
      	gl_contentPane.createParallelGroup(Alignment.TRAILING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addGap(495)
      			.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
      			.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
      			.addComponent(btnIntroduce, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
      			.addGap(63)
      			.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
      			.addGap(88))
      );
      contentPane.setLayout(gl_contentPane);
   }
}