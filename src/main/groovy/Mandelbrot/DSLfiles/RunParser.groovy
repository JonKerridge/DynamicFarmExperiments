package Mandelbrot.DSLfiles

import dynamicFarm.parse.Parser

class RunParser {
  static void main(String[] args) {
    String workingDirectory = System.getProperty("user.dir")
    Parser parser = new Parser("$workingDirectory/src/main/groovy/Mandelbrot/DSLfiles/mandelbrot4096")
    assert parser.parse() :"Parsing failed"
  }

}
