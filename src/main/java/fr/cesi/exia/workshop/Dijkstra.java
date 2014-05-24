package fr.cesi.exia.workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections15.FactoryUtils;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.io.PajekNetReader;

/**
 * 
 * @author Anthony DENAUD
 *
 */
public class Dijkstra {

	private Map<Integer,Integer> couts;
	private UndirectedSparseGraph<Integer, Integer> graph;
	private ArrayList<Integer> marked;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Dijkstra() throws IOException{
		this.marked = new ArrayList<Integer>();
		this.graph = new UndirectedSparseGraph<Integer, Integer>();
		this.couts = new HashMap<Integer, Integer>();

		PajekNetReader reader = new PajekNetReader(
				FactoryUtils.instantiateFactory(Object.class));

		reader.load("smallgraph.net", graph);		
		
		
		
		//Initialiser le coût de chaque noeud à l’infini
		for (Integer vertex : graph.getVertices()) {
			couts.put(vertex, Integer.MAX_VALUE);
		}
		
		//Initialiser le coût du noeud source à 0
		this.couts.put(0, 0);
		
		//Tant qu’il y a des noeuds non-marqués dans le graphe
		while(graphContienNonMarque()){
			//TODO do the next
		}
	}


	private boolean graphContienNonMarque() {
		
		boolean result = true;
		
		for(Integer vertex : graph.getVertices()){
			if(this.marked.contains(vertex)){
				result = false;
			}
		}
		return result;
	}
}
