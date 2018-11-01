package Heros;

import Character.*;
import Map.The.MapAttachments;
/**
 * һ�������Ӣ�ۣ�����
 * @author String
 * @version 1.2
 * @since JDK 1.8
 *
 */
public class HouYi extends Hero implements Skill,MapAttachments {
	/** ���û�������*/
	private Attribute att=new Attribute(500,500,0);
	/**��������ֵΪ50 */
	public int attack=50;
	/**
	 * ���췽��
	 * @param name
	 * @param pos
	 */
	public HouYi(String name,Position pos){
		super.setAttribute(att);
		super.setHeroName(name);
		this.pos=pos;
	}
	/**
	 * �̳е���ͨ����
	 * {@inheritDoc}
	 */
	@Override
		public void normalAttack(Hero hero) {
			// TODO Auto-generated method stub
			hero.att.MP-=attack;
			System.out.println(super.getHeroName()+"��"+hero.getHeroName()+"�����"+this.attack+"���˺�");
		}
	/**
	 *�������ܣ�����һ���ߣ��Ե�������˺�
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
					System.out.println(super.getHeroName()+"��"+map[pos.x][i]+"�����"+this.attack+"���˺�");
				}
				else tempMap[pos.x][i]="0";	
			}
		}
	/**
	 * �ӿڵı�������
	 * {@inheritDoc}
	 */
	@Override
		public void passiveSkill(String[][] map) {
			// TODO Auto-generated method stub
			this.attack++;
		}
	/**
	 * �ƶ�����
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
	 * ���ڼ���չʾ
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
