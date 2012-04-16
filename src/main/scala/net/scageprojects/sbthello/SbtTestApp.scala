package net.scageprojects.sbthello

import net.scage.ScageLib._
import net.scage.support.Vec
import net.scage.ScageScreenApp

/**
 * Hello world!
 *
 */
object SbtTestApp extends ScageScreenApp("SBT Test App", 640, 480) {
  private var ang = 0f
  action {
    ang += 1
  }

  backgroundColor = WHITE
  render {
    openglMove(windowCenter)
    openglRotate(ang)
    print("Hello World", Vec.zero - Vec(50,0), BLACK)
  }
}
