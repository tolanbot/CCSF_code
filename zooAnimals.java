class Toucan implements iAnimal{
    private int IdTag;
    private int minTemp;
    private int maxTemp;
    private char F = '\u2109';
    private static int ID = 1234;
    private static final String animalType = "Toucan";
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
    public String getAnimalType(){
        return animalType;
    }
    public int getIdTag(){
        return IdTag;
    }
    public void setIdTag(int tagNum){
        IdTag = tagNum;
    }
    public int getMinTemperature(){
        return minTemp;
    }
    public int getMaxTemperature(){
        return maxTemp;
    }
    @Override
    public String toString(){
        String animalString = "Animal Type:\t" + animalType + "\n" + "Animal ID:\t" + IdTag + "\n" 
        + "Animal Enclosure Minimum Temperature:\t" + minTemp + F + "\n" + "Animal Enclosure Maximum Temperature:\t" + maxTemp + F;
        return animalString;
    }
}
public class zooAnimals{
    public static void main(String[] args){
        Toucan toucan = new Toucan(12345, 64, 82);
        Toucan toucanID = new Toucan(2468);
        System.out.println(toucan.toString());
        toucan.setIdTag(54321);
        System.out.println("New Animal ID:\t" + toucan.getIdTag());
        System.out.println(toucan.toString());
        System.out.println("[Toucan ID Constructor]\n" + toucanID.toString());
        Toucan toucan1 = new Toucan();
        Toucan toucan2 = new Toucan();
        Toucan toucan3 = new Toucan(68,88);
        System.out.println("The new toucans IDs are:");
        System.out.println(toucan1.getIdTag());
        System.out.println(toucan2.getIdTag());
        System.out.println(toucan3.getIdTag());
        System.out.println(toucan3.toString());
    }
}


        //System.out.println("Animal Type:\t" + toucan.getAnimalType());
        //System.out.println("Animal ID:\t" + toucan.getIdTag());
        //System.out.println("Animal Enclosure Minimum Temperature:\t" + toucan.getMinTemperature() + F);
        //System.out.println("Animal Enclosure Maximum Temperature:\t" + toucan.getMaxTemperature()+ F);

        //zooAnimal toucan = new zooAnimal();
        // toucan.animalType = "Toucan";
        // toucan.IdTag = 12345;
        // toucan.minTemp = 64;
        // toucan.maxTemp = 82;
        //System.out.println(toucan.toString());
        //toucan.setIdTag(54321);
        //System.out.println("New Animal ID:\t" + toucan.getIdTag());


// public String getAnimalType(){
//     return animalType;
// }
// public int getIdTag(){
//     return IdTag;
// }
// public void setIdTag(int tagNum){
//     IdTag = tagNum;
// }
// public int getMinTemperature(){
//     return minTemp;
// }
// public int getMaxTemperature(){
//     return maxTemp;
// }

// public String toString(){
//     String animalString = "Animal Type:\t" + getAnimalType() + "\n" + "Animal ID:\t" + getIdTag() + "\n" 
//     + "Animal Enclosure Minimum Temperature:\t" + getMinTemperature() + F + "\n" + "Animal Enclosure Maximum Temperature:\t" + getMaxTemperature() + F;
//     return animalString;
// }

// public String animalName;
    // public String animalType;
    // public int IdTag;
    // public int minTemp;
    // public int maxTemp;
    // public char F = '\u2109';

    // class zooAnimal{
//     public String animalName;
//     public String animalType;
//     public int IdTag;
//     public int minTemp;
//     public int maxTemp;
//     public char F = '\u2109';
//     @Override
//     public String toString(){
//         String animalString = "Animal Type:\t" + animalType + "\n" + "Animal ID:\t" + IdTag + "\n" 
//         + "Animal Enclosure Minimum Temperature:\t" + minTemp + F + "\n" + "Animal Enclosure Maximum Temperature:\t" + maxTemp + F;
//         return animalString;
//     }
// }