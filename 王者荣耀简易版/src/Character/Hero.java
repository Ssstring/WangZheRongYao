package Character;
/**
 * 英雄的抽象类
 * @author String
 *
 */
public abstract class Hero implements Skill{
	private String heroName;
	public Position pos;
	/**
	 * 设置英雄的名字，在本程序中，英雄名字在地图上出现
	 * @param heroName
	 */
	public void setHeroName(String heroName)
	{
		this.heroName=heroName;
	}
	/**
	 * 返回英雄的名字
	 * @return heroName
	 */
	public String getHeroName() {
		return heroName;
	}
	public Attribute att;
	/**
	 * 设置英雄属性
	 * @param att
	 */
	public void setAttribute(Attribute att)
	{
		this.att=att;
	}
	/**
	 * 普通攻击的抽象方法
	 * @param hero
	 */
	public abstract void normalAttack(Hero hero);
	/**
	 * 移动方法
	 * @param direction
	 */
	public abstract void move(String direction);
}
