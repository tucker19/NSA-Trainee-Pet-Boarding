package Menu;

public class MenuItem {

	public String name;
	public double price;
	public String description;
	public int id;

	
	public MenuItem(String n, double p, String d, int i) {
		name = n;
		price = p;
		description = d;
		id = i;
	}
	
	
	public double getPrice() {
		return price;
	}
        
        public String getName() {
            return name;
        }
	
	
	public int getId() {
		return id;
	}
	
	public String getDescription() { 
		return description;
	}
	
	
	public void setName(String newName) {
            name = newName;
        }
        
	public void setPrice(double p) {
		price = p;
	}
	
	
	public void setDescription(String d) {
		description = d;
	}
	
	public void setId(int i) {
		id = i;
	}
	
}

