package cs2.particles

import scalafx.scene.canvas.GraphicsContext

class RainbowBackground(private var w:Int, private var h:Int) extends ColorRotation {
  
  def display(g:GraphicsContext) {
    g.setFill(stepColor)
    g.fillRect(0,0, w,h)
  }
  
}