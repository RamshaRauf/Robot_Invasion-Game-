import java.util.*;

/** 
 * Class that contains attributes of a Location
 * Contains NPCs and items that player can bring along in journey
 * 
 * @author Ramsha, Ying, Zoe
 * @version Spring 2022
 */ 
public class Location{

  /** Stores location name */
  private String name; 
  /** Stores all neighbors in location */
	private ArrayList <Location> neighbors = new ArrayList<Location>(); 
  /** Stores description of location*/
	private String description; 
  /** Stores items at location */
	private HashSet<Item> loc_items = new HashSet<Item>();
  /** Stores NPCs at location */
  private HashSet<NPC> loc_NPC = new HashSet<NPC>(); 
  
  /**
	 * Constructor to initialize location info and put items that start in the room in it's inventory.
	 * 
	 * @param name, represents name of location
	 * @param description,  description of location
	 */
  public Location(String name, String description) {
		this.name = name;
		this.description = description;
  }

  
  /** getter methods */
  
  /** @return an array of string representing the rooms neighbors */
	public ArrayList<Location> getNeighbors() {
		return this.neighbors;
	}
  
  /** 
   * adds neighbors for that location 
   * 
   * @param loc; location 
   */
  public void addNeighbors(Location loc) {
		neighbors.add(loc);
	}

	/**  @return name of the location */
	public String getName() {
		return this.name;
	}

  /** 
   * adds items for that location
   * 
   * @param item; item for location 
   */
  public void addItem(Item item) {
		loc_items.add(item);
	}

  /** 
   * adds NPC to Location 
   *
   * @param member; the npc you want to add
   */
  public void addNPC(NPC member){
    loc_NPC.add(member);
  }
  
  /** 
   * removes NPC from Location 
   *
   * @param member; the npc you want to remove
   */
  public void removeNPC(NPC member){
    loc_NPC.remove(member);
  }

	/**  @return location items */
	public HashSet<Item> getLocItem() {
		return this.loc_items;
	}

   /** @return npc at location */
  public HashSet<NPC> getLocNPC() {
    return this.loc_NPC;
  }

	/** @return location description */
	public String getDescription() {
		return this.description;
	}


  /**
   * Converts to string representation of location data including neighbors
   *
   * @return location data in string form
   */
  
  public String toString(){
    String data = "Location " +getName()+ "\nDescription:  " +getDescription()+ "\nNeighbors: "+"";
    for (Location i: neighbors){
      data += "\n"+i.getName();
    }
      return data;
    
  }
 

}