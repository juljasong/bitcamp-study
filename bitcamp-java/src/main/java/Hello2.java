import java.util.Scanner;

public class Hello2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int fahrenheit = 100;
    float celcius = (int)(5/9f*(fahrenheit-32) * 100 + 0.5) / 100f;
    System.out.println("Fahrenheit : " + fahrenheit);
    System.out.println("Celcius : " + celcius); //37.78
    
    //System.out.print("한 문자 ? ");
    char ch = '1';
    //[4-1.1] if (x > 10 && x < 20) {
    //[4-1.2] if (ch != ' ' && ch != '\t') {
    //[4-1.3] if (ch == 'x' || ch == 'X') {
    sc.close();
  }

}