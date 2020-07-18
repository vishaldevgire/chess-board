package com.example.chessboard.pieces

import com.example.chessboard.Chessboard
import com.example.chessboard.Position
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class PawnTest {
    @Test
    fun `should return emptyList if pawn is not placed on any chessboard`() {
        val knight = Knight()

        Assertions.assertThat(knight.moves()).isEqualTo(emptyList<String>())
    }

    @Test
    fun `should return valid list of moves when a white pawn is placed on chessboard`() {
        val chessboard = mockk<Chessboard> {
            every { getPosition(any()) } returns Optional.of(Position.fromPositionCode("A1"))
        }

        val pawn = Pawn().apply {
            this.chessboard = chessboard
            this.type = PieceType.WHITE
        }

        Assertions.assertThat(pawn.moves()).isEqualTo(listOf("A2"))
    }

    @Test
    fun `should return valid list of moves when a black pawn is placed on chessboard`() {
        val chessboard = mockk<Chessboard> {
            every { getPosition(any()) } returns Optional.of(Position.fromPositionCode("B3"))
        }

        val pawn = Pawn().apply {
            this.chessboard = chessboard
            this.type = PieceType.BLACK
        }

        Assertions.assertThat(pawn.moves()).isEqualTo(listOf("B2"))
    }

    @Test
    fun `should return empty list of moves when a white pawn is placed on last row of chessboard`() {
        val chessboard = mockk<Chessboard> {
            every { getPosition(any()) } returns Optional.of(Position.fromPositionCode("H8"))
        }

        val pawn = Pawn().apply {
            this.chessboard = chessboard
            this.type = PieceType.WHITE
        }

        Assertions.assertThat(pawn.moves()).isEmpty()
    }

    @Test
    fun `should return empty list of moves when a black pawn is placed on last row of chessboard`() {
        val chessboard = mockk<Chessboard> {
            every { getPosition(any()) } returns Optional.of(Position.fromPositionCode("A1"))
        }

        val pawn = Pawn().apply {
            this.chessboard = chessboard
            this.type = PieceType.BLACK
        }

        Assertions.assertThat(pawn.moves()).isEmpty()
    }
}