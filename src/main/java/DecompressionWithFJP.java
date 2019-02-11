import java.util.BitSet;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DecompressionWithFJP {

  public static void main(String[] args) {

    String bits =
        "11111101111100101110111000100111000101110110000110000001010001110101001100100000"; // 90
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

    long startTime = System.currentTimeMillis();
    ForkJoinPool.commonPool().invoke(new Decompressor(bs.toLongArray(), 90));
    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("total time: " + totalTime);
  }

  private static class Decompressor extends RecursiveTask<long[]> {
    private long[] r;
    private int counter;

    private Decompressor(long[] r, int counter) {
      this.r = r;
      this.counter = counter;
    }

    @Override
    protected long[] compute() {
      long[] a;
      long[] b;
      long[] ab;
      long[] bc; // aggiunto per ForkJoinPool

      int bitL;

      bc = new long[0];
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

        if (i > start) {
          //  -------------------------------------------------
          //	task da aggiungere al ForkJoinPool
          ab = ForkJoinPool.commonPool().invoke(new Decompressor(ab, counter - 1));
          // 	-------------------------------------------------
          if ((ab[0] == -1) || (ab[0] == -2)) {
          } else {
            return ab;
          }
        } else {

          // salva long array calcolato per i = start per lanciare la sua decompressione dopo aver
          // aggiunto tutte le altre possibili alternative al ForkJoinPool
          bc = ab.clone();
        }

        i = i + 1;
        if (i > 24) {
          // return (new long[] {-2});
          ck = 0;
        }
      } while (ck == 1);
      // dopo aver aggiunto tutte le altre possibili alternative al ForkJoinPool, lancia la
      // decompressione per i = start
      ab = ForkJoinPool.commonPool().invoke(new Decompressor(bc, counter - 1));

      if ((ab[0] == -1) || (ab[0] == -2)) {
      } else {
        return ab;
      }
      return ab;
    }
  }
}
