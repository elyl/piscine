package exception;

/**
 * this exception is used to know if the action is finished or not
 * @author Stamper - Lheureux
 *
 */

public class ActionFinishedException extends Exception{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	public ActionFinishedException(){
		super("The action is finished");
	}
}
