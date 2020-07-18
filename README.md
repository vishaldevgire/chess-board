###Chess board console app

This console application accepts two strings as command line parameters representing a chess piece and its position on an empty chessboard, e.g. `King D4`
and returns possible next moves for that piece.

Example:
```
Input: King D4
Output: [E3, C3, E5, C5, D3, D5, C4, E4]
```

Usage: 
```
Usage: <jar> <King|Queen|Bishop|Horse|Rook|Pawn> <board_position>
  -example: <jar> King D4
```

####Libraries used for testing:
1. AssertJ
2. Mockk
