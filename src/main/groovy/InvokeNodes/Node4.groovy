package InvokeNodes

import dynamicFarm.run.WorkNode

class Node4 {
  static void main(String[] args) {
    new WorkNode("127.0.0.1", 4, "127.0.0.4", false).invoke()
  }
}
