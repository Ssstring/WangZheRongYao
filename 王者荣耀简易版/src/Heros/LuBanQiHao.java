package Heros;

import java.util.Scanner;

import com.sun.swing.internal.plaf.basic.resources.basic;

import Character.*;
import Map.The.BasicMap;
import Map.The.MapAttachments;
import Map.The.MapControl;
/**
 * 鲁班七号的类
 * @author String
 *
 */
public class LuBanQiHao extends Hero implements Skill,Robot,Runnable {
	
	private Attribute att=new Attribute(500,500,0);
	public int attack=50;
	public Position pos;
	
	public LuBanQiHao(String name,Position pos) {
		// TODO Auto-generated constructor stub
		super.setHeroName(name);
		this.pos=pos;
	}
	
	/**
	 * 主动技能，传送技能
	 */
	@Override
	public void activeSkill(BasicMap map) {
		// TODO Auto-generated method stub
		int x,y;
		Scanner reader=new Scanner(System.in);
		x=reader.nextInt();
		y=reader.nextInt();
		map.map[pos.x][pos.y]="0";
		map.map[x][y]=this.getHeroName();
	}
	/**
	 * 被动技能
	 */
	@Override
	public void passiveSkill(BasicMap map) {
		// TODO Auto-generated method stub
		this.att.HP+=10;
	}
	/**
	 * 移动方法
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
	 * 普通攻击
	 */
	@Override
	public void normalAttack(Hero hero) {
		// TODO Auto-generated method stub
		hero.getAttribute().HP-=super.getAttack();
		System.out.println(super.getHeroName()+"对"+hero.getHeroName()+"造成了"+super.getAttack()+"点伤害");
	}
	/**
	 * 线程run方法
	 */
	@Override
	public void run() {
		for(int i=0;i<100;i++)
			action(MapControl.basicMap);
	}
	/**
	 * 机器人应该作出的操作
	 */
	@Override
	public void action(BasicMap map) {
		// TODO Auto-generated method stub
		Position pos1=judgePos(MapControl.basicMap);
		if(Math.random()>0.1)
		{
			RobotMove(pos1);
		}
		else {
			robotActiveSkill(pos1);
			MapControl.logger.debug("Robot LuBan use skill");
		}
	}
	/**
	 * 机器人的主动技能
	 * @param pos1
	 */
	public void robotActiveSkill(Position pos1)
	{
		if(Math.random()<0.25&&pos1.x-1>0)
		{
			MapControl.basicMap.map[pos.x][pos.y]="0";
			MapControl.basicMap.map[pos1.x-1][pos1.y]=this.getHeroName();
		}
		else if(Math.random()<0.5&&pos1.x+1<20)
		{
			MapControl.basicMap.map[pos.x][pos.y]="0";
			MapControl.basicMap.map[pos1.x+1][pos1.y]=this.getHeroName();
		}
		else if(Math.random()<0.75&&pos1.y-1>0)
		{
			MapControl.basicMap.map[pos.x][pos.y]="0";
			MapControl.basicMap.map[pos1.x][pos1.y-1]=this.getHeroName();
		}
		else if(pos1.y+1<20)
		{
			MapControl.basicMap.map[pos.x][pos.y]="0";
			MapControl.basicMap.map[pos1.x][pos1.y+1]=this.getHeroName();
		}
	}
	/**
	 * 机器人的移动方法，产生随机移动
	 * @param pos1
	 */
	public void RobotMove(Position pos1)
	{
		int flag=0;
		if(Math.random()>0.5)
		{
			if(this.pos.x<pos1.x&&this.pos.x<20&&MapControl.basicMap.map[this.pos.x+1][this.pos.y]=="0")
			{
				this.move("down");
				flag=1;
				MapControl.logger.debug("Robot move down");
			}
			else if(this.pos.x>pos1.x&&this.pos.x>0&&MapControl.basicMap.map[this.pos.x-1][this.pos.y]=="0")
			{
				this.move("up");
				flag=1;
				MapControl.logger.debug("Robot move up");
			}
		}
		else 
		{
			if(this.pos.y<=pos1.y&&this.pos.y<20&&MapControl.basicMap.map[this.pos.x][this.pos.y+1]=="0")
			{
				this.move("right");
				flag=1;
				MapControl.logger.debug("Robot move left");
			}
			else if(this.pos.y>pos1.y&&this.pos.y>0&&MapControl.basicMap.map[this.pos.x][this.pos.y-1]=="0")
			{
				this.move("left");
				flag=1;
				MapControl.logger.debug("Robot move left");
			}
		}
	}
}
