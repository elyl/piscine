package action;

import exception.ActionFinishedException;

/**
 * Generic implementation of an Action
 * @author Stamper - Lheureux
 *
 */
public abstract class Action {
	
	/**
	 * isFinished() indicates if the action is finished
	 * @return true if the action is finished, else return false 
	 */
	public abstract boolean isFinished();
	
	/**
	 * isReady() indicates if the action is ready
	 * @return true if the action is ready, else return false
	 */
	public abstract boolean isReady();
	
	/**
	 * realDoStep() used to increment steps of the action
	 */
	protected abstract void realDoStep();
	
	/**
	 * isInProgress() indicates if the action is in progress
	 * @return true if the action is in progress, else return false
	 */
	public boolean isInProgress(){
		return (!isFinished() && !isReady());
	}
	
	/**
	 * doStep() used to call realDoStep() method. doStep() verify if the action is finished
	 * @throws ActionFinishedException
	 */
	public void doStep() throws ActionFinishedException{
		if(this.isFinished())
			throw new ActionFinishedException();
		else 
			this.realDoStep();
	}
}
