package com.example.chessboard.pieces

import com.example.chessboard.Position

class Pawn : Piece() {
    override fun moves(): List<String> {
        if (chessboard == null) {
            return emptyList()
        }

        val position = chessboard!!.getPosition(this).get()
        val moves = mutableListOf<Position>()

        if (this.type == PieceType.WHITE) {
            moves.add(Position(position.row - 1, position.col))
        } else {
            moves.add(Position(position.row + 1, position.col))
        }

        return moves.filter { it.isValid() }.map { it.toPositionCode() }
    }
}