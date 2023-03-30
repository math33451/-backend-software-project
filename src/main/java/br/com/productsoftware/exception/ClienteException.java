package br.com.productsoftware.exception;

public class ClienteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3822725498868300838L;
	
	public ClienteException(String msg) {
		super(msg);
	}
	
	public ClienteException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
