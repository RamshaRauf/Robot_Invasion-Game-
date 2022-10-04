import java.util.*; 
class RobotInvasion{
  /** attribute setup */
  private Location mainApartment;
  private Location pennStation;
  private Location hotel;
  private Location conv_store;
  private Location police_station;
  private Location central_park;
  private Location ferry;
  private Location statue_liberty;

  private Item chip;
  private Item baseball_bat;
  private Item gun;
  private Item sandwich;
  private Item notebook;
  private Item boat;
  private Item Hcar;
  private Item Pcar;
  private Item train;
  private Item map;
  
  private NPC homeless_man;
  private NPC police_officer;
  private NPC professor;
  private NPC sus_guy;
  private NPC robot;
  private NPC robot1;
  private NPC bossRobot;
  private User player;

  
  
/** 
 * Sets up the entire game including locations, npcs, and different items.
 *
 * @author Ramsha, Ying, Zoe
 * @version Spring 2022
 */
  public void setUp(){
     
    this.mainApartment = new Location ("main apartment", "You open your eyes, confused and dazed. Looking around you find that you are in a room sitting on a chair with a notebook next to you on a table, a bed in front of you with an item glistening in the sheets, and a door that seems to lead out somewhere.");
    
    this.pennStation = new Location("penn station", "You arrive at Penn station and the usual hustle and bustle that you would expect from a New York City station was completely gone. The area was desolate and the only things that brought the place to life was just a few pieces of trash on the ground. ");
    
   this.hotel = new Location ("hotel", "You arrive at the hotel and see that the area had already been hit by robots. Cars were alflame around the area and the doors in front of the hotel were barricaded using those rolling carts that carry luggage.");
    
    this.conv_store = new Location ("convenience store", "You arrive at the convenience store and see that almost all of the aisles are empty. It seems that people raided the area for supplies just as the robot invasion was starting." );
    
    this.police_station = new Location("police station", "You arrive at the police station and were shocked by how horrible the scene was. Bullet holes were found everywhere and you could even see some marks of blood around the ground. ");
    
     this.central_park = new Location ("central park", "You arrive at central park and everything seems relatively normal compared to other places you have seen. A sense of calm envelopes you as you see how not much of the scenery has changed yet.");
    
     this.ferry = new Location ("ferry", " You arrive at the ferry dock and are hit by a cool sea breeze. Not much is present around the area and all that really gets your attention is the strong scent of the sea and the distance between you and your destination.");
    
     this.statue_liberty = new Location("statue of liberty", "You arrive at the Statue of liberty and can see that a lot of robots are swarming around the area. You can see the large satellite connected to a computer atop the statue but you have to be careful not to accidentally trigger one into their attack mode. ");


    //main apartment neighbors
    this.mainApartment.addNeighbors(this.pennStation);
    this.mainApartment.addNeighbors(this.hotel);
    this.mainApartment.addNeighbors(this.police_station);
    this.mainApartment.addNeighbors(this.conv_store);
    //police station neighbor 
    this.police_station.addNeighbors(this.mainApartment);
    this.police_station.addNeighbors(this.hotel);
    this.police_station.addNeighbors(this.central_park);
    // convinient store neighbors
    this.conv_store.addNeighbors(this.mainApartment);
    this.conv_store.addNeighbors(this.pennStation);
    //hotel neighbors
    this.hotel.addNeighbors(this.ferry);
    this.hotel.addNeighbors(this.police_station);
    this.hotel.addNeighbors(this.mainApartment);
    //penn station neighbors
    this.pennStation.addNeighbors(this.conv_store);
    this.pennStation.addNeighbors(this.mainApartment);
    this.pennStation.addNeighbors(this.ferry);
    this.pennStation.addNeighbors(this.central_park);
    //central park neighbors 
    this.central_park.addNeighbors(this.pennStation);
    this.central_park.addNeighbors(this.police_station);
    //ferry neighbors 
    this.ferry.addNeighbors(this.pennStation);
    this.ferry.addNeighbors(this.hotel);
    this.ferry.addNeighbors(this.statue_liberty);
    //statue of liberty neighbors
    this.statue_liberty.addNeighbors(this.ferry);

    //making a player
    this.player = new User(mainApartment);

    /**Item setup*/
    //Item(String name, boolean canEat, int power(#reuses))
    //Item notebook = new Item("notebook", false, 1);
    this.chip = new Item("chip","You examine the chip and it green in color", 1);
    this.baseball_bat = new Item("bat","100% organic wood", 5);
    this.gun = new Item("gun","You examine the gun and it is loaded with 5 bullets",5);
    this.sandwich = new Item ("sandwich", "You examine the sandwich and it has a chick-fil-a reciept attached that has someone named Dave's order of 1 Spicy Chicken Sandwich for $5.00", -1);
    this.notebook = new Item("notebook","You look at the notebook and it seems to be a diary of sorts. It reads:\nApril 17, 2022 The robots are coming closer, I don’t know why they are here but they are dangerous. This will be my last entry but if anyone finds this please find help and save our city ... \nThe entry cuts off there and suddenly, you remember the reason why you are here. As an FBI agent, your task is to find the source of a sudden violent robot invasion that took place in New York City. There is not much time left to stop the robot invasion as a previous nationwide broadcast announced that the robots will take over the entirety of the United States by sundown.  As you look through the notebook a key and map falls out.", 3);
    this.boat = new Item ("boat","You examine the boat and it is white and blue in color.", -2);
    this.Hcar = new Item ("car","You examine the car and it is a grey Honda Accord with a full tank. ", -2);
    this.Pcar = new Item ("car","You examine the police car and the entire system is broken and it seems as if someone damaged it on purpose but it still has a full tank.", -2);
    this.train = new Item ("train","You examine the train and it is empty and not even the engineer is present.", -2);
    this.map = new Item("map", "You examine the map and see that there are places near you", 0);
    
    pennStation.addItem(train);
    ferry.addItem(boat);
    hotel.addItem(Hcar);
    police_station.addItem(Pcar);
    mainApartment.addItem(notebook);
    hotel.addItem(chip);
    conv_store.addItem(baseball_bat);
    conv_store.addItem(sandwich);
    police_station.addItem(gun);
    mainApartment.addItem(map);


    //Adds npc to each location and also sets a response for npc if user asks questions
    //parameters are just the name and the strength of each npc i wasnt sure if I shouldve made response a parameter too but I can change it
    this.homeless_man = new NPC("homeless man", 1, 3, false);
    this.police_officer = new NPC ("police officer", 3, 3, false);
    this.robot = new NPC ("angry robot", 6, 3, true);
    this.professor = new NPC ("professor nick", 2, 3, false);
    this.sus_guy = new NPC ("suspicious guy", 5, 3, true);
    // this.bossRobot = new NPC ("boss robot", 5, 3, true);
    homeless_man.setResponse("The man stares blankly at something. You pull out your map to see what direction he is staring at and it seems to be the Statue of liberty");
    police_officer.setResponse("The officer talks about what happened a few hours before you arrived");
    professor.setResponse("The professor talks about how the invasion was his fault and cries hysterically.");
    sus_guy.setResponse("The suspicious person does not respond to you");
    this.robot1 = new NPC ("angry robot1", 6, 3, true);
   
    statue_liberty.addNPC(robot1);
    police_station.addNPC(police_officer);
    pennStation.addNPC(homeless_man);
    statue_liberty.addNPC(robot);
    central_park.addNPC(sus_guy);
    hotel.addNPC(professor);

    

  }
   /**
    * allows player to play game via the console.
    */
  public void playGame(){
    System.out.println("\nHello! Welcome to The NYC Robot Invasion Game.\n");
    System.out.println("Please use the following commands to interact with the game:\nlook around \nexamine [item] \ntake [item] \ndrop [item] \ngo [place] \nattack [person] with [item] \nbring [person] \neat [food] \napproach [person] \ncheck inventory \n\n");
    Scanner sc = new Scanner(System.in);
    boolean wonGame = false;
    System.out.println(player.getLocation().getDescription());

    //Taking in User input
    while(endGame(wonGame)== false) { // allows for player to repeatedly enter input

			// scanner set up to read user input
      System.out.print("\n> ");
			String input = sc.nextLine();
			input = input.toLowerCase();
			String[] words = input.split(" ");
      System.out.println();

			// if command is to take
			if (words[0].equals("take")) {
			  take(words);
			} 
      else if (words[0].equals("drop")) { // player wants to drop
			  drop(words);
			} 
      else if (words[0].equals("look")) { 
				player.look();
			} 
      else if (words[0].equals("go")){ 
        go(words);
      }

      //user wants to attack an NPC
      else if(words[0].equals("attack")){
        attack(words, wonGame);
      }

      //user wants to bring NPC
      else if(words[0].equals("bring")){
        bring(words);
      }

      //user wants to eat item
      else if(words[0].equals("eat")){
        eat(words);
      }

      else if(words[0].equals("approach")){
        approach(words);
      }

      else if(words[0].equals("check")&& words[1].equals("inventory")){
        checkInventory();
      }

      else if(words[0].equals("check")&& words[1].equals("health")){
        checkHealth();
      }
      else if(words[0].equals("examine")){
        examine(words);
      }
      else { // else no such command
				System.out.println("No such command, please try again");
			}
    }
    
  }
  
  
  
