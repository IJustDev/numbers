package de.ijustdev.numbers.main;

import java.util.List;

public class NumberUtils {

    private HashMap<Integer, String> numbers = new HashMap<Integer, String>();
    private HashMap<Integer, String> exceptions = new HashMap<Integer, String>();

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
        List<Integer> numberList = new List<Integer>();
        for (char c: charArr) {
            int placeNumber = Integer.parseInt(String.valueOf(c));
            numberList.add(placeNumber);
        }
        return numberList.toArray();
    }

    private String parseNumberToString(int number) {
        StringBuilder builder = new StringBuilder();
        int index = (""+number).toCharArray().length - 1;
        for (int placeNumber: getPartsOfNumber()) {
            builder.append(this.numbers.get(placeNumber));
            builder.append(placeNumber);
        }
    }

    private void initMaps() {
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
