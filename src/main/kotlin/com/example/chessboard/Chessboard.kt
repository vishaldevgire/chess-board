package com.example.chessboard

import com.example.chessboard.pieces.Piece
import java.util.*

class Chessboard {
    private val pieces: Array<Array<Piece?>> = Array(8) { Array<Piece?>(8) { null } }

    fun place(position: String, piece: Piece) {
        val (row, col) = Position.fromPositionCode(position)
        piece.chessboard = this
        pieces[row][col] = piece
    }

    fun getPosition(piece: Piece): Optional<Position> {
        (0 until 8).forEach { row ->
            (0 until 8).forEach { col ->
                if (pieces[row][col] == piece) {
                    return Optional.of(Position(row, col))
                }
            }
        }
        return Optional.empty<Position>()
    }
}