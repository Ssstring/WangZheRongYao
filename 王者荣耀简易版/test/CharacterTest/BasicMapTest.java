package CharacterTest;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.System.*;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import Map.The.BasicMap;

class BasicMapTest {
	BasicMap map=new BasicMap();
	
	@Test
	void test() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ByteArrayOutputStream expect = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		map.run();
		
		System.setOut(new PrintStream(expect));
		for(int k=0;k<10;k++)
		{
			System.out.println("µÚ"+k+"Ãë");
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<20;j++)
					System.out.print(map.map[i][j]+" ");
				System.out.println();
			}
			System.out.println();
		}
		
		assertEquals(expect.toString(), output.toString());
	}

}
