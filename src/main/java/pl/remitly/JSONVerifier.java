package pl.remitly;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONVerifier {

    /**Verifies whether json input is correct (according to AWS::IAM::Role Policy) and if it is method checks
     * whether JSON Resource field contains a single asterisk , if not it returns True
     * @param jsonObject json input data
     * @return boolean
     **/
    protected boolean verify(JSONObject jsonObject) {
        if(!jsonObject.has("PolicyName")) {return false;}
        String policyName = jsonObject.get("PolicyName").toString();
        if(policyName.isEmpty() || policyName.length() > 128) {return false;}
        if(!policyName.matches("[\\w+=,.@-]+")){return false;}
        if(!jsonObject.has("PolicyDocument")) {return false;}
        try{
            jsonObject.getJSONObject("PolicyDocument");
        }catch (JSONException e){
            return false;
        }
        if(!jsonObject.getJSONObject("PolicyDocument").has("Statement")){return false;}
        for(int i=0; i< jsonObject.getJSONObject("PolicyDocument").getJSONArray("Statement").length(); i++){
            var x = (JSONObject) jsonObject.getJSONObject("PolicyDocument").getJSONArray("Statement").get(i);
            if(!x.has("Resource")){return false;}
            if(x.get("Resource").toString().equals("*")){return false;}
        }
        return true;
    }
}
