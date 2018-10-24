package Character.Heros;

import Character.Attribute;
import Character.Hero;
import Character.Position;

public class HouYi implements Hero implements skill {
	private String name;
	private Position pos;
	private Attribute att=new Attribute(500,500,0);

	public HouYi(String name,int x, int y) {
		this.name=name;
		this.pos.x=x;
		this.pos.y=y;
	}
	@Override
	public void move(String[][] map, int x, int y) {
		map[this.pos.x][this.pos.y]="0";
		map[x][y]=name;
		this.pos.x=x;
		this.pos.y=y;
	}
	@Override
	public Position getPOS() {
		return this.pos;
	}
	@Override
	public void setPOS(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
}
