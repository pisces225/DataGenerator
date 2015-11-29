package datatypes.chars;

import Common.Util;
import datatypes.DataType;

public class CharValue extends DataType {
	String TypeName="CHAR";
	final static int MAX_LENGTH = 2000;
	int size = -1;
	char type='P';
	
	
	public CharValue(int size){
		this.size = size;
	}
	public void setType(char t){
		this.type=t;
	}
	public String getPrintableValue(){
		setType('A');
		return generateValue(type,this.size);
	}
	public String getUpperValue(){
		setType('U');
		return generateValue(type,size);
	}
	public String getLowerValue(){
		setType('L');
		return generateValue(type,size);
	}
	public String getDigitalValue(){
		setType('D');
		return generateValue(type,size);
	}
	public String getPunctuationValue(){
		setType('P');
		return generateValue(type,size);
	}
	public String generateValue(char type,int length) {
		StringBuilder value = new StringBuilder();	
		if(check(length)){
			for(int i=0;i < length ; i++){
				char c = Util.pickRandomChar(type);
				value.append(c);
			}
		}
		return value.toString();
	}

	public static boolean check(int length){
		if (length <= MAX_LENGTH && length >= 0){
			return true;
		}
		return false;
	}
}
