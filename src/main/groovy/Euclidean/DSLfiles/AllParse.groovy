package Euclidean.DSLfiles

import dynamicFarm.parse.Parser

class AllParse {
  static void main(String[] args) {
    Parser parser
    parser = new Parser("./src/main/groovy/Euclidean/DSLfiles/exp1")
    assert parser.parse() :"Parsing failed"
    parser = new Parser("./src/main/groovy/Euclidean/DSLfiles/exp2")
    assert parser.parse() :"Parsing failed"
    parser = new Parser("./src/main/groovy/Euclidean/DSLfiles/exp3")
    assert parser.parse() :"Parsing failed"
    parser = new Parser("./src/main/groovy/Euclidean/DSLfiles/exp4")
    assert parser.parse() :"Parsing failed"
  }

}
