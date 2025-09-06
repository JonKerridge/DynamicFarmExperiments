package Mandelbrot.Invoke

import Euclidean.Locality.AreaData
import Euclidean.Locality.AreaLocales
import Euclidean.Locality.AreaPoICollect
import Euclidean.Locality.PoILocales
import dynamicFarm.run.Farmer

class MandelbrotFarmer {
  static void main(String[] args) {
    String structure = args[0]
    Class dataClass = AreaData
    Class sourceData = null
    Class workData = null
    Class resultClass = AreaPoICollect
    new Farmer(structure, dataClass, sourceData, workData, resultClass, "Net", false).invoke()
  }
}
