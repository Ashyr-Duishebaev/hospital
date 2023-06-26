package abstractFactory;

import model.Diagnosis;

public class SimpleDiagnosisFactory implements DiagnosisFactory {

	@Override
	public Diagnosis createDiagnosis() {
		return new Diagnosis();
	}
}
