package resource;

/**
*	Pool of cubicles.
*	@author Stamper - Lheureux
*/

public class CubiclePool extends ResourcePool<Cubicle>{

	public CubiclePool(int nbResource) {
		super(nbResource);
	}

	@Override
	public Cubicle createRes() {
		return new Cubicle();
	}
}
