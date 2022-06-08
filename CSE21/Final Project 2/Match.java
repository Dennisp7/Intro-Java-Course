// These allow you to import the library of each one
// Exceptions allow me to handle errors easily
import java.io.FileNotFoundException; // Needed to open the file - error handling
import java.io.File; // To work with files
import java.util.Scanner; // Scanner

public class Match {
  // The driver file- hence the main (purpose of program is to match two people)
  // Reading files
  public static void main(String[] args) throws FileNotFoundException {
    // Create an array of Students (max = 100)
   Student[] studentArray = new Student[100];

  /* 
  get the path of the file:

  download project into eclipse
  search for files within project 2 folder
  right click on the file, click properties, copy and paste the information in the location
  */
    File roster = new File ("C:/Users/Dennis Perez/IdeaProjects/Project2/src/FullRoster.txt"); // actual information of students we will use
    //File stu = new File ("C:/Users/Dennis Perez/IdeaProjects/Project2/src/Students.txt");      // more of an example to mess with

    int index = 0; // used as counter or a flag
    String name;
    String gender;
    String birthdate;
    int month;
    int day;
    int year;
    int quietTime;
    int music;
    int reading;
    int chatting;

    // Read 1 row at a time from the file.
    Scanner myFileScanner1 = new Scanner(roster);

    // Read the line from the text file until you reach the End of File.
    while (myFileScanner1.hasNextLine()) {

      // Create a second scanner to extract data from each row. Read the arguments from the row.
      Scanner myFileScanner2 = new Scanner(myFileScanner1.nextLine());

      myFileScanner2.useDelimiter("\t");

      name = myFileScanner2.next();
      gender = myFileScanner2.next();
      birthdate = myFileScanner2.next();

      // Create a third scanner to extract the month, day, and year.
      Scanner myBirthdayScanner = new Scanner(birthdate);
      myBirthdayScanner.useDelimiter("-");

      month = myBirthdayScanner.nextInt();
      day = myBirthdayScanner.nextInt();
      year = myBirthdayScanner.nextInt();

      quietTime = myFileScanner2.nextInt();
      music = myFileScanner2.nextInt();
      reading = myFileScanner2.nextInt();
      chatting = myFileScanner2.nextInt();

//      System.out.println(name);
//      System.out.println(gender);
//      System.out.println(birthdate);
//      System.out.println(month);
//      System.out.println(day);
//      System.out.println(year);
//      System.out.println(quietTime);
//      System.out.println(music);
//      System.out.println(reading);
//      System.out.println(chatting);
//      System.out.println(gender.charAt(0));

      // Create Student object and add that object to the studentArray
      Student student = new Student(name, gender.charAt(0), new Date(month, day, year), new Preference(quietTime, music, reading, chatting));
      studentArray[index] = student;
      index++; // Increments the index so the new object will be tied to the next element in the array.

    }
    // There are 25 people in the Full Roster.
    // System.out.println(index);

    // Iterate through the entire array and print the names of all people.
    // for (int count = 0; count < index; count++) {
    //    System.out.println(studentArray[count].getname());
    //}

      int numberOfStudents = index;

      // Find the first unmatched person.
      for (int currentStudentIndex = 0; currentStudentIndex < numberOfStudents; currentStudentIndex++) { // Checks the entire array
          if(!studentArray[currentStudentIndex].getmatched()) {              // Condition that checks for not matched students

              int bestMatchScore = 0;
              int bestMatchStudentIndex = 0;

              // Pair the person with someone else that remains unmatched.
              for (int remainingStudentsIndex = currentStudentIndex + 1; remainingStudentsIndex < numberOfStudents; remainingStudentsIndex++) {
                  if(!studentArray[remainingStudentsIndex].getmatched()) {
                       int currentScore = studentArray[currentStudentIndex].compare(studentArray[remainingStudentsIndex]);

                        if (currentScore > bestMatchScore) {
                            bestMatchStudentIndex = remainingStudentsIndex;
                            bestMatchScore = currentScore;
                        }
                  }
              }

              // At this point, we know that Person A and Person B are a match for one another.
              // Person A is studentArray[currentStudentIndex]
              // Person B is studentArray[bestMatchStudentIndex]
              // Their score is held in bestMatchScore.

              if (bestMatchScore > 0) {
                  // Set matched for both individuals to TRUE
                  studentArray[currentStudentIndex].setmatched(true);
                  studentArray[bestMatchStudentIndex].setmatched(true);
                  // Display PERSON A matched with PERSON B
                  System.out.println(studentArray[currentStudentIndex].getname() + " matches with " + studentArray[bestMatchStudentIndex].getname() + " with the score " + bestMatchScore + ".");
              } else if (!studentArray[currentStudentIndex].getmatched()) {
                  // This person had no matches.
                  System.out.println(studentArray[currentStudentIndex].getname() + " has no matches.");
              }
          }
      }
  }

}