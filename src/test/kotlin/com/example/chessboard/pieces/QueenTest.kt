package com.example.chessboard.pieces

import com.example.chessboard.Chessboard
import com.example.chessboard.Position
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class QueenTest {

    @Test
    fun `should return emptyList if queen is not placed on any chessboard`() {
        val queen = Queen()

        Assertions.assertThat(queen.moves()).isEqualTo(emptyList<String>())
    }

    @Test
    fun `should return valid list of moves when placed on a chessboard`() {
        val positionToExpectedMoves = mapOf<String, List<String>>(
                "a1" to listOf( "B1", "C1", "D1", "E1", "F1", "G1", "H1",
                                "A2", "A3", "A4", "A5", "A6", "A7", "A8",
                                "B2", "C3", "D4", "E5", "F6", "G7", "H8"),

                "a8" to listOf( "A1", "A2", "A3", "A4", "A5", "A6", "A7",
                                "B8", "C8", "D8", "E8", "F8", "G8", "H8",
                                "B7", "C6", "D5", "E4", "F3", "G2", "H1"),

                "h1" to listOf( "B1", "C1", "D1", "E1", "F1", "G1", "A1",
                                "H2", "H3", "H4", "H5", "H6", "H7", "H8",
                                "G2", "F3", "E4", "D5", "C6", "B7", "A8"),

                "h8" to listOf( "H1", "H2", "H3", "H4", "H5", "H6", "H7",
                                "B8", "C8", "D8", "E8", "F8", "G8", "A8",
                                "G7", "F6", "E5", "D4", "C3", "B2", "A1"),

                "D4" to listOf( "A4", "B4", "C4", "E4", "F4", "G4", "H4",
                                "D1", "D2", "D3", "D5", "D6", "D7", "D8",
                                "A7", "B6", "C5", "E3", "F2", "G1",
                                "A1", "B2", "C3", "E5", "F6", "G7", "H8"),

                "E5" to listOf( "E4", "E3", "E2", "E1", "E6", "E7", "E8",
                                "A5", "B5", "C5", "D5", "F5", "G5", "H5",
                                "B8", "C7", "D6", "F4", "G3", "H2",
                                "A1", "B2", "C3", "D4", "F6", "G7", "H8")
        )

        val chessboard = mockk<Chessboard>()
        val queen = Queen().apply {
            this.chessboard = chessboard
        }

        positionToExpectedMoves.forEach { (position, expectedMoves) ->
            every { chessboard.getPosition(any()) } returns Optional.of(Position.fromPositionCode(position))
            Assertions.assertThat(queen.moves()).containsExactlyInAnyOrderElementsOf(expectedMoves)
        }
    }
}