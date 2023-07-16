/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package han.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hieu-Acer
 */
public class CartObj implements Serializable {
    private String customerId; 
    private Map<String, Map<Float, Integer>> items;

    
    public String getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, Map<Float, Integer>> getItems() {
        return items;
    }
    
    public Map<Float, Integer> getItemsValue(String title) {
        return items.get(title);
    }

    public void addItemToCart (String title, float price) {
        Map<Float, Integer> tmp = new HashMap<Float, Integer>();
        if (this.items == null) {
            this.items = new HashMap<String, Map<Float, Integer>>();
        }
        
        int quantity = 1;
        if (this.items.containsKey (title)) { 
            quantity = (this.items.get(title)).get(price) + 1;
        }
        
        tmp.put(price, quantity);
        this.items.put(title, tmp);
    }
    
    public void removeItemFromCart (String title) {
        if (this.items == null) {
            return;
        }
        
        if (this.items.containsKey (title)) { 
            this.items.remove(title);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
}
