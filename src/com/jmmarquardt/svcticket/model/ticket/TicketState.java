/**
 * TicketState.java
 * Written by John-Michael Marquardt
 */
package com.jmmarquardt.svcticket.model.ticket;

import com.jmmarquardt.svcticket.model.command.Command;

/**
 * TicketState is an interface for the states in the Ticket Manager. All
 * concrete ticket states must implement the TicketState interface.
 * 
 * @author John-Michael Marquardt
 */
public interface TicketState {

	/**
	 * updateState(Command) - Updates the state of the ticket according to the given
	 * Command.
	 * 
	 * @param command A Command object describing the action that will update the
	 *                Ticket's state.
	 * @throws UnsupportedOperationException if the CommandValue is not a valid
	 *                                       action for the ticket's current state.
	 */
	void updateState(Command command);

	/**
	 * getStateName - returns a String that represents the ticket's current state.
	 * 
	 * @return a String that represents the ticket's current state.
	 */
	String getStateName();
}
