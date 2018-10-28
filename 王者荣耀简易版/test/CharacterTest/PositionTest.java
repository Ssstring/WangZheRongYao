package CharacterTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Character.Position;

import Character.Position;

class PositionTest {
	
	@Test
	public void test1Position() {
		Position pos=new Position(0, 0);
		assertEquals(pos.x, pos.getPosition().x);
		assertEquals(pos.y, pos.getPosition().y);
	}
	@Test
	public void test2Position() {
		Position pos=new Position(19, 19);
		assertEquals(pos.x, pos.getPosition().x);
		assertEquals(pos.y, pos.getPosition().y);
	}
	@Test
	public void test3Position() {
		Position pos=new Position(15, 15);
		assertEquals(pos.x, pos.getPosition().x);
		assertEquals(pos.y, pos.getPosition().y);
	}
	@Test
	public void test4Position() {
		Position pos=new Position(10, 10);
		assertEquals(pos.x, pos.getPosition().x);
		assertEquals(pos.y, pos.getPosition().y);
	}
	@Test
	public void test5Position() {
		Position pos=new Position(5, 5);
		assertEquals(pos.x, pos.getPosition().x);
		assertEquals(pos.y, pos.getPosition().y);
	}

}
