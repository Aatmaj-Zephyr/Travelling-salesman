import java.util.*;
public class pathfinder
{
  //This class does the work of finding the shortest path.

  private citylist path;	//The shortest path.
  private citylist temp;	//The temparory citylist
  private double distance;	//The shortesrt distance.


  private pathfinder ()
    //default constructor to be called only by the other constructoes, hence marked private.
  {
    path = new citylist ();	//Instantiation
    temp = new citylist ();	//Instantiation
  }

  pathfinder (city START, city END)
  {				//Parametrized constructor to find the shortest distance between the two points 
    this ();			//call the defaut constructor for Instantiation
    distance = FindPath (START, END, 1000.00);	//find the shortest distance

  }

  pathfinder (String startname, String endname, citylist temp)
  {
    //the Parametrized constructor which takes in names instead of cities.
    this (temp.get (startname), temp.get (endname));
  }


  public citylist sendpath ()
  {				//return the citylist path which stores the shortest path
    return path;
  }

  public void printpathname ()
  {				//print the shortest path.
    path.print ("-");
  }

  public double distance ()
  {				//Return the shortest distance.
    return distance;
  }

  public void printdistance ()
  {				//Print the shortest distance.
    System.out.print (String.format("%.3f",distance));
  }



  private double FindPath (city START, city END, double min)
  {
    //The function which has the traveling salseman algorithm 
    temp.append (START);
    //Append the START city in the citylist temp.

    if (END.equals (temp.last ()))
      //If the temp citylist's last element is our destination END.....
      {
	double dist = temp.sum ();
	//Get the sum of all distances along the path,
	//that is the distance of this path from START to END 

	if (dist < min)
	  {			//If the sum is the minimum till now, then the value of citylist path equals that of temp.
	    path.set (temp);
	  }

	temp.pop ();		//Remve the last value appended to the list

	return dist;		//return the shortest distance

      }

    else			//Else....
      {
	for (int i = 0; i < START.neighbours.size (); i++)
	  {			//For every neighbour of START,.......
	    city newcity = START.neighbours.get (i);	//Get the neighbour

	    if (temp.contains (newcity) == true)
	      {
		//If the neighbour is already in the citylist temp,
		//this means we are going in circles, so go for the next neighbour
		continue;
	      }

	    double temparory = FindPath (newcity, END, min); //Recusion.
	    /*
	    The shortest path from one city to another is the
	    shortest of the shortest path from the starting city to all it's neighbours.
	    */

	    if (temparory < min)
	    //If temparory (distace returned by recursion) is the shortest, then min is now temparory
	      {
		min = temparory;
		
	      }


	  }
	temp.pop ();
	return min;
    //now no neighbours are left.
      }
  }

}
