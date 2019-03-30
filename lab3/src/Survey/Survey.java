package Survey;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "Survey")
@ApplicationScoped
public class Survey {

    private String name;
    private String email;
    private int age;
    private String gender = "male";
    private String education;
    private int height;
    private double bustCircuit;
    private double cupSize;
    private double waistF;
    private double waistM;
    private double hips;
    private double chest;
    private String monthCost;
    private String frequencyOfBuying;
    private List<String> colors = new LinkedList<>();
    private boolean showNextSection = false;

    public Survey() {
    }

    public String getMonthCost() {
        return monthCost;
    }

    public boolean getShowNextSection() {
        return showNextSection;
    }

    public void setShowNextSection(boolean showNextSession) {
        this.showNextSection = showNextSession;
    }

    public void setMonthCost(String monthCost) {
        this.monthCost = monthCost;
    }

    public String getFrequencyOfBuying() {
        return frequencyOfBuying;
    }

    public void setFrequencyOfBuying(String frequencyOfBuying) {
        this.frequencyOfBuying = frequencyOfBuying;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public double getBustCircuit() {
        return bustCircuit;
    }

    public void setBustCircuit(double bustCircuit) {
        this.bustCircuit = bustCircuit;
    }

    public double getCupSize() {
        return cupSize;
    }

    public void setCupSize(double cupSize) {
        this.cupSize = cupSize;
    }

    public double getWaistF() {
        return waistF;
    }

    public void setWaistF(double waistF) {
        this.waistF = waistF;
    }

    public double getWaistM() {
        return waistM;
    }

    public void setWaistM(double waistM) {
        this.waistM = waistM;
    }

    public double getHips() {
        return hips;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isMale(){
        return this.gender.equals("male");
    }

    public void proceed() {
        this.showNextSection = true;
    }

    public String save() {
        return "summarySurvey";
    }
}
