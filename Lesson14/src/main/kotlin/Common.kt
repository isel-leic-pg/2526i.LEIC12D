package isel.pg.li32d.lesson14

import pt.isel.canvas.BLACK

val CANVAS_WIDTH = 300
val CANVAS_HEIGHT = 200
val CIRCLE_RADIUS = 20
val MARGIN = 5
val REFRESH_TIME = 100
val BALL_MOVE_DELTA = 10

data class Ball(val x: Int, val y: Int, val radius: Int, val direction: Int, val color: Int = BLACK)


fun move(ball: Ball): Ball {
    val newDirection = if(ball.x + ball.radius > CANVAS_WIDTH || ball.x - ball.radius < 0) -ball.direction else ball.direction

    return Ball(ball.x + newDirection, ball.y, ball.radius, newDirection,  ball.color)
}