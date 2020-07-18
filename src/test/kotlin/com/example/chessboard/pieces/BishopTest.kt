package com.example.chessboard.pieces

import com.example.chessboard.Chessboard
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class BishopTest {
    @Test
    fun `should return emptyList if bishop is not placed on any chessboard`() {
        val bishop = Bishop()

        assertThat(bishop.moves()).isEqualTo(emptyList<String>())
    }

    @Test
    fun `should return valid list of moves when placed on a chessboard`() {
        val positionToExpectedMoves = mapOf<String, List<String>>(
                "a6" to listOf("B5", "B7", "C4", "C8", "D3", "E2", "F1"),
                "c4" to listOf("D3", "E2", "F1", "B3", "A2", "D5", "E6", "F7", "G8", "B5", "A6"),
                "h8" to listOf("G7", "F6", "E5", "D4", "C3", "B2", "A1"),
                "a1" to listOf("G7", "F6", "E5", "D4", "C3", "B2", "H8"),
                "a8" to listOf("B7", "C6", "D5", "E4", "F3", "G2", "H1"),
                "h1" to listOf("B7", "C6", "D5", "E4", "F3", "G2", "A8"),
                "h4" to listOf("G3", "F2", "E1", "G5", "F6", "E7", "D8")
        )

        positionToExpectedMoves.forEach { position, expectedMoves ->
            val chessboard = mockk<Chessboard> {
                every { getPosition(any()) } returns Optional.of(Position.fromPositionCode(position))
            }

            val bishop = Bishop().apply {
                this.chessboard = chessboard
            }

            assertThat(bishop.moves()).containsExactlyInAnyOrderElementsOf(expectedMoves)
        }
    }
}