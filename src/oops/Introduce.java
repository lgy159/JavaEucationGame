package oops;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Introduce extends JFrame {

   private Main main;
    private ImageIcon image;
   private JPanel contentPane;
   final int frame_Height = 900;
   final int frame_Width = 1300;
   final Font F_title;
   final Font F_text;

   
   /**
    * Create the frame.
    */
   public Introduce(Main main_input)
   {
      setTitle("Introduce");
      this.main = main_input;
      
      setBounds(100, 100, frame_Width, frame_Height);
      setResizable(false);
         image = new ImageIcon("introduce.png");
         
         contentPane = new JPanel() {
               public void paintComponent(Graphics g) {
                  g.drawImage(image.getImage(), 0, 0, null);
                  setOpaque(false);
                  super.paintComponent(g);
               }
            };
            
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      F_title=new Font("Times",Font.BOLD|Font.ITALIC,60);
      F_text=new Font("Times",Font.BOLD,30);
      
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGap(0, 1272, Short.MAX_VALUE)
      );
      gl_contentPane.setVerticalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
      );
      contentPane.setLayout(gl_contentPane);
      
      this.addWindowListener(new WindowListener()
      {
         
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
         public void windowClosing(WindowEvent e) 
         {
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
      
   }
}