  // public static void main(String[] args) {
  //   RobotInvasion.setUp();
  //   playGame();
  // }
  
  /**
   * Ends game if player dies or reaches ending locaiton
   * @param wonGame, whether or not won game
   * @return true if the game should end
   */
  public boolean endGame(boolean wonGame){
    if(wonGame == true){
      
      System.out.println("Yay! you won.");
      return true;
    }
    if(player.getHealth() > 0){
      return false; //the player is alive so don't end game
      }
    else{
      System.out.println("You fall to the ground in pain. A few seconds later you breath your last breath and die.");
      System.out.println("You lost. The robots reign supreme!");
      return true;
    }
    //return false;
  }

   /**
    * Allows player to attack npc or robot
    * @param words, command to attack npc
    */
  public void attack(String[] words, Boolean wonGame){
    if (words.length >= 5) {
		  String myNpc = words[1]+ " " + words[2];
      boolean isNPC = false;
      NPC toAttack = null;
      //looking for npcs in location
      for(NPC npc : player.getLocation().getLocNPC()){
        if(npc.getNPCname().equals(myNpc)){
          toAttack = npc;
          isNPC = true;
        }
      }
      //looking for npcs in user's party
      for(NPC npc : player.getParty()){
        if(npc.getNPCname().equals(myNpc)){
          toAttack = npc;
          isNPC = true;
        }
      }

      String aItem = words[4];
      boolean haveItem = false;
      Item toUse = null;
          
      for(Item myItem : player.getInventory()){
        if(myItem.getName().equals(aItem)){
          toUse = myItem;
          haveItem = true;
        }
      }

      if(isNPC == false && haveItem == false){
        System.out.print("There is no " + words[1] + " " + words[2] + " near you to attack, and you do not have a " + aItem);
      }

      if(haveItem == true && isNPC == false){
        System.out.println("There is no " + words[1] + " " + words[2] + " near you to attack");
      }

      if(haveItem == false && isNPC == true){
        System.out.println("You do not have a " + aItem);
      }
 
      if(isNPC == true && haveItem == true){
        player.attack(toUse, toAttack);
        if(toAttack.getNPCname().equals("angry robot")){
          if(player.getLocation().getLocNPC().contains(robot)){
            wonGame = true;
            endGame(true);
          }
        }
      }
		} else {
			System.out.println("Please be more specific. List who you want to attack and with what item. Ie Attack man with stick");
		}
  }

 
  /**
    * Allows player to take an item
    * @param words, command to take an item
    */
  public void take(String[] words){
    // making sure input has command and item
	  if (words.length >= 2) {
			String item = words[1]; //the item should be the second thing typed
      boolean haveItem = false;
      for(Item myItem : player.getLocation().getLocItem()){
        if(myItem.getName().equals(item)){
          player.pickUp(myItem, player.getLocation());
          haveItem = true;
          break;
        }
      }
      if(haveItem == false){
        System.out.println(words[1] + " is not near you.");
      }
		}else { 
			System.out.println("What item do you want to take?");
		}
  }

