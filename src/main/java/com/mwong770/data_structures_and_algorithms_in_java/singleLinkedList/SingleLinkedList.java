package com.mwong770.data_structures_and_algorithms_in_java.singleLinkedList;
import java.util.Scanner;

public class SingleLinkedList
{
		private Node start;
		
		public SingleLinkedList()
		{
			start=null;
		}
		
		public void createList() 
		{
			int i, n, data;
			
			Scanner scan = new Scanner(System.in);
			
//			captures number of desired nodes
			System.out.print("Enter the number of nodes : ");
			n = scan.nextInt();
			
//			leaves function if no nodes desired
			if (n == 0)
				return;
			
//			loops through number of desired nodes
			for (i=1; i<=n; i++)
			{
//				captures data to insert into nodes
				System.out.print("Enter the element to be inserted : ");
				data = scan.nextInt();
				
//				inserts nodes with data
				insertAtEnd(data);		
			}
		} /* ends createList() */
		
//		inserts new node to end of list
		public void insertAtEnd(int data)
		{
			Node p;
			Node temp = new Node(data);
			
//			if start is null, set start to refer to new node
			if (start == null)
			{
				start = temp;
				return;
			}
			
//			capture start because start refers to the first node
			p = start;
			
//			loops to find reference to the last node
			while (p.link !=null)
//				makes p refer to the next node in the list
				p = p.link;
			
//			links last node to new node
			p.link = temp;
		}
		
//		inserts new node in beginning of list or to empty list
		public void insertInBeginning(int data)
		{
//			creates new node
			Node temp=new Node(data);
			
//			links new node to first node (just as start is linked)
			temp.link=start;
			
//			links start to new node making it the first node
			start=temp;
		}
		
		public void displayList()
		{
			Node p;
			if (start == null)
			{
				System.out.println("List is empty");
				return;
			}
			System.out.print("List is :    ");
			p=start;
			
//			traverses the linked list and prints info in each node
			while (p != null)
			{
//				prints contents of individual node
				System.out.print(p.info + " ");
				
//				makes p refer to the next node
				p=p.link;
			}
			System.out.println();
			
		} /* ends displayList() */
		
		public void countNodes()
		{
			int n=0;
			Node p = start;
			while (p != null) 
			{
				n++;
				p=p.link;
			}
			System.out.println("Number of nodes in the list = " + n);
		} /* ends countNodes() */
		
//		returns true if x present in list, false if not
		public boolean search(int x) 
		{
			Node p;
			
			
			int position = 1; 
			p=start;
			while (p != null)
			{
				if (p.info == x)
					break;
				position++;
				p=p.link;
			}
			if (p==null)
			{
				System.out.println(x + " not found in list");
				return false;
			}
			else
			{
//				gives position of node containing x
				System.out.println(x + " is at position " + position);
				return true;
			}

		}
		
//		inserts new node after node with value x
		public void insertAfter(int data, int x)
		{
			Node p = start;
			
//			gets reference to node with x
			while(p !=null)
			{
				if(p.info == x)
					break;
				p = p.link;
			}
			
//			prints message if x not present in the list
			if (p == null)
				System.out.println(x + " not present in the list");
			else
			{
//				makes new node and inserts it after node with x
				Node temp = new Node(data);
				temp.link = p.link;
				p.link = temp;
			}
		}
		
