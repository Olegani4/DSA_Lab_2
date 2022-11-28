public class TitanicData {
    private boolean survived;
    private int pasClass, age, siblings_spouses, parents_children;
    private String name, gender;
    private double fare;

    public TitanicData(boolean survived, int pasClass, String name, String gender,
                       int age, int siblings_spouses, int parents_children, double fare) {
        this.survived = survived;
        this.pasClass = pasClass;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.siblings_spouses = siblings_spouses;
        this.parents_children = parents_children;
        this.fare = fare;
    }

    public boolean getSurvived() {
        return survived;
    }

    public int getPasClass() {
        return pasClass;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getSiblings_spouses() {
        return siblings_spouses;
    }

    public int getParents_children() {
        return parents_children;
    }

    public double getFare() {
        return fare;
    }

}
