package Class_02_BinSearch;

public class FirstOccur {
  public int firstOccur(int[] array, int target) {
    if(array == null || array.length == 0) {
      return -1;
    }
    int start = 0;
    int end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if(target <= array[mid]) {
        mid = end; // find fistOccur, if equal let mid = end
      } else {
        mid = start;
      }
    }
    if(array[start] == target) {
      return start;
    } else if (array[end] == target) {
      return end;
    }
    return -1;
  }
}
