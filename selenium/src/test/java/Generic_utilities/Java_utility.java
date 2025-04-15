package Generic_utilities;

import java.util.Random;

public class Java_utility {
	/**
	 * This method is used to avoid duplicate values
	 * @return
	 * @author Lavanya
	 */
	public int getRandomNum()
	{
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		return ranNum;
		
	}
	
	public String random() {
		String alphabet = "8327!#$@#$%%$143@#$%";
		int N = alphabet.length();
		Random rd = new Random();
		int iLength =6;
		StringBuilder sb = new StringBuilder(iLength);
		for (int i = 0; i < iLength; i++)
		{
		    sb.append(alphabet.charAt(rd.nextInt(N)));
		}
		System.out.println(sb);
		return alphabet;
	}

}
