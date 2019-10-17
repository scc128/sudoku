public class Box{
	private int [] numbers;
	private int boxNum;
	private int positionNumbers;
	public Box(int [] numbers , int boxNum , int [] positionNumbers){
		// these will be checked when inputed to the board class 
		this.numbers = numbers;
		if(boxNum < 0 || boxNum > 9){
			// fail condition 
		}else{
			this.boxNum = boxNum;
		}
		// these do not really matter 
		this.positionNumbers = positionNumbers;

	}
	// this could be in a super class becuase of duplicate code 
	public ArrayList<Integer> getKnownFalse(ArrayList<Integer> knownFalse){
		for(Integer i : numbers ){
			//need to make sure that there are no duplicats 
			// not for strorage reasons but because the check for if found a number is if knownFalse size is 9;
			if(!knownFalse.contains(i)){
				knownFalse.add(i);
			}
			
		}
		//return the updated list 
		return knownFalse;
	}
	

}