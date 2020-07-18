package com.example.chessboard.pieces

import com.example.chessboard.Chessboard
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class KnightTest {

    @Test
    fun `should return emptyList if the knight is not places on any chessboard`() {
        val knight = Knight()

        assertThat(knight.moves()).isEqualTo(emptyList<String>())
    }

    @Test
    fun `should return valid list of moves when placed on a chessboard`() {
        val positionToExpectedMoves = mapOf<String, List<String>>(
                "d5" to listOf("E3", "C3", "F6", "F4", "B6", "B4", "E7", "C7"),
                "a1" to listOf("C2", "B3"),
                "h1" to listOf("F2", "G3"),
                "a8" to listOf("B6", "C7"),
                "h8" to listOf("G6", "F7")
        )

        positionToExpectedMoves.forEach { position, expectedMoves ->
            val chessboard = mockk<Chessboard> {
                every { getPosition(any()) } returns Optional.of(Position.fromPositionCode(position))
            }

            val knight = Knight().apply {
                this.chessboard = chessboard
            }

            assertThat(knight.moves()).isEqualTo(expectedMoves)
        }
    }
}