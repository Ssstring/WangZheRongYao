package Character;
/**
 * �洢Ӣ�����ڵ�λ��
 * @author hasee
 *
 */
public class Position {
	public int x,y;
	public Position(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public Position getPosition() {
		return new Position(this.x, this.y);
	}
}
