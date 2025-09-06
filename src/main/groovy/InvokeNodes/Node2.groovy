package InvokeNodes

import dynamicFarm.run.WorkNode

class Node2 {
  static void main(String[] args) {
    new WorkNode("127.0.0.1", 4, "127.0.0.2", false).invoke()
  }
}
