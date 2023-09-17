import java.util.Map;

public interface Loterable<T> {
    void extractItem(T item);
    Map<T, Integer> summaryChance();
}
