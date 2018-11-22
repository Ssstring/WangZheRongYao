package Heros;

import org.junit.rules.TestName;

import com.sun.swing.internal.plaf.basic.resources.basic;

import Character.*;
import Map.The.BasicMap;
import Map.The.MapAttachments;
import Map.The.MapControl;
/**
 * һ�������Ӣ�ۣ�����
 * @author String
 * @version 1.2
 * @since JDK 1.8
 *
 */
public class HouYi extends Hero implements Skill,Runnable,Robot {
	/**
	 * �������������˺���ps���˴��������������洢�˺���ΪӢ�۵ȼ�������׼��
	 */
	private int activeSkillHurt=100;
	/**
	 * ���췽�������ڳ�ʼ��Ӣ�����֣����ԣ���������λ��
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
	 * �̳е���ͨ����
	 * {@inheritDoc}
	 */
	@Override
		public void normalAttack(Hero hero) {
			hero.getAttribute().HP-=super.getAttack();
			System.out.println(super.getHeroName()+"��"+hero.getHeroName()+"�����"+super.getAttack()+"���˺�");
		}
	/**
	 *�������ܣ�����һ���ߣ��Ե�������˺�
	 *!!!�߳�Ӧ���ǽ�ȥ��ÿһ��չʾ������
	 * {@inheritDoc}
	 */
	@Override
		public synchronized void activeSkill(BasicMap map) {
			String[][] tempMap=new String[20][20];
			for(int i=0;i<20;i++)
				System.arraycopy(map.map[i], 0, tempMap[i], 0, map.map.length);
			for(int i=pos.y+1;i<20;i++)
			{
				if(tempMap[pos.x][i]=="1")
					break;
				map.map[pos.x][i]="~";
				try{Thread.sleep(1000);}
				catch(InterruptedException e) {}
//				show(tempMap);
				//�˴�Ӣ�ۼ����˺���Χ�жϣ�
				if(tempMap[pos.x][i]!="0")
				{
					map.map[pos.x][i]=tempMap[pos.x][i];
					int j;
					for(j=0;j<map.heros.size();j++)
						if(map.heros.get(j).pos.x==pos.x&&map.heros.get(j).pos.y==i)
							break;
					map.heros.get(j).hurt(activeSkillHurt);
					System.out.println(super.getHeroName()+"��"+map.map[pos.x][i]+"�����"+activeSkillHurt+"���˺�");
				}
				else map.map[pos.x][i]="0";	
			}
			for(int i=0;i<20;i++)
				System.arraycopy(tempMap[i], 0, map.map[i], 0, map.map.length);
		}
	/**
	 * �ӿڵı�������
	 * {@inheritDoc}
	 */
	@Override
		public void passiveSkill(BasicMap map) {
			super.setAttack(super.getAttack()+1);
		}
	/**
	 * �ƶ�����
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
	 * �߳�run����
	 */
	@Override
	public void run() {
		for(int i=0;i<100;i++)
			this.action(MapControl.basicMap);
	}
	
	/**
	 * ������Ӧ�������Ĳ���
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
	}
	
	/**
	 * �����˵��ƶ���������Ҫ�����ڲ�������ƶ�
	 * @param pos1
	 */
	public void RobotMove(Position pos1)
	{
		int flag=0;//��¼�Ƿ��ƶ�
		if(Math.random()>0.5)
		{
			if(this.pos.x<=pos1.x&&this.pos.x>0&&MapControl.basicMap.map[this.pos.x-1][this.pos.y]=="0")
			{
				this.move("up");
				flag=1;
				MapControl.logger.debug("Robot move up");
			}
			else if(this.pos.x>pos1.x&&this.pos.x<20&&MapControl.basicMap.map[this.pos.x+1][this.pos.y]=="0")
			{
				this.move("down");
				flag=1;
				MapControl.logger.debug("Robot move down");
			}
		}
		else 
		{
			if(this.pos.y<=pos1.y&&this.pos.y>0&&MapControl.basicMap.map[this.pos.x][this.pos.y-1]=="0")
			{
				this.move("left");
				flag=1;
				MapControl.logger.debug("Robot move left");
			}
			else if(this.pos.y>pos1.y&&this.pos.y<20&&MapControl.basicMap.map[this.pos.x][this.pos.y+1]=="0")
			{
				this.move("right");
				flag=1;
				MapControl.logger.debug("Robot move right");
			}
		}
	}
}
