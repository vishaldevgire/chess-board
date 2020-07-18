package com.example.chessboard

import com.example.chessboard.pieces.Knight

fun main() {
	val chessboard = Chessboard()
	val knight = Knight()

	chessboard.place("d5", knight)

	print("Moves: ${knight.moves()}")
}
