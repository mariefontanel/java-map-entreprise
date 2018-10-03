package fr.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private String csvFile;
    private boolean header;

    /**
     * @param path
     */
    public CsvReader(String path, boolean header) {
        this.csvFile = path;
        this.header = header;
    }

    /**
     * @param csvFile
     */
    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    /**
     * @return
     */
    public String getCsvFile() {
        return csvFile;
    }

    /**
     * @return List de Country
     */
    public List<Country> read() {

        List<Country> dataCountry = new ArrayList<Country>();


        String line = "";
        String cvsSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            if (this.header) { // si le header est présent / true
                br.readLine(); // je lis une ligne sans rien faire pour passer à la suivante
            }
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;  // Skip blank lines
                }
                // use regex as separator ," "
                String[] countryLine = line.split(cvsSplitBy);
                Country country = new Country();

                if (countryLine[0].trim().length() > 0) {
                    country.setId(Integer.parseInt(countryLine[0].trim())); // methode trim() qui supprime les espaces dans une string
                }
                if (countryLine[1].trim().length() > 0) {
                    country.setName(countryLine[1].trim());
                }
                if (countryLine[2].trim().length() > 0) {
                    country.setAbbrev(countryLine[2].trim());
                }

                dataCountry.add(country);

            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return dataCountry;
    }
}
