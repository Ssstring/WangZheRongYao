package Character;
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
	public void activeSkill(String map[][]);
	/**
	 * 被动技能
	 * @param map
	 */
	public void passiveSkill(String map[][]);
}
