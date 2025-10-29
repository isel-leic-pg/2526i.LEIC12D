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
        c.drawCircle(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, CIRCLE_RADIUS, RED)
        c.drawRect(CANVAS_WIDTH/2-CIRCLE_RADIUS-MARGIN, CANVAS_HEIGHT/2-CIRCLE_RADIUS-MARGIN, (CIRCLE_RADIUS+MARGIN)*2, (CIRCLE_RADIUS+MARGIN)*2, RED, 2)
        c.drawLine(0,0, CANVAS_WIDTH-1, CANVAS_HEIGHT-1)
        c.drawLine(0,CANVAS_HEIGHT-1, CANVAS_WIDTH-1, 0)
        c.drawText(CANVAS_WIDTH/2-25, CANVAS_HEIGHT/3/2, "PG", RED, 40)
        c.drawImage("slb-logo.png", CANVAS_WIDTH/2-25, CANVAS_HEIGHT-CANVAS_HEIGHT/3, 75, 75)
    }

    onFinish {
        println("Finish")
    }
    println("End")
}

//   Red     Green     Blue
// 00000000 11111111 00000000

//0x 00FF00
