public class SimpleOOmage implements OOmage {
    /** Red, green, blue have value between 0 and 255. */
    protected int   red;
    protected int green;
    protected int  blue;

    private static final double WIDTH = 0.01;
    private static final boolean USE_PERFECT_HASH = true;

    @Override 
    public boolean equals(Object o) {
        // Reflexive: x.equals(x) must be true for any non-null x
        if (o == this)                      return   true;
        if (o == null)                      return  false;
        if (o.getClass() != this.getClass()) return false;
        // Cast o
        SimpleOOmage other = (SimpleOOmage) o;
        return this.red == other.red && this.green == other.green && this.blue == other.blue;
    }

    @Override
    public int hashCode() {
        if (!USE_PERFECT_HASH) return red + green + blue;

        // Perfect hash calculation, use base 53, prime number
        int hash = 0;
        hash +=   (red/5)   * 53 * 53;
        hash +=   (green/5) * 53;
        hash +=   blue      /5;
    }

    public SimpleOomage(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException();
        }
        if ((r % 5 != 0) || (g % 5 != 0) || (b % 5 != 0)) {
            throw new IllegalArgumentException("red/green/blue values must all be multiples of 5!");
        }
        red = r;
        green = g;
        blue = b;
    }
    @Override
    public void draw(double x, double y, double scalingFactor) {
        StdDraw.setPenColor(new Color(red, green, blue));
        StdDraw.filledSquare(x, y, WIDTH * scalingFactor);
    }

    public static SimpleOomage randomSimpleOomage() {
        int red = StdRandom.uniform(0, 51) * 5;
        int green = StdRandom.uniform(0, 51) * 5;
        int blue = StdRandom.uniform(0, 51) * 5;
        return new SimpleOomage(red, green, blue);
    }

    public static void main(String[] args) {
        System.out.println("Drawing 4 random simple Oomages.");
        randomSimpleOomage().draw(0.25, 0.25, 1);
        randomSimpleOomage().draw(0.75, 0.75, 1);
        randomSimpleOomage().draw(0.25, 0.75, 1);
        randomSimpleOomage().draw(0.75, 0.25, 1);
    }

    public String toString() {
        return "R: " + red + ", G: " + green + ", B: " + blue;
    }
}