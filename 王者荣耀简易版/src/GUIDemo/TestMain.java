package GUIDemo;

import javax.swing.JFrame;

public class TestMain extends JFrame {
	BattleField panel=new BattleField();
	public TestMain() {
		// TODO Auto-generated constructor stub
		setSize(panel.getWidth(), panel.getHeight());
		getContentPane().add(panel);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
	}
	public static void main(String args[]) {
		new TestMain();
	}
}
