package Character;

public abstract class Hero{
	private String heroName;
	public Position pos;
	public void setHeroName(String heroName)
	{
		this.heroName=heroName;
	}
	public String getHeroName() {
		return heroName;
	}
	public Attribute att;
	public void setAttribute(Attribute att)
	{
		this.att=att;
	}
	
	public abstract void normalAttack(Hero hero);
//	public void move(Position pos1) {
//		this.pos=pos1;
//	}
}
