package Character;

import Heros.Robot;
import Map.The.BasicMap;
import Map.The.MapControl;

/**
 * Ӣ�۵ĳ�����
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
	 * ����Ӣ�۵����֣��ڱ������У�Ӣ�������ڵ�ͼ�ϳ���
	 * @param heroName
	 */
	public void setHeroName(String heroName)
	{
		this.heroName=heroName;
	}
	/**
	 * ����Ӣ�۵�����
	 * @return heroName
	 */
	public String getHeroName() {
		return heroName;
	}
	/**
	 * ����Ӣ������
	 * @param att
	 */
	public void setAttribute(Attribute att)
	{
		this.att=att;
	}
	/**
	 * �õ�Ӣ������
	 * @return
	 */
	public Attribute getAttribute()
	{
		return att;
	}
	/**
	 * ����Ӣ�۹�����
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
	 * ����Ӣ�۹�����
	 * @return
	 */
	public int getAttack()
	{
		return this.attack;
	}
	/**
	 * ��ͨ�����ķ���
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
	 * hero�е��ƶ�����
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
	 * ɨ���ͼ���������Ӣ�������Ӣ��
	 * TODO:Ӧ�÷��صз�Ӣ��
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
	 * ��������Ұ��Χ�ڵ�����ĵз�Ӣ����heros�е����
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
