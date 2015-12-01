package datatypes.chars;

public class Varchar2Value extends CharValue{
	String TypeName="VARCHAR2";
	final static int EXTEND_MAX_LENGTH = 32767;
	boolean enable32k = false;
	
	public Varchar2Value(){
		if(enable32k)
			size = (int)(Math.random() * EXTEND_MAX_LENGTH + 1);
		else {
			size = (int)(Math.random() * (MAX_LENGTH-1) + 1) ;
		}
	}
	
	public Varchar2Value(int size){
		this.size = size;
	}
	
	public Varchar2Value(boolean extended){
		this.enable32k = extended;
		size = (int)(Math.random() * EXTEND_MAX_LENGTH + 1);
	}
	
	boolean check32k(){
		return enable32k;
	}
	
	void enable32K(){
		enable32k = true;
	}
	
	public boolean check(int length){
		if(!enable32k){
			if (length <= MAX_LENGTH && length >= 0){
				return true;
			}
		}	
		else {
			if (length <= EXTEND_MAX_LENGTH && length >= 0){				
				return true;
			}
		}
		System.out.println("Error:out of range");
		return false;
	}
	
	public String getValue(int length){
		return generateValue('P', length);
	}
	
	public void setSize(int length){
		this.size = length;
	}
}
