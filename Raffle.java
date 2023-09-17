import java.util.Map;
import java.util.Random;

public class Raffle {
    private Loterable<Toy> itemSet;

    public Raffle(Loterable<Toy> itemSet) {
        this.itemSet = itemSet;
    }

    public Toy playRound(){
        Map<Toy, Integer> chances = itemSet.summaryChance();
        int chanceSumm = calcChanceSumm(chances);
        int number = new Random().nextInt(chanceSumm);
        Toy vennerToy = getVinnerToy(chances, number);
        itemSet.extractItem(vennerToy);
        return vennerToy;
    }
    
  
    private int calcChanceSumm(Map<Toy, Integer> chances){
        int result = 0;
        for (int chance : chances.values()) {
            result += chance;
        }
        return result;
    }

    private Toy getVinnerToy(Map<Toy, Integer> chances, int playValue){
        int n = 0;
        for (Toy toy : chances.keySet()) {
            n += chances.get(toy);
            if (playValue < n) return toy;
        }
        return null;
    }
}
