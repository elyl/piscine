package action;

import resource.Resource;
import resource.ResourceFulUser;
import resource.ResourcePool;

/**
 * This class is used to take a resource
 * @author Stamper - Lheureux
 *
 */

public class TakeResourceAction extends Action{

	/**
	 * user of the resource
	 */
	private ResourceFulUser<Resource> resourceUser;
	
	/**
	 * resource represent a pool
	 */
	private ResourcePool<Resource> pool;
	
	/**
	 * indication if the action has run
	 */
	private boolean hasRun;
	
	public TakeResourceAction(ResourcePool<Resource> pool, ResourceFulUser<Resource> resourceFulUser) {
		this.pool = pool;
		this.resourceUser = resourceFulUser;
		hasRun = false;
	}
	
	@Override
	public boolean isFinished() {
		return (hasRun);
	}

	@Override
	public boolean isReady() {
		return (!hasRun);
	}

	@Override
	protected void realDoStep() {
		Resource res = pool.provideResource();
		if(res != null)
			resourceUser.setResource(res);
	}

}
