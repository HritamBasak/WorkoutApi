package Model;

public class Model {
    String muscles,workout,intensity,beginnersets,intermediatesets,expertsets,equipment,explanation,longexplanation,link;

    public Model(String muscles, String workout, String intensity, String beginnersets, String intermediatesets, String equipment, String expertsets, String explanation, String longexplanation, String link) {
        this.muscles = muscles;
        this.workout = workout;
        this.intensity = intensity;
        this.beginnersets = beginnersets;
        this.intermediatesets = intermediatesets;
        this.equipment = equipment;
        this.expertsets = expertsets;
        this.explanation = explanation;
        this.longexplanation = longexplanation;
        this.link = link;
    }

    public Model() {
    }

    public String getMuscles() {
        return muscles;
    }

    public void setMuscles(String muscles) {
        this.muscles = muscles;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String workout) {
        this.workout = workout;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getBeginnersets() {
        return beginnersets;
    }

    public void setBeginnersets(String beginnersets) {
        this.beginnersets = beginnersets;
    }

    public String getIntermediatesets() {
        return intermediatesets;
    }

    public void setIntermediatesets(String intermediatesets) {
        this.intermediatesets = intermediatesets;
    }

    public String getExpertsets() {
        return expertsets;
    }

    public void setExpertsets(String expertsets) {
        this.expertsets = expertsets;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getLongexplanation() {
        return longexplanation;
    }

    public void setLongexplanation(String longexplanation) {
        this.longexplanation = longexplanation;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
