import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class RattenFanger {

    public static void main(String[] args) throws UnsupportedEncodingException {


        int bcounter = 0;


        BigInteger ren = new BigInteger("1110110000000001110110001100001100000010100000111101100000000011101100011000011000000101000001", 2);


        String bitC = "";

        System.out.println(ren.bitLength() + "|" + ren.bitLength() % 4);

        ren = new BigInteger("0" + ren.toString(2), 2);


        do {
            bitC = "";

            for (int e = 3; e < ren.bitLength() + 3; e = e + 3) {


                if ((e > ren.bitLength() - 1) && ((ren.bitLength() + bitC.length()) % 4 > 0)) {
                    bitC = "0" + bitC;
                } else {
                    if (ren.testBit(e)) {

                        ren = ren.flipBit(e - 3);
                        ren = ren.flipBit(e - 2);
                        ren = ren.flipBit(e - 1);

                        bitC = "1" + bitC;

                    } else {

                        bitC = "0" + bitC;

                    }
                    ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength() - e - 1) + ren.toString(2).substring(ren.bitLength() - e, ren.bitLength()), 2);

                }

            }
            ren = new BigInteger(ren.toString(2) + bitC, 2);

            bcounter = bcounter + 1;

        } while (bcounter < 200);

        System.out.println(ren.toString(2));
        System.out.println(bcounter + " | " + Integer.bitCount(bcounter));

    }

}
