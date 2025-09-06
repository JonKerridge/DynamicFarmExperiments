package Euclidean.Locality

import dynamicFarm.records.ResultInterface

/**
 * The object used by Collector processes to collect rhe results of the processing
 * by the processing network
 */
class AreaPoICollect implements ResultInterface<AreaData> {

  List <AreaData> allAreas
  List <Location> accessedPoIs
  PrintWriter pw

  AreaPoICollect(List p){
    allAreas = []
    accessedPoIs = []
    pw = new PrintWriter(new File(p[0] as String))
  }

  /**
   * collate() is used to aggregate the results of the application and is called as
   * each data object is read by a Collect process
   *
   * @param data the data object to be aggregated of the same type as that created in the Emit cluster
   * @param params any parameters required for collate to function as required
   */
  @Override
  void collate(AreaData data, List params) {
    allAreas << data
    pw.println("$data")
    data.nearPoIs.each{loc ->
      accessedPoIs << loc
    }
  }

  /**
   * finalise() is called once in the Collect process and is used to provide any
   * post-processing of the data aggregated by collate()
   *
   * @param params any parameters required for collate to function as required,
   * for example the name of a file into which results should be saved
   */
  @Override
  void finalise(List params) {
    List <Integer> unusedPoI
    List <Integer> areasWithNoPoI
    unusedPoI = []
    areasWithNoPoI = []
    // find any areas that have no close PoI
    allAreas.each { ad ->
      if (ad.areaLocation.crowDistance == null)
        areasWithNoPoI << ad.areaLocation.id
    }
    // find PoIs that have not been accessed
    def uniquePoIs = accessedPoIs.toUnique { a, b -> a.id <=> b.id}
    def sortedPoIs = uniquePoIs.toSorted{a,b -> a.id <=> b.id}
    int current
    current = 0
    while ( current < (sortedPoIs.size()-1)){
      if ( (sortedPoIs[current].id + 1) != sortedPoIs[current+1].id)
        unusedPoI << sortedPoIs[current+1].id
      current = current + 1
    }
    println "\n"
    println "Areas with no close PoI = $areasWithNoPoI"
    println "PoIs not accessed = $unusedPoI "
    pw.flush()
    pw.close()
  }
}

