package Heros;

import Character.Attribute;
import Character.Hero;
import Character.Position;
import Character.skill;

public class LuBanQiHao extends Hero implements skill {
	
	private Attribute att=new Attribute(500,500,0);
	public int attack=50;
	
	public LuBanQiHao(String name,Position pos) {
		// TODO Auto-generated constructor stub
		super.setHeroName(name);
		super.pos=pos;
	}
	
	
	@Override
	public void firstSkill(String[][] map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void normalAttack(Hero hero) {
		// TODO Auto-generated method stub
		
	}
	
}
