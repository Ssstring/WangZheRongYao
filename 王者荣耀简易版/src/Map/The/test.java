package Map.The;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
 
// ����Scanner�Ĺ��췽�����ܻ��׳�һ��I/O�쳣
 
public class test {
	public static void main(String[] args) throws IOException {
		File file = new File("scores.txt");
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String firstName = input.next();
			String mi = input.next();
			String lastName = input.next();
			int score = input.nextInt();
			System.out.println(firstName + " " + mi + " " + lastName + " " + score);
		}
		// û��Ҫ�ر������ļ�������������һ���ͷ���Դ�ĺ÷���
		input.close();
	}
}
// result is
// John T Smith 90
// Eric K Jones 85