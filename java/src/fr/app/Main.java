package fr.app;

public class Main {
    public static void main(String[] args) {
        String csvFile = "data/country1.csv";

        CsvReader reader = new CsvReader(csvFile);

        System.out.println(reader.read());

    }

}
