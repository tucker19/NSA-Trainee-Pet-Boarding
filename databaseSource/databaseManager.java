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
			addPetRecord("Matthew",  "Jahnke", "Archer2", "Dog", "M", "Something", 15, "Black", "04-01-2014", "Allofem" , "ALLOFEM" );
			petRecord[] p = getPetRecords();
			for (petRecord r: p) {
				System.out.println("OwnerFirstName is " + r.ownerFirstName + " PetName is " + r.petName);
			}
		} else {
			System.out.println("Failed to make connection!");
		}
		
		
	}
	
	public static void addPetRecord(String ofn, String oln, String pn, String cd, String s, String br, int w, String co, String d, String p, String i) {
		Statement stmt;
		try {
			stmt = conn.createStatement ();
			String sql = "INSERT INTO PET_RECORDS " +
	                   "VALUES ('Mattttt', 'JAH-NKE', 'TheDOG', 'Dog', 'M', 'Lab', 115, 'Black', '04-21-14', 'ALL DEM', 'SO IMMUNE')";
	      stmt.executeUpdate(sql);
			
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
}