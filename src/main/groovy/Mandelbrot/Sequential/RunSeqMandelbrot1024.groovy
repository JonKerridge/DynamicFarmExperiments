package Mandelbrot.Sequential

import Mandelbrot.ClassFiles.MandelbrotCollect
import Mandelbrot.ClassFiles.MandelbrotData


int maxIterations, widthPoints
long startTime, endTime
widthPoints = 1024
maxIterations = 2048


startTime = System.currentTimeMillis()
MandelbrotData mandelbrotBase = new MandelbrotData([widthPoints, maxIterations])
MandelbrotCollect mandelbrotCollect = new MandelbrotCollect()

MandelbrotData mandelbrotInstance
mandelbrotInstance = mandelbrotBase.create()
while (mandelbrotInstance != null){
  mandelbrotInstance.calculateColour(null, null)
  mandelbrotCollect.collate(mandelbrotInstance, [])
  mandelbrotInstance = mandelbrotBase.create()
}
mandelbrotCollect.finalise([])
endTime = System.currentTimeMillis()
println "Elapsed time = ${endTime-startTime} milliseconds"
