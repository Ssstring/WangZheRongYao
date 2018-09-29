package Main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * �趨��ɫ������Ӣ�ۺ���ӣ����������ԣ�Ѫ���͹�����
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
 * ������ʵ�֡�¯ʯ��˵�����װ�ϵͳ  CSP201609-3
 * @author String
 *
 */
public class Main{
	//������ҵĽ�ɫList
	public static List<JueSe> p1=new ArrayList<JueSe>();
	public static List<JueSe> p2=new ArrayList<JueSe>();
	//�������ֺ��֣�����ÿ�λغϽ����󽻻�
	public static List<JueSe> xianShou;
	public static List<JueSe> houShou;
	/**
	 * �ٻ���ӣ�����List��
	 * @param pos
	 * @param xueLiang
	 * @param gongJiLi
	 */
	public static void zhaoHuan(int pos,int xueLiang,int gongJiLi)
	{
		xianShou.add(pos,new JueSe(xueLiang,gongJiLi));
	}
	/**
	 * ��ӽ��й���
	 * @param pos1
	 * @param pos2
	 */
	public static void gongJi(int pos1,int pos2)
	{
		xianShou.get(pos1).xueLiang-=houShou.get(pos2).gongJiLi;
		houShou.get(pos2).xueLiang-=xianShou.get(pos1).gongJiLi;
	}
	/**
	 * �ڹ���֮���ж�����Ƿ�����
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
	 * ��������������������
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		String str;
		int pos,xueLiang,gongJiLi,pos1;
		//��Ӣ�ۣ�Ѫ��30��������0������Ӧ��List��0����
		p1.add(0,new JueSe(30,0));
		p2.add(0,new JueSe(30,0));
		//��ʼ����p1���֣�p2����
		xianShou=p1;
		houShou=p2;
		//��������
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
		//�жϲ����ʤ��
		if((p1.get(0).xueLiang<=0&&p2.get(0).xueLiang<=0)||(p1.get(0).xueLiang>0&&p2.get(0).xueLiang>0))
			System.out.println("0");
		else if(p2.get(0).xueLiang<=0)
			System.out.println("1");
		else System.out.println("-1");
		//����ĿҪ�����
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