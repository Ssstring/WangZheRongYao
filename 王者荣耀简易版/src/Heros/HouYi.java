package Heros;

import Character.*;
import Map.The.MapAttachments;
/**
 * 一个具体的英雄：后羿
 * @author String
 * @version 1.2
 * @since JDK 1.8
 *
 */
public class HouYi extends Hero implements Skill,MapAttachments {
	/** 设置基本属性*/
	private Attribute att=new Attribute(500,500,0);
	/**攻击力，值为50 */
	public int attack=50;
	/**
	 * 构造方法
	 * @param name
	 * @param pos
	 */
	public HouYi(String name,Position pos){
		super.setAttribute(att);
		super.setHeroName(name);
		this.pos=pos;
	}
	/**
	 * 继承的普通攻击
	 * {@inheritDoc}
	 */
	@Override
		public void normalAttack(Hero hero) {
			// TODO Auto-generated method stub
			hero.att.MP-=attack;
			System.out.println(super.getHeroName()+"对"+hero.getHeroName()+"造成了"+this.attack+"点伤害");
		}
	/**
	 *主动技能，发射一条线，对敌人造成伤害
	 * {@inheritDoc}
	 */
	@Override
		public void activeSkill(String[][] map) {
			// TODO Auto-generated method stub
			String[][] tempMap=new String[20][20];
			for(int i=0;i<20;i++)
				System.arraycopy(map[i], 0, tempMap[i], 0, map.length);
			for(int i=pos.y+1;i<20;i++)
			{
				if(map[pos.x][i]=="1")
					break;
				tempMap[pos.x][i]="~";
				show(tempMap);
				if(map[pos.x][i]!="0")
				{
					tempMap[pos.x][i]=map[pos.x][i];
					System.out.println(super.getHeroName()+"对"+map[pos.x][i]+"造成了"+this.attack+"点伤害");
				}
				else tempMap[pos.x][i]="0";	
			}
		}
	/**
	 * 接口的被动技能
	 * {@inheritDoc}
	 */
	@Override
		public void passiveSkill(String[][] map) {
			// TODO Auto-generated method stub
			this.attack++;
		}
	/**
	 * 移动方法
	 * @param direction
	 */
	@Override
	public void move(String direction) {
		// TODO Auto-generated method stub
		if(direction.equals("up"))
			pos.x--;
		else if(direction.equals("down"))
			pos.x++;
		else if(direction.equals("left"))
			pos.y--;
		else if(direction.equals("right"))
			pos.y++;
	}
	/**
	 * 用于技能展示
	 * @param map
	 */
	@Override
	public void show(String[][] map)
	{
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
}
