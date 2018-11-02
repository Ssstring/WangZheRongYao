package Map.The;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
 
// 调用Scanner的构造方法可能会抛出一个I/O异常
 
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
		// 没必要关闭输入文件，但这样做是一种释放资源的好方法
		input.close();
	}
}
// result is
// John T Smith 90
// Eric K Jones 85