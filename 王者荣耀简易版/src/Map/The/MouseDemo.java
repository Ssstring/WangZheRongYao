package Map.The;

import Map.The.MapControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
public class MouseDemo
{
    //定义该图形中所需的组件的引用
    private Frame f;
    private Button bt; 
    
    //方法
   MouseDemo()//构造方法
    {
        madeFrame();
    }
    
    public void madeFrame()
    {
        f = new Frame("王者荣耀——简易版");
        
        //对Frame进行基本设置。
        f.setBounds(300,100,1200,1000);//对框架的位置和大小进行设置
        f.setLayout(null);//设计布局
        
        bt = new Button("开始游戏");
        bt.setBounds(500, 400, 200, 200);
        bt.setFont(new Font("宋体", Font.PLAIN, 40));
        //将组件添加到Frame中
        f.add(bt);
        
        //加载一下窗体上的事件
        myEvent();
        
        //显示窗体
        f.setVisible(true);
    }
    
    private void myEvent()
    {
        f.addWindowListener(new WindowAdapter()//窗口监听
        {
            public void windowClosing(WindowEvent e)
            {
                System.out.println("游戏关闭");
                System.exit(0);
            }
        });

        bt.addActionListener(new ActionListener()//按钮监听
        {
            public void actionPerformed(ActionEvent e)
            {
                 System.out.println("游戏结束");
            }
        });
        bt.addMouseListener(new MouseAdapter()//鼠标监听
        {
            private int count = 1; 
            private int mouseCount = 1;
            public void mouseClicked(MouseEvent e)
            {
            	System.out.println("游戏开始");

            	MapControl m=new MapControl();
            	try {
					m.main(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
    
    public static void main(String[] agrs)
    {
        new MouseDemo();
    }
}