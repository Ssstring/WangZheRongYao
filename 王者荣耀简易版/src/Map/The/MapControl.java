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
	 * 主方法
	 * @param args
	 */
	public static void main(String[] args) {
		basicMap.show(basicMap.map);
		while(true)
		{
			chaozuo=reader.next();
			/**
			 * 加入英雄
			 */
			if(chaozuo.equals("add"))
			{
				Add();
				basicMap.show(basicMap.map);
			}
			/**
			 * 移动英雄
			 */
			else if(chaozuo.equals("move"))
			{
				Move();
				logger.debug("move");
			}
			/**
			 * 使用主动技能
			 */
			else if(chaozuo.equals("activeSkill"))
			{
				ActiveSkill();
			}
			/**
			 * 使用被动技能
			 */
			else if(chaozuo.equals("passiveSkill"))
			{
				PassiveSkill();
			}
			Die();
		}
	}
	/**
	 * 判断是否死亡
	 */
	public static void Die() {
		for(int i=0;i<heros.size();i++)
		{
			logger.debug(heros.get(i).getHeroName()+"HP="+heros.get(i).att.HP);
			if(heros.get(i).att.HP<=0)
			{
				System.out.println(heros.get(i).getHeroName()+"死亡");
				basicMap.map[heros.get(i).pos.x][heros.get(i).pos.y]="0";
				heros.remove(i);
			}
		}
	}
	/**
	 * 增加英雄方法
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
	 * 英雄移动方法
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
	 * 主动技能方法
	 */
	public static void ActiveSkill() {
		num=reader.nextInt();
		heros.get(num).activeSkill(basicMap.map);
		logger.debug(heros.get(num).getHeroName()+"use active skill");
	}
	/**
	 * 被动技能方法
	 */
	public static void PassiveSkill() {
		num=reader.nextInt();
		heros.get(num).passiveSkill(basicMap.map);
		logger.debug(heros.get(num).getHeroName()+"use passive skill");
	}
}
