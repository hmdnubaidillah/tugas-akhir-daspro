package Menu;

public class MenuItem {
    private int index;
    private String name;
    private int price;

    public MenuItem(int index,String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    // Getters and setters (optional)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getIndex(){
        return index;
    }
}