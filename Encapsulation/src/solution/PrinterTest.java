package solution;

/**
 * Created by Petko-PC on 2/21/2017.
 */
public class PrinterTest {

    public static void main(String[] args) {
        Printer printer = new Printer(50, false);
        System.out.println("Initial page count: " + printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was: " + pagesPrinted + " new total print count for printer = " + printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was: " + pagesPrinted + " new total print count for printer = " + printer.getPagesPrinted());
    }

}
