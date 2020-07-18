package com.example.chessboard.pieces

import com.example.chessboard.Chessboard
import com.example.chessboard.Position
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*


class RookTest {
    @Test
    fun `should return emptyList if rook is not placed on any chessboard`() {
        val rook = Rook()

        Assertions.assertThat(rook.moves()).isEqualTo(emptyList<String>())
    }

    @Test
    fun `should return valid list of moves when placed on a chessboard`() {
        val positionToExpectedMoves = mapOf<String, List<String>>(
                "a1" to listOf("A2", "B1", "A3", "C1", "A4", "D1", "A5", "E1", "A6", "F1", "A7", "G1", "A8", "H1"),
                "h1" to listOf("H2", "B1", "H3", "C1", "H4", "D1", "H5", "E1", "H6", "F1", "H7", "G1", "H8", "A1"),
                "a8" to listOf("A2", "B8", "A3", "C8", "A4", "D8", "A5", "E8", "A6", "F8", "A7", "G8", "A1", "H8"),
                "h8" to listOf("G8", "F8", "E8", "D8", "C8", "B8", "A8", "H7", "H6", "H5", "H4", "H3", "H2", "H1"),
                "d5" to listOf("D6", "D7", "D8", "D4", "D3", "D2", "D1", "A5", "B5", "C5", "E5", "F5", "G5", "H5"),
                "e4" to listOf("A4", "B4", "C4", "D4", "F4", "G4", "H4", "E1", "E2", "E3", "E5", "E6", "E7", "E8")
        )

        val chessboard = mockk<Chessboard>()

        val rook = Rook().apply {
            this.chessboard = chessboard
        }

        positionToExpectedMoves.forEach { (position, expectedMoves) ->
            every { chessboard.getPosition(any()) } returns Optional.of(Position.fromPositionCode(position))
            Assertions.assertThat(rook.moves()).containsExactlyInAnyOrderElementsOf(expectedMoves)
        }
    }
}