package Euclidean.Locality

import dynamicFarm.records.WorkDataInterface

/**
 * Object used to hold data accessed by Worker processes using the WorkDataInterface
 */
class PoILocales implements WorkDataInterface<Location> {

  List <Location> pois
  int nPoi

  /**
   * Constructor that uses the data file name provided in a 'work' specification in
   * the *.clic file
   * @param fileName containing the data that forms the work data comprising a stream of Locations.
   * The data is loaded into the list pois and nPoi is initialised with the number of
   * such Locations.
   */
  PoILocales(String fileName){
    pois = []
    File objFile = new File("./$fileName")
    objFile.withObjectInputStream { inStream ->
      inStream.eachObject {
        pois << it
      }
    }
    nPoi = pois.size()
  }

  /**
   * Gets the next data item from the List pois
   *
   * @param index assumed to be a valid subscript in pois
   * @param p a list of filter values, not needed in this case
   * @return a list comprising  [index+1, value at location index]
   */
  @Override
  List getFilteredWorkData(int index, List p) {
    // assume index is valid!!
    return [index+1, pois[index]]
  }

  /**
   * Gets the size of pois
   *
   * @return the number of Locations in pois
   */
  @Override
  int getWorkDataSize() {
    return nPoi
  }
}

