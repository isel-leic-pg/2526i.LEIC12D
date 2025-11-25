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


var game = createGame()

fun main() {
    println("Begin")

    onStart {
        //c.showHeroSprite(2,1)
        c.drawBoard()
    }

    c.onKeyPressed {
        var newDirection = it.char.newDirection()
        var newHeroCell = game.player.position.add(newDirection)
        newDirection = if(newDirection == Direction.NONE)
                            game.player.direction
                        else
                            newDirection

        game = ChaseGame(
            Hero(newHeroCell, newDirection),
            game.robots.moveRobots(newHeroCell)
        )
        c.drawBoard()
    }

    onFinish {
        println("Finish")
    }
    println("End")
}

private fun List<Robot>.moveRobots(newHeroCell: Cell): List<Robot> {
    return this.map { robot ->
        var newRow = robot.position.row
        var newCol = robot.position.col

        if(newHeroCell.row != robot.position.row && newHeroCell.row - robot.position.row < newHeroCell.col - robot.position.col) {
            newRow += when {
                newHeroCell.row > robot.position.row -> 1
                newHeroCell.row < robot.position.row -> -1
                else -> 0
            }
        } else {
            newCol += when {
                newHeroCell.col > robot.position.col -> 1
                newHeroCell.col < robot.position.col -> -1
                else -> 0
            }
        }




        Robot(Cell(newRow, newCol))
    }

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




fun Canvas.drawBoard() {
    this.erase()
    for (i in 1..<COLS) {
        val x = i*(SQUARE_SIZE+GRID_THICKNESS)-GRID_THICKNESS
        c.drawLine(x, 0, x, CANVAS_HEIGHT , thickness = GRID_THICKNESS)
    }

    (1..<ROWS).forEach {
        val y = it * (SQUARE_SIZE + GRID_THICKNESS) - GRID_THICKNESS
        c.drawLine(0, y, CANVAS_WIDTH, y, thickness = GRID_THICKNESS)
    }
    game.player.drawHero()
    game.robots.drawRobots()

}

fun Canvas.showHeroSprite(row: Int, col: Int) {
    c.drawImage("hero.png|${col*HERO_SPRITE_WIDTH},${row* HERO_SPRITE_HEIGHT},${HERO_SPRITE_WIDTH},${HERO_SPRITE_HEIGHT}", 0, 0, 100, 100)
}

fun Hero.drawHero() {
    val x =  this.direction.spritePosition.col * HERO_SPRITE_WIDTH
    val y =  this.direction.spritePosition.row * HERO_SPRITE_HEIGHT
    c.drawImage("hero.png|$x,$y,$HERO_SPRITE_WIDTH,$HERO_SPRITE_HEIGHT", this.position.col.toGridPosition() , this.position.row.toGridPosition(), HERO_SPRITE_WIDTH, HERO_SPRITE_HEIGHT)
}


fun List<Robot>.drawRobots() {
    this.forEach {
        c.drawImage("robot.png|0,0,$ROBOT_SPRITE_SIZE,$ROBOT_SPRITE_SIZE", it.position.col.toGridPosition() , it.position.row.toGridPosition(), HERO_SPRITE_WIDTH, HERO_SPRITE_HEIGHT)
    }
}

fun Int.toGridPosition() = this * (SQUARE_SIZE + GRID_THICKNESS)

fun createGame() : ChaseGame {
    var emptyCells = (0..< ROWS*COLS).map {
        Cell(it / COLS, it % COLS)
    }
    val heroCell = emptyCells.random()
    emptyCells -= heroCell

    return ChaseGame(
        Hero(heroCell, Direction.RIGHT),
        createRobots(emptyCells)
    )
}

fun createRobots(emptyCells: List<Cell>): List<Robot> {
//    var robots = emptyList<Robot>()
//    for(i in (0..NUM_ROBOTS)) {
//        val row = (0..ROWS).random()
//        val col = (0..COLS).random()
//        robots += Robot(Cell(row, col))
//    }
//    return robots

    var internalEmptyCells = emptyCells
    return (0..<NUM_ROBOTS).map {
        val cell = emptyCells.random()
        internalEmptyCells -= cell
        Robot(cell)
    }
}


