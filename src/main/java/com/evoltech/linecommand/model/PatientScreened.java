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
    float blood_group;
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
            float a_g_ratio,
            float alanine_transaminase_sgpt_alt_serum,
            float albumin_serum,
            float alkaline_phosphatase_serum,
            float aspartate_transaminase_sgot_ast_serum,
            float basophils,
            float blood_group,
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
        sb.append("patientId:");
        sb.append(this.patientId);
        sb.append(" Gender:");
        sb.append(this.gender);
        sb.append(" Village:");
        sb.append(this.village);
        sb.append(" BirthDate:");
        sb.append(this.birthDate);
        sb.append(" BMI:");
        sb.append(this.bmi);

        sb.append(" a_g_ratio");
        sb.append(this.a_g_ratio);

        sb.append(" alanine_transaminase_sgpt_alt_serum");
        sb.append(this.alanine_transaminase_sgpt_alt_serum);

        sb.append(" albumin_serum");
        sb.append(this.albumin_serum);

        sb.append(" alkaline_phosphatase_serum:");
        sb.append(this.alkaline_phosphatase_serum);

        sb.append(" aspartate_transaminase_sgot_ast_serum");
        sb.append(this.aspartate_transaminase_sgot_ast_serum);

        sb.append(" basophils");
        sb.append(this.basophils);

        sb.append(" blood_group");
        sb.append(this.blood_group);

        sb.append(" blood_urea:");
        sb.append(this.blood_urea);

        sb.append(" blood_urea_nitrogen");
        sb.append(this.blood_urea_nitrogen);

        sb.append(" cholesterol_serum");
        sb.append(this.cholesterol_serum);

        sb.append(" creatinine_serum");
        sb.append(this.creatinine_serum);

        sb.append(" direct_bilirubin");
        sb.append(this.direct_bilirubin);

        sb.append(" direct_bilirubin_serum");
        sb.append(this.direct_bilirubin_serum);

        sb.append( "eosinophils");
        sb.append(this.eosinophils);

        sb.append( " folic_acid_assay:");
        sb.append(this.folic_acid_assay);

        sb.append(" globulin_serum:");
        sb.append(this.globulin_serum);

        sb.append( " hb_a1c:");
        sb.append(this.hb_a1c);

        sb.append( " hdl_cholesterol_serum:");
        sb.append(this.hdl_cholesterol_serum);

        sb.append( " hemoglobin:");
        sb.append(this.hemoglobin);

        sb.append( " indirect_bilirubin_serum:");
        sb.append(this.indirect_bilirubin_serum);

        sb.append( " ldl_hdl_cholesterol_ratio:");
        sb.append(this.ldl_hdl_cholesterol_ratio);

        sb.append( " ldl_cholesterol_serum:");
        sb.append(this.ldl_cholesterol_serum);

        sb.append( " lymphocytes:");
        sb.append(this.lymphocytes);

        sb.append( " m_c_h:");
        sb.append(this.m_c_h);

        sb.append( " m_c_h_c:");
        sb.append(this.m_c_h_c);

        sb.append( " m_c_v:");
        sb.append(this.m_c_v);

        sb.append( " monocytes:");
        sb.append(this.monocytes);

        sb.append( " neutrophils:");
        sb.append(this.neutrophils);

        sb.append( " p_c_v:");
        sb.append(this.p_c_v);

        sb.append( " platelet_count.");
        sb.append(this.platelet_count);

        sb.append( " potassium");
        sb.append(this.potassium);

        sb.append( " prostate_specific_antigen_psa:");
        sb.append(this.prostate_specific_antigen_psa);

        sb.append( " random_blood_sugar:");
        sb.append(this.random_blood_sugar);

        sb.append( " r_d_w_cv:");
        sb.append(this.r_d_w_cv);

        sb.append( " serum:");
        sb.append(this.serum);

        sb.append( " sgot_sgpt_ratio:");
        sb.append(this.sgot_sgpt_ratio);

        sb.append( "sodium");
        sb.append(this.sodium);

        sb.append( " t3_tri_iodothyronine:");
        sb.append(this.t3_tri_iodothyronine);

        sb.append( " t4_thyroxine:");
        sb.append(this.t4_thyroxine);

        sb.append( " total_bilirubin:");
        sb.append(this.total_bilirubin);

        sb.append( " total_bilirubin_serum:");
        sb.append(this.total_bilirubin_serum);

        sb.append( " total_cholesterol_hdl_cholesterol_ratio:");
        sb.append(this.total_cholesterol_hdl_cholesterol_ratio);

        sb.append( " total_cholesterol_serum:");
        sb.append(this.total_cholesterol_serum);

        sb.append( " total_protein_serum:");
        sb.append(this.total_protein_serum);

        sb.append( " total_rbc_count:");
        sb.append(this.total_rbc_count);

        sb.append( " total_wbc_count:");
        sb.append(this.total_wbc_count);

        sb.append( " triglyceride_serum:");
        sb.append(this.triglyceride_serum);

        sb.append( " tsh:");
        sb.append(this.tsh);

        sb.append( " uric_acid_serum:");
        sb.append(this.uric_acid_serum);

        sb.append( " vit_d_assay:");
        sb.append(this.vit_d_assay);

        sb.append( " vitamin_a_retinol:");
        sb.append(this.vitamin_a_retinol);

        sb.append( " vitamin_b12:");
        sb.append(this.vitamin_b12);

        sb.append(" vldl_cholesterol_serum:");
        sb.append(this.vldl_cholesterol_serum);

        return(sb.toString());
    }

}