package Main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * 设定角色，包括英雄和随从，有两个属性：血量和攻击力
 * @author String
 *
 */
class JueSe{
	public int xueLiang,gongJiLi;
	JueSe(int xueLiang,int gongJiLi){
		this.xueLiang=xueLiang;
		this.gongJiLi=gongJiLi;
	}
}
/**
 * 本程序实现“炉石传说”简易版系统  CSP201609-3
 * @author String
 *
 */
public class Main{
	//两个玩家的角色List
	public static List<JueSe> p1=new ArrayList<JueSe>();
	public static List<JueSe> p2=new ArrayList<JueSe>();
	//声明先手后手，用于每次回合结束后交换
	public static List<JueSe> xianShou;
	public static List<JueSe> houShou;
	/**
	 * 召唤随从，存入List中
	 * @param pos
	 * @param xueLiang
	 * @param gongJiLi
	 */
	public static void zhaoHuan(int pos,int xueLiang,int gongJiLi)
	{
		xianShou.add(pos,new JueSe(xueLiang,gongJiLi));
	}
	/**
	 * 随从进行攻击
	 * @param pos1
	 * @param pos2
	 */
	public static void gongJi(int pos1,int pos2)
	{
		xianShou.get(pos1).xueLiang-=houShou.get(pos2).gongJiLi;
		houShou.get(pos2).xueLiang-=xianShou.get(pos1).gongJiLi;
	}
	/**
	 * 在攻击之后判断随从是否死亡
	 */
	public static void siWang()
	{
		for(int i=1;i<p1.size();i++)
		{
			if(p1.get(i).xueLiang<=0)
				p1.remove(i);
		}
		for(int i=1;i<p2.size();i++)
		{
			if(p2.get(i).xueLiang<=0)
				p2.remove(i);
		}
	}
	/**
	 * 主方法，包括输入和输出
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		String str;
		int pos,xueLiang,gongJiLi,pos1;
		//把英雄：血量30，攻击力0存入相应的List【0】中
		p1.add(0,new JueSe(30,0));
		p2.add(0,new JueSe(30,0));
		//初始设置p1先手，p2后手
		xianShou=p1;
		houShou=p2;
		//读入命令
		for(int i=0;i<n;i++) 
		{
			str=reader.next();
			if(str.equals("summon"))
			{
				pos=reader.nextInt();
				gongJiLi=reader.nextInt();
				xueLiang=reader.nextInt();
				JueSe suicong=new JueSe(xueLiang,gongJiLi);
				xianShou.add(pos,suicong); 
			}
			else if(str.equals("attack"))
			{
				pos=reader.nextInt();
				pos1=reader.nextInt();
				gongJi(pos,pos1);
				siWang();
			}
			else if(str.equals("end"))
			{
				List<JueSe> temp;
				temp=xianShou;
				xianShou=houShou;
				houShou=temp;
			}
		}
		//判断并输出胜败
		if((p1.get(0).xueLiang<=0&&p2.get(0).xueLiang<=0)||(p1.get(0).xueLiang>0&&p2.get(0).xueLiang>0))
			System.out.println("0");
		else if(p2.get(0).xueLiang<=0)
			System.out.println("1");
		else System.out.println("-1");
		//按题目要求输出
		System.out.println(p1.get(0).xueLiang);
		System.out.print(p1.size()-1+" ");
		for(int i=1;i<p1.size();i++)
			System.out.print(p1.get(i).xueLiang+" ");
		System.out.println();
		System.out.println(p2.get(0).xueLiang);
		System.out.print(p2.size()-1+" ");
		for(int i=1;i<p2.size();i++)
			System.out.print(p2.get(i).xueLiang+" ");
		reader.close();
	}
}