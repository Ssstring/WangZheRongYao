package Heros;

import Character.*;
import Map.The.BasicMap;
import Map.The.MapControl;
/**
 * 一个具体的英雄：后羿
 * @author String
 * @version 1.2
 * @since JDK 1.8
 *
 */
public class HouYi extends Hero {
	/**
	 * 设置主动技能伤害，ps：此处可以用数组来存储伤害，为英雄等级提升做准备
	 */
	private int activeSkillHurt=100;
	/**
	 * 构造方法，用于初始化英雄名字，属性，攻击力，位置
	 * @param name
	 * @param pos
	 */
	public HouYi(String name,Position pos){
		super.setAttribute(new Attribute(500,500,0));
		super.setHeroName(name);
		super.setAttack(50);
		super.pos=pos;
	}
	/**
	 *主动技能，发射一条线，对敌人造成伤害
	 *!!!线程应考虑进去，每一秒展示？？？
	 * {@inheritDoc}
	 */
	@Override
		public synchronized void activeSkill(BasicMap map) {
			String[][] tempMap=new String[20][20];
			for(int i=0;i<20;i++)
				System.arraycopy(map.map[i], 0, tempMap[i], 0, map.map.length);
			for(int i=pos.y+1,k=0;i<20&&k<3;i++,k++)
			{
//				if(tempMap[pos.x][i]=="1")
//					break;
				map.map[pos.x][i]="~";
				//此处英雄技能伤害范围判断？
				if(tempMap[pos.x][i]!="0")
				{
					int j;
					for(j=0;j<map.heros.size();j++)
						if(map.heros.get(j).pos.x==pos.x&&map.heros.get(j).pos.y==i)
							break;
					map.heros.get(j).hurt(activeSkillHurt);
					System.out.println(super.getHeroName()+"对"+map.map[pos.x][i]+"造成了"+activeSkillHurt+"点伤害");
				}
//				else map.map[pos.x][i]="0";	
			}
			try{Thread.sleep(1000);}
			catch(InterruptedException e) {}
			for(int i=0;i<20;i++)
				System.arraycopy(tempMap[i], 0, map.map[i], 0, map.map.length);
		}
	/**
	 * 接口的被动技能
	 * {@inheritDoc}
	 */
	@Override
		public void passiveSkill(BasicMap map) {
			super.setAttack(super.getAttack()+1);
		}
	/**
	 * 移动方法
	 * @param direction
	 */
	@Override
	public void move(String direction) {
		// TODO Auto-generated method stub
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
	/**
	 * 线程run方法
	 */
	@Override
	public void run() {
		for(int i=0;i<100;i++)
		{
			this.action(MapControl.basicMap);
		}
	}
	
	/**
	 * 机器人应该作出的操作
	 */
	@Override
	public void action(BasicMap map) {
		Position pos1=judgePos(MapControl.basicMap);
		if(this.pos.x==pos1.x)
		{
			if(Math.random()>0.5)
			{
				this.activeSkill(map);
				MapControl.logger.debug("Robot HouYi use skill");
			}
			else this.RobotMove(pos1);
		}
		else this.RobotMove(pos1);
		
		try{Thread.sleep(1000);}
		catch(InterruptedException e) {}
	}
	
	/**
	 * 机器人的移动方法，主要是用于产生随机移动
	 * @param pos1
	 */
	public void RobotMove(Position pos1)
	{
		int flag=0;//记录是否移动
		if(Math.random()>0.5)
		{
			if(this.pos.x<=pos1.x&&this.pos.x>1&&MapControl.basicMap.map[this.pos.x-1][this.pos.y]=="0")
			{
				this.move("up");
				flag=1;
				MapControl.logger.debug("Robot move up");
			}
			else if(this.pos.x>pos1.x&&this.pos.x<19&&MapControl.basicMap.map[this.pos.x+1][this.pos.y]=="0")
			{
				this.move("down");
				flag=1;
				MapControl.logger.debug("Robot move down");
			}
		}
		else 
		{
			if(this.pos.y<=pos1.y&&this.pos.y>1&&MapControl.basicMap.map[this.pos.x][this.pos.y-1]=="0")
			{
				this.move("left");
				flag=1;
				MapControl.logger.debug("Robot move left");
			}
			else if(this.pos.y>pos1.y&&this.pos.y<19&&MapControl.basicMap.map[this.pos.x][this.pos.y+1]=="0")
			{
				this.move("right");
				flag=1;
				MapControl.logger.debug("Robot move right");
			}
		}
		
	}
}
