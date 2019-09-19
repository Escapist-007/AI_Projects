/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_02;


/**
 * This class will contain the original solution and other statistics of your search algorithm.
 * You will use object of this class, to pass information from searcg algorithm to the caller
 * Add necessary fields as per your need.
 * @author user
 *
 */
public class SolutionInfo {

	
	Route solution;
	int loopCount;
	
	public SolutionInfo(Route solution, int loopCount) {
		// TODO Auto-generated constructor stub
		this.solution = solution;
		this.loopCount = loopCount;
	}
}
