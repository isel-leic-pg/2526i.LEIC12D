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
import kotlin.math.max
import kotlin.math.min


val c = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT)
var p = Hero(Cell(2, 2), Directions.DOWN)

fun main() {
    println("Begin")

    onStart {
        //c.showHeroSprite(2,1)
        c.drawBoard()
    }

    c.onKeyPressed {
        val cell =  when(it.char) {
            'w' -> Pair(Cell(max(p.position.row - 1, 0), p.position.col), Directions.UP)
            'x' -> Pair(Cell(min(p.position.row + 1, ROWS-1), p.position.col), Directions.DOWN)
            'a' -> Pair(Cell(p.position.row, max(p.position.col - 1, 0)), Directions.LEFT)
            'd' -> Pair(Cell(p.position.row, min(p.position.col + 1, COLS-1)), Directions.RIGHT)
            else -> Pair(p.position, p.direction)
        }
        p = Hero(cell.first, cell.second)
        c.drawBoard()
    }

    onFinish {
        println("Finish")
    }
    println("End")
}


fun Canvas.showHeroSprite(row: Int, col: Int) {
    c.drawImage("hero.png|${col*SPRITE_WIDTH},${row* SPRITE_HEIGHT},${SPRITE_WIDTH},${SPRITE_HEIGHT}", 0, 0, 100, 100)
}


fun Canvas.drawBoard() {
    this.erase()
    for (i in 1..<COLS) {
        var x = i*(SQUARE_SIZE+GRID_THICKNESS)-GRID_THICKNESS
        c.drawLine(x, 0, x, CANVAS_HEIGHT , thickness = GRID_THICKNESS)
    }

    (1..<ROWS).forEach {
        var y = it*(SQUARE_SIZE+GRID_THICKNESS)-GRID_THICKNESS
        c.drawLine(0, y, CANVAS_WIDTH, y , thickness = GRID_THICKNESS)
    }
    p.drawHero()

}

fun Hero.drawHero() {
    c.drawImage("hero.png|$SPRITE_WIDTH,${direction.direction*SPRITE_HEIGHT},$SPRITE_WIDTH,$SPRITE_HEIGHT", this.position.col.toGridPosition() , this.position.row.toGridPosition(), SPRITE_WIDTH, SPRITE_HEIGHT)
}

fun Int.toGridPosition() = this * (SQUARE_SIZE + GRID_THICKNESS)
