package Map.The;

import Map.The.MapControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
public class MouseDemo
{
    //�����ͼ������������������
    private Frame f;
    private Button bt; 
    
    //����
   MouseDemo()//���췽��
    {
        madeFrame();
    }
    
    public void madeFrame()
    {
        f = new Frame("������ҫ�������װ�");
        
        //��Frame���л������á�
        f.setBounds(300,100,1200,1000);//�Կ�ܵ�λ�úʹ�С��������
        f.setLayout(null);//��Ʋ���
        
        bt = new Button("��ʼ��Ϸ");
        bt.setBounds(500, 400, 200, 200);
        bt.setFont(new Font("����", Font.PLAIN, 40));
        //�������ӵ�Frame��
        f.add(bt);
        
        //����һ�´����ϵ��¼�
        myEvent();
        
        //��ʾ����
        f.setVisible(true);
    }
    
    private void myEvent()
    {
        f.addWindowListener(new WindowAdapter()//���ڼ���
        {
            public void windowClosing(WindowEvent e)
            {
                System.out.println("��Ϸ�ر�");
                System.exit(0);
            }
        });

        bt.addActionListener(new ActionListener()//��ť����
        {
            public void actionPerformed(ActionEvent e)
            {
                 System.out.println("��Ϸ����");
            }
        });
        bt.addMouseListener(new MouseAdapter()//������
        {
            private int count = 1; 
            private int mouseCount = 1;
            public void mouseClicked(MouseEvent e)
            {
            	System.out.println("��Ϸ��ʼ");

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