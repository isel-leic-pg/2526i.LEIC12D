package isel.pg.li32d.lesson18.Chase


val COLS = 15
val ROWS = 10
val SQUARE_SIZE = 53
val GRID_THICKNESS = 1
const val HERO_IMAGE_WIDTH = 288
const val HERO_IMAGE_HEIGHT = 192
const val HERO_IMAGE_HORIZONTAL_SPRITES = 6
const val HERO_IMAGE_VERTICAL_SPRITES = 4
const val SPRITE_WIDTH = HERO_IMAGE_WIDTH/HERO_IMAGE_HORIZONTAL_SPRITES
const val SPRITE_HEIGHT = HERO_IMAGE_HEIGHT/HERO_IMAGE_VERTICAL_SPRITES

val CANVAS_WIDTH = COLS * SQUARE_SIZE + (COLS-1) * GRID_THICKNESS
val CANVAS_HEIGHT = ROWS * SQUARE_SIZE + (ROWS-1) * GRID_THICKNESS

data class ChaseGame(val player: Hero, val robots: List<Robot>)
data class Hero(val position: Cell, val direction: Direction)
data class Robot(val position: Cell)

data class Cell(val row: Int, val col: Int)
fun Cell.add( direction: Direction) : Cell {
    if(direction == Direction.NONE)
        return this
    val newLine = when(direction) {
        Direction.UP, Direction.UP_RIGHT, Direction.UP_LEFT  -> row - 1
        Direction.DOWN, Direction.DOWN_RIGHT, Direction.DOWN_LEFT -> row + 1
        else -> row
    }

    val newCol = when(direction) {
        Direction.LEFT, Direction.DOWN_LEFT, Direction.UP_LEFT  -> col - 1
        Direction.RIGHT, Direction.UP_RIGHT, Direction.DOWN_RIGHT -> col + 1
        else -> col
    }
    return Cell(newLine, newCol)
}


enum class Direction(val pos: Int) {
    DOWN(0),
    LEFT(1),
    RIGHT(2),
    UP(3),
    UP_LEFT(4),
    UP_RIGHT(5),
    DOWN_LEFT(6),
    DOWN_RIGHT(7),
    NONE(99)
}