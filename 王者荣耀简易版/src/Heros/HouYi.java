package Heros;

import Character.*;

public class HouYi extends Hero implements Skill {
//	private String name;
//	private Position pos;
	private Attribute att=new Attribute(500,500,0);
	public int attack=50;
	
	public HouYi(String name,Position pos){
		super.setHeroName(name);
		super.pos=pos;
	}
	
	@Override
		public void normalAttack(Hero hero) {
			// TODO Auto-generated method stub
			hero.att.MP-=attack;
			System.out.println(super.getHeroName()+"对"+hero.getHeroName()+"造成了"+this.attack+"点伤害");
		}
	@Override
		public void activeSkill(String[][] map) {
			// TODO Auto-generated method stub
			String[][] tempMap=map;
			for(int i=1;i<20;i++)
			{
				tempMap[19][i]="~";
				show(tempMap);
				if(i==5)
					tempMap[19][i]="B";
				else tempMap[19][i]="0";			}
		}
	@Override
		public void passiveSkill(String[][] map) {
			// TODO Auto-generated method stub
			
		}
	public static void show(String[][] map)
	{
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
//	public HouYi(String name,int x, int y) {
//		this.name=name;
//		this.pos.x=x;
//		this.pos.y=y;
//	}
//	@Override
	public void move(String[][] map, int x, int y) {
		map[this.pos.x][this.pos.y]="0";
		map[x][y]=super.getHeroName();
		this.pos.x=x;
		this.pos.y=y;
	}
//	@Override
//	public Position getPOS() {
//		return this.pos;
//	}
//	@Override
//	public void setPOS(int x, int y) {
//		this.x=x;
//		this.y=y;
//	}
//	@Override
//	public void attack() {
//		// TODO Auto-generated method stub
//		
//	}
}
