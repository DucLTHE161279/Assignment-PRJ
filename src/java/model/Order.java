/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Order {
    
  private ArrayList<OrderDetail> details = new ArrayList<>();
    public int getSize(){
        return details.size();
    }
    public float getTotal(){
    float sum = 0;
    for (OrderDetail detail : details){
        sum+=detail.getTotal();
    }
    return sum;}

    public ArrayList<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<OrderDetail> details) {
        this.details = details;
    }

 

}
