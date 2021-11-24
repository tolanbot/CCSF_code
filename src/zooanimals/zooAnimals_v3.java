// Project 5: Zoo Animals
// CS111B
// Chris Tolan
// UI: Console

package zooanimals;
import java.util.*;
import java.lang.*;
class Toucan implements iAnimal,  Comparable<iAnimal>{
    private int IdTag;
    private int minTemp;
    private int maxTemp;
    private char F = '\u2109';
    private static int ID = 1234;
    private final String animalType = "Toucan";
    private static final int MINTEMP = 64;
    private static final int MAXTEMP = 82;
    public Toucan(){
        this(ID++, MINTEMP, MAXTEMP);
    }
    public Toucan(int IdTag){
        this(IdTag, MINTEMP, MAXTEMP);
    }
    public Toucan(int minTemp, int maxTemp){
        this(ID++, minTemp, maxTemp);
    }
    public Toucan(int IdTag, int minTemp, int maxTemp){
        this.IdTag = IdTag;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
    @Override
    public String getAnimalType(){
        return animalType;
    }
    @Override
    public int getIdTag(){
        return IdTag;
    }
    @Override
    public void setIdTag(int tagNum){
        IdTag = tagNum;
    }
    @Override
    public int getminTemp(){
        return minTemp;
    }
    @Override
    public int getMaxTemperature(){
        return maxTemp;
    }
    @Override
    public String toString(){
        String animalString = "Animal Type:\t" + animalType + "\n" + "Animal ID:\t" + IdTag + "\n" 
        + "Animal Enclosure Minimum Temperature:\t" + minTemp + F + "\n" + "Animal Enclosure Maximum Temperature:\t" + maxTemp + F;
        return animalString;
    }
    @Override
    public int compareTo(iAnimal other){
        int result = this.getAnimalType().compareTo(other.getAnimalType());
        if(result == 0){
            result = Integer.compare(this.getIdTag(), other.getIdTag());
            if(result == 0){
                return result;
            }
        }
        return result;
    }
}
class Dingo implements iAnimal, Comparable<iAnimal> {
    private String animalType = "Dingo";
    private int minTemp = 60;
    private int maxTemp = 75;
    private int IdTag = 0;
    private char F = '\u2109';
    public Dingo(int IdTag){
        this.IdTag = IdTag;
    }
    @Override
    public String getAnimalType() {
        return animalType;
    }
    @Override
    public int getIdTag() {
        return IdTag;
    }
    @Override
    public void setIdTag(int anIdTag) {
        IdTag = anIdTag;
    }
    @Override
    public int getminTemp() {
        return minTemp;
    }
    @Override
    public int getMaxTemperature() {
        return maxTemp;
    }
    @Override
    public String toString(){
        String animalString = "Animal Type:\t" + animalType + "\n" + "Animal ID:\t" + IdTag + "\n" 
        + "Animal Enclosure Minimum Temperature:\t" + minTemp + F + "\n" + "Animal Enclosure Maximum Temperature:\t" + maxTemp + F;
        return animalString;
    }
    @Override
    public int compareTo(iAnimal other){
        int result = this.getAnimalType().compareTo(other.getAnimalType());
        if(result == 0){
            result = Integer.compare(this.getIdTag(), other.getIdTag());
            if(result == 0){
                return result;
            }
        }
        return result;
    }
}
public class zooAnimals_v3{
    public static String capitalize(String str) {
        if(str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        ArrayList<iAnimal> animals = new ArrayList<iAnimal>();
        boolean y = true;
        boolean add = true;
        while(y){
            System.out.println("What kind of animal do you want to create?");
            String animalResponse = input.nextLine();
            String caseResponse = capitalize(animalResponse);
            System.out.println("What is the animal ID for new " + caseResponse + "?");
            int IDresponse = input.nextInt();
            if(caseResponse.equals("Toucan")){
                Toucan toucan = new Toucan(IDresponse);
                for(iAnimal animal : animals){
                    if(toucan.compareTo(animal)==0){
                        add = false;
                        System.out.println("***ERROR*** Cannot Add Duplicate iAnimal");
                    }
                }
                if(add){
                    animals.add(toucan);
                    System.out.println("*Animal Added*");
                }
                add = true;
            }
            if(caseResponse.equals("Dingo")){
                Dingo dingo = new Dingo(IDresponse);
                for(iAnimal animal : animals){
                    if(dingo.compareTo(animal)==0){
                        add = false;
                        System.out.println("***ERROR*** Cannot Add Duplicate iAnimal");
                    }
                }
                if(add){
                    animals.add(dingo);
                    System.out.println("*Animal Added*");
                }
                add= true;
            }
            System.out.println("Do you want to create a new animal? (y/n) ");
            char sentinel = input.next().charAt(0);
            input.nextLine();
            sentinel = Character.toLowerCase(sentinel);
            if(sentinel != 'y'){
                y = false;
            }
        }
        System.out.println();
        int counter = 0;
        for(iAnimal animal: animals){
            System.out.println("Animal " + (++counter) + ":\n" + animal.getAnimalType() + "("+animal.getIdTag()+ ")");
        }
        System.out.println();
        for(iAnimal animal : animals){
            System.out.println(animal);
        }
        input.close();
    }
}

/*
OUTPUT:
What kind of animal do you want to create?
toucan
What is the animal ID for new Toucan?
1234
*Animal Added*
Do you want to create a new animal? (y/n) 
y
What kind of animal do you want to create?
toucan
What is the animal ID for new Toucan?
1234
***ERROR*** Cannot Add Duplicate iAnimal
Do you want to create a new animal? (y/n) 
y
What kind of animal do you want to create?
toucan
What is the animal ID for new Toucan?
4321
*Animal Added*
Do you want to create a new animal? (y/n) 
y
What kind of animal do you want to create?
DINGO
What is the animal ID for new Dingo?
1234
*Animal Added*
Do you want to create a new animal? (y/n) 
y
What kind of animal do you want to create?
DinGO
What is the animal ID for new Dingo?
4321
*Animal Added*
Do you want to create a new animal? (y/n) 
y
What kind of animal do you want to create?
Toucan
What is the animal ID for new Toucan?
1234
***ERROR*** Cannot Add Duplicate iAnimal
Do you want to create a new animal? (y/n) 
y
What kind of animal do you want to create?
TOUCan
What is the animal ID for new Toucan?
5555
*Animal Added*
Do you want to create a new animal? (y/n) 
y
What kind of animal do you want to create?
DinGO
What is the animal ID for new Dingo?
7777
*Animal Added*
Do you want to create a new animal? (y/n) 
n

Animal 1:
Toucan(1234)
Animal 2:
Toucan(4321)
Animal 3:
Dingo(1234)
Animal 4:
Dingo(4321)
Animal 5:
Toucan(5555)
Animal 6:
Dingo(7777)

Animal Type:    Toucan
Animal ID:      1234
Animal Enclosure Minimum Temperature:   64℉
Animal Enclosure Maximum Temperature:   82℉
Animal Type:    Toucan
Animal ID:      4321
Animal Enclosure Minimum Temperature:   64℉
Animal Enclosure Maximum Temperature:   82℉
Animal Type:    Dingo
Animal ID:      1234
Animal Enclosure Minimum Temperature:   60℉
Animal Enclosure Maximum Temperature:   75℉
Animal Type:    Dingo
Animal ID:      4321
Animal Enclosure Minimum Temperature:   60℉
Animal Enclosure Maximum Temperature:   75℉
Animal Type:    Toucan
Animal ID:      5555
Animal Enclosure Minimum Temperature:   64℉
Animal Enclosure Maximum Temperature:   82℉
Animal Type:    Dingo
Animal ID:      7777
Animal Enclosure Minimum Temperature:   60℉
Animal Enclosure Maximum Temperature:   75℉
*/