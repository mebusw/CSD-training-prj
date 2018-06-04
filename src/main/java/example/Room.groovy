package example

class Room {
    int price=300;

    def rate=1f;

    int getSaledPrice() {return price*rate;}

    def setPrice(int price){this.price = price}

    def setCouponRate(float rate){
        this.rate=rate/10f;
    }

    int getActualPrice(){
        return price;
    }


}
