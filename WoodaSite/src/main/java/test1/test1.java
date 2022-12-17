package test1;

import java.util.Random;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String certificationNum = "";
		Random rd = new Random();
		int certificationTotal = 6;
		char[] characterTable = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		for (int i = 0; i < certificationTotal; i++) {
			certificationNum += characterTable[(rd.nextInt(characterTable.length))];
		}
		
		System.out.println(certificationNum);
	}

}
