/*
 * Javolution - Java(TM) Solution for Real-Time and Embedded Systems
 * Copyright (C) 2006 - Javolution (http://javolution.org/)
 * All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package com.bbva.czic.routine.mapper.javolution.xml.stream;

/**
 * This interface declares the constants used in this API. Numbers in the range
 * 0 to 256 are reserved for the specification, user defined events must use
 * event codes outside that range.
 * 
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 4.0, June 16, 2006
 */
public interface XMLStreamConstants {

    /**
	 * Indicates an event is a start element.
	 */
	public static final int START_ELEMENT = 1;

	/**
	 * Indicates an event is an end element.
	 */
	public static final int END_ELEMENT = 2;

	/**
	 * Indicates an event is a processing instruction.
	 */
	public static final int PROCESSING_INSTRUCTION = 3;

	/**
	 * Indicates an event is characters.
	 */
	public static final int CHARACTERS = 4;

	/**
	 * Indicates an event is a comment.
	 */
	public static final int COMMENT = 5;

	/**
	 * The characters are white space (see [XML], 2.10 "White Space Handling").
	 * Events are only reported as SPACE if they are ignorable white space.
	 * Otherwise they are reported as CHARACTERS.
	 */
	public static final int SPACE = 6;

	/**
	 * Indicates an event is a start document.
	 */
	public static final int START_DOCUMENT = 7;

	/**
	 * Indicates an event is an end document.
	 */
	public static final int END_DOCUMENT = 8;

	/**
	 * Indicates an event is an entity reference.
	 */
	public static final int ENTITY_REFERENCE = 9;

	/**
	 * Indicates an event is an attribute.
	 */
	public static final int ATTRIBUTE = 10;

	/**
	 * Indicates an event is a DTD.
	 */
	public static final int DTD = 11;

	/**
	 * Indicates an event is a CDATA section.
	 */
	public static final int CDATA = 12;

	/**
	 * Indicates the event is a namespace declaration.
	 */
	public static final int NAMESPACE = 13;

	/**
	 * Indicates a Notation.
	 */
	public static final int NOTATION_DECLARATION = 14;

	/**
	 * Indicates a Entity Declaration.
	 */
	public static final int ENTITY_DECLARATION = 15;
        
}