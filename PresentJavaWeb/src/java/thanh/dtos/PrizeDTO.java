/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.dtos;

import java.io.Serializable;

/**
 *
 * @author Short Corn
 */
public class PrizeDTO implements Serializable{
    String prizeId, prizeName, description;
    int quantity=0, getOutQuantity=0;
    float price;

    public PrizeDTO(String prizeId, String prizeName, String description, int quantity, float price) {
        this.prizeId = prizeId;
        this.prizeName = prizeName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public PrizeDTO() {
    }

    public PrizeDTO(String prizeId, String prizeName,int quantity, float price) {
        this.prizeId = prizeId;
        this.prizeName = prizeName;
    
        this.quantity = quantity;
        this.price = price;
    }

    public int getGetOutQuantity() {
        return getOutQuantity;
    }

    public void setGetOutQuantity(int getOutQuantity) {
        this.getOutQuantity = getOutQuantity;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
