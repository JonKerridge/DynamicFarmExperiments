package Euclidean.Invoke

import dynamicFarm.run.Farmer
import Euclidean.Locality.AreaData
import Euclidean.Locality.AreaLocales
import Euclidean.Locality.AreaPoICollect
import Euclidean.Locality.PoILocales

class Exp1 {
  static void main(String[] args) {
    String structure = "./src/main/groovy/euclidean/DSLfiles/exp1"
    Class emitClass = AreaData
    Class sourceData = AreaLocales
    Class workData = PoILocales
    Class collectClass = AreaPoICollect
    new Farmer(structure, emitClass, sourceData, workData, collectClass, "Local", false).invoke()
  }
}
