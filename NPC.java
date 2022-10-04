
/** 
 * Class that contains attributes of an NPC
 *
 * @author Ramsha, Ying, Zoe
 * @version Spring 2022
 */ 
public class NPC{
  /** Stores name of NPC */ 
  private String name_NPC;
  /** Stores response of NPC */ 
  private String response;
  /** Stores power of NPC when they attack */ 
  private Integer power; 
  /** Stores health of NPC */ 
  private Integer strength; 
  /** Stores whether NPC is a robot or not */ 
  private boolean isEvil;
  
  
 
  /**
	 * Constructor to initialize NPC in each location
	 * 
	 * @param name, name of NPC
	 * @param power, power of NPC attack
   * @param strength, health of NPC
   * @param isEvil, whether or not NPC is a robot
	 */
  public NPC(String name, Integer power, Integer strength, boolean isEvil){
    this.name_NPC = name;
    this.power = power;
    this.strength = strength;
    this.isEvil = isEvil;
  }

   /** @return name of the npc*/
   public String getNPCname(){
     return this.name_NPC;
   } 

  /**@return whether NPC is a robot*/
  public boolean getIsEvil(){
    return this.isEvil;
  }

  /** @return response of NPC */
   public String getResponse(){
     return this.response;
   }

  /** @param isEvil, whether NPC is a robot */
  public void setIsEvil(boolean isEvil){
    this.isEvil = isEvil;
  }

  /** @param response, response of NPC*/
  public void setResponse(String response){
    this.response = response;
  }

  /** @return hit power of the NPC */
  public Integer getPower(){
    return this.strength;
  }

  /** @param power, hit power of the NPC */
  public void setPower(int power){
    this.power = power;
  }
    
  /** @return health of the NPC */
  public Integer getStrength(){
    return this.strength;
  }

  /** @param strength, health of the NPC */
  public void setStrength(int strength){
    this.strength = strength;
  }

  /** 
   * attacks the user and reduces their health by power of NPC
   * 
   * @param user, target of attack
   */
  public void attacksUser(User user){
    int userHealth = user.getHealth()-this.power;
    user.setHealth(userHealth);
    System.out.println("Oh no! You've been attacked by a " + getNPCname() + "You lost 1 lifepoint. You now have " + userHealth  + " lifepoints left.");
    
  }
}