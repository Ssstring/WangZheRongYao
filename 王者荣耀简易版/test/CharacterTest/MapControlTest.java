package CharacterTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import Map.The.BasicMap;
import Map.The.MapControl;

class MapControlTest { 
	@Test
	void testJudge() {
		MapControl m=new MapControl();
		BasicMap map=new BasicMap();
		File file=new File("scores.txt");
		try {
			m.judge(file);
		} catch (IOException e) {}
		map.map[17][0]="A";
		map.map[19][5]="B";
		for(int i=0;i<20;i++)
		{	for(int j=0;j<20;j++)
			{
				System.out.print(m.basicMap.map[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++)
			{
				assertEquals(map.map[i][j], m.basicMap.map[i][j]);
			}
	}
	
	@Test
	void testJudge1() {
		MapControl m1=new MapControl();
		BasicMap map1=new BasicMap();
		try {
			m1.judge(new File("scores.txt"));
		} catch (IOException e) {}
		map1.map[17][0]="A";
		map1.map[19][5]="B";
		for(int i=0;i<20;i++)
		{	for(int j=0;j<20;j++)
			{
				System.out.print(m1.basicMap.map[i][j]+" ");
			}
			System.out.println();
		}
//		for(int i=0;i<20;i++)
//			for(int j=0;j<20;j++)
//			{
//				assertEquals(map1.map[i][j], m1.basicMap.map[i][j]);
//			}
	}
	
	@Test
	void testJudge2() {
		MapControl m2=new MapControl();
		BasicMap map2=new BasicMap();
		try {
			m2.judge(new File("scores.txt"));
		} catch (IOException e) {}
		map2.map[15][0]="A";
		map2.map[19][5]="B";
		for(int i=0;i<20;i++)
		{	for(int j=0;j<20;j++)
			{
				System.out.print(m2.basicMap.map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	@Test
	void testJudge3() {
		MapControl m3=new MapControl();
		BasicMap map3=new BasicMap();
		try {
			m3.judge(new File("scores.txt"));
		} catch (IOException e) {}
		map3.map[17][0]="A";
		map3.map[19][5]="B";
//		for(int i=0;i<20;i++)
//			for(int j=0;j<20;j++)
//			{
//				assertEquals(map3.map[i][j], m3.basicMap.map[i][j]);
//			}
	}
	
	@Test
	void testJudge4() {
		MapControl m4=new MapControl();
		BasicMap map4=new BasicMap();
		try {
			m4.judge(new File("scores.txt"));
		} catch (IOException e) {}
		map4.map[17][0]="A";
		map4.map[19][5]="B";
//		for(int i=0;i<20;i++)
//			for(int j=0;j<20;j++)
//			{
//				assertEquals(map4.map[i][j], m4.basicMap.map[i][j]);
//			}
	}

}
