package isel.pg.li32d.lesson14

import pt.isel.canvas.Canvas
import pt.isel.canvas.RED
import pt.isel.canvas.YELLOW
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart
import javax.swing.Spring.height

fun main() {
    println("Begin")

    onStart {
        var c = Canvas(CANVAS_WIDTH,CANVAS_HEIGHT)
        var balls = listOf<Ball>(
            Ball(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, CIRCLE_RADIUS, BALL_MOVE_DELTA,RED),
            Ball(CANVAS_WIDTH/2, CANVAS_HEIGHT/2+50, CIRCLE_RADIUS, BALL_MOVE_DELTA,RED)
        )
        
        c.onTimeProgress(REFRESH_TIME) {
            c.erase()
            var newList = emptyList<Ball>()
            for (b in balls) {
                var newBall = move(b)
                c.drawCircle(b.x, b.y, b.radius, b.color)
                newList += newBall
            }
            balls = newList
        }

        c.onMouseDown { e ->
            //balls += Ball(e.x, e.y, CIRCLE_RADIUS, BALL_MOVE_DELTA, RED)
            val clampedX = e.x.coerceIn(CIRCLE_RADIUS, CANVAS_WIDTH - CIRCLE_RADIUS)
            val clampedY = e.y.coerceIn(CIRCLE_RADIUS, CANVAS_HEIGHT - CIRCLE_RADIUS)
            balls += Ball(clampedX, clampedY, CIRCLE_RADIUS, BALL_MOVE_DELTA, RED)
            
        }

        c.onKeyPressed { k ->
            println(k)
        }
    }

    onFinish {
        println("Finish")
    }
    println("End")
}

//   Red     Green     Blue
// 00000000 11111111 00000000

//0x 00FF00
