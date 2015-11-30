package Common;
import datatypes.chars.CharValue;
import datatypes.numeric.NumberValue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CharValue cv = new CharValue(20);
//		String str1 = cv.getPrintableValue();
//		System.out.println(str1);
//		String str2 = cv.getLowerValue();
//		System.out.println(str2);
//		String str3 = cv.getDigitalValue();
//		System.out.println(str3);
//		String str4 = cv.getPunctuationValue();
//		System.out.println(str4);
//		String str5 = cv.getUpperValue();
//		System.out.println(str5);
		NumberValue nv = new NumberValue(38,127);
		String v1 = nv.generateValue();
		System.out.println(v1);
	}

}
