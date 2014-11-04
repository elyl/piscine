package action;

import resource.Resource;
import resource.ResourceFulUser;
import resource.ResourcePool;

/**
 * This class is used to free a resource
 * @author Stamper - Lheureux
 *
 */
public class FreeResourceAction extends Action {

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
	
	public FreeResourceAction(ResourcePool<Resource> pool, ResourceFulUser<Resource> resourceUser) {
		this.resourceUser = resourceUser;
		this.pool = pool;
		this.hasRun = false;
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
		pool.freeResource(this.resourceUser.getResource());
		hasRun = true;		
	}

}
