public class Utils {
  public static long[] shiftL(long[] array, int n) {
    if (n < 0) throw new IllegalArgumentException("'n' must be >= 0");
    // if (n >= 64)
    //      throw new IllegalArgumentException("'n' must be < 64");

    long[] words = array;
    for (int i = 0; i < words.length; i++) {
      if (i == words.length - 1) {
        words[i] = words[i] >>> n;
      } else {
        words[i] = words[i] >>> n | words[i + 1] << 64 - n;
      }
    }

    return words;
  }
}
