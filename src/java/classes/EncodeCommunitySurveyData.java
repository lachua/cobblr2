/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Renliw
 */
public class EncodeCommunitySurveyData {
    private String community_id;
    private String community_name;
    private String year;
    private Calendar surveyYear;
    private String familyName;
    private String address;
    private String yearsInCommunity;
    private String relegionOfFather;
    private String relegionOfMother;
    private String typeOfFamily;
    private String[] numOfFamilyMem;
    private String[] name;
    private String[] age;
    private String[] gender;
    private String[] civilStatus;
    private String[] positionInFamily;
    private String[] educationalAttainment;
    private String[] work;
    private ArrayList<String[]> healthHistory;
    private ArrayList<String[]> illnesses;
    private ArrayList<String[]> familyImmunization;
    private String battered;
    private String fights;
    private String childabuse;
    private String puttingoff;
    private String inappropriateword;
    private String income;
    private String sourceincome;
    private String[] needs;
    private String hasLot;
    private String hasHouse;
    private String typeOfHouse;
    private String typeOfGarbageDisposal;
    private String typeOfToilet;
    private String typeOfDrainage;
    private String sourceOfWater;
    private String sourceOfDrinkingWater;
    private String drinkingWaterStorage;
    private String foodStorage;
    private String breedingSite;
    private String[] typeOfPests;
    private String[] typeOfPets;
    private String typeofhazards;
    private String mealsPerDay;
    private String[] healthPerson;
    private String[] nonHealthPerson;
    private String adequateRest;
    private String exercise;
    private String relaxation;
    private String stressManagement;

    
    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the survetYear
     */
    public Calendar getSurveyYear() {
        return surveyYear;
    }

    /**
     * @param surveyYear the surveyYear to set
     */
    public void setSurveyYear(Calendar surveyYear) {
        this.surveyYear = surveyYear;
    }

    /**
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * @param familyName the familyName to set
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the yearsInCommunity
     */
    public String getYearsInCommunity() {
        return yearsInCommunity;
    }

    /**
     * @param yearsInCommunity the yearsInCommunity to set
     */
    public void setYearsInCommunity(String yearsInCommunity) {
        this.yearsInCommunity = yearsInCommunity;
    }

    /**
     * @return the relegionOfFather
     */
    public String getRelegionOfFather() {
        return relegionOfFather;
    }

    /**
     * @param relegionOfFather the relegionOfFather to set
     */
    public void setRelegionOfFather(String relegionOfFather) {
        this.relegionOfFather = relegionOfFather;
    }

    /**
     * @return the relegionOfMother
     */
    public String getRelegionOfMother() {
        return relegionOfMother;
    }

    /**
     * @param relegionOfMother the relegionOfMother to set
     */
    public void setRelegionOfMother(String relegionOfMother) {
        this.relegionOfMother = relegionOfMother;
    }

    /**
     * @return the numOfFamilyMem
     */
    public String[] getNumOfFamilyMem() {
        return numOfFamilyMem;
    }

    /**
     * @param numOfFamilyMem the numOfFamilyMem to set
     */
    public void setNumOfFamilyMem(String[] numOfFamilyMem) {
        this.numOfFamilyMem = numOfFamilyMem;
    }

