package D3._1213;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc= 1; tc<=10; tc++) {
			int n = sc.nextInt();
			String pt = sc.next();  //����
			String text = sc.next(); //����
			
			int result = 0; //���� ���� ����
			
			//text Ž��
			text : for(int i = 0; i <= text.length() - pt.length(); i++) {
				//�ѱ��ھ� ��
				for(int j = 0; j < pt.length(); j++) {
					if(text.charAt(i+j) != pt.charAt(j)) {
						continue text;
					}
				}
				//�� ������ ������� �ʾҴٸ� ���� ��ġ!
				result++;
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}
}
