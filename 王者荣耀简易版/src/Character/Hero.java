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
	public int activeSkillHurt;
	public int attackRange;
	public int team;
	
	public Hero() {
		this.att=new Attribute(500, 500, 0);
		this.attack=50;
		this.activeSkillHurt=100;
		attackRange=5;
	}
	
	public Hero(Attribute att,int attack,int activeSkillHure) {
		this.att=att;
		this.attack=attack;
		this.activeSkillHurt=activeSkillHure;
		attackRange=5;
	}
	
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
	 * 普通攻击的方法
	 * TODO:need to judge the attack range and show the attack at the map;
	 * @param hero
	 */
	public void normalAttack(BasicMap map)
	{
		int i;
		char dir;
		Position bpos=new Position(pos.x, pos.y);
		i=judgeEnemyPos(map);
		
		if(i!=-1)
		{
			dir=getDirection(map.heros.get(i).pos);
			switch (dir) {
			case 'q':
				while(bpos.x!=map.heros.get(i).pos.x&&map.heros.get(i).pos.y!=bpos.y)
				{
					bpos.x--;
					bpos.y--;
					map.map[bpos.x][bpos.y]="9";
				}
				break;
			case 'e':
				while(bpos.x!=map.heros.get(i).pos.x&&map.heros.get(i).pos.y!=bpos.y)
				{
					bpos.x--;
					bpos.y++;
					map.map[bpos.x][bpos.y]="9";
				}
				break;
			case 'z':
				while(bpos.x!=map.heros.get(i).pos.x&&map.heros.get(i).pos.y!=bpos.y)
				{
					bpos.x++;
					bpos.y--;
					map.map[bpos.x][bpos.y]="9";
				}
				break;
			case 'c':
				while(bpos.x!=map.heros.get(i).pos.x&&map.heros.get(i).pos.y!=bpos.y)
				{
					bpos.x++;
					bpos.y++;
					map.map[bpos.x][bpos.y]="9";
				}
				break;
			default:
				break;
			}
			if(bpos.x==map.heros.get(i).pos.x)
			{
				while(bpos.y + 1 < map.heros.get(i).pos.y)
				{
					
				}
			}
		}
			
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
	 * TODO:应该返回敌方英雄
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
	/**
	 * 返回在视野范围内的最近的敌方英雄在heros中的序号
	 * @param map
	 * @return
	 */
	public int judgeEnemyPos(BasicMap map) {
		int posx=99,posy=99;
		int k=-1;
		for(int i=0;i<map.heros.size();i++)
		{
			if(Math.pow((map.heros.get(i).pos.y-this.pos.y), 2)
					+Math.pow((map.heros.get(i).pos.x-this.pos.x), 2)
					<Math.pow((posx-this.pos.x)+Math.abs(posy-this.pos.y), 2)
					&&map.heros.get(i).team!=this.team)
			{
				posx=map.heros.get(i).pos.x;
				posy=map.heros.get(i).pos.y;
				k=i;
			}
		}
		return k;
	}
	
	public char getDirection(Position pos)
	{
		char dir;
		if(pos.x < this.pos.x)
		{
			if(pos.y < this.pos.y)
				dir='q';
			else if(pos.y > this.pos.y)
				dir='e';
			else dir='u';
		}
		else if(pos.x > this.pos.x)
		{
			if(pos.y < this.pos.y)
				dir='z';
			else if(pos.y > this.pos.y)
				dir='c';
			else dir='d';
		}
		else {
			if(pos.y < this.pos.y)
				dir='l';
			else dir='r';
		}
		return dir;
	}
}
