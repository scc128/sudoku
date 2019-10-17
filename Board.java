import java.util.*;
public class Board{
	public int knownPiecesNum; // is the number of correct pieces that are known.
	public boolean solved = false; // false if not solved true when knownPiecesNum is set to 81
	public void solve(int [][] input){
		int [][] inBoard = input;
		boolean placedPiece = false;
		// loop through the board in order until find a piece that is not placed.
		// if the piece is known what it is then place it if not move to the next piece 
		for(int i = 0 ; i < 9 ; i++){
			for(int j = 0 ; j < 9 ; j++){
				System.out.print(inBoard[i][j]+" ");
			}
			System.out.println();
		}
		// start loop
		do{
			placedPiece = false;

			for(int row = 0 ; row < 9 ; row++){
				for(int col = 0 ; col < 9 ; col++){
					if(inBoard[row][col] != 0){
						placedPiece = true;
					}else{
						ArrayList<Integer> knownFalse = new ArrayList<Integer>(9);
						//find the columns 
						knownFalse = addColumn(row , col , knownFalse , inBoard);
						//find the rows 
						knownFalse = addRow(row , col , knownFalse , inBoard);
						//find the box
						knownFalse = addBox(row , col , knownFalse , inBoard);
						//check if correct piece or known false == 8 
						System.out.println( + row + " "+ col + " " + knownFalse.toString());
						if(knownFalse.size() == 8){
							System.out.println("found a piece placeing piece " + row + " "+ col + knownFalse.toString() );
							for(int i =1 ; i < 9 ; i++){
								if(knownFalse.contains(i)){

								}else{
									// place the number
									inBoard[row][col] = i;
									placedPiece = true;
									break;
								}
							}
						}
					}
				}
			}
			if(countPieces(inBoard) != knownPiecesNum){
				knownPiecesNum = countPieces(inBoard);
			}else{
				break;
			}
		}while(placedPiece);
		for(int i = 0 ; i < 9 ; i++){
			for(int j = 0 ; j < 9 ; j++){
				System.out.print(inBoard[i][j]+" ");
			}
			System.out.println();
		}
	}


	/*
			for(int i = 0 ; i < 9 ; i++){
				if(board[i][j_in] != 0 ){
					poss.add(board[i][j_in]);
				}
				if(board[i_in][i] != 0){
					poss.add(board[i_in][i]);
				}
			}


	*/
	public int countPieces(int [][] inBoard ){
		int piecesKnown = 0;
		for(int row = 0 ; row < 9 ; row++){
			for(int col = 0 ; col < 9 ; col++){
				if(inBoard[row][col] != 0){
					piecesKnown++;
				}
			}
		}
		return piecesKnown;
	}
	public ArrayList<Integer> addColumn(int row, int col , ArrayList<Integer> inputKnownFalse , int [][] inBoard){
		for(int i = 0 ; i < 9 ; i++ ){
			if(inBoard[row][i] != 0 && !inputKnownFalse.contains(i)){
				inputKnownFalse.add(inBoard[row][i]);
			}
		}
		return inputKnownFalse;
	}
	public ArrayList<Integer> addRow(int row , int col , ArrayList<Integer> inputKnownFalse  , int [][] inBoard){
		for(int i = 0 ; i < 9 ; i++ ){
			if(inBoard[i][col] != 0 && !inputKnownFalse.contains(i)){
				inputKnownFalse.add(inBoard[i][col]);
			}
		}
		return inputKnownFalse;
	}
	public ArrayList<Integer> addBox(int row , int col , ArrayList<Integer> inputKnownFalse , int [][] inBoard){
		return inputKnownFalse;
	}
}