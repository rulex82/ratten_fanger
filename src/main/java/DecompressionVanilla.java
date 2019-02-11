import java.math.BigInteger;
import java.util.BitSet;

public class DecompressionVanilla {

  public static long[] unPackV9(long[] r, int counter) {
    long[] a;
    long[] b;
    long[] ab;
    int bitL;

    if (r[r.length - 1] > 0) {
      bitL = (r.length - 1) * 64 + (int) ((Math.log(r[r.length - 1]) / Math.log(2)));

    } else {
      bitL = (r.length) * 64 - 1;
    }

    if ((counter == 0)) {

      if ((bitL < 92) || (bitL > 95)) {
        return new long[] {-2};
      }
      int half = bitL / 2;
      a = r.clone();
      b = r.clone();

      b = Utils.shiftL(b, half + 1);
      // da aggiungere masks
      long mask = 0;
      mask = ~mask;
      mask = mask >>> (64 - half - 1);
      a[0] = a[0] & mask;
      a[1] = 0;
      if (a[0] == b[0]) {
        System.out.println(BitSet.valueOf(a));
        System.out.println(BitSet.valueOf(b));
        System.out.println("TROVATO");
      } else {
        return new long[] {-2};
      }
    }

    int bitlength = bitL;
    if ((bitL + 1) % 4 > 0) {
      bitL = bitL + (4 - ((bitL + 1) % 4));
    }

    int start = (bitL + 1) / 4; // minimum number of blocks

    int i = start;

    long ck;
    do {
      bitL = bitL + (i - start) * 4;

      b = r.clone();

      if ((bitL - bitlength == 3)) {
        if (((b[0] >>> (i - 1)) & 1) == 0) {
          return new long[] {-1};
        }
      }

      a = r.clone();

      a = Utils.shiftL(a, i);

      ck = (a[0] & 1);

      // add check if pari con primo numero controllo 0 not valid - esempio 110 001 110 111 111
      // 011111

      ab = new long[((i - 1) / 16) + 1];

      for (int e = 0; e < i; e++) {
        // take 3 digits
        long buffer = (7 & a[0]); // take only first 3 digits
        if ((b[0] & 1) == 1) {
          buffer = ~buffer;
          buffer = 15 & buffer; // take only first 4 digits
        }
        a = Utils.shiftL(a, 3);
        b = Utils.shiftL(b, 1);

        buffer = buffer << (e * 4 - (e / 16 * 64));

        // controlla ultime 4 a che fare con shift l o line sotto
        ab[e / 16] = (ab[e / 16] | buffer);
      }

      ab = unPackV9(ab, counter - 1);

      if ((ab[0] == -1) || (ab[0] == -2)) {
      } else {
        return ab;
      }
      i = i + 1;

      if (i > 24) {
        return (new long[] {-2});
      }

    } while (ck == 1);
    return ab;
  }

  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();

    String bits =
        "11111101111100101110111000100111000101110110000110000001010001110101001100100000"; //90
//    String bits = "111111101010001100101010110001000111000111110010111110100101010001110110"; //130

    // 1010
    // //90
    //  bits =
    // "11100000000111110011000011000101000000110000000001011110001111001100001010000001010100011001000"; //1
    //   bits =
    // "1111101100100000001101010100101000011000111111011001111101110100011011100101010010100111";
    // // 10
    //   bits =
    // "1000011111001001110111111101001010100101010000101100101100011000100111000100111111000100";
    // // 20
    //   bits = "111111011110010000010010101101100010011100001111110011100000011100
    // 1011111010001101110110"; // 21
    //   bits =
    // "100011000010101001100101110000000110010001110100001010111111101110001000011100011000"; // 22
    //   bits =
    // "10101101100010011111100100000011000100000000010101010001000011011110000000100111010"; //25
    //   bits =
    // "101110011100000011111001111111000010101111111110000000001011101001011101100111010001"; //26
    //   bits =
    // "100110011000000110000011010100000001000000100101101010110010001111011110111001101110"; //27
    //   bits =
    // "110110111001111011101000001000010101101100010011010001001110001111010000000110011101"; // 28
    // bits =
    // "101011001011010001100000100110000100100000001101000111111101011000010101101001011100"; //30
    //   bits =
    // "100110000000001111011000111000110100100111101010001011100000000111010010100110100010" ; //34
    //   bits =
    // "11010010000100110111011010110000010110011000100011100011011001110000010100101101110"; //51
    //   bits =
    // "110100000000010101111111110110100100001001101101000100110001100001010000010111111111"; //75
    //   bits =
    // "10000000101111000010101100010110010001011001111101000101000000100001110001000100011"; //76
    //   bits =
    // "100000101001001101111100010010011000101010111001000001010010011000100110011101001000"; //77
    //   bits =
    // "111010110011111011100110111101100110000101010110010110111100111101001011111000000001"; //78
    //   bits =
    // "1100011001001110000110110001101110101100011000100100001000001110110100000011101100"; //79
    //   bits =
    // "11001110011111110011110001100001111110000111011100100000001011001010101101101010011"; //80
    //   bits =
    // "110111011000110001011000000011011100110000001110101101100101011000111001101100000100"; //81
    //   bits =
    // "10010111011101111000010011011000001100110101110011110100000100111101011101100001100"; //82
    //   bits =
    // "100100100100011010110011001110101001111101000110001100100000011011110010111010111101"; //83
    //  bits =
    // "110010100110100011011101110000100110011010000110000010001100010100010011100000010111"; //84
    //   bits =
    // "11101110111010010011010110110111110000111011101001011111001111110111100010011000100"; //85
    //  bits =
    // "111111111100110101010100001001010010010000110000100011100011100000011111011011111010"; //86
    //  bits =    "11010101100010101010100011000111001011111001000110000101111100000000110101011";
    // //87
    //   bits =
    // "1111000110010000001110001011001000100011001111000110101101100010100000000100100"; //89
    //  bits =
    // "100001000001000000010000011111010100111011101010110110000001010011011000000100111100100110010001"; // 5
    // bits= "101001010100011000100101001000011011111101110100110100101101011101111100"; //100
    //    String bits = "100011010111101101110100000011100001101011010011001100010011011"; // 200
    // bits="10110010010101"; //410
    //  bits
    // ="1110110000000001110110001100001100000010100000111101100000000011101100011000011000000101000001"; //0  --- String originale di partenza

    BitSet bs = new BitSet(bits.length());

    for (int i = 0; i < bits.length(); i++) {
      if (bits.charAt(bits.length() - i - 1) == '1') {
        bs.set(i);
      } else {
        bs.clear(i);
      }
    }

    int bitL = bs.length();
    if ((bitL) % 4 > 0) {
      bitL = bitL + (4 - ((bitL) % 4));
    }

    long[] f = unPackV9(bs.toLongArray(), 90);

    System.out.println(new BigInteger("11101100000000011101100011000011000000101000001", 10));
    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("total time: " + totalTime);
  }
}