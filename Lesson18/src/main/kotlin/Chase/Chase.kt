package isel.pg.li32d.lesson18.Chase

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


val c = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT)

var game = ChaseGame(
    Hero(Cell(2, 2), Direction.DOWN),
    emptyList<Robot>()
)

fun main() {
    println("Begin")

    onStart {
        //c.showHeroSprite(2,1)
        c.drawBoard()
    }

    c.onKeyPressed {


        var newDirection = it.char.newDirection()

        var newCell = game.player.position.add(newDirection)
        newDirection = if(newDirection == Direction.NONE)
                            game.player.direction
                        else
                            newDirection

        game = ChaseGame(
            Hero(newCell, newDirection),
            game.robots
        )
        c.drawBoard()
    }

    onFinish {
        println("Finish")
    }
    println("End")
}

private fun Char.newDirection() : Direction {
    return when(this) {
        'w' -> Direction.UP
        'x' -> Direction.DOWN
        'a' -> Direction.LEFT
        'd' -> Direction.RIGHT
        'e' -> Direction.UP_RIGHT
        'q' -> Direction.UP_LEFT
        'z' -> Direction.DOWN_LEFT
        'c' -> Direction.DOWN_RIGHT
        else -> Direction.NONE
    }

}


fun Canvas.showHeroSprite(row: Int, col: Int) {
    c.drawImage("hero.png|${col*SPRITE_WIDTH},${row* SPRITE_HEIGHT},${SPRITE_WIDTH},${SPRITE_HEIGHT}", 0, 0, 100, 100)
}


fun Canvas.drawBoard() {
    this.erase()
    for (i in 1..<COLS) {
        val x = i*(SQUARE_SIZE+GRID_THICKNESS)-GRID_THICKNESS
        c.drawLine(x, 0, x, CANVAS_HEIGHT , thickness = GRID_THICKNESS)
    }

    (1..<ROWS).forEach {
        val y = it*(SQUARE_SIZE+GRID_THICKNESS)-GRID_THICKNESS
        c.drawLine(0, y, CANVAS_WIDTH, y , thickness = GRID_THICKNESS)
    }
    game.player.drawHero()

}

fun Hero.drawHero() {
    val x = SPRITE_WIDTH
    val y = direction.pos%4*SPRITE_HEIGHT
    c.drawImage("hero.png|$x,$y,$SPRITE_WIDTH,$SPRITE_HEIGHT", this.position.col.toGridPosition() , this.position.row.toGridPosition(), SPRITE_WIDTH, SPRITE_HEIGHT)
}

fun Int.toGridPosition() = this * (SQUARE_SIZE + GRID_THICKNESS)