		public void insertBefore(int data, int x)
		{
			Node temp;
			
//			if list is empty
			if(start==null)
			{
				System.out.println("List if empty");
				return;
			}
			
//			x is in first node, new node is  to be inserted before first node
			if(x == start.info)
			{
				temp = new Node(data);
				temp.link = start;
				start = temp;
				return;
			}
		
//			find reference to predecessor of node containing x
			Node p = start;
			while(p.link != null)
			{
				if(p.link.info == x)
					break;
				p=p.link;
			}
			
			if (p.link == null)
				System.out.println(x + " not present in the list");
			else
			{
				temp = new Node(data);
				temp.link = p.link;
				p.link = temp;
			}
		} /* ends insertBefore() */
		
//		inserts a new node at kth position in list
		public void insertAtPosition(int data, int k)
		{
			Node temp;
			int i;
			
			if(k == 1)
			{
				temp = new Node(data);
				temp.link=start;
				start=temp;
				return;
			}
			
			Node p=start;
			
//			finds reference to node at k-1 
			for(i=1; i<k-1 && p != null; i++)
				p=p.link;
			
			if(p==null)
				System.out.println("You can insert only up to " + i + "th position");
			else
			{
				temp = new Node(data);
				temp.link = p.link;
				p.link = temp;
			}
		}
		
//		deletes first node of list
		public void deleteFirstNode()
		{
			if(start==null)
				return;
			start=start.link;
		}
		
//		deletes last node of list
		public void deleteLastNode()
		{
//			returns if list empty
			if(start==null)
				return;
			
//			sets start to null if only one node in list
			if(start.link==null)
			{
				start=null;
				return;
			}
			
//			gets reference to second to last node of list and sets link to null
			Node p=start;
			while(p.link.link!=null)
				p=p.link;
			p.link=null;
		}
		
		public void deleteNode(int x)
		{
//			returns if list emtpy
			if(start==null)
			{
				System.out.println("List is empty\n");
				return;
			}
			
//			deletes first node if x in first node
			if(start.info==x)
			{
				start=start.link;
				return;
			}
			
//			finds predecessor of node containing x
			Node p=start;
			while(p.link != null)
			{
				if(p.link.info==x)
					break;
				p=p.link;
			}
			
			if(p.link==null)
				System.out.println("Element " + x + " not in list");
			else
//				deletes node containing x
				p.link = p.link.link;
		}
		
		public void reverseList() 
		{
			Node prev, p, next;
			prev=null;
			p=start;
			while(p != null)
			{
				next=p.link;
				p.link=prev;
				prev=p;
				p=next;
			}
			start=prev;
		} /* ends reverseList() */
		
		public void BubbleSortData() 
		{
			Node end, p, q;
			
//			 loops thru list and ends at second node
			 for(end=null; end!=start.link; end=p)
			 {
//				 loops thru list and stops when p.link == end
				 for (p=start; p.link!=end; p=p.link)
				 {
					 q=p.link;
//					 if p.info greater than q.info
					 if(p.info > q.info)
					 {
//						 swaps the two values
						 int temp=p.info;
						 p.info=q.info;
						 q.info=temp;
					 }
				 }
			 }
		} /*ends BubbleSortData() */
		
