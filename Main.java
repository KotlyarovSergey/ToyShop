public class Main {
    public static void main(String[] args) {
        ToySet toys = new ToySet();
        fillToySet(toys);
        System.out.println(toys);

        Raffle raffle = new Raffle(toys);
        int number = 0;
        while (toys.getSize() > 0) {
            Toy toy = raffle.playRound();
            System.out.printf("Vinner %s: %s\n", ++number, toy.getName());
        }
        System.out.println(toys);
    }


    private static void fillToySet(ToySet toys) {
        Toy toy = new Toy(0, "Doll", 20);
        toys.add(toy, 3);

        toy = new Toy(1, "Robot", 30);
        toys.add(toy, 5);

        toy = new Toy(2, "Medical set", 60);
        toys.add(toy, 2);

        toy = new Toy(3, "Car model", 10);
        toys.add(toy, 15);
    }

}