  // /**
  //   * Allows player to take an item
  //   * @param words, command to take an item
  //   */
  public void examine(String[] words){
    // making sure input has command and item
	  if (words.length >= 2) {
			String item = words[1]; //the item should be the second thing typed
      Item examineItem = null;
      for(Item myItem : player.getInventory()){
        if(myItem.getName().equals(item)){
          examineItem = myItem;
        }
      }
      if (examineItem==null){
        System.out.println("You are not holding " + item + ".");
      }
      else{
        System.out.println(examineItem.getDescription());
      }
      if(examineItem.getName().equals("map")){
        lookMap();
      }
    }else{
      System.out.println("This item is not valid.");
    }
  }
    /**
    * Allows player to take an item
    * @param words, command to take an item
    */
  // public void examine(String[] words){
  //   // making sure input has command and item
	 //  if (words.length >= 2) {
		// 	String item = words[1]; //the item should be the second thing typed
  //     Item examineItem = null;
  //     for(Item myItem : player.getInventory()){
  //       if(myItem.getName().equals(item)){
  //         examineItem = myItem;
  //       }
  //     }
  //     if (examineItem==null){
  //       System.out.println(item + " is not near you.");
  //     }else{
  //       System.out.println(examineItem.getDescription());
  //     }
  //   }else{
  //     System.out.println("This item is not valid.");
  //   }

  
   /**
    * Allows player to drop an item
    * @param words, command to drop an item
    */
  public void drop(String[]words){
    if (words.length >= 2) {
			String item = words[1];
      boolean haveItem = false;
      for(Item myItem : player.getInventory()){
        if(myItem.getName().equals(item)){
          player.drop(myItem, player.getLocation());
          haveItem = true;
          break;
        }
      }
      if(haveItem == false){
        System.out.println("You don't have a " + words[1]);
      }
		} else {
			System.out.println("What item do you want to drop?");
		}
  }

