package com.example.chessboard.pieces

class Queen : Piece() {
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

            moves.add(Position(position.row + inc, position.col))
            moves.add(Position(position.row - inc, position.col))
            moves.add(Position(position.row, position.col - inc))
            moves.add(Position(position.row, position.col + inc))
        }

        return moves.filter { it.isValid() }.map { it.toPositionCode() }
    }
}