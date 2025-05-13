package service.indicator;

public class IndicatorPrint {

    private IndicatorManager indicatorManager;

    public IndicatorPrint(IndicatorManager indicatorManager) {
        this.indicatorManager = indicatorManager;
    }

    public void print(IndicatorResult result) {
        System.out.println("Gösterge : " + result.getIndicator().getColor() + " -> " + result.getIndicator().getNumber());
        System.out.println("Okey     : " + result.getOkey().getColor() + " -> " + result.getOkey().getNumber());
    }
}
