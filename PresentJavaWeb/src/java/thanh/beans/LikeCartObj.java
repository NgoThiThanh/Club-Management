/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.beans;

import java.io.Serializable;
import java.util.HashMap;
import thanh.dtos.ContestInfoDTO;
import thanh.dtos.PrizeDTO;

/**
 *
 * @author Short Corn
 */
public class LikeCartObj implements Serializable{
    
    private HashMap<String, ContestInfoDTO> carts;

    public LikeCartObj(){
        this.carts=new HashMap<>();
    }

    public HashMap<String, ContestInfoDTO> getCart() {
        return carts;
    }

    public void setCart(HashMap<String, ContestInfoDTO> cart) {
        this.carts = cart;
    }
    
    public void addToCart(ContestInfoDTO dto) throws Exception {

        if (carts.containsKey(dto.getPrizeId())) {
            int quantity = carts.get(dto.getPrizeId()).getQuantity() + 1;
            dto.setQuantity(quantity);
        }
        this.carts.put(dto.getPrizeId(), dto);
       
    }
    

    public void removeCart(String id) throws Exception{
        if(carts.containsKey(id)){
            this.carts.remove(id);
        }
    }
    
    public void update(String id,int quatity, int rank) throws Exception{
    if (this.carts.containsKey(id)) {
        this.carts.get(id).setQuantity(quatity);
        this.carts.get(id).setRewardRank(rank);
        
    }
}

}
