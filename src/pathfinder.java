import java.util.*;

public class pathfinder {
  // This class does the work of finding the shortest path.

  private cityList shortestPath; // The shortest path.
  private cityList tempCityList; // The temparory citylist
  private double distance; // The shortesrt distance.

  private pathfinder()
  // default constructor to be called only by the other constructoes, hence marked
  // private.
  {
    shortestPath = new cityList(); // Instantiation
    tempCityList = new cityList(); // Instantiation
  }

  pathfinder(
      city START,
      city END) { // Parametrized constructor to find the shortest distance between the two points
    this(); // call the defaut constructor for Instantiation
    distance = findPath(START, END, 1000.00); // find the shortest distance
  }

  pathfinder(String startName, String endName, cityList temp) {
    // the Parametrized constructor which takes in names instead of cities.
    this(temp.getCityByCityName(startName), temp.getCityByCityName(endName));
  }

  public cityList sendShortestPath() { // return the citylist path which stores the shortest path
    return shortestPath;
  }

  public void printShortestPathName() { // print the shortest path.
    shortestPath.print("-");
  }

  public double getShortestPathDistance() { // Return the shortest distance.
    return distance;
  }

  public void printdistance() { // Print the shortest distance.
    System.out.print(String.format("%.3f", distance));
  }

  private double findPath(city START, city END, double min) {
    // The function which has the traveling salseman algorithm
    tempCityList.append(START);
    // Append the START city in the citylist temp.

    if (END.equals(tempCityList.getLastCityElement()))
    // If the temp citylist's last element is our destination END.....
    {
      double dist = tempCityList.getPathLength();
      // Get the sum of all distances along the path,
      // that is the distance of this path from START to END

      if (dist < min) { // If the sum is the minimum till now, then the value of citylist path equals
                        // that of temp.
        shortestPath.copyFromCitylist(tempCityList);
      }

      tempCityList.pop(); // Remve the last value appended to the list

      return dist; // return the shortest distance

    } else // Else....
    {
      for (int i = 0; i < START.neighbours.getSizeOfCityList(); i++) { // For every neighbour of START,.......
        city newcity = START.neighbours.getCityByPosition(i); // Get the neighbour

        if (tempCityList.hasCityByCityObj(newcity) == true) {
          // If the neighbour is already in the citylist temp,
          // this means we are going in circles, so go for the next neighbour
          continue;
        }

        double temparory = findPath(newcity, END, min); // Recusion.
        /*
         * The shortest path from one city to another is the
         * shortest of the shortest path from the starting city to all it's neighbours.
         */

        if (temparory < min)
        // If temparory (distace returned by recursion) is the shortest, then min is now
        // temparory
        {
          min = temparory;
        }
      }
      tempCityList.pop();
      return min;
      // now no neighbours are left.
    }
  }
}
