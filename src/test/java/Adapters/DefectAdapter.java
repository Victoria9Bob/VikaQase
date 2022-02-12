package Adapters;

import Models.Defect;
import Models.DefectResult;
import Models.ResponceBody;
import com.google.common.reflect.TypeToken;

public class DefectAdapter extends BaseAdapter{
    final String DEFECT_URI = "defect/";
    public ResponceBody createDefect(Defect defect){
        return gson.fromJson(post(DEFECT_URI,gson.toJson(defect),200),new TypeToken<ResponceBody<Defect>>(){}.getType());
    }
    public ResponceBody getDefect(String projectCode,String defectId,int expectedStatusCode){
        return gson.fromJson(get(DEFECT_URI+projectCode+defectId, expectedStatusCode),new TypeToken<ResponceBody<DefectResult>>(){}.getType());
    }
}
