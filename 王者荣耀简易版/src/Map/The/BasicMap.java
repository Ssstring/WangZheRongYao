package Map.The;

import java.util.*;

import Character.Position;
import Heros.*;

public class BasicMap {
	public static void show()
	{
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	static String map[][]= {{"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"},
				   		    {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"},
				   		    {"0","0","0","0","1","1","1","1","1","1","1","1","1","1","0","0","0","0","0","0"},
				   		    {"0","0","0","1","1","1","1","1","1","1","1","1","1","1","1","0","0","0","0","0"},
				   		    {"0","0","1","1","1","1","1","1","1","1","1","1","1","0","0","0","0","0","0","0"},
				   		    {"0","0","1","1","1","1","1","1","1","1","1","1","0","0","0","0","1","0","0","0"},
				   		    {"0","0","1","1","1","1","1","1","1","1","1","0","0","0","0","0","1","1","0","0"},
				   		    {"0","0","1","1","1","1","1","1","1","1","0","0","0","0","0","1","1","1","0","0"},
				   		    {"0","0","1","1","1","1","1","1","1","0","0","0","0","0","1","1","1","1","0","0"},
				   		    {"0","0","1","1","1","1","1","1","0","0","0","0","0","1","1","1","1","1","0","0"},
				   		    {"0","0","1","1","1","1","1","0","0","0","0","0","1","1","1","1","1","1","0","0"},
				   		    {"0","0","1","1","1","1","0","0","0","0","0","1","1","1","1","1","1","1","0","0"},
				   		    {"0","0","1","1","1","0","0","0","0","0","1","1","1","1","1","1","1","1","0","0"},
				   		    {"0","0","1","1","0","0","0","0","0","1","1","1","1","1","1","1","1","1","0","0"},
				   		    {"0","0","0","1","0","0","0","0","1","1","1","1","1","1","1","1","1","1","0","0"},
				   		    {"0","0","0","0","0","0","0","1","1","1","1","1","1","1","1","1","1","1","0","0"},
				   		    {"0","0","0","0","0","1","1","1","1","1","1","1","1","1","1","1","1","0","0","0"},
				   		    {"0","0","0","0","0","0","1","1","1","1","1","1","1","1","1","1","0","0","0","0"},
				   		    {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"},
				   		    {"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"},};
	public static void main(String[] args) {
		show();
		Scanner reader=new Scanner(System.in);
		String chaozuo;
		int x,y;
		HouYi houyi=new HouYi("A",new Position(19, 0));
		houyi.move(map, 19, 0);
		HouYi houyi2=new HouYi("B",new Position(19, 5));
		houyi2.move(map, 19, 5);
		show();
		while(true)
		{
			chaozuo=reader.next();
			if(chaozuo.equals("firstSkill"))
			{
				houyi.firstSkill(map);
			}
			else break;
//			if(chaozuo.equals("move"))
//			{
//				x=reader.nextInt();
//				y=reader.nextInt();
//				houyi.move(map, x, y);
//				show();
//			}
//			else {
//				System.out.println("δ����");
//				break;
//			}
		}
		reader.close();
		
	} 
}
