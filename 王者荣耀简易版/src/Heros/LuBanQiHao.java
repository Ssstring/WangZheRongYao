package Heros;

import java.util.Scanner;
import Character.*;
import Map.The.MapAttachments;
/**
 * 鲁班七号的类
 * @author String
 *
 */
public class LuBanQiHao extends Hero implements Skill,MapAttachments {
	
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
	public void activeSkill(String[][] map) {
		// TODO Auto-generated method stub
		int x,y;
		Scanner reader=new Scanner(System.in);
		x=reader.nextInt();
		y=reader.nextInt();
		map[pos.x][pos.y]="0";
		map[x][y]=this.getHeroName();
	}
	/**
	 * 被动技能
	 */
	@Override
	public void passiveSkill(String[][] map) {
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
		hero.att.MP-=attack;
		System.out.println(super.getHeroName()+"对"+hero.getHeroName()+"造成了"+this.attack+"点伤害");
	}
	@Override
	public void show(String[][] map) {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	
}
