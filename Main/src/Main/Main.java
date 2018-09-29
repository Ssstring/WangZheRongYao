package Main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class JueSe{
	public int xueLiang,gongJiLi;
	JueSe(int xueLiang,int gongJiLi){
		this.xueLiang=xueLiang;
		this.gongJiLi=gongJiLi;
	}
}
public class Main{
	public static List<JueSe> p1=new ArrayList<JueSe>();
	public static List<JueSe> p2=new ArrayList<JueSe>();
	public static List<JueSe> xianShou;
	public static List<JueSe> houShou;
	public static void zhaoHuan(int pos,int xueLiang,int gongJiLi)
	{
		xianShou.add(pos,new JueSe(xueLiang,gongJiLi));
	}
	public static void gongJi(int pos1,int pos2)
	{
		xianShou.get(pos1).xueLiang-=houShou.get(pos2).gongJiLi;
		houShou.get(pos2).xueLiang-=xianShou.get(pos1).gongJiLi;
	}
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
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		String str;
		int pos,xueLiang,gongJiLi,pos1;
		p1.add(0,new JueSe(30,0));
		p2.add(0,new JueSe(30,0));
		xianShou=p1;
		houShou=p2;
		for(int i=0;i<n;i++) 
		{
			str=reader.next();
			if(str.equals("summon"))
			{
				pos=reader.nextInt();
				xueLiang=reader.nextInt();
				gongJiLi=reader.nextInt();
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
			for(int j=1;j<p1.size();j++)
				System.out.print(p1.get(j).xueLiang+" ");
		}
		if((p1.get(0).xueLiang<=0&&p2.get(0).xueLiang<=0)||(p1.get(0).xueLiang>0&&p2.get(0).xueLiang>0))
			System.out.println("0");
		else if(p2.get(0).xueLiang<=0)
			System.out.println("1");
		else System.out.println("-1");
		System.out.println(p1.get(0).xueLiang);
		System.out.print(p1.size()-1+" ");
		for(int i=1;i<p1.size();i++)
			System.out.print(p1.get(i).xueLiang+" ");
		System.out.println();
		System.out.println(p2.get(0).xueLiang);
		System.out.print(p2.size()-1+" ");
		for(int i=1;i<p2.size();i++)
			System.out.print(p2.get(i).xueLiang+" ");
	}
}