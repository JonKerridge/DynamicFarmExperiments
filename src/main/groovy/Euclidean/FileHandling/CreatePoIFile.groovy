package Euclidean.FileHandling

import Euclidean.Locality.Location

class CreatePoIFile {
  static void main(String[] args) {
    int entries = 5000
    int range = 175
    String outFileString = "data/pois5000.loc"
    File objFile = new File(outFileString)
    if ( objFile.exists()) objFile.delete()
    ObjectOutputStream outStream = objFile.newObjectOutputStream()
    String type = "poi"
    int x, y
    Random ran = new Random()
    for ( i in 1 .. entries){
      x = ran.nextInt(range) + 1
      y = ran.nextInt(range) + 1
      Location loc = new Location(type, i, x, y)
      println "$loc"
      outStream.writeObject(loc)
    }
    outStream.flush()
    outStream.close()
  }
}
