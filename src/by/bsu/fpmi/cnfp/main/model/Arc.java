package by.bsu.fpmi.cnfp.main.model;

/**
 * @author Igor Loban
 */
public class Arc extends NumerableObject {
    private Node beginNode;
    private Node endNode;
    private double capacity;
    private double cost;
    private double flow;
    private double estimate;

    public Arc() {
    }

    public Arc(int number) {
        super(number);
    }

    public Node getBeginNode() {
        return beginNode;
    }

    public void setBeginNode(Node beginNode) {
        this.beginNode = beginNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = Math.abs(flow);
    }

    public double getEstimate() {
        return estimate;
    }

    public void setEstimate(double estimate) {
        this.estimate = estimate;
    }
}
