package main;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class NumberUtils {

    private HashMap<Integer, String> numbers = new HashMap<Integer, String>();
    private HashMap<Integer, String> exceptions = new HashMap<Integer, String>();
    private HashMap<Integer, String> placeValues = new HashMap<Integer, String>();

    private int number;

    public NumberUtils(int number) {
        this.number = number;
        this.initMaps();
    }

    public String spell() {
        boolean isException = this.exceptions.containsKey(this.number);
        if (isException) {
            return this.exceptions.get(this.number);
        }
        return this.parseNumberToString();
    }

    private int[] getPartsOfNumber() {
        char[] charArr = (""+this.number).toCharArray();
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for (char c: charArr) {
            int placeNumber = Integer.parseInt(String.valueOf(c));
            numberList.add(placeNumber);
        }
        return numberList.stream().mapToInt(i -> i).toArray();
    }

    private String parseNumberToString() {
        StringBuilder builder = new StringBuilder();
        int index = (""+this.number).toCharArray().length - 1;
        for (int placeNumber: getPartsOfNumber()) {
            if (index == 2) {
                builder.append("einhundertund");
            } else {
                builder.append(this.numbers.get(placeNumber));
                builder.append(this.placeValues.get(index));
            }
        }
        return builder.toString();
    }

    private void initMaps() {
        // PlaceValues
        this.placeValues.put(1, "zehn");
        this.placeValues.put(2, "hundertund");
        // Numbers
        this.numbers.put(0, "null");
        this.numbers.put(1, "eins");
        this.numbers.put(2, "zwei");
        this.numbers.put(3, "drei");
        this.numbers.put(4, "vier");
        this.numbers.put(5, "fünf");
        this.numbers.put(6, "sechs");
        this.numbers.put(7, "sieben");
        this.numbers.put(8, "acht");
        this.numbers.put(9, "neun");

        // Exceptions
        this.exceptions.put(10, "zehn");
        this.exceptions.put(11, "elf");
        this.exceptions.put(12, "zwölf");
    }

}
