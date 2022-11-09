package com.evoltech.linecommand.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




// @Document
@Data
// @AllArgsConstructor
@NoArgsConstructor
public class PatientScreened {
    private static final String DELIMITER = "|";
    private static final String SEPARATOR = "\n";
    private String id;
    String  patientId;
    String  gender;
    String  district;
    String  block;
    String  village;
    String  socialMediaPlatform;
    String  birthDate;
    String  familyId;
    String  createdOn;
    String  otherSocialMediaPlatform;
    double  bmi;
    // Campos de test
    float a_g_ratio;
    float alanine_transaminase_sgpt_alt_serum;
    float albumin_serum;
    float alkaline_phosphatase_serum;
    float aspartate_transaminase_sgot_ast_serum;
    float basophils;
    String blood_group;
    float blood_urea;
    float blood_urea_nitrogen;
    float cholesterol_serum;
    float creatinine_serum;
    float direct_bilirubin;
    float direct_bilirubin_serum;
    float eosinophils;
    float folic_acid_assay;
    float globulin_serum;
    float hb_a1c;
    float hdl_cholesterol_serum;
    float hemoglobin;
    float indirect_bilirubin_serum;
    float ldl_hdl_cholesterol_ratio;
    float ldl_cholesterol_serum;
    float lymphocytes;
    float m_c_h;
    float m_c_h_c;
    float m_c_v;
    float monocytes;
    float neutrophils;
    float p_c_v;
    float platelet_count;
    float potassium;
    float prostate_specific_antigen_psa;
    float random_blood_sugar;
    float r_d_w_cv;
    float serum;
    float sgot_sgpt_ratio;
    float sodium;
    float t3_tri_iodothyronine;
    float t4_thyroxine;
    float total_bilirubin;
    float total_bilirubin_serum;
    float total_cholesterol_hdl_cholesterol_ratio;
    float total_cholesterol_serum;
    float total_protein_serum;
    float total_rbc_count;
    float total_wbc_count;
    float triglyceride_serum;
    float tsh;
    float uric_acid_serum;
    float vit_d_assay;
    float vitamin_a_retinol;
    float vitamin_b12;
    float vldl_cholesterol_serum;

    public PatientScreened(
    String uuid,
    String  patientId,
    String  gender,
    String  district,
    String  block,
    String  village,
    String  socialMediaPlatform,
    String  birthDate,
    String  familyId,
    String  createdOn,
    String  otherSocialMediaPlatform,
    double  bmi
    ){
        this.id = uuid;
        this.patientId = patientId;
        this.gender = gender;
        this.district = district;
        this.block = block;
        this.village = village;
        this.socialMediaPlatform = socialMediaPlatform;
        this.birthDate = birthDate;
        this.familyId = familyId;
        this.createdOn = createdOn;
        this.otherSocialMediaPlatform = otherSocialMediaPlatform;
        this.bmi = bmi;
    }


