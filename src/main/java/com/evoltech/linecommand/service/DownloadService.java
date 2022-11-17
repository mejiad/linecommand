package com.evoltech.linecommand.service;

import com.evoltech.linecommand.model.PatientBase;
import com.evoltech.linecommand.model.PatientScreened;
import com.evoltech.linecommand.model.Test;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final String DELIMITER = "|";
    private static final String SEPARATOR = "\n";
    String blood_group = "NA";

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
        values.put("A/G Ratio", -1.0f);
        values.put("Alanine Transaminase (SGPT/ALT) - Serum", -1.0f);
        values.put("Albumin - Serum", -1.0f);
        values.put("Alkaline Phosphatase - Serum", -1.0f);
        values.put("Aspartate Transaminase (SGOT/AST) - Serum", -1.0f);
        // "Basophils",
        // blood_group,
        values.put("Blood Urea", -1.0f);
        values.put("Blood Urea Nitrogen", -1.0f);
        values.put("Cholesterol - Serum", -1.0f);
        values.put("Creatinine - Serum", -1.0f);
        values.put("Direct Bilirubin", -1.0f);  // ****
        values.put("Direct Bilirubin - Serum", -1.0f);  // ****
        values.put("Eosinophils", -1.0f);
        values.put("Folic Acid assay", -1.0f);
        values.put("Globulin - Serum", -1.0f);
        values.put("HbA1c", -1.0f);
        values.put("HDL Cholesterol - Serum", -1.0f);
        values.put("Hemoglobin", -1.0f);
        values.put("Indirect Bilirubin - Serum", -1.0f);
        values.put("LDL / HDL Cholesterol Ratio", -1.0f);
        values.put("LDL Cholesterol - Serum", -1.0f);
        values.put("Lymphocytes", -1.0f);
        values.put("M.C.H.", -1.0f);
        values.put("M.C.H.C", -1.0f);
        values.put("M.C.V.", -1.0f);
        values.put("Monocytes", -1.0f);
        values.put("Neutrophils", -1.0f);
        values.put("P.C.V.", -1.0f);
        values.put("Platelet count", -1.0f);
        values.put("Potassium", -1.0f);
        values.put("Prostate Specific Antigen (PSA)", -1.0f);   // ***
        values.put("Random Blood Sugar", -1.0f);
        values.put("R.D.W. CV", -1.0f);
        values.put("SGOT / SGPT Ratio", -1.0f);
        values.put("Sodium", -1.0f);                           // *****
        values.put("T3 (Tri-iodothyronine)", -1.0f);
        values.put("T4 (Thyroxine)", -1.0f);
        values.put("Total Bilirubin", -1.0f);
        values.put("Total Bilirubin - Serum", -1.0f);
        values.put("Total Cholesterol / HDL Cholesterol Ratio", -1.0f);
        values.put("Total Cholesterol - Serum", -1.0f);
        values.put("Total Protein - Serum", -1.0f);
        values.put("Total RBC Count", -1.0f);
        values.put("Total WBC Count", -1.0f);
        values.put("Triglyceride - Serum", -1.0f);
        values.put("TSH", -1.0f);
        values.put("Uric Acid - Serum", -1.0f);
        values.put("Vit D assay", -1.0f);
        values.put("Vitamin A Retinol", -1.0f);
        values.put("Vitamin B12 - Serum", -1.0f);
        values.put("VLDL Cholesterol - Serum", -1.0f);
    }

    public void savePatients(String filename) {
        try {
            var file = new FileWriter(filename, false);

            file.append(getHeader());

            for (PatientScreened p : patientsList) {
                // log.info(p.getPatientId() + " DirectBilirubinSerum: " + p.getDirect_bilirubin_serum());
                file.append(p.toString());
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
                savePatients("data_tmp.csv");
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
        JSONArray jsonArrayAll  = null;
        try {
            jsonArrayAll = jsonArray.getJSONArray("data");
            log.warn("jsonArrayAll length: " + jsonArrayAll.length());
            // log.warn("all pacientes: " + jsonArrayAll.toString(4));
        } catch(Exception ex){
            log.error("Error en " + patientScreened.getPatientId() );
            throw new RuntimeException(ex);
        }

            for (var i=0; i < jsonArrayAll.length(); i++){
                JSONObject obj = null;
                try {
                    obj = jsonArrayAll.getJSONObject(i);
                } catch(Exception e){
                    log.error("Error al obtener el objeto");
                }
                try {
                    var patient = obj.getJSONObject("patient");
                    log.info("Patient to process:" + patient.getString("patientId"));
                    patientScreened = convertPatientTests(patient);
                    log.info("After convertPatientTests");
                }  catch(Exception e){
                    log.error("Error al obtener el paciente " +  e);
                }
                List<Test> tests = null;
                    initializeValues();
                    // log.info("Before Test results: " + obj.getJSONArray("testResult"));
                try {
                    tests = processResults(patientScreened, obj.getJSONArray("testResult"));
                    // log.info("After processResults:" + obj.getJSONArray("testResult"));
                    // #### TODO agregar tes 20  Total Protein - Serum Valor:6.9

                    patientScreened.setTests(
                            values.get("A/G Ratio"),
                            values.get("Alanine Transaminase (SGPT/ALT) - Serum"),
                            values.get("Albumin - Serum"),
                            values.get("Alkaline Phosphatase - Serum"),
                            values.get("Aspartate Transaminase (SGOT/AST) - Serum"),
                            "Basophils",
                            blood_group,
                            values.get("Blood Urea"),
                            values.get("Blood Urea Nitrogen"),
                            values.get("Cholesterol - Serum"),
                            values.get("Creatinine - Serum"),
                            values.get("Direct Bilirubin"),  // ****
                            values.get("Direct Bilirubin - Serum"),  // ****
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
                            values.get("Prostate Specific Antigen (PSA)"),   // ***
                            values.get("Random Blood Sugar"),
                            values.get("R.D.W. CV"),
                            values.get("SGOT / SGPT Ratio"),
                            values.get("Sodium"),                           // *****
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
                            values.put("Vitamin B12, Serum", -1.0f),
                            values.get("VLDL Cholesterol - Serum")
                    );
                    patientsList.add(patientScreened);
                } catch (Exception ex){
                    log.error("There is no tests");
                }
            }
        // log.info("TEST NAMES");
        log.info(testnames.toString());
    }

    private PatientScreened convertPatientTests(JSONObject patientArg) {
        JSONObject patient = patientArg;
        PatientScreened patientObj = null;
        try {
            var familyId = patient.getString("familyId");
            var gender= patient.getString("gender");
            var birthDate = patient.getString("birthDate");
            var patientId = patient.getString("patientId");
            var createdOn = patient.getString("_createdOn");
            var district = patient.optJSONObject("district").getString("name");
            var block = patient.optJSONObject("block").getString("name");
            var village = patient.optJSONObject("village").getString("name");
            var bmi = patient.optString("bmi");
            log.info("PatientArg BMI: " + bmi);

            String socialMediaPlatform = null;
            try {
                socialMediaPlatform = patient.getString("socialMediaPlatform");
            } catch (JSONException ex){
                log.warn("No social media platform for "  + patientId);
                socialMediaPlatform = "NA";
            }
            String otherSocialMediaPlatform;

            try {
                otherSocialMediaPlatform = patient.getString("otherSocialMediaPlatform");
            } catch (JSONException ex){
                otherSocialMediaPlatform = "N/A";
                log.error("other social media platform invalid");
            }
            log.warn("PatientId: " + patientId);
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
                    Double.parseDouble(bmi)
            );
        } catch (JSONException jex){
            log.error("After create patientObj");
        }
        log.info("Before return convertPatientsTest");
        return patientObj;
    }

    private List<Test> processResults(PatientScreened patient, JSONArray resultsArray) {
        JSONObject jsonTest = null;
        String test_name = "";
        String test_val = "";
        String unit = "";
        String ref_range;
        String test_datetime;
        String abnormalFlag;
        List<Test> testList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9.+-]*", Pattern.CASE_INSENSITIVE);

        for (var i = 0; i < resultsArray.length(); i++) {
            try {
                jsonTest = resultsArray.getJSONObject(i);
            } catch (JSONException jex) {
                log.error("No results array");
            }
            try {
                abnormalFlag = jsonTest.getString("abnormalFlag");
            } catch (JSONException jex) {
                // log.error("No value for abnormal flag");
                abnormalFlag = "N/A";
            }
            try {
                test_name = jsonTest.getString("test_name");
                // log.info("TEST NAME:" + test_name);
                testnames.add(test_name);
            } catch (JSONException jex) {
                log.error("Missing test name");
            }
            try {
                test_val = jsonTest.getString("test_val");
                if (test_name.matches("Blood Group")) {
                    // log.error("DENTRO de BLOOD Group:" + test_val);
                    test_val = test_val.replaceAll("\"", "\'");
                    blood_group = test_val;
                } else {
                    test_val = test_val.replaceAll("\\s", "");
                    test_val = test_val.replaceAll("<", "");
                    test_val = test_val.replaceAll(">", "");
                    Matcher matcher = pattern.matcher(test_val);
                    boolean matchFound = matcher.find();
                    if (!matchFound) {
                        log.error("String NO encontrado" + test_val);
                    }
                }
            } catch (JSONException jex) {
                log.error("Test val convertion error");
            }
            try {
                unit = jsonTest.getString("unit");
            } catch (JSONException jex) {
                log.error("Missing units");
            }
            try {
                ref_range = jsonTest.getString("ref_range");
                // log.warn("ref range name:" + ref_range);
            } catch (JSONException jex) {
                // log.error("There isn't ref_range value.");
                ref_range = "N/A";
            }
            try {
                test_datetime = jsonTest.getString("test_datetime");
            } catch (JSONException jex) {
                log.error("There isn't test_datetime value.");
                test_datetime = "N/A";
            }
            //log.warn("test_name:" + test_name + " test_val: " + test_val );
            // log.info(test_name, " - ", test_val);
            String uuid = UUID.randomUUID().toString();
            Test panelTest = new Test(null,
                    uuid,
                    abnormalFlag,
                    ref_range,
                    test_datetime,
                    test_name,
                    test_val,
                    unit
            );
            testList.add(panelTest);
            if (test_name.matches("Blood Group")) {
                blood_group = test_val;
            } else {
                log.warn("Asignando:" + test_name + ": Valor:" + test_val);
                values.put(test_name, Float.parseFloat(test_val));
            }
        }
        return testList;
    }


    public String getHeader(){
        StringBuilder sb = new StringBuilder();

        sb.append("patient_id"); sb.append(DELIMITER);
        sb.append("gender"); sb.append(DELIMITER);
        sb.append("family_id"); sb.append(DELIMITER);
        sb.append("block"); sb.append(DELIMITER);
        sb.append("district"); sb.append(DELIMITER);
        sb.append("village"); sb.append(DELIMITER);
        sb.append("birth_date"); sb.append(DELIMITER);
        sb.append("bmi"); sb.append(DELIMITER);

        sb.append("a_g_ratio"); sb.append(DELIMITER);
        sb.append("alanine_transaminase_sgpt_alt_serum"); sb.append(DELIMITER);
        sb.append("albumin_serum"); sb.append(DELIMITER);
        sb.append("alkaline_phosphatase_serum"); sb.append(DELIMITER);
        sb.append("aspartate_transaminase_sgot_ast_serum"); sb.append(DELIMITER);
        sb.append("basophils"); sb.append(DELIMITER);
        sb.append("blood_group"); sb.append(DELIMITER);
        sb.append("blood_urea"); sb.append(DELIMITER);
        sb.append("blood_urea_nitrogen"); sb.append(DELIMITER);
        sb.append("cholesterol_serum"); sb.append(DELIMITER);
        sb.append("creatinine_serum"); sb.append(DELIMITER);
        sb.append("direct_bilirubin"); sb.append(DELIMITER);
        sb.append("direct_bilirubin_serum"); sb.append(DELIMITER);
        sb.append("eosinophils"); sb.append(DELIMITER);
        sb.append("folic_acid_assay"); sb.append(DELIMITER);
        sb.append("globulin_serum"); sb.append(DELIMITER);
        sb.append("hb_a1c"); sb.append(DELIMITER);
        sb.append("hdl_cholesterol_serum"); sb.append(DELIMITER);
        sb.append("hemoglobin"); sb.append(DELIMITER);
        sb.append("indirect_bilirubin_serum"); sb.append(DELIMITER);
        sb.append("ldl_hdl_cholesterol_ratio"); sb.append(DELIMITER);
        sb.append("ldl_cholesterol_serum"); sb.append(DELIMITER);
        sb.append("lymphocytes"); sb.append(DELIMITER);
        sb.append("m_c_h"); sb.append(DELIMITER);
        sb.append("m_c_h_c"); sb.append(DELIMITER);
        sb.append("m_c_v"); sb.append(DELIMITER);
        sb.append("monocytes"); sb.append(DELIMITER);
        sb.append("neutrophils"); sb.append(DELIMITER);
        sb.append("p_c_v"); sb.append(DELIMITER);
        sb.append("platelet_count"); sb.append(DELIMITER);
        sb.append("potassium"); sb.append(DELIMITER);
        sb.append("prostate_specific_antigen_psa"); sb.append(DELIMITER);
        sb.append("random_blood_sugar"); sb.append(DELIMITER);
        sb.append("r_d_w_cv"); sb.append(DELIMITER);
        sb.append("sgot_sgpt_ratio"); sb.append(DELIMITER);
        sb.append("sodium"); sb.append(DELIMITER);
        sb.append("t3_tri_iodothyronine"); sb.append(DELIMITER);
        sb.append("t4_thyroxine"); sb.append(DELIMITER);
        sb.append("total_bilirubin"); sb.append(DELIMITER);
        sb.append("total_bilirubin_serum"); sb.append(DELIMITER);
        sb.append("total_cholesterol_hdl_cholesterol_ratio"); sb.append(DELIMITER);
        sb.append("total_cholesterol_serum"); sb.append(DELIMITER);
        sb.append("total_protein_serum"); sb.append(DELIMITER);
        sb.append("total_rbc_count"); sb.append(DELIMITER);
        sb.append("total_wbc_count"); sb.append(DELIMITER);
        sb.append("triglyceride_serum"); sb.append(DELIMITER);
        sb.append("tsh"); sb.append(DELIMITER);
        sb.append("uric_acid_serum"); sb.append(DELIMITER);
        sb.append("vitamin_a_retinol"); sb.append(DELIMITER);
        sb.append("vitamin_b12_serum"); sb.append(DELIMITER);
        sb.append("vit_d_assay"); sb.append(DELIMITER);
        sb.append("vldl_cholesterol_serum"); sb.append(SEPARATOR);

        return(sb.toString());
    }
}
