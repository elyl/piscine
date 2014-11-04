package action;


/**
 * represent an action with 
 * a configurable number of state
 * @author Stamper - Lheureux
 *
 */
public class ForeseeableAction extends Action{
	
	/**
	 * represent the current step of the action
	 */
	private int state;
	
	/**
	 * represent the total number of step
	 */
	private int nbStep;
	
	public ForeseeableAction(int nbStep){
		this.nbStep = nbStep;
		this.state = 0;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return this.state == this.nbStep;
	}

	@Override
	public boolean isReady() {
		return (this.state == 0);
	}

	@Override
	protected void realDoStep() {
		this.state++;
	}

}
