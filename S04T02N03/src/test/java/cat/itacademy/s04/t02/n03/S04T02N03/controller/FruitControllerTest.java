package cat.itacademy.s04.t02.n03.S04T02N03.controller;

import cat.itacademy.s04.t02.n03.S04T02N03.dto.FruitRequest;
import cat.itacademy.s04.t02.n03.S04T02N03.model.Fruit;
import cat.itacademy.s04.t02.n03.S04T02N03.service.FruitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FruitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FruitService fruitService;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class MockConfig {
        @Bean
        public FruitService fruitService() {
            return Mockito.mock(FruitService.class);
        }
    }

    @Test
    void createFruit_shouldReturnCreatedFruit() throws Exception {
        FruitRequest request = new FruitRequest("Cherry", 1L);
        Fruit savedFruit = new Fruit("1" , "Cherry", 1L);

        Mockito.when(fruitService.createFruit(Mockito.any(Fruit.class))).thenReturn(savedFruit);

        mockMvc.perform(post("/fruits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Cherry"))
                .andExpect(jsonPath("$.quantity").value(1));
    }

    @Test
    void createFruit_shouldReturnBadRequest_whenInvalid() throws Exception {
        FruitRequest request = new FruitRequest("", 0L);

        mockMvc.perform(post("/fruits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void updateFruit_shouldReturnUpdatedFruit() throws Exception {
        Fruit existing = new Fruit("Apple", 5L);
        FruitRequest updatedRequest = new FruitRequest("Pear", 9L);
        Fruit updated = new Fruit("Pear", 9L);

        Mockito.when(fruitService.getOneFruit("1"))
                .thenReturn(new Fruit("1", "Apple", 5L));

        Mockito.when(fruitService.updateFruit(Mockito.any(Fruit.class)))
                .thenReturn(new Fruit("1", "Pear", 9L));

        mockMvc.perform(put("/fruits/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Pear"))
                .andExpect(jsonPath("$.quantity").value(9));
    }

    @Test
    void deleteFruit_shouldReturnNoContent() throws Exception {
        Fruit existing = new Fruit("Cherry", 3L);

        Mockito.when(fruitService.getOneFruit("1")).thenReturn(existing);
        Mockito.doNothing().when(fruitService).deleteFruit("1");

        mockMvc.perform(delete("/fruits/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void getOneFruit_shouldReturnSingleFruit() throws Exception {
        Fruit fruit = new Fruit("1" , "Apple", 8L);

        Mockito.when(fruitService.getOneFruit("1")).thenReturn(fruit);

        mockMvc.perform(get("/fruits/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Apple"))
                .andExpect(jsonPath("$.quantity").value(8));
    }

    @Test
    void getAllFruits_shouldReturnList() throws Exception {
        List<Fruit> fruits = List.of(
                new Fruit("1" , "Strawberry", 10L),
                new Fruit("2" , "Kiwi", 5L)
        );

        Mockito.when(fruitService.getAllFruits()).thenReturn(fruits);

        mockMvc.perform(get("/fruits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Strawberry"))
                .andExpect(jsonPath("$[1].quantity").value(5));
    }
}