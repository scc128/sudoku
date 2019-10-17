import java.io.*;
import java.util.*;
public class main{
	public static void main(String args []){
		int [][]board = {
												// place in box nubmer and box numbers for the nine boxes
							{0,0,0,1,0,2,0,3,7}, // 0-8
							{0,0,0,4,0,9,5,8,6}, // 9 -17
							{0,0,6,0,0,8,9,0,0}, // 18 - 26
							{0,7,0,0,0,0,8,6,5}, // 27 -35
							{0,0,1,6,0,0,0,0,3}, // 36 - 44
							{6,3,0,2,0,0,0,0,1}, // 45-53
							{8,1,7,3,4,5,6,2,9}, // 54-62
							{3,9,0,0,2,0,0,5,0}, // 63-71
							{0,6,5,0,0,0,0,0,0} // 72-80
							};
		Board test = new Board();
		test.solve(board);
	}
	public static void findPoss(int i_in , int j_in , int [][] board ){
		ArrayList<Integer> poss = new ArrayList<Integer>();
		if(board[i_in][j_in] == 0 ){
			return;
		}else{
			for(int i = 0 ; i < 9 ; i++){
				if(board[i][j_in] != 0 ){
					poss.add(board[i][j_in]);
				}
				if(board[i_in][i] != 0){
					poss.add(board[i_in][i]);
				}
			}
		}
		if(poss.size() == 8){
			System.out.println("found one ");
			for(Integer i : poss){
				System.out.print("" + i+" ,");
			}
		}
	}
	public int findSquare(int i_in , int j_in , int [][] board){
		if(i_in<=2){

		}else if(i_in<=5){

		}else if(i_in<=8){

		}
		return 0;
	}


}