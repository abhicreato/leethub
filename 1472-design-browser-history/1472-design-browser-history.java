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
        while(steps > 0 && this.history.prev != null){
            this.history = this.history.prev;
            steps--;
        }
        return this.history.data;
 
    }
    
    public String forward(int steps) {
        
        DoublyLinkedList current = this.history;
        while(steps > 0 && this.history.next !=null){
            this.history = this.history.next;
            steps--;
        }
        return this.history.data;

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