package Heros;

import Character.Attribute;
import Character.Hero;
import Character.Position;
import Map.The.BasicMap;

public class LiBai extends Hero{
	
	private int activeSkillHurt=100;
	
	public LiBai(String name,Position pos){
		super.setAttribute(new Attribute(500,500,0));
		super.setHeroName(name);
		super.setAttack(50);
		super.pos=pos;
	}
	
	@Override
	public void activeSkill(BasicMap map) {
		// TODO Auto-generated method stub
		String[][] tempMap=new String[20][20];
		for(int i=0;i<20;i++)
			System.arraycopy(map.map[i], 0, tempMap[i], 0, map.map.length);
		for(int i=pos.y+1,k=0;i<20&&k<2;i++,k++)
		{
			if(pos.x+1<20)
			{
				map.map[pos.x+1][i]="@";
				if(tempMap[pos.x+1][i]!="0")
				{
					int j;
					for(j=0;j<map.heros.size();j++)
						if(map.heros.get(j).pos.x==pos.x&&map.heros.get(j).pos.y==i)
							break;
					map.heros.get(j).hurt(activeSkillHurt);
					System.out.println(super.getHeroName()+"对"+map.map[pos.x][i]+"造成了"+activeSkillHurt+"点伤害");
				}
			}
			if(pos.x<20)
			{
				map.map[pos.x][i]="@";
				if(tempMap[pos.x][i]!="0")
				{
					int j;
					for(j=0;j<map.heros.size();j++)
						if(map.heros.get(j).pos.x==pos.x&&map.heros.get(j).pos.y==i)
							break;
					map.heros.get(j).hurt(activeSkillHurt);
					System.out.println(super.getHeroName()+"对"+map.map[pos.x][i]+"造成了"+activeSkillHurt+"点伤害");
				}
			}
			if(pos.x-1>0)
			{
				map.map[pos.x-1][i]="@";
				if(tempMap[pos.x-1][i]!="0")
				{
					int j;
					for(j=0;j<map.heros.size();j++)
						if(map.heros.get(j).pos.x==pos.x&&map.heros.get(j).pos.y==i)
							break;
					map.heros.get(j).hurt(activeSkillHurt);
					System.out.println(super.getHeroName()+"对"+map.map[pos.x][i]+"造成了"+activeSkillHurt+"点伤害");
				}
			}
		}
		try{Thread.sleep(1000);}
		catch(InterruptedException e) {}
		for(int i=0;i<20;i++)
			System.arraycopy(tempMap[i], 0, map.map[i], 0, map.map.length);
	}

	@Override
	public void passiveSkill(BasicMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action(BasicMap map) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
