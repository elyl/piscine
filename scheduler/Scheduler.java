package scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import action.Action;

/**
*	Generic implmentation of a scheduler to be used for more specific implementations.
*	@author Stamper - Lheureux
*/

public abstract class Scheduler {
	
	protected List<Action> actions;
	
	public Scheduler(){
		actions = new ArrayList<Action>();
	}
	
	/**
	*	Add an action to the actions list.
	*/
	public void addAction(Action action){
		actions.add(action);
	}
	
	/**
	*	Indicates if the scheduler is ready to be used.
	*	@return True if all actions are ready, else if at least one actions isn't ready.
	*/
	public boolean isReady() {
		Iterator<Action> it = this.actions.iterator();
		while(it.hasNext()){
			if(!it.next().isReady())
				return (false);
		}
		return (true);
	}

	/**
	*	Indicates if the scheduler has finished his actions.
	*	@return true if all actions are finished, else returns false.
	*/
	public boolean isFinished() {
		Iterator<Action> it = this.actions.iterator();
		while(it.hasNext()){
			if(!it.next().isFinished())
				return (false);
		}
		return (true);
	}

	/**
	*	Execute the next step for the current action.
	*/
	public abstract void realDoStep();
	
}
