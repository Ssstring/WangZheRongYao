package Character;
/**
 * �洢Ӣ�۵Ļ�������
 * @author String
 *
 */
public class Attribute {
	public int HP;
	public int MP;
	public int EXP;
	/**
	 * ���췽��
	 */
	public Attribute() {
		HP=0;
		MP=0;
		EXP=0;
	}
	/**
	 * ���췽��
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
