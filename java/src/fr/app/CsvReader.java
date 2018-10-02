package fr.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private String csvFile;

    /**
     *
     * @param path
     */
    public CsvReader(String path) {
        this.csvFile = path;
    }

/*    *//**
     *
     * @param csvFile
     *//*
    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    *//**
     *
     * @return
     *//*
    public String getCsvFile() {
        return csvFile;
    }*/

    /**
     *
     * @return List de Country
     */
    public List<Country> read() {

        List<Country> dataCountry = new ArrayList<Country>();


        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] countryLine = line.split(cvsSplitBy);

                //System.out.println(line);

                Country country = new Country();

                country.setId(Integer.parseInt(countryLine[0]));
                country.setName(countryLine[1]);
                country.setAbbrev(countryLine[2]);

                dataCountry.add(country);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataCountry;
    }
}
