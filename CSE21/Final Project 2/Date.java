public class Date {

  private int month;
  private int day;
  private int year;
  // A constructor which sets the instance variables to their appropriate input parameters (3 inputs)

  public Date(int month, int day, int year) {
    this.month = month;
    this.day = day;
    this.year = year;
  }

 // Accessor methods for each of the 3 instance variables
 public int getyear() {
   return year;
 } 
 public int getmonth() {
   return year;
 }
 public int getday() {
   return year;
 }   

  public int dayOfYear() {
    int totalDays = 0;
    switch (month) {
      case 12: totalDays += 30;
      case 11: totalDays += 31;      
      case 10: totalDays += 30;
      case 9: totalDays += 31;
      case 8: totalDays += 31;
      case 7: totalDays += 30;
      case 6: totalDays += 31;
      case 5: totalDays += 30;
      case 4: totalDays += 31;
      case 3: totalDays += 28;
      case 2: totalDays += 31;

    }
    totalDays += day;
    return totalDays;
  }

  public int compare(Date dt) {

      // Computes the difference in years between birth of person 1 and person 2 and multiply all that by 365 to get the number of days difference between them (so say there is a 4 year difference, it would be 4 * 365)
      // Step 1. Calculate yearsDifferenceInDays.

      int yearsDifferenceInDays = Math.abs(this.getyear() - dt.getyear()) * 365;

      // Step 2. Calculate daysDifference.

      //days difference is the difference between the birth months (so the diff in days between january and july)
      // not every single month has the same amount of days (they fluctuate from 28, 30, 31)
   /* so if the person was born on Feb 15

      you take the number of days in the previous months + the number of days your current month, which gives you 46 days. You know that 46 days out of 365 has passed

      so if the person was born on Jul 22
      you take the number of days in the previous months (151) + the number of days your current month (22), which gives you 173 days. You know that 46 days out of 365 has passed

      FINALLY to get the difference between each, you just subrtract the number of days you got for july and feb (173-46)

   */

      int daysDifference = Math.abs(this.dayOfYear() - dt.dayOfYear());
      //abs diff of this variable created by constructor and the dt variable of the compare method. "this" is person 1 and "dt" is person 2

      // Step 3. Calculate totalDifference.
      // Total difference is the difference in # of days per year between person 1 & 2, added to the difference in # of days per month between person 1 & 2
      // (|1992-1996| * 365 = x amount of days difference) - (|Feb 15 - July 22| = x amount of days between July and January)

      int totalDifference = Math.abs((yearsDifferenceInDays) - (daysDifference));

      // Step 4. Determine the difference in number of months between Person A and Person B by dividing by 30.
      // Calculate days differential (totalDifference) by 30.

      int monthsDifference = totalDifference/30;

      if(monthsDifference > 60) {
          return 60; //max
      }
      return monthsDifference;
  }
}