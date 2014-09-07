import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class makeGradeList {
	private String[] clist;
	private String[] elist,cgrade,egrade;
	private int[] ccredit,ecredit;
	private int nccleared=0,necleared=0;
	private int ccount=0,ecount=0,cpoint=0,epoint=0;
	
	
	makeGradeList(String id) throws IOException{
		FileInputStream fstream = new FileInputStream(id+"_core.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		ccount=0;
		while(strLine!=null){
			ccount++;
			strLine=br.readLine();
			//System.out.println("trapped");
		}
		br.close();
		in.close();
		fstream.close();
		fstream = new FileInputStream(id+"_elective.txt");
		// Get the object of DataInputStream
		in = new DataInputStream(fstream);
		strLine="";
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		ecount=0;
		while(strLine!=null){
			ecount++;
			strLine=br.readLine();
			//System.out.println("trapped");
		}
		br.close();
		in.close();
		fstream.close();
		clist=new String[ccount];
		elist=new String[ecount];
		int i;
		fstream = new FileInputStream(id+"_core.txt");
		in = new DataInputStream(fstream);
		strLine="";
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		i=0;
		while(strLine!=null){
			clist[i]=""+strLine;
			strLine=br.readLine();
			i++;
			//System.out.println("trapped");
		}
		br.close();
		in.close();
		fstream.close();
		fstream = new FileInputStream(id+"_elective.txt");
		in = new DataInputStream(fstream);
		strLine="";
		br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		i=0;
		while(strLine!=null){
			//System.out.println("xtrapped");
			elist[i]=""+strLine;
			strLine=br.readLine();
			i++;
		}
		br.close();
		in.close();
		fstream.close();
		ccredit=new int[ccount];
		ecredit=new int[ecount];
		for(i=0;i<=ccount-1;i++){
			ccredit[i]=getCredit(clist[i]);
			//System.out.println("clist["+i+"] of "+clist[i]+" = "+ccredit[i]);
		}
		for(i=0;i<=ecount-1;i++){
			ecredit[i]=getCredit(elist[i]);
			//System.out.println("elist["+i+"] of "+elist[i]+" = "+ecredit[i]);
		}
		cgrade=new String[ccount];
		egrade=new String[ecount];
		for(i=0;i<=ccount-1;i++){
			
			cgrade[i]=getGrade(clist[i],id);
			//System.out.println("clist["+i+"] of "+clist[i]+" = "+cgrade[i]);
		}
		for(i=0;i<=ecount-1;i++){
			
			egrade[i]=getGrade(elist[i],id);
			//System.out.println("elist["+i+"] of "+elist[i]+" = "+egrade[i]);
		}
		//System.out.println("not here dude !!");
		newCleared();
	}
	
	
	private void newCleared(){
		int i=0;
		nccleared=0;
		cpoint=0;
		for(i=0;i<=ccount-1;i++){
			nccleared=nccleared+ccredit[i];
			cpoint=cpoint+(gradeToInt(cgrade[i])*ccredit[i]);
		}
		necleared=0;
		epoint=0;
		for(i=0;i<=ecount-1;i++){
			if(!egrade[i].equals("N")){
				necleared=necleared+ecredit[i];
				epoint=epoint+(gradeToInt(egrade[i])*ecredit[i]);
			}
		}
	}
	
	public int stringToInt(String s){
		int n=0;
		for(int i=0;i<=s.length()-1;i++){
			n=n*10+(s.charAt(i))-48;
		}
		return n;
	}
	public int getCredit(String course) throws IOException{
		FileInputStream fstream = new FileInputStream(course+"_list.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine="";
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		int credit=stringToInt(strLine);
		br.close();
		in.close();
		fstream.close();
		//System.out.println("Fatal ERROR !!! subject="+course+" not found in DataBase!!");
		return credit;
	}
	public String getGrade(String course,String id) throws IOException{
		FileInputStream fstream = new FileInputStream(course+"_gradelist.txt");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		String strLine=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		strLine=br.readLine();
		while(strLine!=null){
			if(strLine.equals(id)){
				strLine=br.readLine();
				br.close();
				in.close();
				fstream.close();
				return strLine;
			}
			strLine=br.readLine();
			strLine=br.readLine();
		}
		br.close();
		in.close();
		fstream.close();
		return "N";
	}
	private int gradeToInt(String grade){
		switch(grade.charAt(0)){
		case 'E':{
			return 10;
		}case 'A':{
			return 9;
		}case 'B':{
			return 8;
		}case 'C':{
			return 7;
		}case 'D':{
			return 6;
		}case 'P':{
			return 5;
		}case 'F':{
			return 4;
		}
		}
		return 0;
	}
	public int getNewC(){
		return nccleared;
	}
	public int getNewE(){
		return necleared;
	}
	public int getCpoint(){
		return cpoint;
	}
	public int getEpoint(){
		return epoint;
	}
	public double getGpa(){
		if(nccleared!=0){
			return (double)cpoint/(double)nccleared;
		}
		else{
			return 0;
		}
	}
	public double getAgpa(){
		if(necleared!=0){
			return (double)epoint/(double)necleared;
		}
		else{
			return 0;
		}
	}
	public String getCgradeText(){
		String text="";
		for(int i=0;i<=ccount-1;i++){
			text=text+"\r\n"+clist[i]+"  ---> "+cgrade[i];
		}
		return text;
	}
	public String getEgradeText(){
		String text="";
		for(int i=0;i<=ecount-1;i++){
			if(!egrade[i].equals("N")){
				text=text+"\r\n"+elist[i]+"  ---> "+egrade[i];
			}
		}
		return text;
	}
}
