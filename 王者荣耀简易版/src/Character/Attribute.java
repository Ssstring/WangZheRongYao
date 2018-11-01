package Character;
/**
 * 存储英雄的基本属性
 * @author String
 *
 */
public class Attribute {
	public int HP;
	public int MP;
	public int EXP;
	/**
	 * 构造方法
	 */
	public Attribute() {
		HP=0;
		MP=0;
		EXP=0;
	}
	/**
	 * 构造方法
	 * @param HP
	 * @param MP
	 * @param EXP
	 */
	public Attribute(int HP,int MP,int EXP)
	{
		this.HP=HP;
		this.MP=MP;
		this.EXP=EXP;
	}
}
