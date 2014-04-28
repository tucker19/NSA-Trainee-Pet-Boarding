
public class ownerRecord {
	String name;
	String contactAddress, contactCity, contactState, contactZip;
	String billingAddress, billingCity, billingState, billingZip;
	String cellPhone, homePhone, workPhone;
	
	public ownerRecord(String na, String ca, String cc, String cs, String cz, 
			String ba, String bc, String bs, String bz, String cp, String hp, String wp) {
		
		name = na;
		contactAddress = ca;
		contactCity = cc;
		contactState = cs;
		contactZip = cz;
		billingAddress = ba;
		billingCity = bc;
		billingState = bs;
		billingZip = bz;
		cellPhone = cp;
		homePhone = hp;
		workPhone = wp;
		
	}
}
