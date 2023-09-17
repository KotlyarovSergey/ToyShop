import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ToySet toys = new ToySet();
        fillToyBox(toys);
        System.out.println(toys);

        Raffle raffle = new Raffle(toys);
        PrizesQueue prizesQueue = new PrizesQueue("prizes.txt");
        while (toys.getSize() > 0) {
            Toy toy = raffle.playRound();
            prizesQueue.add(toy);
        }
        System.out.println(toys);

        while(prizesQueue.size() > 0) {
            prizesQueue.give();
        }
    }

    private static void fillToyBox(ToySet toys) {
        Toy toy = new Toy(0, "Doll", 30);
        toys.add(toy, 3);

        toy = new Toy(1, "Robot", 40);
        toys.add(toy, 5);

        toy = new Toy(2, "Medical set", 60);
        toys.add(toy, 2);

        toy = new Toy(3, "Car model", 10);
        toys.add(toy, 8);

        toy = new Toy(4, "Water gun", 30);
        toys.add(toy, 3);
    }

    
}