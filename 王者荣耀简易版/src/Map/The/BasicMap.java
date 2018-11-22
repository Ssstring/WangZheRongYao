package Map.The;

import java.util.*;
import java.lang.*;
import Character.Hero;
import Character.Position;
import Heros.*;

public class BasicMap implements MapAttachments,Runnable {
	public ArrayList<Hero> heros=new ArrayList<Hero>();
	/**
	 * 展示地图
	 */
	@Override
		public void show(String[][] map) {
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<20;j++)
					System.out.print(map[i][j]+" ");
				System.out.println();
			}
			System.out.println();
		}
	/**
	 * 线程，一次地图，然后sleep 1s
	 */
	public synchronized void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("第"+i+"秒");
			show(map);
			try{Thread.sleep(1000);}
			catch(InterruptedException e){}
		}
	}
	/**
	 * 改变方法，通过这个方法改变Hero的位置
	 * @param old
	 * @param now
	 */
	public void changePos(Position old,Position now)
	{
		int i;
		for(i=0;i<heros.size();i++)
			if(heros.get(i).pos.x==old.x&&heros.get(i).pos.y==old.y)
				break;
		map[old.x][old.y]="0";
		map[now.x][now.y]=heros.get(i).getHeroName();
	}
	/**
	 * 存储地图
	 */
	public String map[][]= {{"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"},
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
}
