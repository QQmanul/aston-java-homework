package ru.aston.homework3.builder;

public class CoffeeType {
    private final String name;
    private final int espressoMl;
    private final int milkMl;
    private final int foamMl;
    private final int sugarGr;
    private final int waterMl;

    private CoffeeType(CoffeeTypeBuilder builder) {
        this.name = builder.name;
        this.espressoMl = builder.espressoMl;
        this.waterMl = builder.waterMl;
        this.milkMl = builder.milkMl;
        this.foamMl = builder.foamMl;
        this.sugarGr = builder.sugarGr;
    }

    public static CoffeeTypeBuilder builder(String name, int espressoMl) {
        return new CoffeeTypeBuilder(name, espressoMl);
    }

    public int getWaterMl() {
        return waterMl;
    }

    public String getName() {
        return name;
    }

    public int getEspressoMl() {
        return espressoMl;
    }

    public int getMilkMl() {
        return milkMl;
    }

    public int getFoamMl() {
        return foamMl;
    }

    public int getSugarGr() {
        return sugarGr;
    }

    public static class CoffeeTypeBuilder {
        private int waterMl;
        private String name;
        private int espressoMl;
        private int milkMl;
        private int foamMl;
        private int sugarGr;

        public CoffeeTypeBuilder(String name, int espressoMl) {
            this.name = name;
            this.espressoMl = espressoMl;
        }

        public CoffeeTypeBuilder setWaterMl(int waterMl) {
            this.waterMl = waterMl;
            return this;
        }

        public CoffeeTypeBuilder setMilkAndFoam(int milkMl, int foamMl) {
            this.milkMl = milkMl;
            this.foamMl = foamMl;
            return this;
        }

        public CoffeeTypeBuilder setSugarGr(int sugarGr) {
            this.sugarGr = sugarGr;
            return this;
        }

        public CoffeeType build() {
            return new CoffeeType(this);
        }
    }

    @Override
    public String toString() {
        return "Состав  " + name + ":" +
                "Эспрессо=" + espressoMl +
                " мл, Горячая вода=" + waterMl +
                " мл, Молоко=" + milkMl +
                " мл, Молочная пена=" + foamMl +
                " мл, Сахар=" + sugarGr + "гр";
    }
}
