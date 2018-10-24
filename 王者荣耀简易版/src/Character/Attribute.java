package Character;

public class Attribute {
	public int HP;
	public int MP;
	public int EXP;
	public int ATK;
	public Attribute() {
		HP=0;
		MP=0;
		EXP=0;
	}
	public Attribute(int HP,int MP,int EXP)
	{
		this.HP=HP;
		this.MP=MP;
		this.EXP=EXP;
	}
	public void hurtHP(int hurt)
	{
		HP-=hurt;
	}
	public void useMP(int use)
	{
		MP-=use;
	}
	public void getEXP(int get)
	{
		EXP+=get;
	}
}
