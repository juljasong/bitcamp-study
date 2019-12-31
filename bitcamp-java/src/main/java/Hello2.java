public class Hello2 {

  public static void main(String[] args) {
    /*
    int fahrenheit = 100;
    float celcius = ((5/9f*(fahrenheit-32))*100+1);
    System.out.println("Fahrenheit : " + fahrenheit);
    System.out.println("Celcius : " + celcius); //37.78
    */
    char ch = '9';
    // 영문자 혹은 숫자일 때만 true
    boolean b = ((ch > 47 && ch < 58) || (ch > 64 && ch < 91) 
        || (ch > 96 && ch < 123));
    
    System.out.println(b);

  }

}