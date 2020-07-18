package com.example.chessboard.pieces

import com.example.chessboard.Chessboard

abstract class Piece {
    public var chessboard: Chessboard? = null
    abstract fun moves(): List<String>
}
