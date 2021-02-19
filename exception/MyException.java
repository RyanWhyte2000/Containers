package exception;

public class MyException extends Exception{
	
	private String msg;//atribute

	public MyException(String msg) {//primary Constructor
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
		
	
}
