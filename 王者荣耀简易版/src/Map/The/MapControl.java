package Map.The;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.PortableServer.THREAD_POLICY_ID;

import Character.*;
import Heros.*;


public class MapControl implements Runnable {
//	public static File file=new File("scores.txt");
//	public static ArrayList<Hero> basicMap.heros=new ArrayList<Hero>();//���Է���basicmap�У���������˺�
	public static BasicMap basicMap=new BasicMap();
	public static String chaozuo,name,heroType;
	public static int x,y,num;
	public static Logger logger = LogManager.getLogger(MapControl.class);
	/**
	 * �̣߳������ж��������
	 * @param args
	 */
	public void run()
	{
		File file=new File("scores.txt");
		try {
			judge(file);
		} catch (IOException e) {}
	}
	/**
	 * ������
	 * @param args
	 * @throws IOException
	 */
	public static void main(String []args) throws IOException{
		Thread t1=new Thread(basicMap);
		Thread t2=new Thread(new MapControl());
		t1.start();
		t2.start();
	}
	/**
	 * �ж��������
	 * @throws IOException
	 */
	public void judge(File file) throws IOException {
//		File file=new File("scores.txt");
		Scanner reader=new Scanner(file);
		if(!file.exists())
			try (PrintWriter output = new PrintWriter(file);) {
			}
		while(true)
		{
			chaozuo=reader.next();
			/**
			 * ����Ӣ��
			 */
			if(chaozuo.equals("add"))
			{
				String isRobot=reader.next();
				heroType=reader.next();
				name=reader.next();
				x=reader.nextInt();
				y=reader.nextInt();
				Add(heroType,name,x,y);
				if(isRobot.equals("yes"))
				{
					Thread t=new Thread(basicMap.heros.get(basicMap.heros.size()-1));
					t.start();
				}
			}
			/**
			 * �ƶ�Ӣ��
			 */
			else if(chaozuo.equals("move"))
			{
				num=reader.nextInt();
				String direction=reader.next();
				Move(num,direction);
				logger.debug("move");
			}
			/**
			 * ʹ����������
			 */
			else if(chaozuo.equals("activeSkill"))
			{
				num=reader.nextInt();
				ActiveSkill(num);
			}
			/**
			 * ʹ�ñ�������
			 */
			else if(chaozuo.equals("passiveSkill"))
			{
				num=reader.nextInt();
				PassiveSkill(num);
			}
			else if(chaozuo.equals("end"))
				break;
			Die();
			try{Thread.sleep(1000);}
			catch(InterruptedException e){}
		}
	}
	/**
	 * �ж��Ƿ�����
	 */
	public static void Die() {
		for(int i=0;i<basicMap.heros.size();i++)
		{
			logger.debug(basicMap.heros.get(i).getHeroName()+"HP="+basicMap.heros.get(i).getAttribute().HP);
			if(basicMap.heros.get(i).getAttribute().HP<=0)
			{
				System.out.println(basicMap.heros.get(i).getHeroName()+"����");
				basicMap.map[basicMap.heros.get(i).pos.x][basicMap.heros.get(i).pos.y]="0";
				basicMap.heros.remove(i);
			}
		}
	}
	/**
	 * ����Ӣ�۷���
	 */
	public static void Add(String heroType,String name,int x,int y)
	{
		if(heroType.equals("HouYi"))
		{
			basicMap.heros.add(new HouYi(name, new Position(x, y)));
			basicMap.map[x][y]=name;
		}
		else if(heroType.equals("LuBanQiHao"))
		{
			basicMap.heros.add(new LuBanQiHao(name, new Position(x, y)));
			basicMap.map[x][y]=name;
		}
		logger.debug("add "+heroType+"pos("+x+","+y+")");
	}
	/**
	 * Ӣ���ƶ�����
	 */
	public static void Move(int num,String direction)
	{
		basicMap.heros.get(num).move(direction);
		logger.debug("move to pos("+basicMap.heros.get(num).pos.x+","+basicMap.heros.get(num).pos.y+")");
	}
	/**
	 * �������ܷ���
	 */
	public static void ActiveSkill(int num) {
		basicMap.heros.get(num).activeSkill(basicMap);
		logger.debug(basicMap.heros.get(num).getHeroName()+" use active skill");
	}
	/**
	 * �������ܷ���
	 */
	public static void PassiveSkill(int num) {
		basicMap.heros.get(num).passiveSkill(basicMap);
		logger.debug(basicMap.heros.get(num).getHeroName()+"use passive skill");
	}
}
