package homework;

import java.util.List;

public interface PatientService {
    void createPatient(Patient patient);
    Patient getPatientById(int id);
    List<Patient> getAllPatients();
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
