package fr.app;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class TestCsvReader {
    /**
     * Test lecture csv
     */
    @Test
    public void shouldReadAllCsvLines() {
        //preparation de l'environment
        String csvFile = "data/country1.csv";
        CsvReader reader = new CsvReader(csvFile, false);

        //execution du test
        List<Country> dataCountry = reader.read();

        // récupération des données de l'objet numéro 1 (à l'index 0)
        Country country1 = dataCountry.get(0);

        // création d'un nouvel objet pour pouvoir faire nos comparaisons
        Country country1Attendu = new Country(1, "France", "FR");

        // AVANT AJOUT CONSTRUCTEUR - assignation des valeurs de la ligne 1 du CSV à notre nouvel objet
        /*country1Attendu.setId(1);
        country1Attendu.setName("France");
        country1Attendu.setAbbrev("FR");
*/
        // comparaison des 2 objets
        assertThat(country1).isEqualTo(country1Attendu);
        // test taille de notre liste
        assertThat(dataCountry).hasSize(3);
        //Assertions.assertEquals(3, dataCountry.size());

        //test du nom de l'objet numero 2
        assertThat(dataCountry.get(1).getName()).contains("Belgique");
        //Assertions.assertEquals(dataCountry.get(1).getName(), "Belgique");
        System.out.println("Test 1 = " + dataCountry);

    }

    @Test
    public void shouldReadCsvWithEmptyFirstLine() {
        String csvFile = "data/country2.csv";
        CsvReader reader = new CsvReader(csvFile, false);

        List<Country> dataCountry = reader.read();
        //Assertions.assertEquals(3, dataCountry.size());

        // récupération des données de l'objet numéro 1 (à l'index 0)
        Country country1 = dataCountry.get(0);

        // création d'un nouvel objet pour pouvoir faire nos comparaisons
        Country country1Attendu = new Country(1, "France", "FR");

        // comparaison des 2 objets
        assertThat(country1).isEqualTo(country1Attendu);

        // test taille de notre liste
        assertThat(dataCountry).hasSize(3);
        //Assertions.assertEquals(3, dataCountry.size());

        //test du nom de l'objet numero 2
        assertThat(dataCountry.get(1).getName()).contains("Belgique");
        //Assertions.assertEquals(country1, country1Attendu);
        System.out.println("Test 2 = " + dataCountry);

    }

    @Test
    public void shouldIgnoreSpacesInColumn() {
        String csvFile = "data/country3.csv";
        CsvReader reader = new CsvReader(csvFile, false);

        List<Country> dataCountry = reader.read();
        //Assertions.assertEquals(3, dataCountry.size());

        // récupération des données de l'objet numéro 1 (à l'index 0)
        Country country1 = dataCountry.get(0);

        // création d'un nouvel objet pour pouvoir faire nos comparaisons
        Country country1Attendu = new Country(1, "France", "FR");

        // comparaison des 2 objets
        assertThat(country1).isEqualTo(country1Attendu);

        // test taille de notre liste
        assertThat(dataCountry).hasSize(3);
        //Assertions.assertEquals(3, dataCountry.size());

        //test du nom de l'objet numero 2
        assertThat(dataCountry.get(1).getName()).contains("Belgique");
        //Assertions.assertEquals(country1, country1Attendu);
        System.out.println("Test 3 = " + dataCountry);


    }

    @Test
    public void shouldReadCsvWithHeader() {
        String csvFile = "data/country4.csv";
        CsvReader reader = new CsvReader(csvFile, true);

        List<Country> dataCountry = reader.read();
        //Assertions.assertEquals(3, dataCountry.size());

        // récupération des données de l'objet numéro 1 (à l'index 1)
        Country country1 = dataCountry.get(0);

        // création d'un nouvel objet pour pouvoir faire nos comparaisons
        Country country1Attendu = new Country(1, "France", "FR");

        // comparaison des 2 objets
        assertThat(country1).isEqualTo(country1Attendu);

        // test taille de notre liste
        assertThat(dataCountry).hasSize(3);
        //Assertions.assertEquals(3, dataCountry.size());

        //test du nom de l'objet numero 2
        assertThat(dataCountry.get(1).getName()).contains("Belgique");
        //Assertions.assertEquals(country1, country1Attendu);
        System.out.println("Test 4 = " + dataCountry);

    }

    @Test
    public void shouldIgnoreEmptyColumns() {
        String csvFile = "data/country5.csv";
        CsvReader reader = new CsvReader(csvFile, true);

        List<Country> dataCountry = reader.read();
        //Assertions.assertEquals(3, dataCountry.size());

        // récupération des données de l'objet numéro 1 (à l'index 1)
        Country country1 = dataCountry.get(0);

        // création d'un nouvel objet pour pouvoir faire nos comparaisons
        Country country1Attendu = new Country(0, "France", "FR");

        // comparaison des 2 objets
        assertThat(country1).isEqualTo(country1Attendu);

        // test taille de notre liste
        assertThat(dataCountry).hasSize(3);
        //Assertions.assertEquals(3, dataCountry.size());

        //test du nom de l'objet numero 2
        assertThat(dataCountry.get(1).getName()).contains("Belgique");
        //Assertions.assertEquals(country1, country1Attendu);
        System.out.println("Test 5 = " + dataCountry);

    }

    @Test
    public void shouldReadCsv() {
        String csvFile = "data/country6.csv";
        CsvReader reader = new CsvReader(csvFile, true);

        List<Country> dataCountry = reader.read();

        // récupération des données de l'objet numéro 1 (à l'index 1)
        Country country1 = dataCountry.get(0);

        // création d'un nouvel objet pour pouvoir faire nos comparaisons
        Country country1Attendu = new Country(0, "France", "FR");

        // comparaison des 2 objets
        assertThat(country1).isEqualTo(country1Attendu);

        // test taille de notre liste
        assertThat(dataCountry).hasSize(9);
        //Assertions.assertEquals(9, dataCountry.size());

        //test du nom de l'objet numero 2
        assertThat(dataCountry.get(1).getName()).contains("Belgique");
        //Assertions.assertEquals(country1, country1Attendu);
        System.out.println("Test 6 = " + dataCountry);
    }

}
