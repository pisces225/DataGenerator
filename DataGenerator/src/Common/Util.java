package Common;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public final static List<ArrayList> charList = new ArrayList<ArrayList>();
	static {
		ArrayList<Character> UpperChars = new ArrayList<Character>();
		ArrayList<Character> LowerChars = new ArrayList<Character>();
		ArrayList<Character> DigitalChars = new ArrayList<Character>();
		ArrayList<Character> Punctuation = new ArrayList<Character>();
		for(int i = 40;i < 127;i++){
			if(i>=48&&i<=57){
				DigitalChars.add((char)i);
			}
			else if(i>=65&&i<=90){
				UpperChars.add((char)i);
			}
			else if(i == 96 || i == 124)
				continue;
			else if(i>=97&&i<=122){
				LowerChars.add((char)i);
			}
			else
				Punctuation.add((char)i);
		}
		charList.add(UpperChars);
		charList.add(LowerChars);
		charList.add(DigitalChars);
		charList.add(Punctuation);
	}
	
	public static char pickRandomChar(char t){
		int type=0;
		switch(t){
			case 'A': type = (int)(Math.random() * 3);break;
			case 'U': type = 0;break;
			case 'L': type = 1;break;
			case 'D': type = 2;break;
			case 'P': type = 3;break;
			default : type = (int)(Math.random() * 3);break;
		}
		int col = (int) (Math.random() * charList.get(type).size());
		return (Character) charList.get(type).get(col);
	}
	
	public static String generateSpecString(char a,int length){
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i < length;i++){
			sb.append(a);
		}
		return sb.toString();
	}
}
