package oops.step;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import oops.BackSound;
import oops.Clock;
import oops.User;

public abstract class Step extends JFrame {

	abstract public int getScore();
	abstract public void setSound(BackSound Sound);
	abstract public void setSound(boolean start);
	abstract public void showlife(int num, ArrayList<JLabel> imageArray,User user);
    abstract public void setClock(Clock clock);
    abstract public Clock getClock();
   
}
