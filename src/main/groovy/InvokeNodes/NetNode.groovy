package InvokeNodes

import dynamicFarm.run.WorkNode

class NetNode {
  static void main(String[] args) {
    // args[0] contains the IP address of the host node
    // args[1] contains number of worker processes
    int workers = Integer.parseInt(args[1])
    new WorkNode(args[0], workers).invoke()
  }
}
