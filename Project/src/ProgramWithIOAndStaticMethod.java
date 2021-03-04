import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIOAndStaticMethod {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIOAndStaticMethod() {
    }

    /**
     * Put a short phrase describing the static method myMethod here.
     */
    private static int mod(int a, int b) {
        assert b > 0 : "Violation of: b > 0";

        int mod = a % b;
        if (mod < 0) {
            mod = mod + b;
        }
        return mod;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        NaturalNumber num = new NaturalNumber1L(1);
        NaturalNumber num2 = new NaturalNumber1L(1);
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        if (num == num2) {
            out.print("yes");
        } else {
            out.print("no");
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
