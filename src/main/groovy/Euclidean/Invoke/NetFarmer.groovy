package Euclidean.Invoke

import Euclidean.Locality.AreaData
import Euclidean.Locality.AreaLocales
import Euclidean.Locality.AreaPoICollect
import Euclidean.Locality.PoILocales
import dynamicFarm.run.Farmer

class NetFarmer {
  static void main(String[] args) {
    String structure = args[0]
    Class emitClass = AreaData
    Class sourceData = AreaLocales
    Class workData = PoILocales
    Class collectClass = AreaPoICollect
    new Farmer(structure, emitClass, sourceData, workData, collectClass, "Net", false).invoke()
  }
}
