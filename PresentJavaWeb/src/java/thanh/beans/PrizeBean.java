/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanh.beans;

import java.io.Serializable;
import java.util.List;
import thanh.daos.PrizeDAO;
import thanh.dtos.PrizeDTO;

/**
 *
 * @author Short Corn
 */
public class PrizeBean implements Serializable{
    List<PrizeDTO> listPrize;
    String priceID, prizeName;
    float minPrice, maxPrice;
    PrizeDTO dto;
    int quantity;
    int page, numberOfPage;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public PrizeBean() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<PrizeDTO> getListPrize() {
        return listPrize;
    }

    public void setListPrize(List<PrizeDTO> listPrize) {
        this.listPrize = listPrize;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPriceID() {
        return priceID;
    }

    public void setPriceID(String priceID) {
        this.priceID = priceID;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public PrizeDTO getDto() {
        return dto;
    }

    public void setDto(PrizeDTO dto) {
        this.dto = dto;
    }
    
    public void getAllDataPrize()throws Exception{
        PrizeDAO dao=new PrizeDAO();
        listPrize=dao.getAllDataPrize(page);
    }
    public boolean deletePrize()throws Exception{
        PrizeDAO dao=new PrizeDAO();
        return dao.deletePrize(priceID);
    }
    public void findPrizeByPrice()throws Exception{
        PrizeDAO dao=new PrizeDAO();
        listPrize=dao.findPrizeByPrice(minPrice, maxPrice);
    }
    public boolean insertPrize()throws Exception{
        PrizeDAO dao=new PrizeDAO();
        return dao.insertPrize(dto);
    }
    public boolean updatePrize()throws Exception{
        PrizeDAO dao=new PrizeDAO();
        return dao.updatePrize(dto);
    }
    public void findPrizeByPrimaryKey() throws Exception{
        PrizeDAO dao=new PrizeDAO();
        dto=dao.findPrizeByPrimaryKey(priceID);
    }
    public void loadPrizeByQuantity()throws Exception{
        PrizeDAO dao=new PrizeDAO();
        listPrize=dao.loadPrizeByQuantity();
    }
    public void loadAllPrizeByQuantity()throws Exception{
        PrizeDAO dao=new PrizeDAO();
        listPrize=dao.loadAllPrizeByQuantity();
    }
    public int countNumberOfRowInDB()throws Exception{
         PrizeDAO dao=new PrizeDAO();
        return numberOfPage=dao.countNumberOfRowInDB();
    }
    public String loadPrizeNameById()throws Exception{
        PrizeDAO dao=new PrizeDAO();
        return prizeName=dao.loadPrizeNameById(priceID);
    }
    
}
