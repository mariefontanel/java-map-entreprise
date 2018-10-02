package fr.app;

public class Country {

    private int id;
    private String name;
    private String abbrev;

    /**
     *
     */
    public Country() {

    }

    /**
     *
     * @param id
     * @param name
     * @param abbrev
     */
    public Country(int id, String name, String abbrev) {
        this.setId(id);
        this.setName(name);
        this.setAbbrev(abbrev);
    }


    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param abbrev
     */
    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    /**
     *
     * @return
     */
    public String getAbbrev() {
        return abbrev;
    }

    @Override
    public String toString() {
        return getId() + "," + getName() + "," + getAbbrev();
    }

    @Override
    public boolean equals(Object o) {
        // Caster un objet = le forcer à avoir le type désiré
        Country country = (Country) o;

        if (country.getId() == this.getId() && country.getName().equals(this.getName()) && country.getAbbrev().equals(this.getAbbrev())) {
            return true;
        } else {
            return false;
        }
    }
}

