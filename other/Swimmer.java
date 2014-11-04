package other;

import resource.BasketPool;
import resource.CubiclePool;
import resource.ResourceFulUser;
import resource.Cubicle;
import resource.Basket;
import action.Action;
import action.ForeseeableAction;

/**
 * Represents a swimmer
 * @author Stamper - Lheureux
 *
 */

public class Swimmer extends Action{

	/**
	 * name of the swimmer
	 */
	private String name;
	
	/**
	 * Pool of baskets
	 */
	private BasketPool basketPool;
	
	/**
	 * Pool of cubicles
	 */
	private CubiclePool cubiclePool;
	
	/**
	 * time to undress
	 */
	private ForeseeableAction gettingUndressed;
	
	/**
	 * time to swim
	 */
	private ForeseeableAction swim;
	
	/**
	 * time to get dressed
	 */
	private ForeseeableAction gettingDressed;
	
    /**
     *	Cubicle ressource handler
     */
    private ResourceFulUser<Cubicle>	cubicle;	

    /**
     *	Basket ressource handler
     */
    private ResourceFulUser<Basket>	basket;
	
	public Swimmer(String name, BasketPool basket, CubiclePool cubicle, int gettingUndressed, int swim, int gettingDressed) {
		this.name = name;
		this.basketPool = basket;
		this.cubiclePool = cubicle;
		this.gettingUndressed = new ForeseeableAction(gettingUndressed);
		this.swim = new ForeseeableAction(swim);
		this.gettingDressed = new ForeseeableAction(gettingDressed);
		this.cubicle = new ResourceFulUser<Cubicle>();
		this.basket = new ResourceFulUser<Basket>();
	}

	/**
	*	Retrun the name of the swimmer
	*/
	public String getName() {
		return (name);
	}

	@Override
	public boolean isFinished() {
	    return (this.swim.isFinished() && this.gettingDressed.isFinished() && this.gettingUndressed.isFinished());
	}

	@Override
	    public boolean isReady() {
	    return (this.swim.isReady() && this.gettingDressed.isReady() && this.gettingUndressed.isReady());
	}

	@Override
	    protected void realDoStep(){
	    try
		{
		    if (!this.gettingUndressed.isFinished())
			{
			    if (this.gettingUndressed.isReady())
				{
				    this.basket.setResource(basketPool.provideResource());
				    this.cubicle.setResource(cubiclePool.provideResource());
				}
			    this.gettingUndressed.doStep();
			}
		    else if (!this.swim.isFinished())
			{
			    if (this.swim.isReady())
				{
				    this.cubiclePool.freeResource(this.cubicle.getResource());
				    this.cubicle.resetResource();
				}
			    this.swim.doStep();
			}
		    else if (!this.gettingUndressed.isFinished())
			{
			    if (this.gettingDressed.isReady())
				this.cubicle.setResource(cubiclePool.provideResource());
			    this.gettingDressed.doStep();
			}
		}
	    catch (Exception e)
		{
		    e.printStackTrace();
		}
	}

    public void doStep()
    {
	this.realDoStep();
    }

    public String toString()
    {
	return (this.name);
    }
}
