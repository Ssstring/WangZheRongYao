package Character;

import Heros.Robot;
import Map.The.BasicMap;
import Map.The.MapControl;

/**
 * 英雄的抽象类
 * @author String
 *
 */
public abstract class Hero implements Skill,Runnable,Robot{
	private String heroName;
	private Attribute att;
	private int attack;
	public Position pos;
	/**
	 * 设置英雄的名字，在本程序中，英雄名字在地图上出现
	 * @param heroName
	 */
	public void setHeroName(String heroName)
	{
		this.heroName=heroName;
	}
	/**
	 * 返回英雄的名字
	 * @return heroName
	 */
	public String getHeroName() {
		return heroName;
	}
	/**
	 * 设置英雄属性
	 * @param att
	 */
	public void setAttribute(Attribute att)
	{
		this.att=att;
	}
	/**
	 * 得到英雄属性
	 * @return
	 */
	public Attribute getAttribute()
	{
		return att;
	}
	/**
	 * 设置英雄攻击力
	 * @param atk
	 */
	public void setAttack(int atk)
	{
		this.attack=atk;
	}
	public void hurt(int h)
	{
		this.att.HP-=h;
	}
	/**
	 * 返回英雄攻击力
	 * @return
	 */
	public int getAttack()
	{
		return this.attack;
	}
	/**
	 * 普通攻击的抽象方法
	 * @param hero
	 */
	public void normalAttack(Hero hero)
	{
		hero.getAttribute().HP-=this.getAttack();
		System.out.println(this.getHeroName()+"对"+hero.getHeroName()+"造成了"+this.getAttack()+"点伤害");
	}
	/**
	 * hero中的移动方法
	 * @param direction
	 */
	public void move(String direction)
	{
		MapControl.basicMap.map[this.pos.x][this.pos.y]="0";
		if(direction.equals("up"))
			pos.x--;
		else if(direction.equals("down"))
			pos.x++;
		else if(direction.equals("left"))
			pos.y--;
		else if(direction.equals("right"))
			pos.y++;
		MapControl.basicMap.map[this.pos.x][this.pos.y]=this.getHeroName();
	}
	@Override
	public void run() {}
	/**
	 * 扫描地图，返回与该英雄最近的英雄
	 * @param map
	 * @return
	 */
	@Override
	public Position judgePos(BasicMap map) {
		int posx=99,posy=99;
		
		for(int i=0;i<map.heros.size();i++)
		{
			if(Math.abs(map.heros.get(i).pos.y-this.pos.y)
					+Math.abs(map.heros.get(i).pos.x-this.pos.x)
					<Math.abs(posx-this.pos.x)+Math.abs(posy-this.pos.y)
					&&!map.heros.get(i).getHeroName().equals(this.getHeroName()))
			{
				posx=map.heros.get(i).pos.x;
				posy=map.heros.get(i).pos.y;
			}
		}
		return new Position(posx, posy);
	}
}
