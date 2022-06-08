//Name: Dennis Perez
//Class : CPSC - 06 - 32002
//DennisPerezLab14



class Main {
  public static void main(String[] args) {
    int[] velocityAir = {400, 403, 406, 409, 412, 415};
    int[] wavelength1 = {350, 350, 350, 350, 350, 350};
    int[] wavelength2 = {401, 402, 403, 404, 405, 406};
    int[] wavelength3 = {420, 430, 440, 450, 460, 470};
    double velocityWater = 0.0;
    double velocitySteel = 0.0;
    double frequency1 = 0.0;
    double frequency2 = 0.0;
    double frequency3 = 0.0;

    String s_velocityWater;
    String s_velocitySteel;
    String s_velocityAir;
    String s_frequency1;
    String s_frequency2;
    String s_frequency3;
    System.out.println("\t");
    System.out.println("Table 1:");
    System.out.println("\t");
    System.out.println("Velocity In Air" + "\t " + "Velocity In Water " + "\t" + "Velocity In Steel ");

    for(int i = 0; i < velocityAir.length; i++) {
        
        velocityWater = guitarStringVelocity(velocityAir[i], "water");
        velocitySteel = guitarStringVelocity(velocityAir[i], "steel");
        

        s_velocityWater = String.format("%.1f", velocityWater);
        s_velocitySteel = String.format("%.1f", velocitySteel);
        s_velocityAir = String.format("%.1f", guitarStringVelocity(velocityAir[i], "air"));

        System.out.println(s_velocityAir + "\t\t\t " + s_velocityWater + "\t\t\t\t" + s_velocitySteel);
    } 
    System.out.println("\t");
    System.out.println("Table 2:");
    System.out.println("\t");
    System.out.println("Velocity" + "\t" + "Wavelength 1" + "\t" + "Frequency 1" + "\t " + "Wavelength 2" + "\t" + "Frequency 2" + "\t " + "Wavelength 3" + "\t" + "Frequency 3");

    for(int i = 0; i < velocityAir.length; i++) {
        
        frequency1 = guitarStringFrequency(velocityAir[i],wavelength1[i]);
        s_frequency1 = String.format("%.3f", frequency1);

        frequency2 = guitarStringFrequency(velocityAir[i],wavelength2[i]);
        s_frequency2 = String.format("%.3f", frequency2);

        frequency3 = guitarStringFrequency(velocityAir[i],wavelength3[i]);
        s_frequency3 = String.format("%.3f", frequency3);
        
        System.out.println(velocityAir[i] + "\t\t\t" + wavelength1[i] + "\t\t\t\t" + s_frequency1 + "\t\t " + wavelength2[i] + "\t\t\t" + s_frequency2 + "\t\t " + wavelength3[i] + "\t\t\t" + s_frequency3);
    }
       
  }
  public static double guitarStringVelocity(int velocityAir, String element) {
      double guitarStringVelocity = velocityAir;
      if(element == "water")
        guitarStringVelocity = velocityAir* (1500/330.0);
      else if(element == "steel")
        guitarStringVelocity = velocityAir* (5000/330.0);
      
      return guitarStringVelocity;

  }
  public static double guitarStringFrequency(int velocity, int wavelength) {
      double frequency = (velocity/(double)wavelength);
      
      return frequency;

  }
}