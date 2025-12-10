package isel.pg.li32d.lesson22.Chase


const val COLS = 5
const val ROWS = 5
const val SQUARE_SIZE = 53
const val GRID_THICKNESS = 1
const val HERO_IMAGE_WIDTH = 288
const val HERO_IMAGE_HEIGHT = 192
const val HERO_IMAGE_HORIZONTAL_SPRITES = 6
const val HERO_IMAGE_VERTICAL_SPRITES = 4
const val HERO_SPRITE_WIDTH = HERO_IMAGE_WIDTH/HERO_IMAGE_HORIZONTAL_SPRITES
const val HERO_SPRITE_HEIGHT = HERO_IMAGE_HEIGHT/HERO_IMAGE_VERTICAL_SPRITES
const val NUM_ROBOTS = 4
const val ROBOT_SPRITE_SIZE = 64
const val FONT_SIZE = SQUARE_SIZE/2

const val CANVAS_WIDTH = COLS * SQUARE_SIZE + (COLS-1) * GRID_THICKNESS
const val CANVAS_HEIGHT = ROWS * SQUARE_SIZE + (ROWS-1) * GRID_THICKNESS

data class ChaseGame(val player: Hero, val robots: List<Robot>, val garbage: List<Garbage>, val state: GameState = GameState.ONGOING)

data class Hero(val position: Cell, val direction: Direction)

data class Garbage(val position: Cell)

fun List<Garbage>.detectCollisions(robots: List<Robot>): List<Garbage> {
//    val robotCells = robots.map { robot -> robot.position }
//    val garbageCells = this.map { garbage -> garbage.position }
//    val cells = robotCells + garbageCells
    val robotCells: List<Cell> = robots.map { it.position }
    val garbageCells: List<Cell> = this.map { it.position }

    var repeatedRobotCells: List<Cell> = robotCells.groupBy { it }
                                         .filter { it.value.size > 1 }
                                         .map { it.key }
    var newGarbageCells = (repeatedRobotCells + garbageCells).toSet().toList()
    return newGarbageCells.map { Garbage(it) }
}



fun List<Robot>.removeRobotsWithCollisions(garbage: List<Garbage>) : List<Robot> {
    var robots: List<Cell> = (this.map { it.position } - garbage.map { it.position })
    println("robots without garbage ${robots}")
    return robots.toSet().toList().map { Robot(it) }
 }


data class Robot(val position: Cell)

data class Cell(val row: Int, val col: Int)

fun Cell.add( direction: Direction) : Cell {
    var newLine = when(direction) {
        Direction.UP, Direction.UP_RIGHT, Direction.UP_LEFT  -> row - 1
        Direction.DOWN, Direction.DOWN_RIGHT, Direction.DOWN_LEFT -> row + 1
        else -> row
    }
    newLine = newLine.coerceIn(0, ROWS-1)

    var newCol = when(direction) {
        Direction.LEFT, Direction.DOWN_LEFT, Direction.UP_LEFT  -> col - 1
        Direction.RIGHT, Direction.UP_RIGHT, Direction.DOWN_RIGHT -> col + 1
        else -> col
    }
    newCol = newCol.coerceIn(0, COLS-1)
    return Cell(newLine, newCol)
}

enum class Direction(val spritePosition: Cell) {
    DOWN(Cell(0, 1)),
    LEFT(Cell(1, 1)),
    RIGHT(Cell(2, 1)),
    UP(Cell(3, 1)),
    UP_LEFT(Cell(1,3)),
    UP_RIGHT(Cell(3, 5)),
    DOWN_LEFT(Cell(0,3)),
    DOWN_RIGHT(Cell(2, 4)),
}


enum class GameState {
    ONGOING,
    WON,
    LOST
}


