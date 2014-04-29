import java.util.Calendar;
import java.util.Date;

public class appointment {
	String petName, ownerFirstName, ownerLastName, hour, minute, room, reason;
	Date appointmentDate;
	
	public appointment(String pn, String ofn, String oln, Date d, String ro, String re) {
		petName = pn;
		ownerFirstName = ofn;
		ownerLastName = oln;
		appointmentDate = d;
		room = ro;
		reason = re;
	}
	
}
