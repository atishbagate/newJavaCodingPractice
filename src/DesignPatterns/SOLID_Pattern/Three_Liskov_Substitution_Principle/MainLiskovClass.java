package DesignPatterns.SOLID_Pattern.Three_Liskov_Substitution_Principle;


//Why this is a "precise" violation:
//If a developer writes a updateSettings(UserProfile profile) method,
//they expect that calling setUsername() and saveToDatabase() will work.
//If they pass a ReadOnlyUserProfile, the app crashes or silently fails to save,
//even though the type system said it was a valid UserProfile.

//3. How to Spot Violations in Your Code
//You can identify a Liskov violation by looking for these three red flags:
//Empty Overrides: You override a method but leave the body empty because the subclass doesn't need it.
//The "Throw" Trap: You override a method just to throw an UnsupportedOperationException.
//Type Checking (instanceof): You have code that looks like this:

//The "Rules of Thumb" for LSP
//When you extend a class in Java, ask yourself:
//Does the subclass fulfill every promise made by the parent?
//If I replace the parent with the child in a List, will the loops still work without extra if checks?

public class MainLiskovClass {
    public static void main(String[] args) {

        UserProfile profile = new ReadableUser();
        profile.UserName = "Atish";
        profile.getUserName();

        WritableUser profile1 = new WritableUser();
        profile1.UpdateUserName("Sumit");
        profile1.save();
        profile1.getUserName();

    }
}
