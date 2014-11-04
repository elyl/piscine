package action;

/**
 * This class is an action with only one step
 * @author Stamper - Lheureux
 *
 */
public class OneStepAction extends Action{

	private boolean hasRun;
	
	public OneStepAction(){
		this.hasRun = false;
	}
	
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return (this.hasRun);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return (!this.hasRun);
	}

	@Override
	protected void realDoStep() {
		// TODO Auto-generated method stub
		this.hasRun = true;
	}

}
