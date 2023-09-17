import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class ToySet implements Loterable<Toy>{
    List<Toy> toys;
    Map<Toy, Integer> toysSet;

    public ToySet() {
        this.toys = new LinkedList<Toy>();
        this.toysSet = new HashMap<>();
    }

    public void add(Toy toy) {
        toys.add(toy);
        this.add(toy, 1);
    }

    public void add(Toy toy, int quantity){
        if(toysSet.containsKey(toy)){
            int count = toysSet.get(toy) + quantity;
            toysSet.put(toy, count);
        }else{
            toysSet.put(toy, quantity);
        }
    }

    // public void setWeight(int toyId, int weight) {
    //     for (Toy toy : toys) {
    //         if (toy.getId() == toyId) {
    //             toy.setWeight(weight);
    //             break;
    //         }
    //     }
    // }

    public Toy getToy(int id) {
        // for (Toy toy : toys) {
        //     if (toy.getId() == id) return toy;
        // }
        // return null;
        for (Toy toy : toysSet.keySet()) {
            if(toy.getId() == id)
                return toy;
        }
        return null;
    }

    public int getSize(){
        // return toys.size();
        return toysSet.size();
    }

    // public void extractItem(Toy toy){
    //     // for (Toy itemToy : toys) {
    //     //     if(itemToy.getId() == toy.getId()){
    //     //         int quantity = itemToy.getQuantity();
    //     //         if(quantity > 1){
    //     //             itemToy.setQuantity(quantity-1);
    //     //         }else{
    //     //             toys.remove(itemToy);
    //     //         }
    //     //         break;
    //     //     }
    //     // }
    //     if(toysSet.containsKey(toy)){
    //         int count = toysSet.get(toy);
    //         if(count == 1){
    //             toysSet.remove(toy);
    //         }else{
    //             toysSet.put(toy, --count);
    //         }
    //     }
    // }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        // for (Toy toy : toys) {
        //     joiner.add(toy.toString());
        // }
        for (Toy toy : toysSet.keySet()) {
            String item = "[" +  toy.toString() + " q: " + toysSet.get(toy) + "]";
            joiner.add(item);
        }
        return joiner.toString();
    }

    @Override
    public void extractItem(Toy item) {
         if(toysSet.containsKey(item)){
            int count = toysSet.get(item);
            if(count == 1){
                toysSet.remove(item);
            }else{
                toysSet.put(item, --count);
            }
        }
    }

    @Override
    public Map<Toy, Integer> summaryChance() {
        Map<Toy, Integer> result = new HashMap<>();
        for (Toy toy : toysSet.keySet()) {
            int chance = toysSet.get(toy) * toy.getWeight();
            result.put(toy, chance);
        }

        return result;
    }
}
