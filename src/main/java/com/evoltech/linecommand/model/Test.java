package com.evoltech.linecommand.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Test {
    private String id;
    public String uuid;
    String  abnormal_flag;
    String  ref_range;    // debe venir del catalogo. Preguntar como esta estructurado
    String  test_datetime;
    String  test_name;     // catalogo de tests. Convertir string a relacion con el catalogo. si no existe el test crearlo
    String  test_val;
    String  unit;         // debe venir del catalogo
}