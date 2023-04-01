package br.com.productsoftware.exception;

public class UsuarioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3822725498868300838L;
	
	public UsuarioException(String msg) {
		super(msg);
	}
	
	public UsuarioException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
