package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    @FXML
    private Button button_1;
    @FXML
    private TextField text_1;
    @FXML
    private TextArea area_1;
    @FXML
    private TextArea area_2;
    @FXML
    private VBox vbox_1;

    public void eventButton(){
        String textStr = text_1.getText();//获取文本框输入的内容
        String area_1Str = area_1.getText();//获取文本框输入的内容
        System.out.print(textStr + "\r\n" + area_1Str);


        if (!"h".equals(text_1.getText())) {
            area_2.setVisible(false);


            TableColumn<Map, String> firstDataColumn = new TableColumn<>("Class A1");
            TableColumn<Map, String> secondDataColumn = new TableColumn<>("Class B");

            firstDataColumn.setCellValueFactory(new MapValueFactory(Column1MapKey));
            firstDataColumn.setMinWidth(130);
            firstDataColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            secondDataColumn.setCellValueFactory(new MapValueFactory(Column2MapKey));
            secondDataColumn.setMinWidth(130);


            TableView table_1 = new TableView<>(generateDataInMap());

            table_1.setEditable(true);
            table_1.getSelectionModel().setCellSelectionEnabled(true);
            table_1.getColumns().setAll(firstDataColumn, secondDataColumn);
            // 多选
            table_1.getSelectionModel().setCellSelectionEnabled(true);
            table_1 .getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            // enable copy/paste
//            TableUtils.installCopyPasteHandler(table_1);

            vbox_1.setVisible(true);

            vbox_1.getChildren().addAll(table_1);
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("information");
//            alert.setContentText("-------");
//            alert.show();
        } else {
            vbox_1.setVisible(false);
            area_2.setVisible(true);
            area_2.setText(textStr + "\r\n" + area_1Str);
        }

    }

    public static final String Column1MapKey = "A";
    public static final String Column2MapKey = "B";

    private ObservableList<Map> generateDataInMap() {
        int max = 10;
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for (int i = 1; i < max; i++) {
            Map<String, String> dataRow = new HashMap<>();

            String value1 = "A" + i;
            String value2 = "B" + i;

            dataRow.put(Column1MapKey, value1);
            dataRow.put(Column2MapKey, value2);

            allData.add(dataRow);
        }
        return allData;
    }

            ;
}
