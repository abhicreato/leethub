class BrowserHistory {
    
    DoublyLinkedList history;

    public BrowserHistory(String homepage) {
        
        this.history = new DoublyLinkedList(homepage);
        
    }
    
    public void visit(String url) {
        
        DoublyLinkedList current = new DoublyLinkedList(url);
        this.history.next = current;
        current.prev = this.history;
        this.history = current;
        
    }
    
    public String back(int steps) {
        DoublyLinkedList current = this.history;
        while(steps > 0 && current.prev != null){
            current = current.prev;
            steps--;
        }
        
        this.history = current;
        return current.data;
 
    }
    
    public String forward(int steps) {
        
        DoublyLinkedList current = this.history;
        while(steps > 0 && current.next !=null){
            current = current.next;
            steps--;
        }
        this.history = current;
        return current.data;

    }
}

class DoublyLinkedList{
    
    String data;
    DoublyLinkedList next;
    DoublyLinkedList prev;
    
    DoublyLinkedList(){
        
    }
    
    DoublyLinkedList(String data){
        this.data = data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */