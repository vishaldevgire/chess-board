package com.example.chessboard

import com.example.chessboard.pieces.*

fun main(args: Array<String>) {
    val factory = mapOf<String, () -> Piece>(
            "King"   to { King() },
            "Horse"  to { Knight() },
            "Pawn"   to { Pawn() },
            "Queen"  to { Queen() },
            "Bishop" to { Bishop() },
            "Rook"   to { Rook() }
    )

	if (args.size < 2) {
		println("Usage: <jar> <King|Queen|Bishop|Horse|Rook|Pawn> <board_position>")
		println("  -example: <jar> King D4")
		return
	}

	val pieceName = args[0]
	val position = args[1]

	if (factory[pieceName] == null) {
		println("Error: Invalid chess piece specified.")
		println("Usage: <jar> <King|Queen|Bishop|Horse|Rook|Pawn> <board_position>")
		println("  -example: <jar> King D4")
		return
	}

	val chessboard = Chessboard()
	val piece = factory[pieceName]!!.invoke()

	chessboard.place(position, piece)

	println(piece.moves())
}

