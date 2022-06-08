
import java.lang.Math;

public class Preference {
  private int quietTime;
  private int music;
  private int reading;
  private int chatting;

  public Preference(int quietTime, int music, int reading, int chatting) { // Constructor
    this.quietTime = quietTime;
    this.music = music;
    this.reading = reading;
    this.chatting = chatting;
  }

  public int getquietTime() {
    return quietTime;
  }  // Accessors
  public int getmusic() {
    return music;
  }
  public int getreading() {
    return reading;
  }
  public int getchatting() {
    return chatting;
  }      
  
  // Performs abs diff of each of the 4 activities added together
  public int compare(Preference pref) {
  //difference of preferences' quiet time value and the constructor's quiet time value
    return (Math.abs(pref.getquietTime() - this.getquietTime()) +
            Math.abs(pref.getmusic() - this.getmusic()) +
            Math.abs(pref.getreading() - this.getreading()) +
            Math.abs(pref.getchatting() - this.getchatting()));

  }
}