public class Premises<T> implements Rent{
    String name;
    String station;
    String address;
    int square;
    int price;
    float avgRating;
    T typeRoom;

    public Premises(String name, String station, String address, int square, int price, float avgRating, T typeRoom) {
        this.name = name;
        this.station = station;
        this.address = address;
        this.square = square;
        this.price = price;
        this.avgRating = avgRating;
        this.typeRoom = typeRoom;
    }

    @Override
    public String toString() {
        return "Название='" + name + '\'' +
                ", Цена=" + price +
                ", Оценка=" + avgRating +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getStation() {
        return station;
    }

    public int getPrice() {
        return price;
    }

    public float getAvgRating() {
        return avgRating;
    }
}
