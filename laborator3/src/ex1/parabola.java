package exp1;

import java.io.*;
import java.util.*;

class Parabola {
    private int a, b, c;

    // Constructor
    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double[] calculateVertex() {
        double x = -b / (2.0 * a);
        double y = (-b * b + 4.0 * a * c) / (4.0 * a);
        return new double[]{x, y};
    }


    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }


    public double[] calculateMidpoint(Parabola other) {
        double[] vertex1 = this.calculateVertex();
        double[] vertex2 = other.calculateVertex();
        double midX = (vertex1[0] + vertex2[0]) / 2;
        double midY = (vertex1[1] + vertex2[1]) / 2;
        return new double[]{midX, midY};
    }

    public static double[] calculateMidpointStatic(Parabola p1, Parabola p2) {
        double[] vertex1 = p1.calculateVertex();
        double[] vertex2 = p2.calculateVertex();
        double midX = (vertex1[0] + vertex2[0]) / 2;
        double midY = (vertex1[1] + vertex2[1]) / 2;
        return new double[]{midX, midY};
    }


    public double calculateDistance(Parabola other) {
        double[] vertex1 = this.calculateVertex();
        double[] vertex2 = other.calculateVertex();
        return Math.hypot(vertex2[0] - vertex1[0], vertex2[1] - vertex1[1]);
    }


    public static double calculateDistanceStatic(Parabola p1, Parabola p2) {
        double[] vertex1 = p1.calculateVertex();
        double[] vertex2 = p2.calculateVertex();
        return Math.hypot(vertex2[0] - vertex1[0], vertex2[1] - vertex1[1]);
    }

    public static void main(String[] args) {
        List<Parabola> parabolas = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Marisia\\IdeaProjects\\Teme lab Java\\laborator3\\src\\ex1\\in.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] coefficients = line.split(" ");
                int a = Integer.parseInt(coefficients[0]);
                int b = Integer.parseInt(coefficients[1]);
                int c = Integer.parseInt(coefficients[2]);
                parabolas.add(new Parabola(a, b, c));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        for (Parabola parabola : parabolas) {
            System.out.println(parabola);
            double[] vertex = parabola.calculateVertex();
            System.out.printf("Vertex: (%.2f, %.2f)%n", vertex[0], vertex[1]);
        }

        if (parabolas.size() >= 2) {
            Parabola p1 = parabolas.get(0);
            Parabola p2 = parabolas.get(1);

            double[] midpoint = Parabola.calculateMidpointStatic(p1, p2);
            System.out.printf("Midpoint: (%.2f, %.2f)%n", midpoint[0], midpoint[1]);

            double distance = Parabola.calculateDistanceStatic(p1, p2);
            System.out.printf("Distance: %.2f%n", distance);
        }
    }
}

