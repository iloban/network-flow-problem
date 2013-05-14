package by.bsu.fpmi.dnfp.main;

import by.bsu.fpmi.dnfp.exception.AntitheticalConstraintsException;
import by.bsu.fpmi.dnfp.exception.IterationLimitException;
import by.bsu.fpmi.dnfp.io.InputData;
import by.bsu.fpmi.dnfp.io.OutputData;
import by.bsu.fpmi.dnfp.main.model.Flow;
import by.bsu.fpmi.dnfp.main.model.Tree;
import by.bsu.fpmi.dnfp.main.net.AbstractNet;
import by.bsu.fpmi.dnfp.main.net.FirstPhaseNet;
import by.bsu.fpmi.dnfp.main.net.Net;

/**
 * @author Igor Loban
 */
public final class NetworkFlowProblem {
    private NetworkFlowProblem() {
    }

    public static void solve(InputData inputData, OutputData outputData) {
        try {
            Net net = inputData.parse();
            FirstPhaseNet firstPhaseNet = net.createFirstPhaseNet();
            doFirstPhase(firstPhaseNet);
            if (firstPhaseNet.hasSolution()) {
                doSecondPhase(net, firstPhaseNet.getTree(), firstPhaseNet.getFlow());
            }
            outputData.write(net);
        } catch (AntitheticalConstraintsException | IterationLimitException e) {
            outputData.writeError(e);
        }
    }

    private static void doFirstPhase(FirstPhaseNet firstPhaseNet) {
        solveProblem(firstPhaseNet);
    }

    private static void doSecondPhase(Net net, Tree tree, Flow flow) {
        net.setInitialParams(tree, flow);
        solveProblem(net);
    }

    private static void solveProblem(AbstractNet net) {
        net.prepare();
        if (net.isViolated()) {
            net.recalcPlan();
            while (!net.isOptimized()) {
                net.changeSupport();
                net.recalcPlan();
            }
        }
    }
}
