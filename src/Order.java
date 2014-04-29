
import java.util.ArrayList;
import Menu.MenuItem;
import java.util.Iterator;

public class Order {
	public int table_no;
	public double total_price;
	public String comments;
        public int splitOrder = 1;
        public double sub_total;
        public double gratuity = 0;
//        public ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        public ArrayList<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order(int table) {
		table_no = table;
		//comments = notes;
		//items.add(order);		
	}	
	
	public double getPrice() {
            sub_total = 0;
            Iterator<OrderItem> it = items.iterator();
            while(it.hasNext()){
                OrderItem obj = it.next();
                sub_total += obj.getItem().getPrice();
            }
                
                
//		total_price = temp;
//		return total_price;
            return sub_total;
	}
        
        public int getTable(){
            return table_no;
        }
        
        public double totalPrice(){
            return total_price;
        }
    
	public double addTax(double tax) {
		total_price = sub_total*tax;
		return total_price;
	}
	
        public double getGratuity(){
            return gratuity;
        }
        
        public void addGratuity(double value){
            gratuity += value;
        }

        public void setSplit(int split){
            splitOrder = split;
        }
        
        public int getSplit(){
            return splitOrder;
        }
        
        public ArrayList getItems(){
            return items;
        }
	
	public void addItem(MenuItem new_item) {
		items.add(new OrderItem(new_item));
	}
	
	public void deleteItem(int new_item) {
		items.remove(new_item);
	}
	
	public void deleteOrder() {
		items.clear();
                total_price = 0;
                sub_total = 0;
                splitOrder = 1;
                gratuity = 0;
	}
}

//package POS;
//
//import java.util.ArrayList;
//import Menu.MenuItem;
//
//public class Order {
//	public int table_no;
//	public double total_price;
//	public String comments;
//        public ArrayList<MenuItem> items = new ArrayList<MenuItem>();
//	//public ArrayList <MenuItem> items = new ArrayList<MenuItem>();
//	
//	public Order(int table, String notes) {
//		table_no = table;
//		comments = notes;
////		items = order;		
//	}	
//	
//	public double getPrice() {
//		//loop to calculate price
//		return total_price;
//	}
//        
//        public String getComment(){
//            return comments;
//        }
//        
//        public void setComment(String newComment){
//            comments = newComment;
//        }
//        
//        public ArrayList getItems(){
//            return items;
//        }
//	
//	public void addItem(MenuItem new_item) {
//		items.add(new_item);
//	}
//	
//	public void deleteItem(int new_item) {
//		items.remove(new_item);
//	}
//	
//	public void deleteOrder() {
//		items.clear();
//	}
//}
