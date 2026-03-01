package Collections.Set.EnumSetExample;

import java.util.EnumSet;
import java.util.Set;

// Define an Enum
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumSetExample1 {


    public static void main(String[] args) {
        // 1. Create an EnumSet containing all days
        Set<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All Days: " + allDays);

        // 2. Create an empty EnumSet
        Set<Day> noDays = EnumSet.noneOf(Day.class);
        System.out.println("No Days: " + noDays);

        // 3. Create an EnumSet with specific days
        Set<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);

        // 4. Create a range of days
        Set<Day> workWeek = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Work Week: " + workWeek);

        // 5. Add/Remove elements
        weekend.add(Day.FRIDAY); // Now includes Friday
        workWeek.remove(Day.MONDAY); // Now starts from Tuesday

        // 6. Complement (All days EXCEPT the ones in the set)
        // Create a set of days that are NOT in the weekend set
        Set<Day> workDays = EnumSet.complementOf((EnumSet<Day>) weekend);
        System.out.println("Work Days (Complement of Weekend): " + workDays);
    }
}
