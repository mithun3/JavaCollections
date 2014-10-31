package collections.sort;
public class Sort {
  void QuickSort(String a[], int lo0, int hi0) {
    int lo = lo0;
    int hi = hi0;
    String mid;

    if (hi0 > lo0) {

      /*
       * Arbitrarily establishing partition element as the midpoint of the
       * array.
       */
      mid = a[(lo0 + hi0) / 2];

      // loop through the array until indices cross
      while (lo <= hi) {
        /*
         * find the first element that is greater than or equal to the
         * partition element starting from the left Index.
         */
        while ((lo < hi0) && (a[lo].compareTo(mid) < 0))
          ++lo;

        /*
         * find an element that is smaller than or equal to the
         * partition element starting from the right Index.
         */
        while ((hi > lo0) && (a[hi].compareTo(mid) > 0))
          --hi;

        // if the indexes have not crossed, swap
        if (lo <= hi) {
          String t = a[hi];
          a[hi] = a[lo];
          a[lo] = t;

          ++lo;
          --hi;
        }
      }

      /*
       * If the right index has not reached the left side of array must
       * now sort the left partition.
       */
      if (lo0 < hi)
        QuickSort(a, lo0, hi);

      /*
       * If the left index has not reached the right side of array must
       * now sort the right partition.
       */
      if (lo < hi0)
        QuickSort(a, lo, hi0);

    }
  }
}