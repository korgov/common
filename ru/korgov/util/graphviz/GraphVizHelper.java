package ru.korgov.util.graphviz;

/**
 * Author: Kirill Korgov (korgov@korgov.ru)
 * Date: 30.05.13 4:15
 */
public class GraphVizHelper {
    public static void addLabeledEdge(final GraphViz gv, final String v1, final String v2, final String edgeLabel) {
        gv.addln(v1 + " -> " + v2 + " [label=\"" + edgeLabel + "\"];");
    }

    public static void addVertexPeripheries(final GraphViz gv, final String v, final int peripheries) {
        gv.addln(v + " [peripheries=" + peripheries + "];");
    }

    public static void addVertexColor(final GraphViz gv, final String v, final String color) {
        gv.addln(v + " [color=" + color + "];");
    }
}
