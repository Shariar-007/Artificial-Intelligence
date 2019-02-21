package Assignment1;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author shariar
 */
@SuppressWarnings("rawtypes")
public class PuzzleNode implements Comparable,Comparator<PuzzleNode>{
    
    PuzzleState state;
    PuzzleNode ParentNode;
    int pathCost;
	
    
    public PuzzleNode(PuzzleState s,PuzzleNode n,int pc){
        state=s;
        ParentNode=n;
        pathCost=pc;
    }
    
    	static PuzzleNode A_star(PuzzleState initial) {

    	PuzzleNode root = new PuzzleNode(initial, null, 0);
    	
    	LinkedList<PuzzleNode> queue=new LinkedList<PuzzleNode>();
    	queue.add(root);
    	Collections.sort(queue,new PuzzleNode(root.state,root.ParentNode,root.pathCost));
    	
	//	PriorityQueue<PuzzleNode> queue = new PriorityQueue<>();
    //	queue.add(root);
		
		HashSet<PuzzleState> checkUnique = new HashSet<>();

		while (!queue.isEmpty()) {

			//PuzzleNode start = queue.poll();
			
			PuzzleNode start = queue.getFirst();
			queue.remove();
			
			PuzzleState currentState = start.state;

			// Graph search
			if (checkUnique.contains(currentState))
				continue;
			checkUnique.add(currentState);

			if (currentState.goal_test())
				return start;

			PuzzleState child;

			child = start.state.up();
			if (child != null)
				queue.add(new PuzzleNode(child, start, start.pathCost + 1));

			child = start.state.down();
			if (child != null)
				queue.add(new PuzzleNode(child, start, start.pathCost + 1));

			child = start.state.left();
			if (child != null)
				queue.add(new PuzzleNode(child, start, start.pathCost + 1));

			child = start.state.right();
			if (child != null)
				queue.add(new PuzzleNode(child, start, start.pathCost + 1));
		}

		return null;
	}

        public int heuristic() {

		return state.manhattan_distance();
		// return state.misplaced_tiles();
	}
        

        
    @Override
	public String toString() {
		return state + "\n";
	}

	public static void print_soln(PuzzleNode n) {
		if (n != null) {
			print_soln(n.ParentNode);
			System.out.println(n);
		}
	}
	

	@Override
	public int compare(PuzzleNode s1, PuzzleNode s2) {
		// TODO Auto-generated method stub
		
    	if(s1.pathCost==s2.pathCost)  
    	return 0;  
    	else if(s1.pathCost>s2.pathCost)  
    	return 1;  
    	else  
    	return -1; 
	}

	
	@Override
	public int compareTo(Object o1) {
		// TODO Auto-generated method stub
		PuzzleNode o=(PuzzleNode)o1;
		return ((pathCost + heuristic()) - (o.pathCost + o.heuristic()));
	}

	
	
    
    	  
}