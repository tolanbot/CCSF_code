/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooanimals;

/**
 *
 * @author lmeade
 */
public interface iAnimal {
    public String getAnimalType();
    public int getIdTag();
    public void setIdTag(int anIdTag);
    public int getMinTemperature();
    public int getMaxTemperature();
}