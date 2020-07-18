package com.example.chessboard.pieces

data class Position(val x: Int, val y: Int) {
    fun isValid() = x > -1 && x < 8 && y > -1 && y < 8
    fun toPositionCode(): String {
        val xChar:Int = 8 - x
        val yChar:Char = (y + 'a'.toInt()).toChar()

        return "$yChar$xChar".toUpperCase()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    companion object {
        fun fromPositionCode(position: String): Position {
            val x = 8 - position[1].toString().toInt()
            val y = position.toLowerCase()[0] - 'a'
            return Position(x, y)
        }
    }
}