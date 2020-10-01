/**
* This class builds the minHeap from a given array. 
* The min heap tree is a complete binary tree and is represented in level order traversal array form where for any index i
* the left child is 2*i +1
* the right child is 2*i +2
*          10                       5
*        /     \                   /  \
*      15     30     ====>      10    30
*      /                        /
*     5                       15
* [10, 15,30,5] becomes [5,10,30,15]
**/
public class MinHeap {
    public void solve(int[] A) {
        //build heap
        buildHeap(A);
        
        for(Integer i:A)
        System.out.print (i+" ");
        
    }
    public void buildHeap(int[] A){
        int startInd=(A.length)/2;
        for(int i=startInd;i>=0;i--){
            minHeapify(A,i);
        }
    }
    
    //To minheapify the tree
    public void minHeapify(int[] A, int index){
        int smallest=index;
        int left=(2*index)+1;
        int right=(2*index)+2;
        
        if(left<A.length && A[left]<A[index]){
            smallest=left;
        }
        if(right<A.length && A[right]<A[smallest]){
            smallest=right;
        }
        
        //if smallest isnt root, heapify
        if(smallest!=index){
            int temp=A[index];
            A[index]=A[smallest];
            A[smallest]=temp;
            minHeapify(A,smallest);
        }
    }
}
