package cat.itacademy.s04.t02.n03.S04T02N03.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FruitRequest {

    @NotBlank(message = "Name can't be empty")
    private String name;

    @NotNull(message = "Quantity can't be empty")
    @Min(value = 1, message = "Quantity must be positive")
    private Long quantity;

    public FruitRequest() {

    }

    public FruitRequest(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
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
}