		public void BubbleSortLinks() 
		{
			Node end, r, p, q, temp;
			
//			loops thru list and ends at second node
			for(end=null; end!=start.link; end=p)
			{
//				 loops thru list and stops when p.link == end
				for(r=p=start; p.link!=end; r=p, p=p.link)
				{
					q=p.link;
					
//					if p.info greater than q.info
					if(p.info > q.info)
					{
//						changes the positions of nodes referred to by p and q
						p.link=q.link;
						q.link=p;
						if(p!=start)
							r.link=q;
						else
							start=q;
						
//						changes values of p and q for next iteration of for loop
						temp=p;
						p=q;
						q=temp;
					}
				}
			}
		} /* ends BubbleSortLinks() */
		
//		merges a sorted SingleLinkedList with SingleLinkedList sent as an argument by creating a new list
		public SingleLinkedList merge1(SingleLinkedList list)
		{
			SingleLinkedList mergeList = new SingleLinkedList();
			mergeList.start = merge1(start, list.start);
			return mergeList;
		}
		
//		creates merged list by allocating new nodes
		private Node merge1(Node p1, Node p2)
		{
			Node startM;
			
//			if p1.info smaller than p2.info
			if(p1.info <= p2.info)
			{
//				allocates new node with info equal to p1.info
				startM = new Node(p1.info);
				
//				moves p1 to next node
				p1=p1.link;
			}
			else
			{
//				allocates new node with info equal to p2.info
				startM =  new Node(p2.info);
				
//				moves p2 to next node
				p2=p2.link;
			}
			
//			pM refers to newly inserted node, the last node of merged list
			Node pM=startM;
			
//			executes until p1 and p2 not null
			while(p1!=null && p2!=null)
			{
				
//				if p1.info smaller than p2.info
				if(p1.info <= p2.info)
				{
					
//					allocates new node with info equal to p1.info and inserts it at end of merge list
					pM.link = new Node(p1.info);
					
//					moves p1 to next node
					p1=p1.link;
				}
				else
				{
					
//					allocates new node with info equal to p2.info and inserts it at end of merge list
					pM.link=new Node(p2.info);
					
//					moves p2 to next node
					p2=p2.link;
				}
				
//				moves pM to next node
				pM=pM.link;
			}
			
//			if second list has finished and elements left in first list
			while(p1!=null)
			{
//				inserts remaining elements to merge list
				pM.link = new Node(p1.info);
				p1=p1.link;
				pM=pM.link;
			}
			
//			if first list has finished and elements left in second list
			while(p2!=null)
			{
//				inserts remaining elements to merge list
				pM.link=new Node(p2.info);
				p2=p2.link;
				pM=pM.link;
			}
			return startM;
		}
		
//		merges a sorted SingleLinkedList with SingleLinkedList sent as an argument by rearranging links
		public SingleLinkedList merge2(SingleLinkedList list)
		{
			SingleLinkedList mergeList = new SingleLinkedList();
			mergeList.start = merge2(start, list.start);
			return mergeList;
		}
		
//		creates merge list; p1 and p2 refer to first nodes of lists to be merged
		private Node merge2(Node p1, Node p2)
		{
			
//			refers to first node of merged list
			Node startM;
			
//			if p1.info smaller
			if(p1.info <= p2.info)
			{
//				sets startM=p1
				startM=p1;
				
//				moves p1 to next node
				p1=p1.link;
			}
			else
			{
//				sets startM=p2
				startM = p2;
				
//				moves p2 to next node
				p2 = p2.link;
			}
			
//			pM refers to newly inserted node 
			Node pM = startM;
			
//			loops until p1 or p2 becomes null
			while(p1!=null && p2!=null)
			{
//				if p1.info smaller
				if(p1.info <= p2.info)
				{
//					insert node referred to by p1 at end of merge list
					pM.link = p1;
					
//					move pM and p1 forward
					pM = pM.link;
					p1 = p1.link;
				}
				else
				{
//					insert node referred to by p2 at end of merge list
					pM.link = p2;
					
//					move pM and p2 forward
					pM = pM.link;
					p2=p2.link;
				}
			}
			
//			if first list has finished
			if(p1==null)
//				insert all remaining nodes of p2 at end of merged list
				pM.link=p2;
			else
//				insert all remaining nodes of p1 at end of merged list
				pM.link=p1;
			return startM;
		}
		
//		sorts linkedList
		public void mergeSort()
		{
			start = mergeSortRec(start);
		}
		
//		recursive method
//		listStart refers to the first node of list that has to be sorted
		private Node mergeSortRec(Node listStart)
		{
//			returns listStart if list empty or has one element 
//			this is the terminating condition of recursion
			if(listStart==null || listStart.link==null)
				return listStart;
			
//			if more than one element, divide list into two lists of almost equal size
			
//			refers to first node of first list
//			start of first list is the start of original list that has to be divided
			Node start1 = listStart;
			
//			refers to first node of second list
			Node start2 = divideList(listStart);
			
//			recursively sorts the lists
			start1 = mergeSortRec(start1);
			start2 = mergeSortRec(start2);
			
//			merges the sorted lists by rearranging links and gets a reference to the first node of the merged list
			Node startM = merge2(start1, start2);
			return startM;
		}
		
//		p refers to first node of list that to be divided
		private Node divideList(Node p)
		{
//			q refers to third node of that list
			Node q=p.link.link;
			
//			loop until q (if even number of nodes) or q.link (if odd number of nodes) become null
			while(q!=null && q.link!=null)
			{
//				moves p one node at a time
				p=p.link;
				
//				moves q two nodes at a time
				q=q.link.link;
			}
			Node start2 = p.link;
			p.link = null;
			
//			start 2 refers to first node of second list
			return start2;
		}
		
//		returns true if the list has a cycle, false if not
		public boolean hasCycle()
		{
			if(findCycle() == null)
				return false;
			else
				return true;
		}
		
//		detects the cyle in the list using Hare and Tortoise algorithm
		private Node findCycle()
		{
			if(start==null || start.link == null)
				return null;
			
//			sets fast and slow reference to first node in list
			Node slowR =start, fastR = start;
			
//			loops until fast (even # nodes) or node after fast (odd # nodes) null
			while(fastR != null && fastR.link!=null){
				
//				moves slow one node at a time
				slowR = slowR.link;
				
//				moves fast 2 nodes at a time
				fastR = fastR.link.link;
				
//				if slow and fast meet, then there's a cycle, and returns node where meet
				if(slowR == fastR) 
					return slowR;
			}
//			returns null if no cycle, aka, fast and slow never meet
			return null;
		} /* ends findCycle() */
		
