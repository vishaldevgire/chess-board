package com.example.chessboard

import com.example.chessboard.pieces.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `should create position from positionCode` () {
        val validPositions = mapOf(
                "a1" to Position(7, 0),
                "a8" to Position(0, 0),
                "h1" to Position(7, 7),
                "h8" to Position(0, 7)
        )

        validPositions.forEach {(positionCode, expectedPosition) ->
            assertThat(Position.fromPositionCode(positionCode)).isEqualTo(expectedPosition)
        }
    }

    @Test
    fun `should translate position to positionCode` () {
        val validPositions = mapOf(
                Position(7, 0) to "A1",
                Position(0, 0) to "A8",
                Position(7, 7) to "H1",
                Position(0, 7) to "H8"
         )

        validPositions.forEach {(position, expectedPositionCode) ->
            assertThat(position.toPositionCode()).isEqualTo(expectedPositionCode)
        }
    }

    @Test
    fun `isValid should return true for valid positions` () {
        val validPositions = listOf(
                Position(7, 0),
                Position(0, 0),
                Position(7, 7),
                Position(0, 7)
        )

        validPositions.forEach {position ->
            assertThat(position.isValid()).isTrue()
        }
    }

    @Test
    fun `isValid should return false for in-valid positions` () {
        val validPositions = listOf(
                Position(-7, 0),
                Position(0, -1),
                Position(-7, 17),
                Position(0, 117)
        )

        validPositions.forEach {position ->
            assertThat(position.isValid()).isFalse()
        }
    }
}