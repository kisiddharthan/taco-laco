package com.detroit.labs.taco.controller;

import com.detroit.labs.taco.controller.api.TacoRequest;
import com.detroit.labs.taco.controller.api.TacoResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TacoControllerTest {

    static TacoController tacoController;

    @BeforeAll
    public static void setup() {
        tacoController = new TacoController();
    }

    @Test
    void testGetTotal() {
        TacoRequest item1 = TacoRequest.builder().name("tacoVeggie").value(1).build();
        TacoRequest[] requests = new TacoRequest[1];
        requests[0] = item1;
        TacoResponse response = tacoController.getTotal(requests);

        assertEquals(2.5, response.getTotal());
    }

    @Test
    void testGetTotalIncludesDiscount() {
        TacoRequest item1 = TacoRequest.builder().name("tacoVeggie").value(4).build();
        TacoRequest[] requests = new TacoRequest[1];
        requests[0] = item1;
        TacoResponse response = tacoController.getTotal(requests);

        assertEquals(8.0, response.getTotal());
    }

    @Test
    void testGetTotalMultipleItems() {
        TacoRequest item1 = TacoRequest.builder().name("tacoVeggie").value(1).build();
        TacoRequest item2 = TacoRequest.builder().name("tacoChickenBeef").value(1).build();
        TacoRequest item3 = TacoRequest.builder().name("tacoChorizo").value(1).build();
        TacoRequest[] requests = new TacoRequest[3];
        requests[0] = item1;
        requests[1] = item2;
        requests[2] = item3;
        TacoResponse response = tacoController.getTotal(requests);

        assertEquals(9.0, response.getTotal());
    }
}