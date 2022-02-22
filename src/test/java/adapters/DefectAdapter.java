package adapters;

import com.google.common.reflect.TypeToken;
import models.CreateDefectResult;
import models.Defect;
import models.DefectResult;
import models.ResponceBody;

public class DefectAdapter extends BaseAdapter {
    final String DEFECT_URI = "defect/";

    public ResponceBody<DefectResult> getDefect(String projectCode, int defectId, int expectedStatusCode) {
        return gson.fromJson(get(DEFECT_URI + projectCode + defectId, expectedStatusCode), new TypeToken<ResponceBody<DefectResult>>() {
        }.getType());
    }

    public ResponceBody<Defect> createDefect(String defectCode, Defect defect) {
        return gson.fromJson(post(DEFECT_URI + defectCode, gson.toJson(defect), 200), new TypeToken<ResponceBody<CreateDefectResult>>() {
        }.getType());
    }

}
