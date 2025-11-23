package isel.pg.li32d.lesson14.Chase


val COLS = 3
val ROWS = 3
val SQUARE_SIZE = 53
val GRID_THICKNESS = 10
const val HERO_IMAGE_WIDTH = 288
const val HERO_IMAGE_HEIGHT = 192
const val HERO_IMAGE_HORIZONTAL_SPRITES = 6
const val HERO_IMAGE_VERTICAL_SPRITES = 4
const val SPRITE_WIDTH = HERO_IMAGE_WIDTH/HERO_IMAGE_HORIZONTAL_SPRITES
const val SPRITE_HEIGHT = HERO_IMAGE_HEIGHT/HERO_IMAGE_VERTICAL_SPRITES



val CANVAS_WIDTH = COLS * SQUARE_SIZE + (COLS-1) * GRID_THICKNESS
val CANVAS_HEIGHT = ROWS * SQUARE_SIZE + (ROWS-1) * GRID_THICKNESS

data class ChaseGame(val player: Hero, val robots: List<Robot>)
data class Hero(val position: Cell, val direction: Directions)
data class Robot(val position: Cell)

data class Cell(val row: Int, val col: Int)

enum class Directions(val direction: Int) {
    DOWN(0), LEFT(1), RIGHT(2), UP(3)
}