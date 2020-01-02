public class KDTree implements PointSet {
    private Node root;
    private static final boolean HORIZONTAL = true;

    private class Node {
        private Point point;
        private Node left;      // when direction != horizontal, vertical, it refers to down
        private Node right;
        private boolean direction;

        public Node(Point point, boolean direction) {
            this.point = point;
            this.direction = direction;
        }
    }

    public KDTree(List<Point> points) {
        for (Point p : points) {
            root = insert(root, p, HORIZONTAL);
        }
    }

    private Node insert(Node n, Point p, boolean direction) {
        if (n == null) return new Node(p, direction);

        if (p.equals(n.point)) return n;

        int cmp = comparePoints(p, n.point, direction);     // compare p and n.point are given direction

        if (cmp < 0) n.left = insert(n.left, p, !direction);
        else        n.right = insert(n.right, p, !direction);

        return n;
    }

    private int comparePoints(Point p1, Point p2, boolean d) {
        // if d true, i.e. d is horizontal, compare on x coordinate
        if (d) return Double.compare(p1.getX(), p2.getX());
        else   return Double.compare(p1.getY(), p2.getY());
    }

    @Override
    public Point nearest(double x, double y) {
        Point goal = new Point(x, y);
        return nearest(root, goal, root.point);
    }

    private Point nearest(Node n, Point goal, Point best) {
        if (n == null) return best;

        if (Point.distance(n.point, goal) < Point.distance(best, goal)) best = n.point;

        int cmp = comparePoints(goal, n.point, n.direction);        // determine which direction to search
        Node goodSide, badSide;
        if (cmp < 0) {
            goodSide = n.left;
            badSide = n.right;
        } else {
            goodSide = n.right;
            badSide = n.left;
        }
        best = nearest(goodSide, goal, best);
        if (stillUseful(n, goal, best)) best = nearest(badSide, goal, best);

        return best;
    }

    private boolean stillUseful(Node n, Point goal, Point best) {
        double goatTobest = Point.distance(goal, best);
        double goalToBadSide;

        if (n.direction) {
            goalToBadSide = Point.distance(new Point(goal.getX(), n.point.getY()), goal);
        } else {
            goalToBadSide = Point.distance(new Point(n.point.getX(), goal.getY()), goal);
        }
        return goalToBadSide < goalTobest;
    }
}