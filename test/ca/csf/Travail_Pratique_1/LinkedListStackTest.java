package ca.csf.Travail_Pratique_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class LinkedListStackTest {

	private LinkedListStack stack;

	@Before
	public void setUp() throws Exception {
		stack = new LinkedListStack();
	}
	
	@Test
	public void whenStackCreated_thenStackIsEmpty() {
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void whenAddElementToStack_thenStackIsNotEmpty() {
		stack.Push(new Object());
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void whenAddAndRemoveElementOnStack_thenStackIsEmpty() {
		stack.Push(new Object());
		stack.Pop();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void whenAddElementToStackAndPop_thenElementIsPoped() {
		Object object = new Object();
		
		stack.Push(object);
		Object returnedObject = stack.Pop();
		
		assertSame(object, returnedObject);
	}
	
	@Test
	public void whenAddTwoElementToStackAndPop_thenSecondElementIsPoped() {
		Object object1 = new Object();
		Object object2 = new Object();
		
		stack.Push(object1);
		stack.Push(object2);
		Object returnedObject = stack.Pop();
		
		assertSame(object2, returnedObject);
		assertNotSame(object1, returnedObject);
	}
	
	@Test
	public void whenPopElementInEmptyStack_thenNullIsReturned() {
		Object returnedObject = stack.Pop();
		
		assertNull(returnedObject);
	}
	
	@Test
	public void whenAddElementInStackAndPeek_thenElementIsReturned() {
		Object object = new Object();
		
		stack.Push(object);
		Object returnedObject = stack.Peek();
		
		assertSame(object, returnedObject);
	}
	
	@Test
	public void whenAddElementInStackAndPeek_thenStackIsNotPoppedAndThusNotEmpty() {
		stack.Push(new Object());
		stack.Peek();
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void whenPeekElementInEmptyStack_thenNullIsReturned() {
		Object returnedObject = stack.Peek();
		
		assertNull(returnedObject);
	}
	
	@Test
	public void whenAddElementInStackAndGet_thenElementIsReturned() {
		Object object = new Object();
		
		stack.Push(object);
		Object returnedObject = stack.GetAt(0);
		
		assertSame(object, returnedObject);
	}
	
	@Test
	public void whenAddTwoElementsInStackAndGet_thenElementIsReturned() {
		Object object1 = new Object();
		Object object2 = new Object();
		
		stack.Push(object1);
		stack.Push(object2);
		Object returnedObject1 = stack.GetAt(0);
		Object returnedObject2 = stack.GetAt(1);
		
		assertSame(object2, returnedObject1);
		assertSame(object1, returnedObject2);
	}
	
	@Test
	public void whenAddElementInStackAndGet_thenStackIsNotPoppedAndThusNotEmpty() {
		stack.Push(new Object());
		stack.GetAt(0);
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void whenStackCreated_thenStackSizeIsZero() {
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void whenAddElementToStack_thenStackSizeRepresentsTheNumberOfElementsInStack() {
		stack.Push(new Object());
		assertEquals(1, stack.getSize());
		stack.Push(new Object());
		assertEquals(2, stack.getSize());
		stack.Push(new Object());
		assertEquals(3, stack.getSize());
	}
	
	@Test
	public void wheRemoveElementInStack_thenStackSizeRepresentsTheNumberOfElementsInStack() {
		stack.Push(new Object());
		stack.Push(new Object());
		stack.Push(new Object());
		
		stack.Pop();
		assertEquals(2, stack.getSize());
		stack.Pop();
		assertEquals(1, stack.getSize());
		stack.Pop();
		assertEquals(0, stack.getSize());
	}
	
	@Test
	public void whenClearStackThatContainsElement_thenStackBecomeEmpty() {
		stack.Push(new Object());
		
		stack.Clear();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void whenClearStackThatContainsElement_thenStackSizeBecomeZero() {
		stack.Push(new Object());
		
		stack.Clear();
		
		assertEquals(0, stack.getSize());
	}

}
