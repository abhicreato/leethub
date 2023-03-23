class BrowserHistory {
    
    Stack<String> curr = new Stack<>();
    Stack<String> forw = new Stack<>();

    public BrowserHistory(String homepage) {
        curr.push(homepage);
    }
    
    public void visit(String url) {
        
        while(!forw.empty()){
            forw.pop();
        }
        
        curr.push(url);
    }
    
    public String back(int steps) {

        while(curr.size() > 1 && steps != 0){
            forw.push(curr.pop());
            steps--;
        }
        
        return curr.peek();
 
    }
    
    public String forward(int steps) {
        
        while(!forw.empty() && steps != 0){
            curr.push(forw.pop());
            steps--;
        }
        
        return curr.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */