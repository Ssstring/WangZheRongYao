package Character;

import Map.The.BasicMap;

/**
 * Ӣ�ۼ��ܽӿ�
 * @author String
 *
 */
public interface Skill {
	/**
	 * ��������
	 * @param map
	 */
	public void activeSkill(BasicMap map);
	/**
	 * ��������
	 * @param map
	 */
	public void passiveSkill(BasicMap map);
}