		public void removeCycle()
		{
//			gives reference to node where fast and slow meet
			Node c = findCycle();
			if(c==null)
				return;
			System.out.println("Node at which the cycle was detected is " + c.info);
			
//			set p and q to reference node where fast and slow met
			Node p=c, q=c;
			
//			finds length of cycle
			int lenCycle=0;
			do
			{
				lenCycle++;
//				moves q one node at a time
				q=q.link;
//				until it meets q again
			}while(p!=q);
//			# times q moves gives length of cycle
			System.out.println("Length of cycle is : " + lenCycle);
			
			int lenRemList=0;
			
//			moves p to first node of list, leaving q where p and q met before
			p=start;
			
//			then find length of remaining list (nodes not in cycle)
			while(p!=q)
			{
				lenRemList++;
//				moves p and q one node at time until meet
				p=p.link;
				q=q.link;
			}
//			# times move gives length of remaining list
			System.out.println("Number of nodes not included in the cycle are : " + lenRemList);;
			
//			captures length of list by adding nodes in cycle with nodes not in cycle
			int lengthList = lenCycle + lenRemList;
			System.out.println("Length of the list is : " + lengthList);
			
			
//			removes cycle
//			p refers to first node in list
			p=start;
//			moves p length of list -1 to get to last node
			for(int i=1; i<=lengthList-1; i++)
				p=p.link;
//			make null terminated by placing null in the link of the last node
			p.link=null;
		}
		
//		inserts cycle at node containing x
		public void insertCycle (int x)
		{
			if (start==null)
				return;
			
			Node p=start, px=null, prev=null;
			
//			loops until p null/ this is when prev refers to last node
			while(p!=null)
			{
//				captures node containing x
				if(p.info==x)
					px=p;
//				move prev to where p is
				prev=p;
//				move p forward one node
				p=p.link;
			}
			if(px!=null)
				
//				links last node to node containing x
				prev.link=px;
			else
				System.out.println(x + " not present in list");
		} /* ends insertCycle() */
		
//		adds the list sent as an argument to the ends of the list object that calls this method
		public void concatenate(SingleLinkedList list)
		{
//			if first list is empty
			if(start==null)
			{
//				sets start to list.start
				start=list.start;
				return;
			}
			
//			returns if list sent as argument empty
			if(list.start==null)
				return;
			
//			finds reference to last node of the first list
			Node p=start;
			while(p.link!=null)
				p=p.link;
			
//			makes last node of first list equal to start of list sent as argument
			p.link=list.start;
		}
		
} 