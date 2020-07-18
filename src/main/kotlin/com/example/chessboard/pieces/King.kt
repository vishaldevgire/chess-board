package com.example.chessboard.pieces

class King : Piece() {
    override fun moves(): List<String> {
        if (chessboard == null) {
            return emptyList()
        }

        val position = chessboard!!.getPosition(this).get()
        val moves = mutableListOf<Position>()

        moves.add(Position(position.row + 1, position.col + 1))
        moves.add(Position(position.row + 1, position.col - 1))
        moves.add(Position(position.row - 1, position.col + 1))
        moves.add(Position(position.row - 1, position.col - 1))

        moves.add(Position(position.row + 1, position.col))
        moves.add(Position(position.row - 1, position.col))
        moves.add(Position(position.row, position.col - 1))
        moves.add(Position(position.row, position.col + 1))

        return moves.filter { it.isValid() }.map { it.toPositionCode() }
    }
}