package fr.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCsvReader {
    /**
     * Test lecture csv
     */
    @Test
    public void testRead1() {
        String csvFile = "data/country1.csv";
        CsvReader reader = new CsvReader(csvFile);
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
        Assertions.assertEquals(country1, country1Attendu);

        // test taille de notre liste
        Assertions.assertEquals(3, dataCountry.size());

        //test du nom de l'objet numero 2
        Assertions.assertEquals(dataCountry.get(1).getName(), "Belgique");
    }
}
