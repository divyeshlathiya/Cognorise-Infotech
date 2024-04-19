package myscientificcalc;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		ScientificCalc sciCalcObj = new ScientificCalc();
		sciCalcObj.setSize(500,600);
		sciCalcObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sciCalcObj.setVisible(true);

	}

}
