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
		
		menu=new JMenu("文件(F)");
		menu.setMnemonic(KeyEvent.VK_F);
		this.add(menu);
		
		menuItem=new JMenuItem("新游戏(N)");
//		menuItem=createMenu("新游戏(N)", "");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("newGame");
//		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem=new JMenuItem("关闭(C)");
		menuItem.setMnemonic(KeyEvent.VK_C);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		menuItem.setActionCommand("close");
//		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menu=new JMenu("帮助(H)");
		menu.setMnemonic(KeyEvent.VK_H);
//		menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		this.add(menu);
		
		menuItem=new JMenuItem("关于(A)");
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
//		btn.setUI(new BasicButtonUI());// 恢复基本视觉效果
//		btn.setPreferredSize(new Dimension(80, 27));// 设置按钮大小
//		btn.setContentAreaFilled(false);// 设置按钮透明
//		btn.setFont(new Font("粗体", Font.PLAIN, 15));// 按钮文本样式
//		btn.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
		
//		btn.addMouseListener(new MyMouseListener(this));//TODO 鼠标事件
		
		return btn;
	}
	
	
}
