package eu.bopet.caelus.fx.caelusfx;

import com.dlsc.gmapsfx.GoogleMapView;
import com.dlsc.gmapsfx.MapComponentInitializedListener;
import com.dlsc.gmapsfx.javascript.object.GoogleMap;
import com.dlsc.gmapsfx.javascript.object.LatLong;
import com.dlsc.gmapsfx.javascript.object.MapOptions;
import com.dlsc.gmapsfx.javascript.object.MapTypeIdEnum;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;
import java.util.Properties;
import java.util.ResourceBundle;


public class CaelusFXController implements Initializable, MapComponentInitializedListener {

    protected GoogleMap map;
    private String path;

    @FXML
    private Label pathText;

    @FXML
    private ListView fileList;

    @FXML
    protected GoogleMapView mapView;


    @FXML
    protected void onHelloButtonClick() {
        pathText.setText("Caelus");
    }

    @Override
    public void mapInitialized() {

        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(51.0, 7.0))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(9);
        map = mapView.createMap(mapOptions, false);
        mapView.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        path=System.getProperty("user.dir");
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File f: files){
            System.out.println(" - "+f.getName());
        }
        pathText.setText(path);
        mapView.addMapInitializedListener(this);
        mapView.setKey(getKey());
    }

    private String getKey() {
        try {
            InputStream input = new FileInputStream("coded_api_key");
            Properties prop = new Properties();
            prop.load(input);
            String codedAPIKey = prop.getProperty("CODED_API_KEY");
            return new String(Base64.getDecoder().decode(codedAPIKey));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}