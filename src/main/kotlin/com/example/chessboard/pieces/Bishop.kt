package com.example.chessboard.pieces

import com.example.chessboard.Position

class Bishop : Piece() {
    override fun moves(): List<String> {
        if (chessboard == null) {
            return emptyList()
        }

        val position = chessboard!!.getPosition(this).get()
        val moves = mutableListOf<Position>()

        (1 until 8).forEach { inc ->
            moves.add(Position(position.row + inc, position.col + inc))
            moves.add(Position(position.row + inc, position.col - inc))
            moves.add(Position(position.row - inc, position.col + inc))
            moves.add(Position(position.row - inc, position.col - inc))
        }

        return moves.filter { it.isValid() }.map { it.toPositionCode() }
    }
}