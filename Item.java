import java.util.*;

/** 
 * Class that contains attributes of an item
 *
 * @author Ramsha, Ying, Zoe
 * @version Spring 2022
 */ 
public class Item{

  /** Stores name of item */ 
  private String name;
   /** Stores description of item */ 
  private String description;
  /** Stores whether or not item is used */ 
  private Boolean used;
  //if -1 then food, if 0 used up, else rated out of 5 
  /** Stores power of item */ 
  private int power; 

  /** 
   * Constructor for an item in game
   * 
   * @param name; name of the item
   * @param power; power of the item
   */ 
  public Item(String name, String Description, int power){
    this.name = name;
    this.power = power;
    this.description=Description;
  }

  /** @return name of item */ 
  public String getName(){
    return this.name;
  }

  /** @return item power */ 
  public int getPower(){
    return this.power;
  }

  /** @return power at level 0 */ 
  public boolean used(){
    return power == 0;
  }

  /** @param power; power of item */ 
  public void setPower(int power){
    this.power = power;
  }

  public String getDescription(){
    return this.description;
  }
}