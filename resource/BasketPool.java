package resource;

/**
*	This class is the pool of Basket ressources alviable
*	@Author Stamper - Lheureux
*/

public class BasketPool extends ResourcePool<Basket>{

	public BasketPool(int nbResource) {
		super(nbResource);
	}

	/**
	*	Create a new Basket ressource
	*/
	@Override
	public Basket createRes() {
		return (new Basket());
	}

	
	
}
