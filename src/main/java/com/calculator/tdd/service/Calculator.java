package com.calculator.tdd.service;

import com.calculator.tdd.exceptions.CalculatorException;
import com.calculator.tdd.model.ClientData;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class Calculator {
    public int add(String number) throws CalculatorException {
        ClientData clientData = new ClientData(number);
        List<Integer> numbers = clientData.getNumbers();
        if(CollectionUtils.isNotEmpty(clientData.getNagativeNumbers())){
            throw new CalculatorException(String.format("negatives not allowed %s", clientData.getNagativeNumbers().toString()));
        }
        return numbers
                .stream()
                .mapToInt(num -> num)
                .sum();
    }
}
