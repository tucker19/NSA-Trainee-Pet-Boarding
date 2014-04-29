/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Menu.MenuItem;

/**
 *
 * @author Matt
 */
public class OrderItem {
    public MenuItem item;
    public String comment;
    int status = 0;
    
    public OrderItem(MenuItem new_item) {
                item = new_item;		
    }
    public MenuItem getItem(){
        return item;
    }
    public void setComment(String new_comment){
        comment = new_comment;
    }
    public String getComment(){
        return comment;
    }
    
    public int getStatus(){
        return status;
    }
    
    public void setStatus(int new_status){
        status = new_status;
    }
}
