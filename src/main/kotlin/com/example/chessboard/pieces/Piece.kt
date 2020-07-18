package com.example.chessboard.pieces

import com.example.chessboard.Chessboard

enum class PieceType { WHITE, BLACK }

abstract class Piece {
    public var chessboard: Chessboard? = null
    public var type: PieceType? = null

    abstract fun moves(): List<String>

    fun place(chessboard: Chessboard, pieceType: PieceType) {
        this.chessboard = chessboard
        this.type = pieceType
    }
}
