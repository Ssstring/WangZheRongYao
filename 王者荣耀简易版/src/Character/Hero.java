package Character;
/**
 * Ӣ�۵ĳ�����
 * @author String
 *
 */
public abstract class Hero implements Skill{
	private String heroName;
	public Position pos;
	/**
	 * ����Ӣ�۵����֣��ڱ������У�Ӣ�������ڵ�ͼ�ϳ���
	 * @param heroName
	 */
	public void setHeroName(String heroName)
	{
		this.heroName=heroName;
	}
	/**
	 * ����Ӣ�۵�����
	 * @return heroName
	 */
	public String getHeroName() {
		return heroName;
	}
	public Attribute att;
	/**
	 * ����Ӣ������
	 * @param att
	 */
	public void setAttribute(Attribute att)
	{
		this.att=att;
	}
	/**
	 * ��ͨ�����ĳ��󷽷�
	 * @param hero
	 */
	public abstract void normalAttack(Hero hero);
	/**
	 * �ƶ�����
	 * @param direction
	 */
	public abstract void move(String direction);
}
