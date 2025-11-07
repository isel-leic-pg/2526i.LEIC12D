package isel.pg.li32d.lesson14.Chase


val COLS = 3
val ROWS = 3
val SQUARE_SIZE = 50
val GRID_THICKNESS = 10

val CANVAS_WIDTH = COLS * SQUARE_SIZE + (COLS-1) * GRID_THICKNESS
val CANVAS_HEIGHT = ROWS * SQUARE_SIZE + (ROWS-1) * GRID_THICKNESS

data class ChaseGame(val player: Player, val robots: List<Robot>)
data class Player(val position: Cell)
data class Robot(val position: Cell)

data class Cell(val row: Int, val col: Int)