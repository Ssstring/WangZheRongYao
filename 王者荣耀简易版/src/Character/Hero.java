package Character;

public interface Hero{
	public Attribute getAtt();
	public Position getPOS();
	public void setPOS(int x,int y);
	public void move(String map[][],int x,int y);
	public void attack();
	public int die();
}
