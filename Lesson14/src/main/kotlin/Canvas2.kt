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
        var b = Ball(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, CIRCLE_RADIUS, BALL_MOVE_DELTA,RED)
        c.drawCircle(b.x, b.y, b.radius, b.color)

        c.onTimeProgress(REFRESH_TIME) {
            b = move(b)
            c.erase()
            c.drawCircle(b.x, b.y, b.radius, b.color)
        }

        c.onMouseDown { e ->
            b = Ball(e.x, e.y, b.radius, b.direction, b.color)
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
