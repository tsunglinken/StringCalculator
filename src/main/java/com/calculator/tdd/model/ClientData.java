package com.calculator.tdd.model;

import com.calculator.tdd.enums.ClientEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientData {
    private String number;
    private String delimiter;
    private List<Integer> nagativeNumbers;

    public ClientData(String number) {
        this.number = StringUtils.isEmpty(number)?"0":number;
        this.delimiter = ClientEnum.DEFAULT_DELIMITER.getCode();
        this.nagativeNumbers = new ArrayList<>();
    }

    public List<Integer> getNagativeNumbers() {
        return nagativeNumbers;
    }

    public List<Integer> getNumbers() {
        checkNumberDefinedSymbol();
        return Arrays.asList(converStrArrToIntArr());
    }

    private Integer[] converStrArrToIntArr() {
        String[] numberStrs = this.number.split(getDelimiterFormat(this.delimiter));
        Integer[] numbers = new Integer[numberStrs.length];
        for (int i = 0; i < numberStrs.length; i++) {
            numbers[i] = Integer.parseInt(StringUtils.isEmpty(numberStrs[i]) ? "0" : numberStrs[i]);
            if(isNagative(numbers[i])) this.nagativeNumbers.add(numbers[i]);
        }
        return numbers;
    }

    private boolean isNagative(Integer number) {
        return number < 0;
    }

    private void checkNumberDefinedSymbol(){
        if(this.number.contains(ClientEnum.DEFINED_SYMBOL.getCode())){
            getDelimiter();
            renewNumber();
        }
    }

    private void renewNumber() {
        this.number = number.substring(definedSymbolLength()+1);
    }

    private void getDelimiter() {
        this.delimiter = number.substring(definedSymbolLength(), definedSymbolLength() +1);
    }

    private int definedSymbolLength() {
        return ClientEnum.DEFINED_SYMBOL.getCode().length();
    }

    private String getDelimiterFormat(String defaultDelimiter) {
        return String.format("%s|%n", defaultDelimiter);
    }
}
