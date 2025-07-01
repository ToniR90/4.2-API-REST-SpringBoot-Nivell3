package cat.itacademy.s04.t02.n03.S04T02N03.repository;

import cat.itacademy.s04.t02.n03.S04T02N03.model.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepository extends MongoRepository<Fruit, String> {
}