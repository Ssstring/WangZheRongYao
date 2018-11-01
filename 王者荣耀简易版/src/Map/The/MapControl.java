package Map.The;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import Character.*;
import Heros.*;


public class MapControl {
	public static ArrayList<Hero> heros=new ArrayList<>();
	public static BasicMap basicMap=new BasicMap();
	public static Scanner reader=new Scanner(System.in);
	public static String chaozuo,name,heroType;
	public static int x,y,num;
	public static Logger logger = LogManager.getLogger(MapControl.class);
	/**
	 * ������
	 * @param args
	 */
	public static void main(String[] args) {
		basicMap.show(basicMap.map);
		while(true)
		{
			chaozuo=reader.next();
			/**
			 * ����Ӣ��
			 */
			if(chaozuo.equals("add"))
			{
				Add();
				basicMap.show(basicMap.map);
			}
			/**
			 * �ƶ�Ӣ��
			 */
			else if(chaozuo.equals("move"))
			{
				Move();
				logger.debug("move");
			}
			/**
			 * ʹ����������
			 */
			else if(chaozuo.equals("activeSkill"))
			{
				ActiveSkill();
			}
			/**
			 * ʹ�ñ�������
			 */
			else if(chaozuo.equals("passiveSkill"))
			{
				PassiveSkill();
			}
			Die();
		}
	}
	/**
	 * �ж��Ƿ�����
	 */
	public static void Die() {
		for(int i=0;i<heros.size();i++)
		{
			logger.debug(heros.get(i).getHeroName()+"HP="+heros.get(i).att.HP);
			if(heros.get(i).att.HP<=0)
			{
				System.out.println(heros.get(i).getHeroName()+"����");
				basicMap.map[heros.get(i).pos.x][heros.get(i).pos.y]="0";
				heros.remove(i);
			}
		}
	}
	/**
	 * ����Ӣ�۷���
	 */
	public static void Add()
	{
		heroType=reader.next();
		name=reader.next();
		x=reader.nextInt();
		y=reader.nextInt();
		if(heroType.equals("HouYi"))
		{
			heros.add(new HouYi(name, new Position(x, y)));
			basicMap.map[x][y]=name;
		}
		else if(heroType.equals("LuBanQiHao"))
		{
			heros.add(new LuBanQiHao(name, new Position(x, y)));
			basicMap.map[x][y]=name;
		}
		logger.debug("add "+heroType+"pos("+x+","+y+")");
	}
	/**
	 * Ӣ���ƶ�����
	 */
	public static void Move()
	{
		num=reader.nextInt();
		String direction=reader.next();
		basicMap.map[heros.get(num).pos.x][heros.get(num).pos.y]="0";
		heros.get(num).move(direction);
		basicMap.map[heros.get(num).pos.x][heros.get(num).pos.y]=heros.get(num).getHeroName();
		logger.debug("move to pos("+heros.get(num).pos.x+","+heros.get(num).pos.y+")");
		basicMap.show(basicMap.map);
	}
	/**
	 * �������ܷ���
	 */
	public static void ActiveSkill() {
		num=reader.nextInt();
		heros.get(num).activeSkill(basicMap.map);
		logger.debug(heros.get(num).getHeroName()+"use active skill");
	}
	/**
	 * �������ܷ���
	 */
	public static void PassiveSkill() {
		num=reader.nextInt();
		heros.get(num).passiveSkill(basicMap.map);
		logger.debug(heros.get(num).getHeroName()+"use passive skill");
	}
}
