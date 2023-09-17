public class Toy {
    private int id;
    private String name;
    private int quantity;
    private int weight;
    
    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }
    
    public int getId() {return id;}
    public String getName() {return name;}
    public int getQuantity() {return quantity;}
    public int getWeight() {return weight;}
    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        StringBuilder sBuilder = new StringBuilder("[id: ");
        sBuilder.append(this.id);
        sBuilder.append(", \"");
        sBuilder.append(this.name);
        sBuilder.append("\", q: ");
        sBuilder.append(this.quantity);
        sBuilder.append(", w: ");
        sBuilder.append(this.weight);
        sBuilder.append(']');
        return sBuilder.toString();
    }
}


