package com.example.chessboard.pieces

import com.example.chessboard.Chessboard
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class KingTest {
    @Test
    fun `should return emptyList if king is not placed on any chessboard`() {
        val king = King()

        assertThat(king.moves()).isEqualTo(emptyList<String>())
    }

    @Test
    fun `should return valid list of moves when placed on a chessboard`() {
        val positionToExpectedMoves = mapOf<String, List<String>>(
                "a1" to listOf("A2", "B2", "B1"),
                "h1" to listOf("H2", "G2", "G1"),
                "a8" to listOf("A7", "B7", "B8"),
                "h8" to listOf("H7", "G7", "G8"),
                "d4" to listOf("C5", "D5", "E5", "E4", "E3", "D3", "C3", "C4"),
                "e5" to listOf("D6", "E6", "F6", "D4", "E4", "F4", "D5", "F5")
        )

        val chessboard = mockk<Chessboard>()
        val king = King().apply {
            this.chessboard = chessboard
        }

        positionToExpectedMoves.forEach { (position, expectedMoves) ->
            every { chessboard.getPosition(any()) } returns Optional.of(Position.fromPositionCode(position))
            assertThat(king.moves()).containsExactlyInAnyOrderElementsOf(expectedMoves)
        }
    }
}