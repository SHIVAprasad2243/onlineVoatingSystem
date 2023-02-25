package onlineVoatingSystem;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class onlineVotingSystem {
	//store the candidate history
	  private Map<String,Integer> candidates=new HashMap<String,Integer>();
	  //store the user history
	  private Map<String,Boolean> users=new HashMap<String,Boolean>();
	  
	  public onlineVotingSystem()
	  {
		  candidates.put("shiva", 0);
		  candidates.put("laxman", 0);
		  candidates.put("akhile", 0);
		  
	  }
	  public void userRegistration(String email,String password,String candidateId)
	  {
		  users.put(email, false);
		  users.put(candidateId, false);
		  
		  System.out.println("user registered succesfully");
		  
	  }
	  public boolean userAuthentication(String email, String password,String candidateId) {
			// TODO Auto-generated method stub
		  if(users.containsKey(email) && !users.get(email)&& users.containsKey(candidateId))
		  {
			  users.put(email, true);
			  users.put(candidateId, true);
			  return true;
		  }
			return false;
		}
	  
	  public void votes(String email, String candiadate) {
			// TODO Auto-generated method stub
		  if(candidates.containsKey(candiadate))
		  {
			  candidates.put(candiadate, candidates.get(candiadate)+1);
			  users.put(email, false);
			  System.out.println("vote done succesfully");
		  }
		  else
			  System.out.println("candidate details r not matched");
			
		}
		public void disPlayVotes() {
			// TODO Auto-generated method stub
			System.out.println("voating result");
			for(String candidate : candidates.keySet()) {
				System.out.println(candidate +" :" + candidates.get(candidate));
			}
		}
		

	
	
	
	public static void main(String[] args) { 
		onlineVotingSystem v1=new onlineVotingSystem();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the email");
		String email=sc.nextLine();
		System.out.println("enter the password");
		String password=sc.nextLine();
		System.out.println("enter the candidateId");
		String candidateId=sc.nextLine();
		v1.userRegistration(email,password,candidateId);
		System.out.println("please login to vote");
		    System.out.println("enter the email");
		     email=sc.nextLine();
		     System.out.println("enter the password");
			 password=sc.nextLine();
			 System.out.println("enter the candidateID");
			 candidateId=sc.nextLine();
			 if(v1.userAuthentication(email,password,candidateId))
			 {
				 System.out.println("please select the candidate");
				 for(String candidate:v1.candidates.keySet()) {
					 System.out.println("candidate");
				 }
				 
			 
		String candiadate=sc.nextLine();
		v1.votes(email,candiadate);
		
	   v1.disPlayVotes();
			 }
			 else
			 {
				 System.out.println("invalid username , password r candidateId");
			 }
		

	}

	

}
