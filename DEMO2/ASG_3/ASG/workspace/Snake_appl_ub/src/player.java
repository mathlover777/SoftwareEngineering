public class player {
	private String name;
	private int[] score;
	public player(String n){
		score=new int[8];
		for(int i=0;i<=7;i++){
			score[i]=0;
		}
		name=""+n;
	}
	public int getScore(int size){
		return score[size-5];
	}
	public String getName(){
		return name;
	}
	public void setScore(int size,int s){
		score[size-5]=s;
	}
}
