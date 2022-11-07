package com.evoltech.linecommand.service;

import com.evoltech.linecommand.model.PatientBase;
import com.evoltech.linecommand.model.PatientScreened;
import com.evoltech.linecommand.model.Test;
import com.evoltech.linecommand.repository.PatientRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DownloadService implements DownloadServiceInterface {
    Logger log = LoggerFactory.getLogger(DownloadService.class);

    // @Autowired
    // PatientRepository patientRepository;

    Hashtable<String, PatientBase> hashtablePatients = new Hashtable<>();

    HashMap<String, Float> values = new HashMap<>();
    HashSet<String> testnames = new HashSet<>();

    ArrayList<PatientScreened> patientsList = new ArrayList<>();

    public String getStringFromService(){
        return "<<<<< String from service >>>>>";
    }

    @Override
    public void downloadFromRemoteServer() {
        log.info("Dentro de download from Remote server");
        initializeValues();
        getJSONScreenedData();
    }

    public void initializeValues() {
        values.put("Direct Bilirubin - Serum", 0.0f);
        values.put("Blood Urea Nitrogen", 0.0f);
        values.put("Total Bilirubin", 0.0f);
        values.put("Total Bilirubin - Serum", 0.0f);
        values.put("Prostate Specific Antigen (PSA) ", 0.0f);
        values.put("M.C.H.C", 0.0f);
        values.put("Vit D assay", 0.0f);
        values.put("Hemoglobin", 0.0f);
        values.put("Triglyceride - Serum", 0.0f);
        values.put("Alanine Transaminase (SGPT/ALT) - Serum", 0.0f);
        values.put("Globulin - Serum", 0.0f);
        values.put("Total RBC Count", 0.0f);
        values.put("SGOT / SGPT Ratio", 0.0f);
        values.put("Random Blood Sugar", 0.0f);
        values.put("Sodium ", 0.0f);
        values.put("M.C.V.", 0.0f);
        values.put("TSH", 0.0f);
        values.put("Direct Bilirubin ", 0.0f);
        values.put("P.C.V.", 0.0f);
        values.put("Uric Acid - Serum", 0.0f);
        values.put("Vitamin A Retinol", 0.0f);
        values.put("VLDL Cholesterol - Serum", 0.0f);
        values.put("Basophils", 0.0f);
        values.put("Albumin - Serum", 0.0f);
        values.put("LDL Cholesterol - Serum", 0.0f);
        values.put("Total WBC Count", 0.0f);
        values.put("Total Cholesterol / HDL Cholesterol Ratio", 0.0f);
        values.put("Creatinine - Serum", 0.0f);
        values.put("Eosinophils", 0.0f);
        values.put("Indirect Bilirubin - Serum", 0.0f);
        values.put("Blood Urea", 0.0f);
        values.put("Cholesterol - Serum", 0.0f);
        values.put("R.D.W. CV", 0.0f);
        values.put("Folic Acid assay", 0.0f);
        values.put("Lymphocytes", 0.0f);
        values.put("Alkaline Phosphatase - Serum", 0.0f);
        values.put("A/G Ratio", 0.0f);
        values.put("Aspartate Transaminase (SGOT/AST) - Serum", 0.0f);
        values.put("Vitamin B12", 0.0f);
        values.put("Serum", 0.0f);
        values.put("HbA1c", 0.0f);
        values.put("Total Cholesterol - Serum", 0.0f);
        values.put("Platelet count", 0.0f);
        values.put("T4 (Thyroxine)", 0.0f);
        values.put("Neutrophils", 0.0f);
        values.put("T3 (Tri-iodothyronine)", 0.0f);
        values.put("LDL / HDL Cholesterol Ratio", 0.0f);
        values.put("Total Protein - Serum", 0.0f);
        values.put("Blood Group", 0.0f);
        values.put("Monocytes", 0.0f);
        values.put("HDL Cholesterol - Serum", 0.0f);
        values.put("Potassium", 0.0f);
        values.put("M.C.H.", 0.0f);
    }

    public void savePatients(){
        var file = new FileWriter("data.csv");

        Iterator<PatientScreened> iter = patientsList.iterator();

        while(iter.hasNext()){
            PatientScreened p = iter.next();
            log.info(p.getPatientId() + " AG.Ratio:" + p.getA_g_ratio());
        }
    }

    @Override
    public void deleteAllPatientsScreened() {
        log.info("Dentro de delete all patients Screened");
    }

    private String getJSONScreenedData() {
        log.warn("Call download function");
        var uriProduction = "https://svmapi.mayamd.ai/api/v1/export_screened_member_data";
        HttpResponse<String> response = null;
        var bodyHandler = HttpResponse.BodyHandlers.ofString(Charset.defaultCharset());
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            /* Ejemplo de request con el POST
            HttpRequest request = HttpRequest.newBuilder() .uri(URI.create(uriStr)) .header("client_id", "SURAKSHA_CLIENT") .header("key", "ea617dcdfbd5ccf00b14beab9764ad39ff57849f11eb02f46362ea864f16195be3e254ac3a722b9756ff3a622ff28b701f7ae4d00d84eac9af6bd4009b9e80ad") .header("authorization", "1234567890123456") .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("salida.json"))) .build();
             */
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uriProduction))
                    .header("client_id", "EVOL_TECH")
                    .header("key", "2b1d0c961bf940e37b582e88ca22a2fe698e68f651a226eae32c9f8093c70e139e3ef1125c71457e5e1c3c42916f72535b0078818de868e065b728024c40b350" )
                    .header("Cookie", "GCLB=CPO6hNGJz-vcyQE")
                    .build();

            // response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
            response = httpClient.send(request, bodyHandler);
            var respHeaders = response.headers();
            log.warn(respHeaders.toString());
        } catch (InterruptedException ioe) {
            throw new RuntimeException(ioe);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(response.statusCode() == 200){
            try {
                JSONObject jsonObjectArray = new JSONObject(response.body());
                processJsonArray(jsonObjectArray);
                savePatients();
            } catch (Exception ioe){
                throw new RuntimeException(ioe);
            }
        } else {
            log.warn("Error HTTP con codigo " + response.statusCode());
        }
        return ("Mi JSON");
    }

    private void processJsonArray(JSONObject jsonArray) {
        PatientScreened patientScreened  = null;
        try {
            JSONArray jsonArrayAll = jsonArray.getJSONArray("data");
            log.warn("jsonArrayAll length: " + jsonArrayAll.length());
            // log.warn("all pacientes: " + jsonArrayAll.toString(4));
            for (var i=0; i < jsonArrayAll.length(); i++){
                JSONObject obj = null;
                try {
                    obj = jsonArrayAll.getJSONObject(i);
                } catch(Exception e){
                    log.error("Error al obtener el objeto");
                }
                try {
                    var patient = obj.getJSONObject("patient");
                    patientScreened = convertPatientTests(patient);
                }  catch(Exception e){
                    log.error("Error al obtener el paciente " +  e);
                }
                List<Test> tests = null;
                try {
                    initializeValues();
                    tests = processResults(patientScreened, obj.getJSONArray("testResult"));
                    // #### TODO agregar test
                    patientScreened.setTests(
                            values.get("A/G Ratio"),
                            values.get("Alanine Transaminase (SGPT/ALT) - Serum"),
                            values.get("Albumin - Serum"),
                            values.get("Alkaline Phosphatase - Serum"),
                            values.get("Aspartate Transaminase (SGOT/AST) - Serum"),
                            values.get("Basophils"),
                            values.get("Blood Group"),
                            values.get("Blood Urea"),
                            values.get("Blood Urea Nitrogen"),
                            values.get("Cholesterol - Serum"),
                            values.get("Creatinine - Serum"),
                            values.get("Direct Bilirubin "),
                            values.get("Direct Bilirubin - Serum"),
                            values.get("Eosinophils"),
                            values.get("Folic Acid assay"),
                            values.get("Globulin - Serum"),
                            values.get("HbA1c"),
                            values.get("HDL Cholesterol - Serum"),
                            values.get("Hemoglobin"),
                            values.get("Indirect Bilirubin - Serum"),
                            values.get("LDL / HDL Cholesterol Ratio"),
                            values.get("LDL Cholesterol - Serum"),
                            values.get("Lymphocytes"),
                            values.get("M.C.H."),
                            values.get("M.C.H.C"),
                            values.get("M.C.V."),
                            values.get("Monocytes"),
                            values.get("Neutrophils"),
                            values.get("P.C.V."),
                            values.get("Platelet count"),
                            values.get("Potassium"),
                            values.get("Prostate Specific Antigen (PSA) "),
                            values.get("Random Blood Sugar"),
                            values.get("R.D.W. CV"),
                            values.get("Serum"),
                            values.get("SGOT / SGPT Ratio"),
                            values.get("Sodium "),
                            values.get("T3 (Tri-iodothyronine)"),
                            values.get("T4 (Thyroxine)"),
                            values.get("Total Bilirubin"),
                            values.get("Total Bilirubin - Serum"),
                            values.get("Total Cholesterol / HDL Cholesterol Ratio"),
                            values.get("Total Cholesterol - Serum"),
                            values.get("Total Protein - Serum"),
                            values.get("Total RBC Count"),
                            values.get("Total WBC Count"),
                            values.get("Triglyceride - Serum"),
                            values.get("TSH"),
                            values.get("Uric Acid - Serum"),
                            values.get("Vit D assay"),
                            values.get("Vitamin A Retinol"),
                            values.get("Vitamin B12"),
                            values.get("VLDL Cholesterol - Serum")

                    );
                } catch(Exception e){
                    log.error("Missing test results for patient:" + patientScreened.getPatientId()) ;
                }
                patientsList.add(patientScreened);
                log.info("Patient data:");
                //log.info(patientScreened.toString());
            }
            log.warn("jsonArrayAll length 2: " + jsonArrayAll.length());
        } catch(Exception ex){
            log.warn("Error en " + patientScreened.getPatientId() );
            // throw new RuntimeException(ex);
        }
        log.info("TEST NAMES");
        log.info(testnames.toString());
    }

    private PatientScreened convertPatientTests(JSONObject patientArg) {
        JSONObject patient = patientArg;
        PatientScreened patientObj;
        try {
            var familyId = patient.getString("familyId");
            var gender= patient.getString("gender");
            var birthDate = patient.getString("birthDate");
            var patientId = patient.getString("patientId");
            var createdOn = patient.getString("_createdOn");
            var district = patient.optJSONObject("district").getString("name");
            var block = patient.optJSONObject("block").getString("name");
            var village = patient.optJSONObject("village").getString("name");
            String socialMediaPlatform = null;
            try {
                socialMediaPlatform = patient.getString("socialMediaPlatform");
            } catch (JSONException ex){
                // log.warn("No social media platform for "  + patientId);
                socialMediaPlatform = "NA";
            }
            String otherSocialMediaPlatform;

            try {
                otherSocialMediaPlatform = patient.getString("otherSocialMediaPlatform");
            } catch (JSONException ex){
                otherSocialMediaPlatform = "N/A";
                // log.error("other social media platform invalid");
            }
            // log.warn("PatientId: " + patientId);
            if(hashtablePatients.contains(patientId)){
                log.error("Duplicate patientId for:" + patientId);
            } else {
                // no existe
            }
            UUID uuid = UUID.randomUUID();
            List<Test> listTest = new ArrayList<>();
            PatientBase base = hashtablePatients.get(patientId);
            patientObj = new PatientScreened(
                    uuid.toString(),
                    patientId,
                    gender,
                    district,
                    block,
                    village,
                    socialMediaPlatform,
                    birthDate,
                    familyId,
                    createdOn,
                    otherSocialMediaPlatform,
                    20 // base.getBmi()
            );
        } catch (JSONException jex){
            throw new RuntimeException(jex);
        }
        return patientObj;
    }

    private List<Test> processResults(PatientScreened patient, JSONArray resultsArray) throws JSONException {
        JSONObject jsonTest;
        String test_name;
        String test_val;
        String unit;
        String ref_range;
        String test_datetime;
        String abnormalFlag;
        List<Test> testList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9.+-]*", Pattern.CASE_INSENSITIVE);
        for (var i = 0; i < resultsArray.length(); i++){
            try {
                jsonTest = resultsArray.getJSONObject(i);
            } catch(JSONException jex){
                throw new RuntimeException(jex);
            }
            try {
                abnormalFlag = jsonTest.getString("abnormalFlag");
            } catch(JSONException jex){
                // log.error("No value for abnormal flag");
                abnormalFlag = "N/A";
            }
            try {
                test_name = jsonTest.getString("test_name");
                //log.info("TEST NAME:" + test_name);
                testnames.add(test_name);
            } catch(JSONException jex){
                throw new RuntimeException(jex);
            }
            try {
                test_val = jsonTest.getString("test_val");
                test_val = test_val.replaceAll("\\s", "" );
                Matcher matcher = pattern.matcher(test_val);
                boolean matchFound = matcher.find();
                if (!matchFound){
                    log.error("String NO encontrado" + test_val);
                }
            } catch(JSONException jex){
                throw new RuntimeException(jex);
            }
            try {
                unit = jsonTest.getString("unit");
            } catch(JSONException jex){
                throw new RuntimeException(jex);
            }
            try {
                ref_range = jsonTest.getString("ref_range");
                // log.warn("ref range name:" + ref_range);
            } catch(JSONException jex){
                // log.error("There isn't ref_range value.");
                ref_range = "N/A";
            }
            try {
                test_datetime = jsonTest.getString("test_datetime");
            } catch(JSONException jex){
                // log.error("There isn't test_datetime value.");
                test_datetime = "N/A";
            }
            /*
            log.warn("test_name:" +
                " test_val: " + test_val +
                " unit: " + unit +
                " ref_range: " + ref_range +
                " test_datetime: " + test_datetime);
             */
            String uuid = UUID.randomUUID().toString();
            Test panelTest = new Test(null,
                    uuid,
                    abnormalFlag,
                    ref_range,
                    test_datetime.toString(),
                    test_name,
                    test_val,
                    unit
                    // patient
            );
            testList.add(panelTest);
            values.put(test_name, Float.parseFloat(test_val));
            // testRepository.save(panelTest);
        }
        return testList;
    }

}
