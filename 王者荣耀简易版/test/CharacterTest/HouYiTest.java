package CharacterTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Character.Position;
import Map.The.BasicMap;
import Heros.HouYi;

class HouYiTest {
	
	@Test
	void testJudgePos()
	{
		BasicMap map=new BasicMap();
		HouYi houyi=new HouYi("A",new Position(18, 18));
		map.heros.add(houyi);
		map.heros.add(new HouYi("B",new Position(19, 2)));
		map.heros.add(new HouYi("C",new Position(18, 3)));
		assertEquals(18, houyi.judgePos(map).x);
		assertEquals(3, houyi.judgePos(map).y);
	}
	@Test
	void test1JudgePos()
	{
		BasicMap map=new BasicMap();
		HouYi houyi=new HouYi("A",new Position(19, 18));
		map.heros.add(houyi);
		map.heros.add(new HouYi("B",new Position(19, 17)));
		map.heros.add(new HouYi("C",new Position(18, 3)));
		assertEquals(19, houyi.judgePos(map).x);
		assertEquals(17, houyi.judgePos(map).y);
	}
	@Test
	void test2JudgePos()
	{
		BasicMap map=new BasicMap();
		HouYi houyi=new HouYi("A",new Position(19, 18));
		map.heros.add(houyi);
		map.heros.add(new HouYi("B",new Position(19, 2)));
		map.heros.add(new HouYi("C",new Position(18, 3)));
		assertEquals(19, houyi.judgePos(map).x);
		assertEquals(2, houyi.judgePos(map).y);
	}
	@Test
	void test3JudgePos()
	{
		BasicMap map=new BasicMap();
		HouYi houyi=new HouYi("A",new Position(19, 18));
		map.heros.add(houyi);
		map.heros.add(new HouYi("B",new Position(19, 3)));
		map.heros.add(new HouYi("C",new Position(18, 3)));
		assertEquals(19, houyi.judgePos(map).x);
		assertEquals(3, houyi.judgePos(map).y);
	}
	@Test
	void test4JudgePos()
	{
		BasicMap map=new BasicMap();
		HouYi houyi=new HouYi("A",new Position(17, 0));
		map.heros.add(houyi);
		map.heros.add(new HouYi("B",new Position(18, 2)));
		map.heros.add(new HouYi("C",new Position(18, 3)));
		assertEquals(18, houyi.judgePos(map).x);
		assertEquals(2, houyi.judgePos(map).y);
	}
	@Test
	void test5JudgePos()
	{
		BasicMap map=new BasicMap();
		HouYi houyi=new HouYi("A",new Position(17, 18));
		map.heros.add(houyi);
		map.heros.add(new HouYi("B",new Position(1, 2)));
		map.heros.add(new HouYi("C",new Position(18, 3)));
		assertEquals(18, houyi.judgePos(map).x);
		assertEquals(3, houyi.judgePos(map).y);
	}

}