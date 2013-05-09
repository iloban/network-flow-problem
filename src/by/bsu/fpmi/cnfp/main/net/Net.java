package by.bsu.fpmi.cnfp.main.net;

import java.util.List;

/**
 * @author Igor Loban
 */
public class Net extends AbstractNet {
    protected double eps;
    private double subOptVal = 0; // TODO: think about theses values
    private double step = 0;

    public Net(List<Node> nodes, List<Arc> arcs, double eps, int nodeCount, int arcCount) {
        super(nodes, arcs, nodeCount, arcCount);
        this.eps = eps;
    }

    public FirstPhaseNet createFirstPhaseNet() {
        // TODO: create net for first phase
        return null;
    }

    public void prepare() {
        // Построить дерево и начальный поток
        //      Ввести искусственные вершины, из которых выходят источники и нейтральные узлы и входят стоки (на каждом
        //      уровне)
        //      Искусственные вершины соединяются дугами из уровня в уровень
        //      Присвоить искусственным дугам стоимость M, где M - большое число (штраф)
        //      Дерево будет состоять из искуственных дуг
        //      Поток равен абсолютным значениям интенсивностей узлов
        //      Решать обычным методом.
        //      Все искусственные дуги должны выйти из базиса
        //      Иначе задача не разрешима

        // Построить динамич опору Qr(op)
        // Посчитать псевдо-c(ij)
        // Посчитать потенциалы psi и ksi
    }

    public void recalcPlan() {
        // Посчитать оценки delta
        // Посчитать v и l
        // Посчитать шаг theta
        // Пересчет плана
    }

    public void changeSupport() {
        // Замена опоры
        // Пересчет потенциалов
    }

    public boolean isViolated() {
        return false;
    }

    public boolean isOptimized() {
        // Пересчет оценки субоптимальности beta
        return (1 - step) * subOptVal <= eps;
    }

    public double calcEstimates(int index) {
        return arcs.get(index).getBeginNode().getPotential() -
                arcs.get(index).getEndNode().getPotential() - arcs.get(index).getCost();
    }
}
