package rmipkg.server;


import java.io.Serializable;

public class SimpleObj implements Serializable {
    private int n;
    private int p;
    private String name;

    public SimpleObj(int n, int p, String name) {
        this.n = n;
        this.p = p;
        this.name = name;
    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleObj simpleObj = (SimpleObj) o;

        if (n != simpleObj.n) return false;
        if (p != simpleObj.p) return false;
        if (name != null ? !name.equals(simpleObj.name) : simpleObj.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = n;
        result = 31 * result + p;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SimpleObj{" +
                "n=" + n +
                ", p=" + p +
                ", name='" + name + '\'' +
                '}';
    }
}
