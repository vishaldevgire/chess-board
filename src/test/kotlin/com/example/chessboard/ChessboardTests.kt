package com.example.chessboard

import com.example.chessboard.pieces.Knight
import com.example.chessboard.pieces.PieceType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*


class ChessboardTests {

    @Test
    fun `should place a piece on given position`() {
        val chessboard = Chessboard()
        val piece = Knight()
        val expectedPosition = Optional.of(Position.fromPositionCode("d5"))

        chessboard.place("d5", piece, PieceType.WHITE)

        assertThat(chessboard.getPosition(piece)).isEqualTo(expectedPosition)
    }
}