  /**
    * Allows player to move from location to location
    * @param words, command to move
    */
  public void go(String[] words){
    String place = words[2];
    for(int i = 3; i < words.length; i++){
      place += " " + words[i];
    }

    Location newLoc = null;
    if (place.equals(player.getLocation().getName())){
      System.out.println("You are currently here.");
    }else{
      boolean foundPlace = false;
      for (Location p:player.getLocation().getNeighbors()){
        String n = p.getName();
        newLoc = p;
        if (place.equals(n)){
          // player.move(p);
          if(newLoc.getName().equals("statue of liberty") || player.getLocation().getName().equals("statue of liberty")){
if(player.getInventory().contains(boat)&&player.getParty().contains(homeless_man)&&(newLoc.getName().equals("ferry")||player.getLocation().getName().equals("ferry"))){
            player.move(newLoc);
            System.out.println(newLoc.getDescription());
        
      }else{
        System.out.println("Sorry you do not have access to this place");
      }
    }else if (newLoc.getName().equals("central park")||player.getLocation().getName().equals("central park")){
      if ((player.getLocation().getName().equals("police station")||newLoc.getName().equals("police station") && player.getInventory().contains(Pcar))||((player.getLocation().getName().equals("hotel") ||newLoc.getName().equals("hotel")) &&player.getInventory().contains(Hcar))){
        player.move(newLoc);
        System.out.println(newLoc.getDescription());
      }else{
        System.out.println("Sorry you do not have access to this place");
      }
      
    }else if (newLoc.getName().equals("ferry")||player.getLocation().getName().equals("ferry")){
      if (((player.getLocation().getName().equals("hotel")||newLoc.getName().equals("hotel"))&& player.getInventory().contains(Hcar))||(((player.getLocation().getName().equals("penn station")||newLoc.getName().equals("penn station"))&&player.getInventory().contains(train)))){
        player.move(newLoc);
        System.out.println(newLoc.getDescription());
        }else{
        System.out.println("Sorry you do not have access to this place");
      }
    }else if (newLoc.getName()=="penn station"||newLoc.getName()=="main apartment"||newLoc.getName()=="hotel"||newLoc.getName()=="convenience store"||newLoc.getName()=="police station"){
       
        player.move(newLoc);
        System.out.println(newLoc.getDescription());
      }else{
        System.out.println("Sorry you do not have access to this place");
      }
      foundPlace = true;
      }
      }
      if (!foundPlace){
        System.out.println("Sorry the location you asked to go is unreachable at this moment.");
      }
      }
  }

