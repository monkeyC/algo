package fr.cesi.exia.workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections15.FactoryUtils;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.io.PajekNetReader;

/**
 * Alogritmes du workshop 1 Alog Avancé
 * @author Anthony DENAUD
 *
 */
public class Graphique {

	private Graph<Integer, Integer> graph;
	private List<Integer> marked;
	private List<Integer> stack;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Graphique() throws IOException {
		this.marked = new ArrayList<Integer>();
		this.stack = new ArrayList<Integer>();
		this.graph = new UndirectedSparseGraph<Integer, Integer>();


		PajekNetReader reader = new PajekNetReader(
				FactoryUtils.instantiateFactory(Object.class));

		reader.load("smallgraph.net", graph);
		
		this.dfs(graph,0);
		
		System.out.println("Algoritme de parcours en largeur");
		
		this.marked.clear();
		
		this.bfs(graph,0);
	}
	
	
	/**
	 * Algoritme de parcours en largeur
	 * @param graph
	 * @param vertex
	 */
	public void bfs(Graph<Integer,Integer> graph, Integer vertex){
		
		stack.add(vertex);
		
		while(!stack.isEmpty()){
			
			vertex = stack.iterator().next();
			stack.remove(vertex);
			
			System.out.println(vertex);
			mark(vertex);
			for (Integer neighbor : graph.getNeighbors(vertex) ) {
				if(!isMarked(neighbor)){
					stack.add(neighbor);
					mark(neighbor);
				}
			}
			
		}
	}
	

	/**
	 * Algotime de parcours en profondeur
	 * @param graph2
	 * @param vertex
	 */
	private void dfs(Graph<Integer, Integer> graph2, int vertex) {
		this.mark(vertex);
		
		System.out.println(vertex);
		
		for (Integer integer : graph.getNeighbors(vertex)) {
			if(!this.isMarked(integer)){
				this.dfs(graph2, integer);
			}
		}
		System.out.println("=========");
	}

	private boolean isMarked(Integer integer) {
		return this.marked.contains(integer);
	}

	private void mark(int integer) {
		this.marked.add(integer);
	}
}
