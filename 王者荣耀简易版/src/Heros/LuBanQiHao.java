package Heros;

import Character.*;

public class LuBanQiHao extends Hero implements Skill {
	
	private Attribute att=new Attribute(500,500,0);
	public int attack=50;
	
	public LuBanQiHao(String name,Position pos) {
		// TODO Auto-generated constructor stub
		super.setHeroName(name);
		super.pos=pos;
	}
	
	
	@Override
	public void activeSkill(String[][] map) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void passiveSkill(String[][] map) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void normalAttack(Hero hero) {
		// TODO Auto-generated method stub
		
	}
	
}
