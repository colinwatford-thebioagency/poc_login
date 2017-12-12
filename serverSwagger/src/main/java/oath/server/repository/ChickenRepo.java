package oath.server.repository;

import java.util.ArrayList;
import java.util.List;

import oath.server.model.Chicken;


public class ChickenRepo {

	private List<Chicken> allChickens;

	
	public ChickenRepo() {
		allChickens = makeChickens();
	}
	
	public List<Chicken> findAll() {
		return allChickens;
	}
	
	public Chicken findById(int id) {
		for(Chicken chicken: allChickens) {
			if(chicken.getId() == id) return chicken;
		}
		return null;
	}

	private static List<Chicken> makeChickens() {
		ArrayList<Chicken> all = new ArrayList<Chicken>();

		all.add(new Chicken(0, "Cluck", 1));
		all.add(new Chicken(1, "Chicken May", 54));
		all.add(new Chicken(2, "Chicken Licken", 0));
		all.add(new Chicken(3, "Sonic the HedgeChicken", 3));

		return all;
	}

}
