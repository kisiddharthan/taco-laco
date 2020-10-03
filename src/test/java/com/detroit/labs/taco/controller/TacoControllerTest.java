package com.detroit.labs.taco.controller;

import com.detroit.labs.taco.controller.api.TacoRequest;
import com.detroit.labs.taco.controller.api.TacoResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TacoControllerTest {

    static TacoController tacoController;

    @BeforeAll
    public static void setup() { tacoController = new TacoController(); }

    @Test
    void testGetTotal() {
        TacoRequest request = TacoRequest.builder().tacoVeggie(1)
                .tacoChickenBeef(1)
                .tacoChorizo(1)
                .build();
        TacoResponse response = tacoController.getTotal(request);

        assertEquals(9.0, response.getTotal());
    }

    @Test
    void testGetTotalIncludesDiscount() {
        TacoRequest request = TacoRequest.builder().tacoVeggie(4).build();
        TacoResponse response = tacoController.getTotal(request);

        assertEquals(8.0, response.getTotal());
    }
}