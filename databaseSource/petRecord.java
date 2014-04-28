
public class petRecord {
	public String ownerFirstName, ownerLastName, petName, catDog, sex, breed, color, dob, perscriptions, immunizations;
	int weight;
	
	public petRecord(String ofn, String oln, String pn, String cd, String s, String br, int w, String co, String d, String p, String i) {
		ownerFirstName = ofn;
		ownerLastName = oln;
		petName = pn;
		catDog = cd;
		sex = s;
		breed = br;
		weight = w;
		color = co;
		dob = d;
		perscriptions = p;
		immunizations = i;
	}
}
