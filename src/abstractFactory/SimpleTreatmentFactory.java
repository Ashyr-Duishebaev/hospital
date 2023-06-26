package abstractFactory;

import model.Treatment;

public class SimpleTreatmentFactory implements TreatmentFactory {

	@Override
	public Treatment createTreatment() {
		return new Treatment();
	}

}
