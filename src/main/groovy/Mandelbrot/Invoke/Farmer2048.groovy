package Mandelbrot.Invoke

import Mandelbrot.ClassFiles.MandelbrotCollect
import Mandelbrot.ClassFiles.MandelbrotData
import dynamicFarm.run.Farmer

class Farmer2048 {
  static void main(String[] args) {
    String structure =  "./src/main/groovy/Mandelbrot/DSLfiles/mandelbrot2048"
    Class dataClass = MandelbrotData
    Class resultClass = MandelbrotCollect
    new Farmer( structure, dataClass, null, null,
        resultClass,"Local", false ).invoke()
  }
}
