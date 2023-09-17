/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        // Toy toy = new Toy(0, "Doll", 3, 20);
        Toy toy = new Toy(0, "Doll", 20);
        System.out.println(toy);

        ToySet toys = new ToySet();
        fillToySet(toys);
        System.out.println(toys);

        toy = toys.getToy(1);
        toy.setWeight(40);
        System.out.println(toys);

        toy = toys.getToy(2);
        toys.extractItem(toy);
        System.out.println(toys);
        
        toys.extractItem(toy);
        System.out.println(toys);

    }

    // private static void fillToySet(ToySet toys){
    //     Toy toy = new Toy(0, "Doll", 3, 20);
    //     toys.add(toy);
        
    //     toy = new Toy(1, "Robot", 5, 30);
    //     toys.add(toy);
        
    //     toy = new Toy(2, "Medical set", 2, 60);
    //     toys.add(toy);
        
    //     toy = new Toy(2, "Car model", 10, 10);
    //     toys.add(toy);
    // }

    private static void fillToySet(ToySet toys){
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