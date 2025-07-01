package cat.itacademy.s04.t02.n03.S04T02N03.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "fruits")
public class Fruit {

    @Id
    private String id;

    private String name;
    private Long quantity;

    public Fruit(){

    }

    public Fruit (String name , Long quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public Fruit(String id, String name, Long quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit: " + name + "\n" +
                "Id: " + id + "\n" +
                "Quantity: " + quantity;
    }
}
