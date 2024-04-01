package org.example;

public class MaClasse {

    MonInterface iC ;
    public MaClasse(MonInterface maMock) {
            this.iC = maMock;
    }

    public String maMethode() {
        return this.iC.maMethode().toString();
    }
}
