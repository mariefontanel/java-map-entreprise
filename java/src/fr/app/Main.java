package fr.app;

public class Main {
    public static void main(String[] args) {
        String csvFile = "data/country6.csv";

        CsvReader reader = new CsvReader(csvFile, true);

        System.out.println(reader.read());

    }

}
