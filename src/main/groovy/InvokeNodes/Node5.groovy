package InvokeNodes

import dynamicFarm.run.WorkNode

class Node5 {
  static void main(String[] args) {
    new WorkNode("127.0.0.1", 4, "127.0.0.5", false).invoke()
  }
}
