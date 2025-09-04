package Euclidean.FileHandling

class ReadSourceFile {
  static void main(String[] args) {
    String readFileString = "data/areas25000.loc"
    File objFile = new File(readFileString)
    objFile.withObjectInputStream { inStream ->
      inStream.eachObject {
        println "$it"
      }
    }
  }
}
