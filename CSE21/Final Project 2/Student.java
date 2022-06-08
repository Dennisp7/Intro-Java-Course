
public class Student { //whether or not there is a match
  // These are only used to pass arguments to preference and date class
  private int month;
  private int day;
  private int year;
  private static int music;
  private static int reading;
  private static int chatting;
  private static int quietTime;
  // These are the instance variables that will be used
  String name;
  char gender;
  boolean matched;

  // We will be using the Date and Preference classes here.
  Date birthdate = new Date(month, day, year);
  Preference pref = new Preference(quietTime, music, reading, chatting);
  
  // One constructor which sets the instance variables to their appropriate input parameters (4 inputs).
  public Student(String name, char gender, Date birthdate, Preference pref) {
    this.name = name;
    this.gender = gender;
    this.birthdate = birthdate;
    this.pref = pref;
  }

  //Accessor methods for each of the 5 instance variables.

  public String getname() { // no arguments passed since its only retrieving data, not setting it
    return name;
  }
  
  public char getgender() {
    return gender;
  }

  public boolean getmatched() {
    return matched;
  } 

  public Date getbirthdate() {
    return birthdate;
  }   

  public Preference getpref() {
    return pref;
  }

  // Mutator method for matched to set it to true after a successful match with another student

  public void setmatched(boolean matched) { 
    //will need to be called twice to set it for each student
    //this needs to bet a "set" so it can mutate the match variable
    // This isn't used until we find a match between two people which is done in Match class
    this.matched = matched;
  }

  // A method that returns the compatibility score between the current student, and the Student input parameter, st

  public int compare(Student st) { // st is the argument being fed into the compare method of Student
    // If the two individuals have opposite genders, return 0.
    // Otherwise, compute the compatibility score.
    // tutor assistance
    // Condensed code into single line statements to improve readability
    if(((st.getgender() == 'M') && (this.getgender() == 'F')) || ((st.getgender() == 'F') && (this.getgender() == 'M'))) {
      // System.out.println("NOPE! OPPOSITE GENDERS.");
      return 0;
    } else { // when same gender
      // return (40 – Preferences) + (60 – AgeDifference);
      // formulas are found in each class under correlating compare methods

      return ((40 - pref.compare(st.pref)) + (60 - birthdate.compare(st.birthdate)));
      //Preferences = abs diff of each of the 4 activities added together
      //AgeDifference = number of months between 2 birthdates with the max being 5 years (60 months)
      //use Math.abs() to calc abs value. "Math.abs(age 2 - age 1)"
    }
  }


}