    /**
     * @return the name
     */
    public String[] getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String[] name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public String[] getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String[] age) {
        this.age = age;
    }

    /**
     * @return the gender
     */
    public String[] getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String[] gender) {
        this.gender = gender;
    }

    /**
     * @return the civilStatus
     */
    public String[] getCivilStatus() {
        return civilStatus;
    }

    /**
     * @param civilStatus the civilStatus to set
     */
    public void setCivilStatus(String[] civilStatus) {
        this.civilStatus = civilStatus;
    }

    /**
     * @return the positionInFamily
     */
    public String[] getPositionInFamily() {
        return positionInFamily;
    }

    /**
     * @param positionInFamily the positionInFamily to set
     */
    public void setPositionInFamily(String[] positionInFamily) {
        this.positionInFamily = positionInFamily;
    }

    /**
     * @return the educationalAttainment
     */
    public String[] getEducationalAttainment() {
        return educationalAttainment;
    }

    /**
     * @param educationalAttainment the educationalAttainment to set
     */
    public void setEducationalAttainment(String[] educationalAttainment) {
        this.educationalAttainment = educationalAttainment;
    }

    /**
     * @return the work
     */
    public String[] getWork() {
        return work;
    }

    /**
     * @param work the work to set
     */
    public void setWork(String[] work) {
        this.work = work;
    }

    
    /**
     * @return the battered
     */
    public String getBattered() {
        return battered;
    }

    /**
     * @param battered the battered to set
     */
    public void setBattered(String battered) {
        this.battered = battered;
    }

    /**
     * @return the fights
     */
    public String getFights() {
        return fights;
    }

    /**
     * @param fights the fights to set
     */
    public void setFights(String fights) {
        this.fights = fights;
    }

    /**
     * @return the childabuse
     */
    public String getChildabuse() {
        return childabuse;
    }

    /**
     * @param childabuse the childabuse to set
     */
    public void setChildabuse(String childabuse) {
        this.childabuse = childabuse;
    }

    /**
     * @return the puttingoff
     */
    public String getPuttingoff() {
        return puttingoff;
    }

    /**
     * @param puttingoff the puttingoff to set
     */
    public void setPuttingoff(String puttingoff) {
        this.puttingoff = puttingoff;
    }

    /**
     * @return the inappropriateword
     */
    public String getInappropriateword() {
        return inappropriateword;
    }

    /**
     * @param inappropriateword the inappropriateword to set
     */
    public void setInappropriateword(String inappropriateword) {
        this.inappropriateword = inappropriateword;
    }

    /**
     * @return the income
     */
    public String getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(String income) {
        this.income = income;
    }

    /**
     * @return the sourceincome
     */
    public String getSourceincome() {
        return sourceincome;
    }

    /**
     * @param sourceincome the sourceincome to set
     */
    public void setSourceincome(String sourceincome) {
        this.sourceincome = sourceincome;
    }

    /**
     * @return the needs
     */
    public String[] getNeeds() {
        return needs;
    }

    /**
     * @param needs the needs to set
     */
    public void setNeeds(String[] needs) {
        this.needs = needs;
    }

    /**
     * @return the hasLot
     */
    public String getHasLot() {
        return hasLot;
    }

    /**
     * @param hasLot the hasLot to set
     */
    public void setHasLot(String hasLot) {
        this.hasLot = hasLot;
    }

    /**
     * @return the hasHouse
     */
    public String getHasHouse() {
        return hasHouse;
    }

    /**
     * @param hasHouse the hasHouse to set
     */
    public void setHasHouse(String hasHouse) {
        this.hasHouse = hasHouse;
    }

    /**
     * @return the typeOfHouse
     */
    public String getTypeOfHouse() {
        return typeOfHouse;
    }

    /**
     * @param typeOfHouse the typeOfHouse to set
     */
    public void setTypeOfHouse(String typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }

    /**
     * @return the typeOfGarbageDisposal
     */
    public String getTypeOfGarbageDisposal() {
        return typeOfGarbageDisposal;
    }

    /**
     * @param typeOfGarbageDisposal the typeOfGarbageDisposal to set
     */
    public void setTypeOfGarbageDisposal(String typeOfGarbageDisposal) {
        this.typeOfGarbageDisposal = typeOfGarbageDisposal;
    }

    /**
     * @return the typeOfToilet
     */
    public String getTypeOfToilet() {
        return typeOfToilet;
    }

    /**
     * @param typeOfToilet the typeOfToilet to set
     */
    public void setTypeOfToilet(String typeOfToilet) {
        this.typeOfToilet = typeOfToilet;
    }

    /**
     * @return the typeOfDrainage
     */
    public String getTypeOfDrainage() {
        return typeOfDrainage;
    }

    /**
     * @param typeOfDrainage the typeOfDrainage to set
     */
    public void setTypeOfDrainage(String typeOfDrainage) {
        this.typeOfDrainage = typeOfDrainage;
    }

    /**
     * @return the sourceOfWater
     */
    public String getSourceOfWater() {
        return sourceOfWater;
    }

    /**
     * @param sourceOfWater the sourceOfWater to set
     */
    public void setSourceOfWater(String sourceOfWater) {
        this.sourceOfWater = sourceOfWater;
    }

    /**
     * @return the sourceOfDrinkingWater
     */
    public String getSourceOfDrinkingWater() {
        return sourceOfDrinkingWater;
    }

    /**
     * @param sourceOfDrinkingWater the sourceOfDrinkingWater to set
     */
    public void setSourceOfDrinkingWater(String sourceOfDrinkingWater) {
        this.sourceOfDrinkingWater = sourceOfDrinkingWater;
    }

    /**
     * @return the drinkingWaterStorage
     */
    public String getDrinkingWaterStorage() {
        return drinkingWaterStorage;
    }

    /**
     * @param drinkingWaterStorage the drinkingWaterStorage to set
     */
    public void setDrinkingWaterStorage(String drinkingWaterStorage) {
        this.drinkingWaterStorage = drinkingWaterStorage;
    }

    /**
     * @return the foodStorage
     */
    public String getFoodStorage() {
        return foodStorage;
    }

    /**
     * @param foodStorage the foodStorage to set
     */
    public void setFoodStorage(String foodStorage) {
        this.foodStorage = foodStorage;
    }

    /**
     * @return the breedingSite
     */
    public String getBreedingSite() {
        return breedingSite;
    }

    /**
     * @param breedingSite the breedingSite to set
     */
    public void setBreedingSite(String breedingSite) {
        this.breedingSite = breedingSite;
    }

    /**
     * @return the typeOfPests
     */
    public String[] getTypeOfPests() {
        return typeOfPests;
    }

    /**
     * @param typeOfPests the typeOfPests to set
     */
    public void setTypeOfPests(String[] typeOfPests) {
        this.typeOfPests = typeOfPests;
    }

    /**
     * @return the typeOfPets
     */
    public String[] getTypeOfPets() {
        return typeOfPets;
    }

    /**
     * @param typeOfPets the typeOfPets to set
     */
    public void setTypeOfPets(String[] typeOfPets) {
        this.typeOfPets = typeOfPets;
    }

    /**
     * @return the typeofhazards
     */
    public String getTypeofhazards() {
        return typeofhazards;
    }

    /**
     * @param typeofhazards the typeofhazards to set
     */
    public void setTypeofhazards(String typeofhazards) {
        this.typeofhazards = typeofhazards;
    }

    /**
     * @return the mealsPerDay
     */
    public String getMealsPerDay() {
        return mealsPerDay;
    }

    /**
     * @param mealsPerDay the mealsPerDay to set
     */
    public void setMealsPerDay(String mealsPerDay) {
        this.mealsPerDay = mealsPerDay;
    }

    /**
     * @return the healthPerson
     */
    public String[] getHealthPerson() {
        return healthPerson;
    }

    /**
     * @param healthPerson the healthPerson to set
     */
    public void setHealthPerson(String[] healthPerson) {
        this.healthPerson = healthPerson;
    }

    /**
     * @return the nonHealthPerson
     */
    public String[] getNonHealthPerson() {
        return nonHealthPerson;
    }

    /**
     * @param nonHealthPerson the nonHealthPerson to set
     */
    public void setNonHealthPerson(String[] nonHealthPerson) {
        this.nonHealthPerson = nonHealthPerson;
    }

    /**
     * @return the adequateRest
     */
    public String getAdequateRest() {
        return adequateRest;
    }

    /**
     * @param adequateRest the adequateRest to set
     */
    public void setAdequateRest(String adequateRest) {
        this.adequateRest = adequateRest;
    }

    /**
     * @return the exercise
     */
    public String getExercise() {
        return exercise;
    }

    /**
     * @param exercise the exercise to set
     */
    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    /**
     * @return the relaxation
     */
    public String getRelaxation() {
        return relaxation;
    }

    /**
     * @param relaxation the relaxation to set
     */
    public void setRelaxation(String relaxation) {
        this.relaxation = relaxation;
    }

    /**
     * @return the stressManagement
     */
    public String getStressManagement() {
        return stressManagement;
    }

    /**
     * @param stressManagement the stressManagement to set
     */
    public void setStressManagement(String stressManagement) {
        this.stressManagement = stressManagement;
    }

    /**
     * @return the community_id
     */
    public String getCommunity_id() {
        return community_id;
    }

    /**
     * @param community_id the community_id to set
     */
    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    /**
     * @return the community_name
     */
    public String getCommunity_name() {
        return community_name;
    }

    /**
     * @param community_name the community_name to set
     */
    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    /**
     * @return the typeOfFamily
     */
    public String getTypeOfFamily() {
        return typeOfFamily;
    }

    /**
     * @param typeOfFamily the typeOfFamily to set
     */
    public void setTypeOfFamily(String typeOfFamily) {
        this.typeOfFamily = typeOfFamily;
    }

    /**
     * @return the healthHistory
     */
    public ArrayList<String[]> getHealthHistory() {
        return healthHistory;
    }

    /**
     * @param healthHistory the healthHistory to set
     */
    public void setHealthHistory(ArrayList<String[]> healthHistory) {
        this.healthHistory = healthHistory;
    }

    /**
     * @return the illnesses
     */
    public ArrayList<String[]> getIllnesses() {
        return illnesses;
    }

    /**
     * @param illnesses the illnesses to set
     */
    public void setIllnesses(ArrayList<String[]> illnesses) {
        this.illnesses = illnesses;
    }

    /**
     * @return the familyImmunization
     */
    public ArrayList<String[]> getFamilyImmunization() {
        return familyImmunization;
    }

    /**
     * @param familyImmunization the familyImmunization to set
     */
    public void setFamilyImmunization(ArrayList<String[]> familyImmunization) {
        this.familyImmunization = familyImmunization;
    }
}
