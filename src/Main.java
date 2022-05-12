import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Rent> rentList = new ArrayList<Rent>(Arrays.asList(
                new Flat<Integer>("Евро", "Сокольники", "Самара, ул. Московская, 4", 40, 3500000, 8.7f, 2)
                , new Premises<String>("Вита", "Ольховская", "Москва, ул. Самарская, 1", 45, 1000000, 9.1f, "Аптека")
                , new Flat<Integer>("Сталинка", "Сокольники", "Самара, ул. Тургенева, 16", 40, 8000000, 5.2f, 4)
                , new Premises<String>("ЦУМ", "Ольховская", "Москва, ул. Терешковой, 43", 45, 1000000, 6.4f, "Магазин")
                , new Flat<Integer>("Студия", "Динамо", "Самара, ул. Победы, 159", 40, 3000000, 9.0f, 1)
                , new Premises<String>("Овощебаза", "Каширская", "Москва, ул. Театральная, 8", 45, 100000000, 5.9f, "Склад")
                , new Flat<Integer>("Хрущевка", "Динамо", "Самара, ул. Степана Разина, 19", 40, 6000000, 4.4f, 3)
        ));

        System.out.println("Вывод коллекции на экран: ");
        outputRentList(rentList, null);

        System.out.println("\nДобавление в коллекцию квартиры \"Панелька\" и коммерческого помещения \"Булочка\":");
        //	Добавление квартиры в список для аренды.
        addRent(rentList, new Flat<Integer>("Панелька", "Чистые пруды", "Самара, ул. Свердлова, 9", 67, 4500000, 3.7f, 3));
        //	Добавление помещения в список для аренды.
        addRent(rentList, new Premises<String>("Булочка", "Вишневая", "Москва, ул. Высоцкого, 4", 102, 10000000, 9.4f, "Пекарня"));
        outputRentList(rentList, null);

        System.out.println("\nУдаление из коллекции  квартиры \"Панелька\" и коммерческого помещения: \"Булочка\": ");
        //	Удалить квартиру из списка для аренды.
        removeRent(rentList, "Flat", "Панелька");
        //	Удалить помещение из списка для аренды.
        removeRent(rentList, "Premises", "Булочка");
        outputRentList(rentList, null);

        System.out.println("\nСортировка квартир по цене по возрастанию: ");
        sortPriceAsc(rentList, "Flat");

        System.out.println("\nСортировка помещений по цене по  возрастанию: ");
        sortPriceAsc(rentList, "Premises");

        System.out.println("\nСортировка квартир по цене по убыванию: ");
        sortPriceDesc(rentList, "Flat");

        System.out.println("\nСортировка помещений по цене по убыванию: ");
        sortPriceDesc(rentList, "Premises");

        System.out.println("\nСгруппировать квартиры по станции метро и вывести:");
        groupMetroStation(rentList, "Flat");

        System.out.println("\nСгруппировать помещения по станции метро и вывести.:");
        groupMetroStation(rentList, "Premises");

        System.out.println("\nВыбрать лучшую квартиру по оценке и вывести:");
        betterRating(rentList, "Flat");

        System.out.println("\nВыбрать лучшее комерческое помещение по оценке и вывести:");
        betterRating(rentList, "Premises");

        System.out.println("\nВывести изначальный список квартир для аренды. (Порядок, в котором они были добавлены):");
        initialRentList(rentList, "Flat");

        System.out.println("\nВывести изначальный список помещений для аренды. (Порядок, в котором они были добавлены):");
        initialRentList(rentList, "Premises");

        System.out.println("\nВывести сгруппированные списки. (Квартиры – список, Коммерческие помещение - список):");
        groupRentList(rentList);

        System.out.println("\nУдалить всё из списков:");
        rentList.clear();
        outputRentList(rentList, null);


    }

    public static void initialRentList(List<Rent> rentList, String nameObject){
        rentList.stream().filter(x-> x.getClass().getName().equals(nameObject)).forEachOrdered(System.out::println); ;
    }

    //	Удалить объект из списока аренды.
    public static void removeRent(List<Rent> rentList, String nameObject, String name)
    {
        Optional<Rent> rent = rentList.stream().filter(x-> x.getClass().getName().equals(nameObject) && x.getName().equals(name)).findFirst();
        rent.ifPresent(rentList::remove);
    }

    public static void groupMetroStation(List<Rent> rentList, String nameObject) {
        Map<String, List<Rent>> hashMap =
                rentList.stream().filter(x-> x.getClass().getName().equals(nameObject)).collect(Collectors.groupingBy(Rent::getStation)) ;
        hashMap.forEach((k,v)->
        {
            System.out.println(k) ;
            for (Rent rent : v) {
                System.out.println(rent);
            }
        } );
    }

    public static void groupRentList(List<Rent> rentList) {
    Map<String, List<Rent>> hashMap =
            rentList.stream().collect(Collectors.groupingBy(x -> x.getClass().getName()=="Premises" ? "Торговые помещения:" : "Квартиры:" ));
        hashMap.forEach((k,v)->
        {
            System.out.println(k) ;
            for (Rent rent : v) {
                System.out.println(rent);
            }
        } );
    }



    public static void sortPriceAsc(List<Rent> rentList, String nameObject){
        rentList.stream().filter(x-> x.getClass().getName().equals(nameObject)).sorted(Comparator.comparing(Rent::getPrice)).forEach(System.out::println);
    }
    public static void sortPriceDesc(List<Rent> rentList, String nameObject){
        rentList.stream().filter(x-> x.getClass().getName().equals(nameObject)).sorted(Comparator.comparing(Rent::getPrice).reversed()).forEach(System.out::println);
    }

    //	Добавить объект в список для аренды.
    public static void addRent(List<Rent> rentList, Rent rent)
    {
        rentList.add(rent);
    }

    // Вывод коллекции на экран
    public static void outputRentList(List<Rent> rentList, String nameObject)
    {
        if (nameObject == null)
            rentList.forEach(System.out::println);
        else
            rentList.stream().filter(x -> x.getClass().getName().equals(nameObject)).forEach(System.out::println);
    }

    //	Выбрать лучшее по оценке и вывести.
    public static void betterRating(List<Rent> rentList, String nameObject)
    {
        rentList.stream().filter(x-> x.getClass().getName().equals(nameObject)).max(Comparator.comparing(Rent::getAvgRating)).ifPresent(System.out::println);
    }

}
