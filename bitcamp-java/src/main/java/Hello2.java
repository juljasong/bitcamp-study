import java.util.Scanner;

public class Hello2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    /*
    int fahrenheit = 100;
    float celcius = ((5/9f*(fahrenheit-32))*100+1);
    System.out.println("Fahrenheit : " + fahrenheit);
    System.out.println("Celcius : " + celcius); //37.78
     */
    //System.out.print("한 문자 ? ");
    char ch = 'a';
    //[4-1.1] if (x > 10 && x < 20) {
    //[4-1.2] if (ch != ' ' && ch != '\t') {
    if (ch == 'x' || ch == 'X') {
      System.out.println("true");
    }
    sc.close();
  }

}