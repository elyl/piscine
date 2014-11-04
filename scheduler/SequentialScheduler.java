package scheduler;

import exception.ActionFinishedException;

/**
*	A particular scheduler which will wait for the current action to be finished before moving on to the next one.
*	@author Stamper - Lheureux
*/

public class SequentialScheduler extends Scheduler{

	private int index;
	
	public SequentialScheduler() {
		super();
		index = 0;
	}

	@Override
	public void realDoStep() {
		while(super.actions.get(index).isFinished()) {
			++index;
		}
		try {
			super.actions.get(index).doStep();
		} catch (ActionFinishedException e) {
			e.printStackTrace();
		}
	}
}
