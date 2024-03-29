import java.io.*;

public class Getinput
// This class generates the cities from the files.
{
  public cityList setCityNeighbours(String ObjectFile, String NeighbourFile)
  // This is the method which is called.
  // This does the job of calling the two functions of making city instances and
  // setting the
  // neighbours
  {
    return SetCityNeighboursFromCityListAndNeighbourFileIfPossible(SetCityInstancesIfPossible(ObjectFile), NeighbourFile);
  }

  public cityList SetCityInstancesIfPossible(String ObjectFile) { 
    try // try catch to prevent the file not exists exception.
    {
      return SetCityInstances(ObjectFile);
    } catch (Exception ex) {
      System.out.println("File doesn't exist or has invalid entries"); // the file does not exist.
      return null;
    }
  }
  private cityList SetCityInstances(String ObjectFile) throws FileNotFoundException, IOException {
    {     // This method make city instances with the names and the coordinates given
      // in the ObjectFile, and stores them in a citylist which it returns.
      cityList myCityList = new cityList(); // Citylist to store the city instances.

      File f = new File(ObjectFile);
      FileReader fileReader = new FileReader(f);
      BufferedReader reader = new BufferedReader(fileReader);
      // Standred syntax to readline.
      String line = null; // Make a string which reads the line.
      while ((line = reader.readLine()) != null) // While not the end of file.
      {
        
        myCityList.append(readCityFromFileLine(line));
        // Add the coty to the citylist which is to be returned.

      }
      reader.close(); // close the File

      return myCityList;
    } 
  }
  private  city readCityFromFileLine(String line){
    String arr[] = line.split(":"); // split the read string to bifercate name and two coordinates.

        String name = arr[0]; // name of the city
        double x = Double.parseDouble(arr[1]); // x coordinate
        double y = Double.parseDouble(arr[2]); // y coordinate

        city citytobeadded = new city(x, y);
        citytobeadded.setName(name);
        return citytobeadded;
  }
  private cityList SetCityNeighboursFromCityListAndNeighbourFileIfPossible(
      cityList mycitylist,
      String NeighbourFile) { // This method is present to set the Neighbours of the cities in the
                              // citylist mycitylist

    try // try catch to prevent the file not exists exception.
    {
      return SetCityNeighboursFromCityListAndNeighbourFile(mycitylist, NeighbourFile);

    } catch (Exception ex) {
      System.out.println("File doesn't exist or has invalid entries"); // the file does not exist.
      return null;
    }
  }
  private cityList SetCityNeighboursFromCityListAndNeighbourFile(cityList mycitylist, String NeighbourFile) throws IOException,FileNotFoundException{
    File f = new File(NeighbourFile);
      FileReader fileReader = new FileReader(f);
      BufferedReader reader = new BufferedReader(fileReader);
      // Standred syntax to readline.

      String line = null; // Make a string which reads the line

      while ((line = reader.readLine()) != null) // While not the end of file.
      {
        readNEighboursFromFileLine(line,mycitylist);
        }
      
      reader.close(); // close the file.

      return mycitylist; // return the citylist which have now been added with Neighbours.
  }
  private void readNEighboursFromFileLine(String line, cityList mycitylist){

    String arr[] = line.split(":");
    // split the line to seperate the names and the neoghbors.

    String name = arr[0];
    String nei[] = arr[1].split(",");
    // Seperate the Neighbours which are seperated by commas.

    for (int i = 0; i < nei.length; i++) {
      mycitylist.getCityByCityName(name).neighbours.append(mycitylist.getCityByCityName(nei[i]));
      // Set the Neighbours.
  }
}
}

