import java.util.*;

public class cityList
// This is the class which is made for storing city objects as a list.
{
  ArrayList<city> listOfCities;
  // This arraylist is the one which has all the city objects.

  cityList() // default constructor.
  {
    listOfCities = new ArrayList<city>(); // instantiate new ArrayList
  }

  public void append(city a) // Method to append in the list.
  {
    listOfCities.add(a);
  }

  /*
   * hasCity() Method is used to check if the citylist contains the list or not.
   * If citylist has the city, then return true, else return false.
   * We can give parameters of city, city name or coordinates.
   */
  public boolean hasCityByCityObj(city a) {

    for (int j = 0; j < listOfCities.size(); j++) {
      if (city.equals(listOfCities.get(j), a) == true) {
        return true;
      }
    }
    return false;
  }

  public boolean hasCityByStringName(String a) {
    for (int j = 0; j < listOfCities.size(); j++) {
      if (city.equals(listOfCities.get(j), a) == true) {
        return true;
      }
    }
    return false;
  }

  public boolean hasCityByCoordinates(double a, double b) {
    return hasCityByCityObj(new city(a, b));
  }

  public void copyFromCitylist(cityList a) {
    // method to set values of another citylist into this citylist.

    listOfCities.clear();
    for (int i = 0; i < a.listOfCities.size(); i++) {
      listOfCities.add(a.listOfCities.get(i));
    }
  }

  public city getLastCityElement() {
    // return the last element in the list

    return listOfCities.get(listOfCities.size() - 1);
  }

  public void pop() // pop from the list
  {
    listOfCities.remove(listOfCities.size() - 1);
  }

  public double getPathLength()
  // This method is present to calculate the path length.
  // This method sums up the distances between all the two cities in the list.
  {
    double temp = 0; // temparory variable to store the sum.
    for (int i = 0; i <= (listOfCities.size() - 2); i++) {
      temp = temp
          + complex.distanceBetweenComplexPoints(listOfCities.get(i).coordinates, listOfCities.get(i + 1).coordinates);
    }
    return temp;
  }

  /*
   * Methods to print the elements (name of the cities) of the citylist.
   * print()- print the names.
   * println()- print the names on a new line .
   * print(String Seperator)- print with Seperator, like comma, etc.
   */
  public void print() {
    for (int i = 0; i <= (listOfCities.size() - 1); i++) {
      System.out.print(listOfCities.get(i).cityName);
    }
  }

  public void println() {
    for (int i = 0; i <= (listOfCities.size() - 1); i++) {
      System.out.println(listOfCities.get(i).cityName);
    }
  }

  public void print(String Seperator) {
    for (int i = 0; i < (listOfCities.size() - 1); i++) {
      System.out.print(listOfCities.get(i).cityName);
      System.out.print(Seperator); // print with Seperator
    }
    System.out.print(listOfCities.get(listOfCities.size() - 1).cityName);
  }

  /*
   * The methods to find the position of the city in the list.
   * Can add parameters of city object, city name or coordinates.
   */
  public int getPositionByCity(city a) {
    for (int j = 0; j < listOfCities.size(); j++) {
      if (city.equals(listOfCities.get(j), a) == true) {
        return j;
      }
    }
    return -1;
  }

  public int getPositionByString(String a) {
    for (int j = 0; j < listOfCities.size(); j++) {
      if (city.equals(listOfCities.get(j), a) == true) {
        return j;
      }
    }
    return -1;
  }

  public int getPositionByPoint(double a, double b) {
    return getPositionByCity(new city(a, b));
  }

  /*
   * Methods to get the city object from the citylist.
   */
  public city getCityByPosition(int a) // get the a'th position of the citylist
  {
    return listOfCities.get(a);
  }

  public city getCityByCity(city a) {
    return getCityByPosition(getPositionByCity(a));
  }

  public city getCityByCityName(String a) {
    return listOfCities.get(getPositionByString(a));
  }

  public city getCityByCoordinates(double a, double b) {
    return getCityByCity(new city(a, b));
  }

  public int getSizeOfCityList() // the size of the citylist
  {
    return listOfCities.size();
  }
}
