import java.util.Date;


public class boarding {
	Date startDate, endDate;
	String petName, ownerFirstName, ownerLastName;
	int petWeight;
	
	public boarding(String p, String ofn, String oln, int w, Date sd, Date ed) {
		petName = p;
		ownerFirstName = ofn;
		ownerLastName = oln;
		petWeight = w;
		startDate = sd;
		endDate = ed;
	}
}
