package com.detroit.labs.taco.controller;

import com.detroit.labs.taco.controller.api.TacoRequest;
import com.detroit.labs.taco.controller.api.TacoResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/getTotal")
public class TacoController {

    @PostMapping
    public TacoResponse getTotal(@RequestBody @Valid TacoRequest[] tacoRequest) {

        double total = 0;
        int count = 0;

        for (TacoRequest request: tacoRequest) {
            switch (request.getName()) {
                case "tacoVeggie":
                    total = total + request.getValue() * 2.50;
                    break;
                case "tacoChickenBeef":
                    total = total + request.getValue() * 3.00;
                    break;
                case "tacoChorizo":
                    total = total + request.getValue() * 3.50;
                    break;
                default:
            }
            count = count + request.getValue();
        }
        if(count > 3)
            total = total - (total * .2);

        TacoResponse tacoResponse = new TacoResponse();
        tacoResponse.setTotal(total);
        return tacoResponse;
    }
}
