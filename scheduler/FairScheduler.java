package scheduler;

import exception.ActionFinishedException;

/**
*	A particular scheduler implementation which will make every actions to do a step before returning to the first one.
*	@author Stamper - Lheureux
*/

public class FairScheduler extends Scheduler{
	
	private int index;
	
	public FairScheduler(){
		super();
		index = 0;
	}
	
	@Override
	public void realDoStep() {
		while(super.actions.get(index).isFinished()) {
			index = (index + 1) % super.actions.size();
		}
		try {
			super.actions.get(index).doStep();
		} catch (ActionFinishedException e) {
			e.printStackTrace();
		}
		index = (index + 1) % super.actions.size();
	}
	
	
}
