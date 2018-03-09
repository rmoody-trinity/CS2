package cs2.particles

import cs2.util.Vec2 
import scalafx.Includes.eventClosureWrapperWithParam
import scalafx.Includes.jfxGraphicsContext2sfx
import scalafx.Includes.jfxMouseEvent2sfx
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.input.MouseEvent
import scalafx.scene.image.Image
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode


object ParticleSystemApp extends JFXApp{
  
  stage = new JFXApp.PrimaryStage {
    title = "Particles!"
    scene = new Scene(600,400) {
      val canvas = new Canvas(600,400)
      content = canvas
      
      val g = canvas.getGraphicsContext2D
      var wind = new Vec2
      
      canvas.onMouseMoved = (e:MouseEvent) => {
        wind = new Vec2((e.x-300)/300, 0)
      }
      
      var pss:List[ParticleSystem] = Nil
      
      val partImg = new Image("file:smoke.png")
        
      canvas.onMouseClicked = (e:MouseEvent) => {
        pss ::= new ImageParticleSystem(new Vec2(e.x,e.y), partImg)
      }
      
      val backg = new RainbowBackground(600,400)
      
      var prevTime:Long = 0
      val timer = AnimationTimer (t => {
        if (t-prevTime > 1e9/60) {
          prevTime = t
          backg.display(g)
          for(ps <- pss) {
            ps.display(g)
            ps.timeStep
            ps.applyForce(new Vec2(0,-0.2))
            ps.applyForce(wind)
            ps.addParticle
        }
        }
      })
      timer.start
    }
  }
  
}