   /**
    * Allows player to take npc and add them to party
    * @param words, command to take NPC
    */
  public void bring(String [] words){
    if (words.length >= 2) {
	    String npc = words[1] + " " + words[2]; //the npc should be the second thing typed
      
      boolean isNPC = false;
      for(NPC myNPC : player.getLocation().getLocNPC()){
        if(myNPC.getNPCname().equals(npc)){
          player.addNPC(myNPC, player.getLocation());
          isNPC = true;
        }
      }
    //the user has already brought the npc
      for(NPC myNPC : player.getParty()){
        if(myNPC.getNPCname().equals(npc)){
          System.out.println("You already have " + npc + " in your party.");
          isNPC = true;
        }
      }
      if(isNPC == false){
        System.out.println(words[1] + " is not near you.");
      }
		}else { 
			System.out.println("Who do you want to bring?");
		}
  }

    /**
    * Allows player to eat and regain health
    * @param words, command to eat
    */
  public void eat(String[] words){
    if (words.length >= 2) {
			String item = words[1];
      boolean haveItem = false;
      for(Item myItem : player.getInventory()){
        if(myItem.getName().equals(item)){
          player.eat(myItem);
          haveItem = true;
          if(Math.random() < 0.4){
            System.out.println("What terrible luck! You get food poisoning and loose 5 life points.");
            player.setHealth(player.getHealth()-5);
          }
        }
      }
      if(haveItem == false){
        System.out.println("You don't have a " + words[1]);
      }
		} else {
			System.out.println("What item do you want to eat?");
		}
  }

  /**
    * Allows player to approach an NPC
    * @param words, command to approach an NPC
    */
  public void approach(String[] words){
    //ArrayList<NPC> = 
    if(words.length > 2){
      String myNpc = words[1]+ " " + words[2];
      boolean isNPC = false;
      NPC toApproach = null;
    //looking for npcs in location
      for(NPC npc : player.getLocation().getLocNPC()){
        if(npc.getNPCname().equals(myNpc)){
          toApproach = npc;
          isNPC = true;
        }
      }
      if(toApproach.getIsEvil()){
        toApproach.attacksUser(player);
      }else{
        System.out.println(toApproach.getResponse());
      }
    }
    else{
      System.out.println("Sorry, there is no NPC called " + words[1] + ". You can only approach NPCs using the format 'approach [npc name]'");
    }

  }

  /**
    * Allows player to check inventory
    */
  public void checkInventory(){
    if (player.getInventory().isEmpty()){
      System.out.println("\nyour inventory is currently empty. ");
    }else{
      System.out.println("\nYour inventory contains: ");
      for (Item inventoryItem : player.getInventory()){
        System.out.println(inventoryItem.getName());
      }
    } 
  }
  /**
   * checks health of the user
   */
  public void checkHealth(){
    int health = player.getHealth();
    System.out.println("current health: " + health);
  }
  /**
    * looks at map item and current neighbors of the place you are in. 
    */
  public void lookMap(){
    if (player.getInventory().contains(map)){
      System.out.print("You navigate the map and you see ");
      for (Location neighbor:player.getLocation().getNeighbors()){
        System.out.print(neighbor.getName()+" ");
      }
      System.out.println("near you.");
    }else{
      System.out.println("You do not have the map with you.");
    }
  }
}