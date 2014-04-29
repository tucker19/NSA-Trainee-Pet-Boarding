package Menu;

import java.util.ArrayList;

public class StephensDepotMenu {
	public static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();

	
	public static void createMenus() {
            
		menu.add(new MenuItem("CAT- Heartworm Prevention", 40, "One Year", 1));
		menu.add(new MenuItem("CAT- Flea/Tick Prevention", 10, "6 Month", 2));
		menu.add(new MenuItem("CAT- Kitten Food", 15, "10 Lbs", 3));
		menu.add(new MenuItem("CAT- Adult Cat Food", 20, "15 Lbs", 4));
		menu.add(new MenuItem("CAT- Reduced Fat Adult Cat Food", 25, "15 Lbs", 5));
		menu.add(new MenuItem("CAT- Senior Adult Cat Food", 20, "15 lbs", 6));
		menu.add(new MenuItem("DOG- Heartworm Prevent", 50, "(small/med breed)",  7));
		menu.add(new MenuItem("DOG- Heartworm Prevention", 60, "(large breed)", 8));
		menu.add(new MenuItem("DOG- Flea/Tick Prevention", 15, "(6 month)", 9));
		menu.add(new MenuItem("DOG- Puppy (small breed) Food", 15, " (10 lbs)",  10));
		menu.add(new MenuItem("DOG- Puppy (med/large breed) Food", 20, " (15 lbs)", 11));
		menu.add(new MenuItem("DOG- Adult Dog Food ", 25, " (20 lbs)", 12));
		menu.add(new MenuItem("DOG- Reduced Fat Adult Dog Food", 30, "(20 lbs)", 13));
		menu.add(new MenuItem("DOG- Senior Adult Dog Food ", 25, "(20 lbs)", 14));
	}
	
}
