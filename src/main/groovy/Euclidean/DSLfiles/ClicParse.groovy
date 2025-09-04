package Euclidean.DSLfiles

import dynamicFarm.parse.Parser

String inFileName = "./exp1"
Parser parser = new Parser(inFileName)
boolean result = parser.parse()
if (result) println "parsing OK"
else println "parsing FAILED!"
