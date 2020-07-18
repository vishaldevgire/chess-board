This console application accepts three strings as command line parameters representing 
1. a chess piece 
2. its position on an empty chessboard
3. optionally, type of piece (White or Black), assumed white if not specified

and returns possible next moves for that piece.

Example:
```
Input: King D4
Output: [E3, C3, E5, C5, D3, D5, C4, E4]

Input: Pawn A4 B
Output: [A3]
```

Usage: 
```
Usage: <jar> <King|Queen|Bishop|Horse|Rook|Pawn> <board_position> [W|B]
  -example: <jar> King D4
  -example: <jar> Pawn A4 B
```

#### Libraries used for testing:
1. AssertJ
2. Mockk
