package GUIDemo;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

import Map.The.MapControl;

//import Map.The.MyMouseListener;

import java.awt.event.*;
import java.io.IOException;

public class ChooseHeroAndMapDemo implements ActionListener {
	static JFrame frame;
	
	private void setLookAndFeel() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JPanel createPane() {
		JLabel background;
		JButton heroA,heroB,startGame;
		
		JPanel panel=new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				ImageIcon icon=new ImageIcon("./images/wzry.png");
				Image image=icon.getImage();
				g.drawImage(image,0,0,frame.getWidth(),frame.getHeight(),this);
			}
		};
		panel.setLayout(null);
		
		heroA=new JButton("后羿");
		heroA.setBounds(60,120,100,40);
		heroA.setActionCommand("addHouYi");
		heroA.addActionListener(this);
		panel.add(heroA);
		
		heroB=new JButton("鲁班七号");
		heroB.setBounds(60,180,100,40);
		heroB.setActionCommand("addLuBan");
		heroB.addActionListener(this);
		panel.add(heroB);
		
		startGame=new JButton("开始游戏");
		startGame.setBounds(60,240,100,40);
		startGame.setActionCommand("startGame");
		startGame.addActionListener(this);
		panel.add(startGame);
		
		return panel;
		
	}
	
	private static void createAndShowGUI() {
		frame=new JFrame("王者荣耀————简易版");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ChooseHeroAndMapDemo demo=new ChooseHeroAndMapDemo();
		demo.setLookAndFeel();
		frame.setContentPane(demo.createPane());
		frame.setJMenuBar(new MyMenuBar());
		
		frame.setSize(1152,700);
		
		frame.setLocation(400, 100);
		
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				createAndShowGUI();
			}
		});
	}

	/**
	 * 该判断方法应该移动到MyMenuBar类中
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str=e.getActionCommand();
		if(str.equals("newGame"))
		{
			MapControl m=new MapControl();
			try {
				m.main(null);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(str.equals("close"))
			frame.dispose();
	}
}