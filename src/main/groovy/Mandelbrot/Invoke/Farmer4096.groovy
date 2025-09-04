package Mandelbrot.Invoke

import Mandelbrot.ClassFiles.MandelbrotCollect
import Mandelbrot.ClassFiles.MandelbrotData
import dynamicFarm.run.Farmer

class Farmer4096 {
  static void main(String[] args) {
    String structure =  "./src/main/groovy/Mandelbrot/DSLfiles/mandelbrot4096"
    Class dataClass = MandelbrotData
    Class resultClass = MandelbrotCollect
    new Farmer( structure, dataClass, null, null,
        resultClass,"Local", false ).invoke()
  }
}
