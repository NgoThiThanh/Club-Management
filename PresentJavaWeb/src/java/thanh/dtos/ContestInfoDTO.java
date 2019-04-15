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
public class ContestInfoDTO implements Serializable{
    String prizeId, contestId;
    int rewardRank;
    int quantity, quantityInPrize;
    float price;
    String prizeName;
    public ContestInfoDTO() {
    }

    public ContestInfoDTO(String prizeId, String contestId, int rewardRank, int quantity, float price) {
        this.prizeId = prizeId;
        this.contestId = contestId;
        this.rewardRank = rewardRank;
        this.quantity = quantity;
        this.price = price;
    }
    public ContestInfoDTO(String prizeId, float price) {
        this.prizeId = prizeId;
        this.price = price;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getContestId() {
        return contestId;
    }

    public int getQuantityInPrize() {
        return quantityInPrize;
    }

    public void setQuantityInPrize(int quantityInPrize) {
        this.quantityInPrize = quantityInPrize;
    }

    public void setContestId(String contestId) {
        this.contestId = contestId;
    }

    public int getRewardRank() {
        return rewardRank;
    }

    public void setRewardRank(int rewardRank) {
        this.rewardRank = rewardRank;
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
