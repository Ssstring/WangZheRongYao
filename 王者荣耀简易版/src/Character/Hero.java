package Character;
/**
 * Ӣ�۵ĳ�����
 * @author String
 *
 */
public abstract class Hero{
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
//	/**
//	 * �ƶ�����
//	 * @param pos1
//	 */
//	public abstract void move(Position pos1);
//	public void move(Position pos1) {
//		this.pos=pos1;
//	}
}
