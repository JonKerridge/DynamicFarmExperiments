package Euclidean.Locality

import dynamicFarm.records.SourceDataInterface

/**
 * Used to define data accessible to Emitter processes using the SourceDataInterface
 */
class AreaLocales implements SourceDataInterface<Location> {

  List <Location> areas
  int nAreas, current

/**
 *  Populates the area list with Location data from the file of such objects
 *  initialises  nAreas to the number of such Location objects and current to zero
 *
 * @param fileName the name of the file holding the source data objects obtained from the -f option
 * on the 'emit' specification in the *.clic file
 */
  AreaLocales (String fileName){
    areas = []
    File objFile = new File("./$fileName")
    objFile.withObjectInputStream { inStream ->
      inStream.eachObject {
        areas << it
      }
    }
    nAreas = areas.size()
    current = 0
  }
/**
 *
 * @return the next object from the source data or null if no more data remains
 */
  @Override
  Location getSourceData() {
    if (current < nAreas){
      Location r = areas[current]
      current = current + 1
      return r
    }
    else
      return null
  }

}

