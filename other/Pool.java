package other;

import resource.BasketPool;
import resource.CubiclePool;
import scheduler.FairScheduler;

/**
 * The main prgram.
 * @author Stamper - Lheureux
 *
 */

public class Pool {

	public static void main(String[] args){
		BasketPool basket = new BasketPool(6);
		CubiclePool cubicle = new CubiclePool(3);
		FairScheduler s = new FairScheduler();
		s.addAction(new Swimmer("Camille", basket, cubicle, 6, 4, 8));
		s.addAction(new Swimmer("Lois", basket, cubicle, 2, 10, 4));
		s.addAction(new Swimmer("Mae", basket, cubicle, 10, 18, 10));
		s.addAction(new Swimmer("Ange", basket, cubicle, 3, 7, 5));
		s.addAction(new Swimmer("Louison", basket, cubicle, 18, 3, 3));
		s.addAction(new Swimmer("Charlie", basket, cubicle, 3, 6, 10));
		s.addAction(new Swimmer("Alexis", basket, cubicle, 6, 5, 7));
		
		int nbSteps = 0;
		while(!s.isFinished()) {
			nbSteps++;
			s.realDoStep();
		}
		System.out.println("Finished in " + nbSteps + " steps");
		
	}
	
}
