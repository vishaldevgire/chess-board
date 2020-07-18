package com.example.chessboard.pieces

data class Position(val row: Int, val col: Int) {
    fun isValid() = row > -1 && row < 8 && col > -1 && col < 8

    fun toPositionCode(): String {
        val rowChar:Int = 8 - row
        val colDigit:Char = (col + 'a'.toInt()).toChar()

        return "$colDigit$rowChar".toUpperCase()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (row != other.row) return false
        if (col != other.col) return false

        return true
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + col
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