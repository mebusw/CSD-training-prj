package example

class Administor {
    def assign(Room room, int price) {
        room.setPrice(price)
    }

    def setCoupon(Room room, float rate) {
        room.setCouponRate(rate);
    }

    def giveGoldCardTp(Coach coach) {
        coach.isGolden=true;
    }
}
