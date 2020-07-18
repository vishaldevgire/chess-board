package com.example.chessboard.pieces

class Pawn : Piece() {
    override fun moves(): List<String> {
        if (chessboard == null) {
            return emptyList()
        }

        val position = chessboard!!.getPosition(this).get()
        val moves = mutableListOf<Position>()

        moves.add(Position(position.row - 1, position.col))

        return moves.filter { it.isValid() }.map { it.toPositionCode() }
    }
}