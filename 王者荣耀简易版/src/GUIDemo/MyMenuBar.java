package GUIDemo;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * TODO: Add action listener<br/>
 * TODO: Prettify the menuItem by using createMenuItem Button<br/>
 * TODO: Add mouse listener<br/>
 * @author String
 *
 */
public class MyMenuBar extends JMenuBar {

	public MyMenuBar() {
		createMenuBar();
	}
	
	public void createMenuBar() {
		JMenu menu;
		JMenuItem menuItem;
		this.setLayout(new FlowLayout(40, 4, 0));
		
		menu=new JMenu("�ļ�(F)");
		menu.setMnemonic(KeyEvent.VK_F);
		this.add(menu);
		
		menuItem=new JMenuItem("����Ϸ(N)");
//		menuItem=createMenu("����Ϸ(N)", "");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("newGame");
//		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem=new JMenuItem("�ر�(C)");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("close");
//		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menu=new JMenu("����(H)");
		menu.setMnemonic(KeyEvent.VK_H);
//		menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		this.add(menu);
		
		menuItem=new JMenuItem("����(A)");
		menuItem.setMnemonic(KeyEvent.VK_A);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		menu.add(menuItem);
	}
	
	private JMenuItem createMenu(String text,String icon)
	{
		ImageIcon ii=new ImageIcon(icon);
		ii.getImage();
		Image temp=ii.getImage().getScaledInstance(20,-1,Image.SCALE_DEFAULT);
		ii=new ImageIcon(temp);
//		menuBar.add(new JButton("File",ii));
		JMenuItem btn = new JMenuItem(text, ii);
//		btn.setUI(new BasicButtonUI());// �ָ������Ӿ�Ч��
//		btn.setPreferredSize(new Dimension(80, 27));// ���ð�ť��С
//		btn.setContentAreaFilled(false);// ���ð�ť͸��
//		btn.setFont(new Font("����", Font.PLAIN, 15));// ��ť�ı���ʽ
//		btn.setMargin(new Insets(0, 0, 0, 0));// ��ť������߿����
		
//		btn.addMouseListener(new MyMouseListener(this));//TODO ����¼�
		
		return btn;
	}
	
	
}