    public void setTests(
            Float a_g_ratio,
            float alanine_transaminase_sgpt_alt_serum,
            float albumin_serum,
            float alkaline_phosphatase_serum,
            float aspartate_transaminase_sgot_ast_serum,
            float basophils,
            String blood_group,
            float blood_urea,
            float blood_urea_nitrogen,
            float cholesterol_serum,
            float creatinine_serum,
            float direct_bilirubin,
            float direct_bilirubin_serum,
            float eosinophils,
            float folic_acid_assay,
            float globulin_serum,
            float hb_a1c,
            float hdl_cholesterol_serum,
            float hemoglobin,
            float indirect_bilirubin_serum,
            float ldl_hdl_cholesterol_ratio,
            float ldl_cholesterol_serum,
            float lymphocytes,
            float m_c_h,
            float m_c_h_c,
            float m_c_v,
            float monocytes,
            float neutrophils,
            float p_c_v,
            float platelet_count,
            float potassium,
            float prostate_specific_antigen_psa,
            float random_blood_sugar,
            float r_d_w_cv,
            float serum,
            float sgot_sgpt_ratio,
            float sodium,
            float t3_tri_iodothyronine,
            float t4_thyroxine,
            float total_bilirubin,
            float total_bilirubin_serum,
            float total_cholesterol_hdl_cholesterol_ratio,
            float total_cholesterol_serum,
            float total_protein_serum,
            float total_rbc_count,
            float total_wbc_count,
            float triglyceride_serum,
            float tsh,
            float uric_acid_serum,
            float vit_d_assay,
            float vitamin_a_retinol,
            float vitamin_b12,
            float vldl_cholesterol_serum
    ){
        this.a_g_ratio = a_g_ratio;
        this.alanine_transaminase_sgpt_alt_serum = alanine_transaminase_sgpt_alt_serum;
        this.albumin_serum = albumin_serum;
        this.alkaline_phosphatase_serum = alkaline_phosphatase_serum;
        this.aspartate_transaminase_sgot_ast_serum = aspartate_transaminase_sgot_ast_serum;
        this.basophils = basophils;
        this.blood_group = blood_group;
        this.blood_urea = blood_urea;
        this.blood_urea_nitrogen = blood_urea_nitrogen;
        this.cholesterol_serum = cholesterol_serum;
        this.creatinine_serum = creatinine_serum;
        this.direct_bilirubin = direct_bilirubin;
        this.direct_bilirubin_serum = direct_bilirubin_serum;
        this.eosinophils = eosinophils;
        this.folic_acid_assay = folic_acid_assay;
        this.globulin_serum = globulin_serum;
        this.hb_a1c = hb_a1c;
        this.hdl_cholesterol_serum = hdl_cholesterol_serum;
        this.hemoglobin = hemoglobin;
        this.indirect_bilirubin_serum = indirect_bilirubin_serum;
        this.ldl_hdl_cholesterol_ratio = ldl_hdl_cholesterol_ratio;
        this.ldl_cholesterol_serum = ldl_cholesterol_serum;
        this.lymphocytes = lymphocytes;
        this.m_c_h = m_c_h;
        this.m_c_h_c = m_c_h_c;
        this.m_c_v = m_c_v;
        this.monocytes = monocytes;
        this.neutrophils = neutrophils;
        this.p_c_v = p_c_v;
        this.platelet_count = platelet_count;
        this.potassium = potassium;
        this.prostate_specific_antigen_psa = prostate_specific_antigen_psa;
        this.random_blood_sugar = random_blood_sugar;
        this.r_d_w_cv = r_d_w_cv;
        this.serum = serum;
        this.sgot_sgpt_ratio = sgot_sgpt_ratio;
        this.sodium = sodium;
        this.t3_tri_iodothyronine = t3_tri_iodothyronine;
        this.t4_thyroxine = t4_thyroxine;
        this.total_bilirubin = total_bilirubin;
        this.total_bilirubin_serum = total_bilirubin_serum;
        this.total_cholesterol_hdl_cholesterol_ratio = total_cholesterol_hdl_cholesterol_ratio;
        this.total_cholesterol_serum = total_cholesterol_serum;
        this.total_protein_serum = total_protein_serum;
        this.total_rbc_count = total_rbc_count;
        this.total_wbc_count = total_wbc_count;
        this.triglyceride_serum = triglyceride_serum;
        this.tsh = tsh;
        this.uric_acid_serum = uric_acid_serum;
        this.vit_d_assay = vit_d_assay;
        this.vitamin_a_retinol = vitamin_a_retinol;
        this.vitamin_b12 = vitamin_b12;
        this.vldl_cholesterol_serum = vldl_cholesterol_serum;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.patientId);
        sb.append(DELIMITER);

        sb.append(this.gender);
        sb.append(DELIMITER);

        sb.append(this.familyId);
        sb.append(DELIMITER);

        sb.append(this.block);
        sb.append(DELIMITER);

        sb.append(this.district);
        sb.append(DELIMITER);

        sb.append(this.village);
        sb.append(DELIMITER);

        sb.append(this.birthDate);
        sb.append(DELIMITER);

        sb.append(this.bmi);
        sb.append(DELIMITER);

        sb.append(this.a_g_ratio);
        sb.append(DELIMITER);

        sb.append(this.alanine_transaminase_sgpt_alt_serum);
        sb.append(DELIMITER);

