package Euclidean.Locality

import dynamicFarm.records.EmitInterface
import dynamicFarm.records.WorkDataInterface

class AreaData implements EmitInterface<AreaData>{

  Location areaLocation
  List <Location> nearPoIs
  List <Location> adjacentPoI

  AreaData(List p){
    areaLocation = null
    nearPoIs = []
    adjacentPoI = []
  } // areaData

  AreaData(Location a){
    this.areaLocation = a
    this.nearPoIs = []
    adjacentPoI = []
  } // areaData

  @Override
  AreaData create(Object loc) {
    if (loc == null)
      return null
    else
      return new AreaData(loc as Location)
  } // create

  /**
   * Calculates the euclidean distance between this Location and another, obtained from
   * data held in a WorkDataInterface object
   *
   * @param workData object implementing the WorkDataInterface
   * @param p list of parameters passed from *.clic file 'work' specification,
   * parameter p[0] contains the distance measure below which this location will
   * be appended to the List nearPoIs
   */
  void distance(Object workData, List p){
    double testDistance = p[0]
    int dataMax = (workData as PoILocales).getWorkDataSize()
    for ( i in 0 ..< dataMax){
      List wd = (workData as PoILocales).getFilteredWorkData(i, null)
      Location poi = wd[1] as Location
      double distance = areaLocation.euclideanDistance(poi)
      if (distance <= testDistance) {
        poi.crowDistance = distance
        areaLocation.crowDistance = distance  // might be overwritten several times
        // but will be not null if there is a close poi
        nearPoIs << poi
      }
    }
  } // distance

  /**
   * Calculates the adjacency between this Location and another, obtained from
   * data held in a WorkDataInterface object
   *
   * @param workData object implementing the WorkDataInterface
   * @param p list of parameters passed from *.clic file 'work' specification,
   * parameter p[0] contains the distance measure below which this location will
   * be appended to the List adjacentPoIs
   */
  void adjacent(WorkDataInterface<Location> workData, List p){
    double minDistance = p[0]
    double maxDistance = p[1]
    int dataMax = workData.getWorkDataSize()
    for ( i in 0 ..< dataMax){
      List wd = (workData as PoILocales).getFilteredWorkData(i, null)
      Location poi = wd[1] as Location
      double distance = areaLocation.euclideanDistance(poi)
      if ((distance > minDistance) && (distance <= maxDistance)) {
        poi.furtherDistance = distance
        adjacentPoI << poi
      }
    }
  } // distance

  /**
   * Standard toString() method
   *
   * @return string representing this object
   */
  String toString(){
    String s = "${areaLocation} \n  near  "
    nearPoIs.each {loc ->
      s = s + "${loc}, "
    }
    s = s + " \n further  "
    adjacentPoI.each {Location loc ->
      s = s + "${loc}, "
    }
    return s
  }
}
