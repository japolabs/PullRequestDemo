/* 
 * Copyright 2021 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.layers.data;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import org.japo.java.libraries.UtilesBD;
import org.japo.java.services.DServices;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class DManager implements DServices {

    //<editor-fold defaultstate="collapsed" desc="--- Data Access Manager ---">
    // Referencias
    private final Connection conn;
    private final Statement stmt;
    private final Properties prp;

    // Constructor Parametrizado - Properties
    public DManager(Properties prp) {
        // Memorización
        this.prp = prp;

        // Establecer acceso a la BD
        conn = UtilesBD.conectar(prp);
        stmt = UtilesBD.vincular(conn, prp);
    }

    // Cerrar Artefactos BD
    @Override
    public final void close() {
        // Cerrando Artefactos
        UtilesBD.cerrar(stmt);
        UtilesBD.cerrar(conn);
    }
    //</editor-fold>

    // Lógica de Acceso a Datos Adicional
}
