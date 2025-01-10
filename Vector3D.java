public class Vector3D {
    private double x, y, z;

    Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalize(Vector3D vector) {
        double magnitude = getMagnitude();

        if (magnitude == 0) {
            throw new IllegalStateException("Vector magnitude is zero.");
        }

        return new Vector3D(x / magnitude, y / magnitude, z / magnitude);
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.x, y + other.y, z + other.z);
    }

    public Vector3D multiply(double constant) {
        return new Vector3D(x * constant, y * constant, z * constant);
    }

    public double dotProduct(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public double angleBetween(Vector3D other) {
        double mag1 = getMagnitude();
        double mag2 = other.getMagnitude();

        if (mag1 == 0 || mag2 == 0) {
            throw new IllegalStateException("One or more vectors has magnitude zero.");
        }

        double cos = dotProduct(other) / (mag1 * mag2);

        return Math.acos(cos) * 180 / Math.PI;
    }

    public Vector3D crossProduct(Vector3D other) {
        double newX = y * other.z - z * other.y;
        double newY = z * other.x - x * other.z;
        double newZ = x * other.y - y * other.x;
        return new Vector3D(newX, newY, newZ);
    }
}
