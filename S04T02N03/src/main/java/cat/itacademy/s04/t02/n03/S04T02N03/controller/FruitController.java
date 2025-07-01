package cat.itacademy.s04.t02.n03.S04T02N03.controller;

import cat.itacademy.s04.t02.n03.S04T02N03.dto.FruitRequest;
import cat.itacademy.s04.t02.n03.S04T02N03.model.Fruit;
import cat.itacademy.s04.t02.n03.S04T02N03.service.FruitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping
    public ResponseEntity<?> createFruit(@Valid @RequestBody FruitRequest fruitRequest){

        Fruit fruit = new Fruit();
        fruit.setName(fruitRequest.getName());
        fruit.setQuantity(fruitRequest.getQuantity());

        Fruit newFruit = fruitService.createFruit(fruit);

        return ResponseEntity.status(HttpStatus.CREATED).body(newFruit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFruit(@PathVariable String id , @Valid @RequestBody FruitRequest fruitRequest){

        Fruit fruit = fruitService.getOneFruit(id);
        fruit.setName(fruitRequest.getName());
        fruit.setQuantity(fruitRequest.getQuantity());

        Fruit updatedFruit = fruitService.updateFruit(fruit);

        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFruit(@PathVariable String id){
        fruitService.getOneFruit(id);
        fruitService.deleteFruit(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Fruit> getAllFruits(){
        return fruitService.getAllFruits();
    }

    @GetMapping("/{id}")
    public Fruit getOneFruit (@PathVariable String id){
        return fruitService.getOneFruit(id);
    }
}