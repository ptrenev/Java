package Chapter01.BreakingTheSurface;

/**
 * Created by Petko on 29.3.2016 г..
 */
public class Loopy {
    public static void main(String[] args) {
        int x = 1;
        System.out.println("Before the loop");
        while ( x<4 ){
            System.out.println("In the loop");
            System.out.println("The value of x is: " + x);
            x++;
        }
        System.out.println("This is after the loop");
    }

}
