package resource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
*	Generic class for pools of ressources implementations
*	@author Stamper - Lheureux
*/

public abstract class ResourcePool<T extends Resource> {
	
	private List<T> freeResource;
	private List<T> busyResource;
	
	public ResourcePool(int nbResource) {
		this.freeResource = new ArrayList<T>(nbResource);
		this.busyResource = new ArrayList<T>(nbResource);
		for(int i = 0; i<nbResource; i++) {
			this.freeResource.add(this.createRes());
		}
	}
	
	/**
	*	Return a ressource if any alviable or throws a NoSuchElementException if not
	*/
	public T provideResource() throws NoSuchElementException{
		if(this.freeResource.isEmpty()) 
			throw new NoSuchElementException();
		T resource = this.freeResource.remove(0);
		this.busyResource.add(resource);
		return (resource);
	}
	
	/**
	*	Free the ressource "ressource" and make it alviable for use. If the ressource doesn't exist throws IllegalArgumentException	
	*/
	public void freeResource(T resource) throws IllegalArgumentException{
		if(this.busyResource.isEmpty() || !this.busyResource.contains(resource))
			throw new IllegalArgumentException();
		int index = this.busyResource.indexOf(resource);
		T busyRes = this.busyResource.remove(index);
		this.freeResource.add(busyRes);
		
	}
	
	/**
	*	Create a new Ressource T
	*/
	public abstract T createRes();

}
