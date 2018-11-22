package Character;

import Map.The.BasicMap;

/**
 * 英雄技能接口
 * @author String
 *
 */
public interface Skill {
	/**
	 * 主动技能
	 * @param map
	 */
	public void activeSkill(BasicMap map);
	/**
	 * 被动技能
	 * @param map
	 */
	public void passiveSkill(BasicMap map);
}
