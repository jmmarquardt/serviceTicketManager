/**
 * 
 */
package com.jmmarquardt.svcticket.model.ticket;

import java.util.ArrayList;

/**
 * Ticket
 * <p>
 * Ticket represents a ticket tracked by our system. A {@code Ticket} shows its
 * ticketId, state, ticketType, subject, caller, category, priority, owner,
 * feedbackCode, resolutionCode, cancellationCode, and all of its notes. Each
 * Ticket object instance has its own state which is updated from the commands
 * (via {@code Command}) that are propagated to it from the UI
 * ({@code TicketManagerGUI}). Other fields may be updated when a Command is
 * issued as per the definition of the Ticket Manager FSM in the design
 * documents. For example, ownerId is updated when a CommandValue.PROCESS
 * Command transitions the ticket from NewState to WorkingState.
 * 
 * The six concrete {@code State} classes implement {@code TicketState}. They
 * are inner classes of Ticket, and each support two behaviors:
 * {@code updateState()} when given a Command, and {@code getStateName()}.
 * 
 * Ticket also encapsulates three enumerations, {@code TicketType},
 * {@code Category}, and {@code Priority}.
 * 
 * @author John-Michael Marquardt (jmmarquardt@gmail.com)
 *
 */
public class Ticket {
	/** TicketType Request String representation */
	private static final String TT_REQUEST = "Request";
	/** TicketType Incident String representation */
	private static final String TT_INCIDENT = "Incident";
	/** Category "Inquiry" String representation */
	private static final String C_INQUIRY = "Inquiry";
	/** Category "Software" String representation */
	private static final String C_SOFTWARE = "Software";
	/** Category "Hardware" String representation */
	private static final String C_HARDWARE = "Hardware";
	/** Category "Network" String representation */
	private static final String C_NETWORK = "Network";
	/** Category "Database" String representation */
	private static final String C_DATABASE = "Database";
	/** Priority "Urgent" String representation */
	private static final String P_URGENT = "Urgent";
	/** Priority "High" String representation */
	private static final String P_HIGH = "High";
	/** Priority "Medium" String representation */
	private static final String P_MEDIUM = "Medium";
	/** Priority "Low" String representation */
	private static final String P_LOW = "Low";
	/** State String representation for "New" state */
	private static final String NEW_NAME = "New";
	/** State String representation for "Working" state */
	private static final String WORKING_NAME = "Working";
	/** State String representation for "Feedback" state */
	private static final String FEEDBACK_NAME = "Feedback";
	/** State String representation for "Resolved" state */
	private static final String RESOLVED_NAME = "Resolved";
	/** State String representation for "Closed" state */
	private static final String CLOSED_NAME = "Closed";
	/** State String representation for "Canceled" state */
	private static final String CANCELED_NAME = "Canceled";
	/**
	 * IllegalArgumentException error message for the constructor, and its setters.
	 */
	private static final String ERROR = "Ticket cannot be created.";
	/** UnsupportedOperationException error message for the update() method. */
	private static final String UOE_ERROR = "Invalid command.";

	/**
	 * Category is one of only 5 types: Inquiry, Software, Hardware, Network or
	 * Database
	 */
	private enum Category {
		INQUIRY, SOFTWARE, HARDWARE, NETWORK, DATABASE
	}

	/** Priority is only one of 4 types: Urgent, High, Medium or Low */
	private enum Priority {
		URGENT, HIGH, MEDIUM, LOW
	}

	/** TicketType can only be one of two types: Request or Incident */
	private enum TicketType {
		REQUEST, INCIDENT
	}

	/** ticketId is a unique id for a ticket */
	private int ticketId;
	/** state is the current state for the ticket of type {@code TicketState} */
//	private TicketState state = null;
	/** ticketType for this ticket instance (Incident or Request) */
	private TicketType ticketType = null;
	/**
	 * subject is the Ticket's subject information from when the ticket is created
	 */
	private String subject;
	/** caller is the User id of the person who created the ticket */
	private String caller;
	/** category of the ticket, from one of the Category enumerator values */
	private Category category = null;
	/** priority of the ticket, from one of the Priority enumerator values */
	private Priority priority = null;
	/**
	 * User id of the ticket owner or "" (empty String) if there is no assigned
	 * owner
	 */
	private String owner = null;
	/**
	 * FeedbackCode for the ticket, null if the ticket is not in the FeedbackState
	 */
//	private FeedbackCode feedbackCode = null;
	/**
	 * ResolutionCode for the ticket, null if the ticket is not in ResolvedState or
	 * ClosedState
	 */
//	private ResolutionCode resolutionCode = null;
	/**
	 * CancellationCode for the ticket, null if the ticket is not in CanceledState
	 */
//	private CancellationCode cancellationCode = null;
	/** An ArrayList of all the notes on a ticket */
	private ArrayList<String> notes = new ArrayList<String>();
	/**
	 * counter keeps track of the id value that should be given to the next ticket
	 * created
	 */
	private static int counter = 1;

	// Ticket maintains one instance of every concrete TicketState class
	/** Final instance of the NewState inner class */
//	private final NewState newState = new NewState();
	/** Final instance of the WorkingState inner class */
//	private final WorkingState workingState = new WorkingState();
	/** Final instance of the FeedbackState inner class */
//	private final FeedbackState feedbackState = new FeedbackState();
	/** Final instance of the ResolvedState inner class */
//	private final ResolvedState resolvedState = new ResolvedState();
	/** Final instance of the ClosedState inner class */
//	private final ClosedState closedState = new ClosedState();
	/** Final instance of the CanceledState inner class */
//	private final CanceledState canceledState = new CanceledState();

	/**
	 * Ticket(TicketType, String, String, Category, Priority, String)
	 * <p>
	 * Constructs a Ticket from the provided parameters. If any of the given
	 * parameters are null or an empty string (if a String type), then an
	 * IllegalArgumentException is thrown. The ticketId is set to the value stored
	 * in {@code counter}. The counter is then incremented using
	 * {@code Ticket.incrementCounter()}. The rest of the fields are initialized to
	 * the parameter values, null, false or an empty object type as appropriate. The
	 * {@code owner} field should be initialized to an empty String. A new Ticket
	 * begins in the "New" state.
	 * </p>
	 * 
	 * @param ticketType A TicketType enumeration representing either Incident or
	 *                   Request.
	 * @param subject    A String representing this Ticket's subject information
	 * @param caller     A String representing the User id of the person who
	 *                   reported the ticket
	 * @param category   A Category enumeration: Inquiry, Software, Hardware,
	 *                   Network, Database.
	 * @param priority   A Priority enumeration: Urgent, High, Medium, Low.
	 * @param notes      An {@code ArrayList<String>} All of the notes of this
	 *                   Ticket.
	 * @throws IllegalArgumentException if any of the given values are null or if
	 *                                  any of the String type parameters are empty
	 *                                  strings.
	 */
	public Ticket(TicketType ticketType, String subject, String caller, Category category, Priority priority,
			ArrayList<String> notes) {
		String err = "Ticket cannot be created.";
		// remaining null checks are in the individual setters.
		if (ticketType == null || category == null || priority == null || notes == null) {
			throw new IllegalArgumentException(err);
		}
		if (notes.equals("")) {
			throw new IllegalArgumentException(err);
		}

		// clear all the data fields of ticket
		this.feedbackCode = null;
		this.resolutionCode = null;
		this.cancellationCode = null;

		this.ticketType = ticketType;
		this.subject = subject;
		this.caller = caller;
		this.category = category;
		this.priority = priority;
		this.notes = notes;
	}

}