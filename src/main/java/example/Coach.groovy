package example

class Coach {

    boolean isGolden

    int getOrderPrice(Room room) {
        return room.getSaledPrice()*(isGolden?0.8:1)
    }
}
