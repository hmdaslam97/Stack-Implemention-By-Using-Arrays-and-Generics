package myUtility;

public class Stacks <T> 
{
	//Private declaration doesnot allow user to modify data outside this class
	private int stackLength;
	private Object[] objectArray;
	private int top;
	
	private int pointer=-1;
	private int bottom=0;
	
	
	public Stacks()
	{
		stackLength=5;
		objectArray=new Object[stackLength];
		top=-1;
	}
	
//	Inserts object into stack in the Form of LIFO or FILO 
	public void push(T data)
	{
		if(top==objectArray.length-1)
		{
			try
			{			
				throw new StackOverflowError("Stack Overflow or Stack is Full.");
			}
			catch(StackOverflowError e)
			{
				e.printStackTrace();
				System.exit(0);
			}
		}		
		objectArray[++top]=data;
	}	

//	Removes last element added and return it
	@SuppressWarnings("unchecked")
	public T pop()
	{		
		if(top==-1)
		{
			try
			{
				throw new StackOverflowError("Stack Underflow or Stack is Empty.");
			}
			catch(StackOverflowError e)
			{
				e.printStackTrace();
				System.exit(0);
			}				
		}
		return (T)objectArray[top--];			
	}	
	
//	Returns last element added without Removing from stack
	@SuppressWarnings("unchecked")
	public T peek()
	{
		if(top==-1)
		{
			try
			{
				throw new StackOverflowError("Stack Underflow or Stack is Empty.");
			}
			catch(StackOverflowError e)
			{
				e.printStackTrace();
				System.exit(0);
			}
		}
		return (T)objectArray[top];		
	}
	
//	Checks if Element is present in Stack and returns boolean
	public boolean contains(T data)
	{
		for(int i=0;i<objectArray.length;i++)
		{
			if(objectArray[i]==data)
			{
				return true;
			}
		}
		return false;
	}
	
//	Returns no of Elements in Stack
	public int size()
	{
		return top+1;
	}
	
//	Reverses the Stack Elements
	public void reverse()
	{		
		for(int i=0;i<=top/2;i++)
		{
			@SuppressWarnings("unchecked")
			Object temp=(T)objectArray[i];
			objectArray[i]=objectArray[top-i];
			objectArray[top-i]=temp;
		}
	}
	
//	Iterator Methods
	
//	1,Checks If Element is Present Based on Next Position of Stack and Returns Boolean
	public boolean hasNext()
	{
		for(int i=0;i<top;i++)
		{
			if(++pointer==i)
			{
				pointer--;
				return true;
			}
		}		
		return false;
	}
	
//	2,Returns Element Present Based on Next Position of Stack
	@SuppressWarnings("unchecked")
	public T next()
	{
		for(int i=pointer+1;i<=top;i++)
		{
			if(++pointer==i)
			{	
				System.out.println(pointer+" "+bottom);
				return (T)objectArray[pointer];				
			}
		}
		try
		{
			throw new Exception("There is No Object Present at next Pointer!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}
	
//	3,Removes the Element Based on Position of Stack 
	public void remove()
	{
		if(pointer==-1 || pointer<bottom)
		{
			try
			{
				throw new Exception("Pointer is Not Pointing to Any Object!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(0);
			}
		}
		objectArray[pointer]=null;
		bottom++;
	}
	
//	Returns Element Based on index of Stack Elements
	@SuppressWarnings("unchecked")
	public T traverse(int index)
	{
		if(index>=0 && index<=top)
		{
			return (T)objectArray[index];
		}
		else
		{
			try
			{
				throw new Exception("Stack Index out of Bound!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(0);
				return null;
			}
		}
	}
	
//	Displays Elements Present in Stack in the form of container
	public void print()
	{
		if(top==-1)
		{
			try
			{
				throw new StackOverflowError("Stack Underflow or Stack is Empty.");
			}
			catch(StackOverflowError e)
			{
				e.printStackTrace();
				System.exit(0);
			}
		}
		else
		{
			System.out.println("Top of Stack");
			for(int i=top;i>=bottom;i--)
			{
				System.out.println(objectArray[i]);
			}
			System.out.println("Bottom of Stack");
		}
	}
	
//	Displays Stack Elements directly by printing Stacks type reference
	public String toString()
	{
		String s="TOP[ ";
		for(int i=top;i>=bottom;i--)
		{
			s+=objectArray[i]+" ";
		}
		s+="]BOTTOM";
		return s;
	}
	
	//Miscellaneous Methods
	
//	Checks if Stack is Empty and Return Boolean value
	public boolean isEmpty()
	{
		return top==-1?true:false;
	}
	
//	Returns the Maximum Capacity of Stack 
	public int capacity()
	{
		return objectArray.length;
	}
	
//	Grows the Stack Capacity by 5 Elements
	public void growStack()
	{
		if((objectArray.length-top)<=5)
		{
			stackLength+=5;
			Object[] a=new Object[stackLength];
			for(int i=0;i<objectArray.length;i++)
			{
				a[i]=objectArray[i];
			}
			objectArray=new Object[stackLength];
			for(int i=0;i<objectArray.length;i++)
			{
				objectArray[i]=a[i];
			}
		}
		else
		{
			System.out.println("First Fill the already grown Stack!");
		}
	}
	
//	Checks the Element Present in Stack and Returns its Position in Stack Counted From TOP
	public int search(T data)
	{
		reverse();
		for(int i=bottom;i<=top;i++)
		{
			if(objectArray[i]==data)
			{
				reverse();
				return i+1;
			}
		}
		reverse();
		return 0;
	}
	
//	Checks the Element Present in Stack and Returns its index in Stack 
	public int index(T data)
	{
		for(int i=bottom;i<=top;i++)
		{
			if(objectArray[i]==data)
			{
				return i;
			}
		}
		return -1;
	}
}
