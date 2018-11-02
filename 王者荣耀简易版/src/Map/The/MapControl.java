package Map.The;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Character.*;
import Heros.*;


public class MapControl  {
//	public static File file=new File("scores.txt");
	public static ArrayList<Hero> heros=new ArrayList<>();
	public static BasicMap basicMap=new BasicMap();
	public static String chaozuo,name,heroType;
	public static int x,y,num;
	public static Logger logger = LogManager.getLogger(MapControl.class);
	/**
	 * 主方法
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		File file=new File("scores.txt");
		Scanner reader=new Scanner(file);
		if(!file.exists())
			try (PrintWriter output = new PrintWriter(file);) {
			
			}
		basicMap.show(basicMap.map);
		while(true)
		{
			chaozuo=reader.next();
			/**
			 * 加入英雄
			 */
			if(chaozuo.equals("add"))
			{
				heroType=reader.next();
				name=reader.next();
				x=reader.nextInt();
				y=reader.nextInt();
				Add(heroType,name,x,y);
				basicMap.show(basicMap.map);
			}
			/**
			 * 移动英雄
			 */
			else if(chaozuo.equals("move"))
			{
				num=reader.nextInt();
				String direction=reader.next();
				Move(num,direction);
				logger.debug("move");
			}
			/**
			 * 使用主动技能
			 */
			else if(chaozuo.equals("activeSkill"))
			{
				num=reader.nextInt();
				ActiveSkill(num);
			}
			/**
			 * 使用被动技能
			 */
			else if(chaozuo.equals("passiveSkill"))
			{
				num=reader.nextInt();
				PassiveSkill(num);
			}
			else if(chaozuo.equals("end"))
				break;
//			Die();
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
	public static void Add(String heroType,String name,int x,int y)
	{
//		heroType=reader.next();
//		name=reader.next();
//		x=reader.nextInt();
//		y=reader.nextInt();
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
	public static void Move(int num,String direction)
	{
//		num=reader.nextInt();
//		String direction=reader.next();
		basicMap.map[heros.get(num).pos.x][heros.get(num).pos.y]="0";
		heros.get(num).move(direction);
		basicMap.map[heros.get(num).pos.x][heros.get(num).pos.y]=heros.get(num).getHeroName();
		logger.debug("move to pos("+heros.get(num).pos.x+","+heros.get(num).pos.y+")");
		basicMap.show(basicMap.map);
	}
	/**
	 * 主动技能方法
	 */
	public static void ActiveSkill(int num) {
//		num=reader.nextInt();
		heros.get(num).activeSkill(basicMap.map);
		logger.debug(heros.get(num).getHeroName()+"use active skill");
	}
	/**
	 * 被动技能方法
	 */
	public static void PassiveSkill(int num) {
//		num=reader.nextInt();
		heros.get(num).passiveSkill(basicMap.map);
		logger.debug(heros.get(num).getHeroName()+"use passive skill");
	}
}
