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
    public TacoResponse getTotal(@RequestBody @Valid TacoRequest tacoRequest) {

        TacoResponse tacoResponse = new TacoResponse();
        double total = (tacoRequest.getTacoVeggie() * 2.50) +
                (tacoRequest.getTacoChickenBeef() * 3.00) +
                (tacoRequest.getTacoChorizo() * 3.50);

        if (tacoRequest.getTacoVeggie() + tacoRequest.getTacoChickenBeef() + tacoRequest.getTacoChorizo() > 3)
            total = total - (total * .2);

        tacoResponse.setTotal(total);
        return tacoResponse;
    }
}
