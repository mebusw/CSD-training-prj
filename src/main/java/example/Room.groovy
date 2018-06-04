package example

class Room {
    int price=300;

    def rate=1f;

    Object ordered;

    int getSalePrice() {return price*rate;}

    def setPrice(int price){this.price = price}

    def setCouponRate(float rate){
        this.rate=rate/10f;
    }

    int getActualPrice(){
        return price;
    }

    Object getOrdered() {
        return ordered;
    }

    def setOrdered(Object ordered){
        if(this.ordered == null){

            this.ordered = ordered
        }else{
            throw new Exception("Room is Ordered")
        }
    }

}
