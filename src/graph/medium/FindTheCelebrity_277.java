
/**
 * Created by gopinath_mb on Oct 23, 2021
 */
package graph.medium;

/**
 * @author gopinath_mb
 */
public class FindTheCelebrity_277 extends Relation {

  public int findCelebrity(int n) {

    int start = 0;
    int end = n - 1;
    while (start < end) {
      if (knows(start, end)) {
        start++;
      } else {
        end--;
      }
    }

    int celebrity = end;

    for(int i = 0; i < n; i++) {
      if (i == celebrity) {
        continue;
      }
      if (knows(celebrity, i) || !knows(i, celebrity)) {
        return -1;
      }
    }
    return celebrity;
  }
}

class Relation {

  private int[][] mat;

  public Relation(int mat[][]) {
    this.mat = mat;
  }

  public Relation() {
  }

  public boolean knows(int i, int j) {
    return (mat[i][j] == 1);
  }
}
