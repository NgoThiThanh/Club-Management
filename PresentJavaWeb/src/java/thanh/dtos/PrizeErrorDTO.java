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
public class PrizeErrorDTO implements Serializable{
    String prizeIdError;

    public PrizeErrorDTO() {
    }

    public String getPrizeIdError() {
        return prizeIdError;
    }

    public void setPrizeIdError(String prizeIdError) {
        this.prizeIdError = prizeIdError;
    }
    
}
