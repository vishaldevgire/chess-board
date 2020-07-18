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
		printUsage()
		return
	}

	val pieceName = args[0]
	val position = args[1]
	var pieceType = PieceType.WHITE

	if (args.size > 2) {
		pieceType = if (args[2] == "W") PieceType.WHITE else PieceType.BLACK
	}

	if (factory[pieceName] == null) {
		println("Error: Invalid chess piece specified.")
		printUsage()
		return
	}

	val chessboard = Chessboard()
	val piece = factory[pieceName]!!.invoke()

	chessboard.place(position, piece, pieceType)

	println(piece.moves())
}

fun printUsage() {
	println("Usage: <jar> <King|Queen|Bishop|Horse|Rook|Pawn> <board_position> [W|B]")
	println("  -example: <jar> King D4")
	println("  -example: <jar> Pawn A4 B")
}

