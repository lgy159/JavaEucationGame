package oops;

import oops.step.FourStep;
import oops.step.OneStep;
import oops.step.ThreeStep;
import oops.step.TwoStep;

public class User {

   public User(Login login) {
      this.login = login;
      // TODO Auto-generated constructor stub
   }

   private OneStep onestep;
   private TwoStep twostep;
   private ThreeStep threestep;
   private FourStep fourstep;
   private Store store;
   private String user;
   private int lifenum;
   private int hintnum;
   private int coin;
   private Login login;

   public void step(OneStep onestep) {
      this.onestep = onestep;
   }

   public void step(TwoStep twostep) {
      this.twostep = twostep;
   }

   public void step(ThreeStep threestep) {
      this.threestep = threestep;
   }

   
   public void step(FourStep fourstep) {
      this.fourstep = fourstep;
   }

   public int score() {
      int score_int = onestep.getScore();
      if (twostep != null)
         score_int = score_int + twostep.getScore();
      if (threestep != null)
         score_int = score_int + threestep.getScore();
      if (fourstep != null)
         score_int = score_int + fourstep.getScore();

      return score_int;
   }


   public void setCoin(int co) {
	      this.coin = co;
	   }
   public int getCoin(int num){
	   this.coin=this.coin+num;
	   return coin;
   }
   

   public int getHintnum() {
      return hintnum;
   }

   public void setHintnum(int hintnum) {
      this.hintnum = hintnum;
   }

   public String user() {
      user = login.getId();
      return user;
   }

   public void setlifenum(int num) {
      this.lifenum = num;
   }

   public int lifenum(int num) {
      lifenum = lifenum + num;
      return lifenum;
   }
   
   
   

}