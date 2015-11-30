package datatypes.numeric;

import datatypes.DataType;
import datatypes.chars.CharValue;

public class NumberValue extends DataType{
	String TypeName = "NUMBER";
	int precision = 38;
	int scale = 0;
	static final int MAX_PRECISION = 38;
	static final int MIN_PRECISION = 1;
	static final int MAX_SCALE = 127;
	static final int MIN_SCALE = -84;
	
	public NumberValue(int p,int s){
		this.precision = p;
		this.scale = s;
	}
	public NumberValue(int p){
		this.precision = p;
		this.scale = 0;
	}
	public NumberValue(){
		this.precision = 38;
		this.scale = 0;
	}
	
	boolean check(){
		if(precision > NumberValue.MAX_PRECISION || precision < NumberValue.MIN_PRECISION)
			return false;
		if(scale > NumberValue.MAX_SCALE || scale < NumberValue.MIN_SCALE)
			return false;
		return true;
	}
	
	boolean checkValid(String v,int p,int s){
		if(s > 0){
			int point = v.indexOf('.');
			int p1 = point;
			int p2 = v.length() - point - 1;
			if(point == -1)
				return false;
			else{
				if(p2 > s)
					return false;
				else if(p1+p2 > p)
					return false;
				else if(p1 > p - s)
					return false;
			}
			return true;
		}
		else if(s == 0){
			if(v.charAt(0) != '0'){
				return false;
			}
		}
		else{
			int point = v.indexOf('.');
			int p1 = point;
			int p2 = v.length() - point -1;
			if(point == -1){
				p1 = v.length();
			}
			if(p1 > p -s )
				return false;
		}
		return true;
	}
	
	String replaceFirst(String value){
		return value.replaceFirst("0", String.valueOf((int)Math.random()*8+1));
	}
	
	public String generateValue(){
		String value = new String();
		if(scale == 0){
			if(check()){
				CharValue cv = new CharValue(precision);
				String candidate = cv.getDigitalValue();
				if(checkValid(candidate,precision,0))
					value = candidate;
				else{
					value = replaceFirst(candidate);
				}
			}
		}
		else if(scale > 0){
			if(check()){
				if(precision >= scale){
					int length = (int)(Math.random() * (precision - scale -1) + 1);
					CharValue p1 = new CharValue(length);
					CharValue p2 = new CharValue(scale);
					System.out.println(length);
					StringBuilder candidate = new StringBuilder();
					candidate.append(p1.getDigitalValue());
					candidate.append('.');
					candidate.append(p2.getDigitalValue());
					if(candidate.charAt(0) == '0')
						value = replaceFirst(candidate.toString());
					else 
						value = candidate.toString();
				}
				else{
					
				}
			}
		}
		else {
			if(check()){
				CharValue cv = new CharValue(precision - scale);
				String candidate = cv.getDigitalValue();
				if(candidate.charAt(0) == '0')
					value = replaceFirst(candidate.toString());
				else 
					value = candidate.toString();
			}
		}
		return value;
	}
}
