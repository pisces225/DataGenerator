package Common;
import datatypes.chars.CharValue;
import datatypes.chars.Varchar2Value;
import datatypes.numeric.IntegerValue;
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
//		NumberValue nv = new NumberValue(38,12);
//		String v1 = nv.generateValue();
//		System.out.println(v1);
//		IntegerValue iv = new IntegerValue();
//		String v2 = iv.generateValue();
//		System.out.println(v2);
		Varchar2Value vv = new Varchar2Value();
		vv.setSize(3000);
		String v3 = vv.getLowerValue();
		System.out.println(v3);
		
	}

}
