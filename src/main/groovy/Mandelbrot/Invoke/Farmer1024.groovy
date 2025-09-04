package Mandelbrot.Invoke

import Mandelbrot.ClassFiles.MandelbrotCollect
import Mandelbrot.ClassFiles.MandelbrotData
import dynamicFarm.run.Farmer

class Farmer1024 {
  static void main(String[] args) {
    String structure =  "./src/main/groovy/Mandelbrot/DSLfiles/mandelbrot1024"
    Class dataClass = MandelbrotData
    Class resultClass = MandelbrotCollect
    new Farmer( structure, dataClass, null, null,
        resultClass,"Local", false ).invoke()
  }
}
