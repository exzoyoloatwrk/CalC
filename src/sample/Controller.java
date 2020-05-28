package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField diameter;

    @FXML
    private TextField length;

    @FXML
    private TextField thickness;

    @FXML
    private TextField result;

    @FXML
    private TextField costkg;

    @FXML
    private TextField fabw;

    @FXML
    private TextField quantity;

    @FXML
    private TextField tcost;

    private double dia;
    private double len;
    private double thick;
    private double res;
    private double cstkg;
    private double fab;
    private double quanti;
    private double tcos;

    @FXML
    void runCalc() {

        // get input values
        Double dia = this.hasText(diameter) ? Double.parseDouble(diameter.getText()) : 0.0d;
        Double len =  this.hasText(length) ? Double.parseDouble(length.getText()) : 0.0d;
        Double thick = this.hasText(thickness) ? Double.parseDouble(thickness.getText()) : 0.0d;
        Double quanti = this.hasText(quantity) ? Double.parseDouble(quantity.getText()) : 0.0d;
        Double cstkg = this.hasText(costkg) ? Double.parseDouble(costkg.getText()) : 0.0d;


        // run the calculation
        Double res = calculate(dia, len, thick);
        Double fab = calculateresult(res);
        Double tcos = calculatetotalcost(res, cstkg, quanti);

        // set the result field's text
        result.setText(res.toString());
        fabw.setText(fab.toString());
        tcost.setText(tcos.toString());
    }

    private double calculate(double dia, double len, double thick) {
        double result = 3.14 * dia * len * thick * 8.65 / 1000000;
        return result;
   }

    private double calculateresult( double res) {
        double fabw = (1.15 * res);
        return fabw;
    }

    private double calculatetotalcost(double res, double cstkg, double quanti){
        double tcost = ((res * 1.15 )* cstkg * quanti);
        return tcost;
    }

    /**
     * CheckS if a given input Field IS empty
     * @param input
     * @return
     */
    private boolean hasText(TextField input) {
        return input.getText() != null && !input.getText().trim().isEmpty();
    }

}