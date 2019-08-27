package alg.laioffer.class14.probsampling;

import java.util.List;

public interface GeneralizedReservoirSampling {
  void read(int value);
  List<Integer> sample();
}