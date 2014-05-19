package by.bsu.fpmi.dnfp.main.model;

import by.bsu.fpmi.dnfp.main.util.AlgoUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Igor Loban
 */
public class Tree {
    private Set<Node> roots = new HashSet<>();
    private Set<Arc> arcs = new HashSet<>();
    private Set<Arc> fakeArcs = new HashSet<>();

    public Tree(Node root) {
        roots.add(root);
    }

    public Set<Node> getRoots(int period) {
        return AlgoUtils.getRootByArcs(arcs, period);
    }

    public Set<Arc> populate(Set<Arc> newArcs) {
        Set<Arc> populatedArcs = new HashSet<>();
        newArcs.stream().filter(arc -> !arcs.contains(arc)).forEach(arc -> {
            arcs.add(arc);
            populatedArcs.add(arc);
        });
        return populatedArcs;
    }

    public Set<Arc> getArcs() {
        return arcs;
    }

    public void addFakeArc(Node beginNode, Node endNode) {
        Arc arc = new Arc(0, beginNode.getPeriod());
        arc.setBeginNode(beginNode);
        arc.setEndNode(endNode);
        arc.setFake(true);
        fakeArcs.add(arc);
    }

    public Set<Arc> getFakeArcs() {
        return fakeArcs;
    }
}