        sb.append(this.albumin_serum);
        sb.append(DELIMITER);

        sb.append(this.alkaline_phosphatase_serum);
        sb.append(DELIMITER);

        sb.append(this.aspartate_transaminase_sgot_ast_serum);
        sb.append(DELIMITER);

        sb.append(this.basophils);
        sb.append(DELIMITER);

        sb.append(this.blood_group);
        sb.append(DELIMITER);

        sb.append(this.blood_urea);
        sb.append(DELIMITER);

        sb.append(this.blood_urea_nitrogen);
        sb.append(DELIMITER);

        sb.append(this.cholesterol_serum);
        sb.append(DELIMITER);

        sb.append(this.creatinine_serum);
        sb.append(DELIMITER);

        sb.append(this.direct_bilirubin);
        sb.append(DELIMITER);

        sb.append(this.direct_bilirubin_serum);
        sb.append(DELIMITER);

        sb.append(this.eosinophils);
        sb.append(DELIMITER);

        sb.append(this.folic_acid_assay);
        sb.append(DELIMITER);

        sb.append(this.globulin_serum);
        sb.append(DELIMITER);

        sb.append(this.hb_a1c);
        sb.append(DELIMITER);

        sb.append(this.hdl_cholesterol_serum);
        sb.append(DELIMITER);

        sb.append(this.hemoglobin);
        sb.append(DELIMITER);

        sb.append(this.indirect_bilirubin_serum);
        sb.append(DELIMITER);

        sb.append(this.ldl_hdl_cholesterol_ratio);
        sb.append(DELIMITER);

        sb.append(this.ldl_cholesterol_serum);
        sb.append(DELIMITER);

        sb.append(this.lymphocytes);
        sb.append(DELIMITER);

        sb.append(this.m_c_h);
        sb.append(DELIMITER);

        sb.append(this.m_c_h_c);
        sb.append(DELIMITER);

        sb.append(this.m_c_v);
        sb.append(DELIMITER);

        sb.append(this.monocytes);
        sb.append(DELIMITER);

        sb.append(this.neutrophils);
        sb.append(DELIMITER);

        sb.append(this.p_c_v);
        sb.append(DELIMITER);

        sb.append(this.platelet_count);
        sb.append(DELIMITER);

        sb.append(this.potassium);
        sb.append(DELIMITER);

        sb.append(this.prostate_specific_antigen_psa);
        sb.append(DELIMITER);

        sb.append(this.random_blood_sugar);
        sb.append(DELIMITER);

        sb.append(this.r_d_w_cv);
        sb.append(DELIMITER);

        sb.append(this.serum);
        sb.append(DELIMITER);

        sb.append(this.sgot_sgpt_ratio);
        sb.append(DELIMITER);

        sb.append(this.sodium);
        sb.append(DELIMITER);

        sb.append(this.t3_tri_iodothyronine);
        sb.append(DELIMITER);

        sb.append(this.t4_thyroxine);
        sb.append(DELIMITER);

        sb.append(this.total_bilirubin);
        sb.append(DELIMITER);

        sb.append(this.total_bilirubin_serum);
        sb.append(DELIMITER);

        sb.append(this.total_cholesterol_hdl_cholesterol_ratio);
        sb.append(DELIMITER);

        sb.append(this.total_cholesterol_serum);
        sb.append(DELIMITER);

        sb.append(this.total_protein_serum);
        sb.append(DELIMITER);

        sb.append(this.total_rbc_count);
        sb.append(DELIMITER);

        sb.append(this.total_wbc_count);
        sb.append(DELIMITER);

        sb.append(this.triglyceride_serum);
        sb.append(DELIMITER);

        sb.append(this.tsh);
        sb.append(DELIMITER);

        sb.append(this.uric_acid_serum);
        sb.append(DELIMITER);

        sb.append(this.vit_d_assay);
        sb.append(DELIMITER);

        sb.append(this.vitamin_a_retinol);
        sb.append(DELIMITER);

        sb.append(this.vitamin_b12);
        sb.append(DELIMITER);

        sb.append(this.vldl_cholesterol_serum);
        sb.append(SEPARATOR);

        return(sb.toString());
    }

}