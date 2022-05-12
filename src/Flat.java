public class Flat<T> implements Rent{
    String name;
    String station;
    String address;
    int square;
    int price;
    float avgRating;
    T countRoom;

    public Flat(String name, String station, String address, int square, int price, float avgRating, T countRoom) {
        this.name = name;
        this.station = station;
        this.address = address;
        this.square = square;
        this.price = price;
        this.avgRating = avgRating;
        this.countRoom = countRoom;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Название='" + name + '\'' +
                ", Цена=" + price +
                ", Оценка=" + avgRating +
                '}';
    }

    public String getStation() {
        return station;
    }

    public float getAvgRating() {
        return avgRating;
    }

    public int getPrice() {
        return price;
    }
}
