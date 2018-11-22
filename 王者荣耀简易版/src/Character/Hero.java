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
	 * ��ͨ�����ĳ��󷽷�
	 * @param hero
	 */
	public void normalAttack(Hero hero)
	{
		hero.getAttribute().HP-=this.getAttack();
		System.out.println(this.getHeroName()+"��"+hero.getHeroName()+"�����"+this.getAttack()+"���˺�");
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
