package fr.app;

public class Main {
    public static void main(String[] args) {
        String csvFile = "data/country2.csv";

        CsvReader reader = new CsvReader(csvFile, false);

        System.out.println(reader.read());

    }

}
