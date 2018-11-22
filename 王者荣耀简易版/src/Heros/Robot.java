package Heros;

import Character.Position;
import Map.The.BasicMap;

public interface Robot {
	public Position judgePos(BasicMap map);
	public void action(BasicMap map);
}
