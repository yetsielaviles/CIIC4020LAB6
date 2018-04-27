package ProcessingSystem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import Classes.Job;

public class Main {

	public static void main(String[] args){

		int t = 0; //time
		int size = 0;
		Scanner in = new Scanner(System.in);
		
		
		
		Queue<Job> inputQueue = new LinkedList<>(); 
		Queue<Job> processingQueue =  new LinkedList<>(); //Empty queue of jobs
		LinkedList<Job> terminatedJobs = new LinkedList<>(); //Empty list of terminated jobs
		
		ArrayList<Integer> inJ = new ArrayList<>();
		
		while(in.hasNextLine()){
			String line = in.nextLine();
			String[] parts = line.split(", ");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			inJ.add(a);
			inJ.add(b);
		}
	
		for (int i = 0; i < inJ.size(); i++) {
			
			Job nj = new Job(i + 1, inJ.get(i), inJ.get(i + 1));
			processingQueue.add(nj);
			size++;
			
		}
		while( (!processingQueue.isEmpty()) || (!terminatedJobs.isEmpty())){
			if(!processingQueue.isEmpty()){
				Job currentJ = processingQueue.element();
				t++;
				if(currentJ.getRemainingTime() == 0){
					currentJ.setDepartureTime(t);
					processingQueue.remove();
					terminatedJobs.add(currentJ);
				}
				else{
					processingQueue.poll();
					processingQueue.add(currentJ);
				}
			}
			else if(!inputQueue.isEmpty() && inputQueue.peek().getArrivalTime() == t){
				Job firstJ = inputQueue.peek();
				inputQueue.remove();
				processingQueue.add(firstJ);
			}
			
			t++;
		}
		
		System.out.println("Average Time in System is: " + t);
	}
}