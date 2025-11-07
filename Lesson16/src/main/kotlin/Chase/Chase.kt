package isel.pg.li32d.lesson14.Chase

// The goal is to implement the Chase Game.
// The chase is a grid game that has 2 kind of actors:
// The player and the
// robots. The robot only moves when the player moves.
// The robots win if one of the robots is in the same cell
// the player is. When two robots are in the same cell,
// they both disappear.


import pt.isel.canvas.Canvas
import pt.isel.canvas.onFinish
import pt.isel.canvas.onStart


fun main() {
    println("Begin")

    onStart {
        drawBoard()
    }

    onFinish {
        println("Finish")
    }
    println("End")
}


fun drawBoard() {
    val c = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT)


    for (i in 1..<COLS) {
        var x = i*(SQUARE_SIZE)+(i-1)*GRID_THICKNESS
        c.drawLine(x, 0, x, CANVAS_HEIGHT , thickness = GRID_THICKNESS)
    }

    (1..<ROWS).forEach {
        var y = it*(SQUARE_SIZE)+(it-1)*GRID_THICKNESS
        c.drawLine(0, y, CANVAS_WIDTH, y , thickness = GRID_THICKNESS)
    }

}
