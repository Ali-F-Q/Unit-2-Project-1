public class Item{

  String name;
  long itemNum;
  float price;
  int quantity;

  public Item(String name, long itemNum, float price, int quantity){
    this.name = name;
    this.itemNum = itemNum;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return this.name;
  }

  public long getItemNum() {
    return this.itemNum;
  }

  public float getPrice() {
    return this.price;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public String toString() {
    return this.name + " " + this.itemNum + " " + this.price + " " + this.quantity;
  }
}