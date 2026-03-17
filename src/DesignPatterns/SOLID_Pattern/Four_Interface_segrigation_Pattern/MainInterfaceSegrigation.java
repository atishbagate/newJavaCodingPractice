package DesignPatterns.SOLID_Pattern.Four_Interface_segrigation_Pattern;

//1. The "Fat Interface" (The Violation)
//We often make the mistake of creating one giant interface for "User Actions."

//If we create a Patient class, we are forced to provide an empty or "throwing" implementation for prescribeMedication(). This violates ISP.
//2. The ISP Solution (The Proper Way)
//We break the "Fat" interface into Lean, Specific Interfaces.

//3. Why this is "Proper" Code
//Safety: You can't accidentally call prescribeMedication() on a Patient object because the compiler won't allow it. The Patient type doesn't even have that method.
//Maintenance: If the prescribeMedication() method signature changes (e.g., adding a dosage parameter), you only have to update the Doctor and ChiefSurgeon classes. The Patient class remains untouched.
//Decoupling: Your frontend (perhaps the React side of your MERN stack) can interact with a Payer interface without knowing if it's a Patient, an InsuranceProvider, or a GovernmentAgency.

//Summary Checklist for ISP
//When you look at your Java code, ask:
//        "Does this class use every method in the interface it implements?"
//If the answer is No, you have an ISP violation. Split the interface.


public class MainInterfaceSegrigation {
    public static void main(String[] args) {

        Doctor doctor = new Doctor();
        doctor.login();
        doctor.takeRecord();

        Patient patient = new Patient();
        patient.login();
        patient.payBilling();
    }
}
