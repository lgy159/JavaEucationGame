package oops.step;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Hint {

	private int index;
	private ArrayList<String> hints;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		if (index < 0)
			System.out.println("Error!");
		this.index = index;
	}

	public ArrayList<String> getHints() {
		return hints;
	}

	public void setHints(ArrayList<String> hints) {
		if(hints==null)
			System.out.println("error!");
		this.hints = hints;
	}

	public Hint(){
		try {
			hints = new ArrayList<String>();
			File myFile = new File("hint.txt");
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				hints.add(line);
			}
			setHints(hints);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
