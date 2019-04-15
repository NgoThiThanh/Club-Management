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
public class ContestErrorDTO implements Serializable{
    String contestIdError;

    public ContestErrorDTO() {
    }

    public String getContestIdError() {
        return contestIdError;
    }

    public void setContestIdError(String contestIdError) {
        this.contestIdError = contestIdError;
    }
    
}
