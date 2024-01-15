public class Player extends Person{

    private String position;
    private double fitness;
    private double passingAccuracy;
    private double shotAccuracy;
    private double shotFrequency;
    private double defensiveness;
    private double aggression;
    private double positioning;
    private double dribbling;
    private double chanceCreation;
    private double offsideAdherence;

    Player(String position, double fitness, double passingAccuracy, double shotAccuracy, double shotFrequency, double defensiveness, double aggression, double positioning, double dribbling, double chanceCreation, double offsideAdherence){
    super("firstName","surname","team");
    this.position = position;
    this.fitness = fitness;
    this.passingAccuracy = passingAccuracy;
    this.shotAccuracy = shotAccuracy;
    this.shotFrequency = shotFrequency;
    this.defensiveness = defensiveness;
    this.aggression = aggression;
    this.positioning = positioning;
    this.dribbling = dribbling;
    this.chanceCreation = chanceCreation;
    this.offsideAdherence = offsideAdherence;
    }

    // getter and setter methods
    public void setPosition(String position) {
        this.position = position;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void setPassingAccuracy(double passingAccuracy) {
        this.passingAccuracy = passingAccuracy;
    }

    public void setAggression(double aggression) {
        this.aggression = aggression;
    }

    public void setChanceCreation(double chanceCreation) {
        this.chanceCreation = chanceCreation;
    }

    public void setDefensiveness(double defensiveness) {
        this.defensiveness = defensiveness;
    }

    public void setDribbling(double dribbling) {
        this.dribbling = dribbling;
    }

    public void setOffsideAdherence(double offsideAdherence) {
        this.offsideAdherence = offsideAdherence;
    }

    public void setPositioning(double positioning) {
        this.positioning = positioning;
    }

    public void setShotAccuracy(double shotAccuracy) {
        this.shotAccuracy = shotAccuracy;
    }

    public void setShotFrequency(double shotFrequency) {
        this.shotFrequency = shotFrequency;
    }

    public String getPosition() {
        return position;
    }

    public double getAggression() {
        return aggression;
    }

    public double getChanceCreation() {
        return chanceCreation;
    }

    public double getDefensiveness() {
        return defensiveness;
    }

    public double getDribbling() {
        return dribbling;
    }

    public double getFitness() {
        return fitness;
    }

    public double getOffsideAdherence() {
        return offsideAdherence;
    }

    public double getPassingAccuracy() {
        return passingAccuracy;
    }

    public double getPositioning() {
        return positioning;
    }

    public double getShotAccuracy() {
        return shotAccuracy;
    }

    public double getShotFrequency() {
        return shotFrequency;
    }
}

