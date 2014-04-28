import java.sql.*;

public class databaseManager {
	public static Connection conn = null;

	public static void main(String args[]) {
		Statement stat = null;
		ResultSet result = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
	 
		try {
			System.out.println("Going to try to connect");
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/egroves","egroves", "eecs690");
			System.out.println("Connected");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (conn != null) {
			System.out.println("You made it, take control your database now!");
			System.out.println("Getting pets");
			//addPetRecord("Matthew",  "Jahnke", "Archer2", "Dog", "M", "Something", 15, "Black", "04-01-2014", "Allofem" , "ALLOFEM" );
			petRecord[] p = getPetRecords();
			for (petRecord r: p) {
				System.out.println("OwnerFirstName is " + r.ownerFirstName + " PetName is " + r.petName);
			}
			ownerRecord[] o = getOwnerRecords();
			//addOwnerRecord("Eric", "Groves", "123 Street", "Lawrence", "KS", "66046", "123 Street", "Lawrence", "KS", "66046", "123456789", "234567890", "341256789");
			for (ownerRecord r: o) {
				System.out.println("OwnerFirstName is " + r.firstName + " Address is " + r.contactAddress);
			}
		} else {
			System.out.println("Failed to make connection!");
		}
		
		
	}
	
	public static void addPetRecord(String ofn, String oln, String pn, String cd, String s, String br, int w, String co, String d, String p, String i) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into PET_RECORDS(Owner_First_Name, Owner_Last_Name, Pet_Name, Cat_Dog, Sex, Breed, Weight, Color, Dob, " +
					"Perscriptions, Immunizations) values(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, ofn);
			pst.setString(2, oln);
			pst.setString(3, pn);
			pst.setString(4, cd);
			pst.setString(5, s);
			pst.setString(6, br);
			pst.setInt(7, w);
			pst.setString(8, co);
			pst.setString(9, d);
			pst.setString(10, p);
			pst.setString(11, i);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static petRecord[] getPetRecords() {
		Statement stat = null;
		ResultSet result = null;
		int petRecordSize = 0;
		try {
			stat = conn.createStatement();
			result = stat.executeQuery("SELECT COUNT(*) FROM PET_RECORDS");
			if(result.next()) 
				petRecordSize = result.getInt(1); 
			//System.out.println("size is: " + petRecordSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		petRecord[] pets = new petRecord[petRecordSize];
		
		try {
			stat = conn.createStatement();
			result = stat.executeQuery("SELECT * FROM PET_RECORDS");
			int count = 0; 
			while (result.next()) {
				String ownerFirstName = result.getString("Owner_First_Name");
				String ownerLastName = result.getString("Owner_Last_Name");
				String petName = result.getString("Pet_Name");
				String catDog = result.getString("Cat_Dog");
				String sex = result.getString("Sex");
				String breed = result.getString("Breed");
				int weight = result.getInt("Weight");
				String color = result.getString("Color");
				String dob = result.getString("Dob");
				String perscriptions = result.getString("Perscriptions");
				String immunizations = result.getString("Immunizations");
				petRecord p = new petRecord(ownerFirstName, ownerLastName, petName, catDog, sex, breed, weight, color, dob, perscriptions, immunizations);
				pets[count] = p;
				count++;
				//System.out.println(petName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pets;
	}
	
	public static ownerRecord[] getOwnerRecords() {
		Statement stat = null;
		ResultSet result = null;
		int ownerRecordSize = 0;
		try {
			stat = conn.createStatement();
			result = stat.executeQuery("SELECT COUNT(*) FROM OWNER_RECORDS");
			if(result.next()) 
				ownerRecordSize = result.getInt(1); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ownerRecord[] owners = new ownerRecord[ownerRecordSize];
		
		try {
			stat = conn.createStatement();
			result = stat.executeQuery("SELECT * FROM OWNER_RECORDS");
			int count = 0; 
			while (result.next()) {
				String firstName = result.getString("First_Name");
				String lastName = result.getString("Last_Name");
				String contactAddress = result.getString("Contact_Address");
				String contactCity = result.getString("Contact_City");
				String contactState = result.getString("Contact_State");
				String contactZip = result.getString("Contact_Zip");
				String billingAddress = result.getString("Billing_Address");
				String billingCity = result.getString("Billing_City");
				String billingState = result.getString("Billing_State");
				String billingZip = result.getString("Billing_Zip");
				String cellPhone = result.getString("Cell_Phone");
				String homePhone = result.getString("Home_Phone");
				String workPhone = result.getString("Work_Phone");
				ownerRecord o = new ownerRecord(firstName, lastName, contactAddress, contactCity, contactState, contactZip,
						billingAddress, billingCity, billingState, billingZip, cellPhone, homePhone, workPhone);
				owners[count] = o;
				count++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return owners;
	}
	
	public static void addOwnerRecord(String fn, String ln, String ca, String cc, String cs, String cz, 
			String ba, String bc, String bs, String bz, String cp, String hp, String wp) {
		Statement stmt;
		try {
			PreparedStatement pst = conn.prepareStatement("insert into OWNER_RECORDS(First_Name, Last_Name, Contact_Address, Contact_City, Contact_State, Contact_Zip," +
					"Billing_Address, Billing_City, Billing_State, Billing_Zip, Cell_Phone, Home_Phone, Work_Phone) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, fn);
			pst.setString(2, ln);
			pst.setString(3, ca);
			pst.setString(4, cc);
			pst.setString(5, cs);
			pst.setString(6, cz);
			pst.setString(7, ba);
			pst.setString(8, bc);
			pst.setString(9, bs);
			pst.setString(10, bz);
			pst.setString(11, cp);
			pst.setString(12, hp);
			pst.setString(13, wp);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}