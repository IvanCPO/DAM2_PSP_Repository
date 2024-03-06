package org.a22ivancp.UD2.exer6;

public enum Material {
    TABACO("tabaco"),
    PAPEL("papel"),
    CERILLA("cerillas");

    private String name;

    Material(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
