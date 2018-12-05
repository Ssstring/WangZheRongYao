package GUIDemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;


public class BattleField extends JPanel implements Runnable, KeyListener{
	
	private static final int	HEIGHT	= 720;
	private static final int	WEIGHT	= 1024;
	
	
	public BattleField() {
		setSize(WEIGHT, HEIGHT);
		setBorder(new SoftBevelBorder(1, Color.white, Color.white));
		// Sets the focusable state of this Component to the specified value.
		// This value overrides the Component's default focusability.
		setFocusable(true);
		// ¼àÌýÊÂ¼þ
		addKeyListener(this);
		new Thread(this).start();
		JLabel hero[] = new JLabel[10];
		Image icon = getToolkit().getImage("./images/¿ÙÍ¼°æºóôà.png");
		icon=icon.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		hero[0] = new JLabel(new ImageIcon(icon));
		hero[0].setBounds(60,120,37,36);
		this.add(hero[0]);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		ImageIcon icon=new ImageIcon("./images/BattleFieldMap.png");
		Image image=icon.getImage();
		g.drawImage(image,0,0,WEIGHT,HEIGHT,this);
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
