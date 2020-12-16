/**
 * Command.java
 */
package com.jmmarquardt.svcticket.model.command;

/**
 * Command is a class that describes the actions to apply to a TicketState. Each
 * Command object has an owner and can optionally have a note attached. Each
 * Command object also has a CommandValue, and either a FeedbackCode, a
 * ResolutionCode or a CancellationCode--all of which are inner enumerations in
 * this class.
 * 
 * @author John-Michael Marquardt
 */
public class Command {
	/**
	 * Class String Constants
	 */
	/** Feedback message "Awaiting Caller". */
	public static final String F_CALLER = "Awaiting Caller";
	/** Feedback message "Awaiting Change". */
	public static final String F_CHANGE = "Awaiting Change";
	/** Feedback message "Awaiting Provider". */
	public static final String F_PROVIDER = "Awaiting Provider";
	/** Resolution code "Completed". */
	public static final String RC_COMPLETED = "Completed";
	/** Resolution code "Not Completed". */
	public static final String RC_NOT_COMPLETED = "Not Completed";
	/** Resolution code "Solved". */
	public static final String RC_SOLVED = "Solved";
	/** Resolution code "Workaround". */
	public static final String RC_WORKAROUND = "Workaround";
	/** Resolution code "Not Solved. */
	public static final String RC_NOT_SOLVED = "Not Solved";
	/** Resolution code "Caller Closed". */
	public static final String RC_CALLER_CLOSED = "Caller Closed";
	/** Cancellation code "Duplicate". */
	public static final String CC_DUPLICATE = "Duplicate";
	/** Cancellation code "Inappropriate". */
	public static final String CC_INAPPROPRIATE = "Inappropriate";

	/**
	 * Class Enumerators
	 */
	/** CommandValue contains the type of this command. */
	public enum CommandValue {
		PROCESS, FEEDBACK, RESOLVE, CONFIRM, REOPEN, CANCEL
	}

	/** FeedbackCode */
	public enum FeedbackCode {
		AWAITING_CALLER, AWAITING_CHANGE, AWAITING_PROVIDER
	}

	/** ResolutionCode */
	public enum ResolutionCode {
		COMPLETED, NOT_COMPLETED, SOLVED, WORKAROUND, NOT_SOLVED, CALLER_CLOSED
	}

	/** CancellationCode */
	public enum CancellationCode {
		DUPLICATE, INAPPROPRIATE
	}

	/**
	 * Instance Variables (fields)
	 */
	/** The CommandValue of this instance */
	private CommandValue commandValue;
	/** A String representing the owner id of this Command instance. */
	private String ownerId;
	/** A String representing the note to be attached to this Command instance. */
	private String note;
	/** The FeedbackCode of this Command instance, null if none. */
	private FeedbackCode feedbackCode = null;
	/** The ResolutionCode of this Command instance, null if none. */
	private ResolutionCode resolutionCode = null;
	/** The CancellationCode of this Command instance, null if none. */
	private CancellationCode cancellationCode = null;

	/**
	 * Command(CommandValue, String, String, FeedbackCode, ResolutionCode,
	 * CancellationCode)
	 * <p>
	 * Constructs a new Command from the given parameters, that contains the
	 * information to update a TicketState object. A Command with a CommandValue of
	 * PROCESS must have an ownerID assigned to it.
	 * </p>
	 * 
	 * @param c                Process, Feedback, Confirm, Reopen, Resolve, and
	 *                         Cancel.
	 * @param ownerId          The user id of this Command's owner (String).
	 * @param feedbackCode     "Awaiting Caller", "Awaiting Provider", or "Awaiting
	 *                         Change".
	 * @param resolutionCode   "Completed", "Not Completed", "Solved", "Not Solved",
	 *                         "Workaround" or "Caller Closed".
	 * @param cancellationCode "Duplicate" or "Inappropriate"
	 * @param note             An optional note entered by the user (String).
	 * @throws IllegalArgumentException if the given commandValue is null or does
	 *                                  not have the appropriate code passed as
	 *                                  well.
	 */
	public Command(CommandValue c, String ownerId, FeedbackCode feedbackCode, ResolutionCode resolutionCode,
			CancellationCode cancellationCode, String note) {
		String err = "Invalid Command.";
		// CommandValue cannot be null
		if (c == null)
			throw new IllegalArgumentException(err);
		// CommandValue.PROCESS ownerId cannot be null or empty
		switch (c) {
		case PROCESS:
			if (ownerId == null || ownerId.equals(""))
				throw new IllegalArgumentException(err);
			break;
		case FEEDBACK:
			if (feedbackCode == null)
				throw new IllegalArgumentException(err);
			this.feedbackCode = feedbackCode;
			break;
		case RESOLVE:
			if (resolutionCode == null)
				throw new IllegalArgumentException(err);
			this.resolutionCode = resolutionCode;
			break;
		case CANCEL:
			if (cancellationCode == null)
				throw new IllegalArgumentException(err);
			this.cancellationCode = cancellationCode;
			break;
		default:
			break;
		}
		this.commandValue = c;
		this.ownerId = ownerId;
		this.note = note;
	}

	/**
	 * getCommandValue - returns the commandValue.
	 * 
	 * @return the commandValue
	 */
	public CommandValue getCommandValue() {
		return commandValue;
	}

	/**
	 * getOwnerId - returns the ownerId.
	 * 
	 * @return the ownerId
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * getNote - returns the note for this Command.
	 * 
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * getFeedbackCode - returns the FeedbackCode if any, else null.
	 * 
	 * @return the feedbackCode if any, else null.
	 */
	public FeedbackCode getFeedbackCode() {
		return feedbackCode;
	}

	/**
	 * getResolutionCode - returns the ResolutionCode if any, else null.
	 * 
	 * @return the resolutionCode if any, else null.
	 */
	public ResolutionCode getResolutionCode() {
		return resolutionCode;
	}

	/**
	 * getCancellationCode - returns the CancellationCode if any, else null.
	 * 
	 * @return the cancellationCode if any, else null.
	 */
	public CancellationCode getCancellationCode() {
		return cancellationCode;
	}
}