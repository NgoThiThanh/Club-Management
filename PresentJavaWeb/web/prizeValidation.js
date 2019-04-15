/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validateInsertPrize() {
//    String prizeId, prizeName,status, description;
//    int quantity;
//    float price;
    var prizeId = document.getElementById('prizeId').value;
    var prizeName = document.getElementById('prizeName').value;
    var price = document.getElementById('price').value;
    var quantity = document.getElementById('quantity').value;

    var validPrizeId = document.getElementById('prizeId-error');
    var validPrizeName = document.getElementById('prizeName-error');
    var validPrice = document.getElementById('price-error');
    var validQuantity = document.getElementById('quantity-error');

    if (prizeId.length === 0) {
        validPrizeId.innerHTML = "Prize Id can't be blank!";
        return false;
    } else {
        validPrizeId.innerHTML = "";
    }

    if (prizeName.length === 0) {
        validPrizeName.innerHTML = "Prize Name can't be blank!";
        return false;
    } else {
        validPrizeName.innerHTML = "";
    }

    if (price.length === 0) {
        validPrice.innerHTML = "Price can't be blank!";
        return false;
    } else if (price < 0 || isNaN(price)) {

        validPrice.innerHTML = "Price must be a positive number!";
        return false;
    } else {
        validPrice.innerHTML = "";
    }

    if (quantity.length === 0) {
        validQuantity.innerHTML = "Quantity can't be blank!";
        return false;
    } else if (quantity < 0 || isNaN(quantity)) {
        validQuantity.innerHTML = "Quantity must be a positive number!";
        return false;
    } else {
        validQuantity.innerHTML = "";
    }


}

function validateSearchPrize(){
    var minPrice=document.getElementById('minPrice').value;
    var maxPrice=document.getElementById('maxPrice').value;
    
    var validateMinPrice=document.getElementById('minPrice-error');
    var validateMaxPrice=document.getElementById('maxPrice-error');
    
    if(minPrice.length===0){
        validateMinPrice.innerHTML="**Min price cant be blank.";
        return false;
    }else if(minPrice<0 || isNaN(minPrice)){
        validateMinPrice.innerHTML="**Min price must be a positive number.";
        return false;
    }
    else{
        validateMinPrice.innerHTML="";
    }
    
    if(maxPrice.length===0){
        validateMaxPrice.innerHTML="**Max price cant be blank.";
        return false;
    }else if(maxPrice<0 || isNaN(maxPrice)){
        validateMaxPrice.innerHTML="**Max price must be a positive number.";
        return false;
    }
    else{
        validateMaxPrice.innerHTML="";
    }
}



