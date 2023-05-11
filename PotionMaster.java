// Gino Benitez
// gi146072
// COP 3330, Spring 2023

// Import all Java classes and containers
import java.util.*;

public class PotionMaster
{

 public static Map<String, Set<String>> potionToReagentsMap(List<PotionInfo> potionsManual)
  {

      // Create a new HashMap with value being the set of reagents
      Map<String, Set<String>> potionBook = new HashMap<>();

      //for every PotionInfo object in potionsManual
      for(PotionInfo p : potionsManual)
      {
        //Create a Set mirroring the list of reagents
        Set<String> s = new HashSet<>(p.reagents);

        //Set up key-value relationship with potion and reagents
        potionBook.put(p.name, s);
        }

    //Return new HashMap
    return potionBook;
  }

  public static Map<String, Set<String>> reagentToPotionsMap(List<PotionInfo> potionsManual)
  {
     // Create a new HashMap with value being the set of Potions
      Map<String, Set<String>> reagentsBook = new HashMap<>();

      // for every PotionInfo object in potionsManual
      for(PotionInfo p : potionsManual)
      {

        // for every Reagent in the list of Reagents
        for(String r : p.reagents)
        {
            // Use hashing to properly store potions in correct sets
            Set<String> s = reagentsBook.getOrDefault(r, new HashSet<>());

            // Add potion names to sets
            s.add(p.name);

            // Add reagent and potion set to HashMap
            reagentsBook.put(r, s);
        }
      }

    // Return HashMap
    return reagentsBook;
  }

  public static boolean canBrewPotion(PotionInfo potionInfo, Set<String> reagentsOnHand)
  {
      // Set boolean variable to true automatically
      boolean truth = true;

      // Increment through all reagents
      for(String s : potionInfo.reagents)
      {

        // if reagents on hand does not contain all reagents for potion
        if(!reagentsOnHand.contains(s))
        {
          // return false and exit
          return false;
        }
      }

    // if everything holds true return truth
    return truth;
  }

  public static boolean canBrewPotion(String potionToBrew,
  Map<String, Set<String>> potionToReagentsMap,
  Set<String> reagentsOnHand)
  {

      // Set boolean variable to true automatically
      boolean t = true;

      // Increment through keys
      for (String s : potionToReagentsMap.keySet())
      {
        // If the potion we are making is not apart of the Map return false
        if (!s.equals(potionToBrew))  {return false;}

        // Else check to see if reagents on hand matches needed reagents
        else
        {
            // Create a set from needed reagents
            Set<String> m = potionToReagentsMap.get(s);

            // if reagents on hand contain all needed reagaents
            // return t else return false
            if(reagentsOnHand.containsAll(m))  {return t;}

            else  {return false;}
          }
        }

    // if everything holds true return t 
    return t;
  }

  public static Set<String> allPossiblePotions(Map<String,Set<String>>potionToReagentsMap,
  Map<String, Set<String>> reagentToPotionsMap,
  Set<String> reagentsOnHand)
  {
    // create new HashSet
    Set<String> possiblePotions = new HashSet<>();

    // Increment through keys in potionToReagentMap
    for(String p : potionToReagentsMap.keySet())
    {
      // create new set from values of keys
      Set<String> t = potionToReagentsMap.get(p);

        // if reagents conatain all reagents needed, add potion to set
        if(reagentsOnHand.containsAll(t))  {possiblePotions.add(p);}
     }

    // Return set
    return possiblePotions;
  }

  public static double difficultyRating()
  {
    return 3.0;
  }

  public static double hoursSpent()
  {
    return 5.0;
  }
}
